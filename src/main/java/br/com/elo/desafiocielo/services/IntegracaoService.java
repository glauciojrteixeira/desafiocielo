package br.com.elo.desafiocielo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.ControleLancamento;
import br.com.elo.desafiocielo.domains.DomicilioBancario;
import br.com.elo.desafiocielo.domains.LancamentoContaCorrente;
import br.com.elo.desafiocielo.domains.LancamentoFinanceiro;
import br.com.elo.desafiocielo.dto.ControleLancamentoDTO;
import br.com.elo.desafiocielo.dto.IntegracaoDTO;
import br.com.elo.desafiocielo.dto.LancamentoFinanceiroDTO;
import br.com.elo.desafiocielo.repositories.ControleLancamentoRepository;
import br.com.elo.desafiocielo.repositories.DomicilioBancarioRepository;
import br.com.elo.desafiocielo.repositories.LancamentoContaCorrenteRepository;
import br.com.elo.desafiocielo.repositories.LancamentoFinanceiroRepository;
import br.com.elo.desafiocielo.services.exceptions.APIVersionExcecao;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Slf4j
@Service
public class IntegracaoService {
	
	// Declara a injeção de dependencia ao objeto repository
	
	@Autowired
	private DomicilioBancarioRepository domicilioBancarioRepo;
	@Autowired
	private LancamentoFinanceiroRepository lancamentoFinanceiroRepo;
	@Autowired
	private LancamentoContaCorrenteRepository lancamentoContaCorrenteRepo;
	@Autowired
	private ControleLancamentoRepository controleLancamentoRepo;
	
	/*
	 * Atributo
	 */
	@Value("${api.version.default}")
	private String apiVersionDefault;
		
	public DomicilioBancario buscarBancoAgenciaConta(
			String version, String codigoBanco, String numeroAgencia, String numeroContaCorrente) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			DomicilioBancario obj = domicilioBancarioRepo
					.findByCodigoBancoAndNumeroAgenciaAndNumeroContaCorrente(
							codigoBanco, numeroAgencia, numeroContaCorrente);
			
			return obj;
			
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
	}
	
	@Transactional
	public void processarPayLoad(String version, IntegracaoDTO objetoDTO) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			// Implementa codigo para persistir pay load
			
			/*
			 * Os totais dos atributos deste objeto podem, eventualmente serem 
			 * utilizados para validar se todos os objetos do pay load totalizam 
			 * com os valores deste objeto.
			 * Por uma questão de tempo, vou deixar essa implementação pra depois.
			 */
			
			//ControleLancamentoTotalDTO controleLancamentoTotal = objetoDTO.getTotalControleLancamento();
			
			
			for (ControleLancamentoDTO x : objetoDTO.getListaControleLancamento()) {
				ControleLancamento controleLancamento = new ControleLancamento();
				//controleLancamento.setLancamentoContaCorrente(lancamentoContaCorrente);
				controleLancamento.setDataEfetivaLancamento(x.getDataEfetivaLancamento());
				controleLancamento.setDataLancamentoContaCorrenteCliente(x.getDataLancamentoContaCorrenteCliente());
				controleLancamento.setNumeroEvento(x.getNumeroEvento());
				controleLancamento.setDescricaoGrupoPagamento(x.getDescricaoGrupoPagamento());
				controleLancamento.setCodigoIdentificadorUnico(x.getCodigoIdentificadorUnico());
				controleLancamento.setNomeBanco(x.getNomeBanco());
				controleLancamento.setQuantidadeLancamentoRemessa(x.getQuantidadeLancamentoRemessa());
				controleLancamento.setNumeroRaizCNPJ(x.getNumeroRaizCNPJ());
				controleLancamento.setNumeroSufixoCNPJ(x.getNumeroSufixoCNPJ());
				controleLancamento.setValorLancamentoRemessa(x.getValorLancamentoRemessa());
				controleLancamento.setDateLancamentoContaCorrenteCliente(x.getDateLancamentoContaCorrenteCliente());
				controleLancamento.setDateEfetivaLancamento(x.getDateEfetivaLancamento());
				
				controleLancamentoRepo.saveAndFlush(controleLancamento);
				
				
				
				List<LancamentoFinanceiroDTO> x1 = x
						.getLancamentoContaCorrenteCliente()
						.getDadosAnaliticoLancamentoFinanceiroCliente();
				
				List<LancamentoFinanceiro> lancamentoFinanceiros = new ArrayList<>();
				
				for (LancamentoFinanceiroDTO y : x1) {
					LancamentoFinanceiro lancamentoFinanceiro = new LancamentoFinanceiro();
					lancamentoFinanceiro.setStatus(y.getStatus());
					//lancamentoFinanceiro.setLancamentoContaCorrente(lancamentoContaCorrente);
					
					lancamentoFinanceiroRepo.saveAndFlush(lancamentoFinanceiro);
					
					lancamentoFinanceiros.add(lancamentoFinanceiro);
				}
				
				
				String codigoBanco = x.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getCodigoBanco();
				String numeroAgencia = x.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia();
				String numeroContaCorrente = x.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente();
				
				DomicilioBancario entity = buscarBancoAgenciaConta(version, codigoBanco, numeroAgencia, numeroContaCorrente);
				
				DomicilioBancario domicilioBancario = new DomicilioBancario();
				if (entity == null) {
					domicilioBancario.setCodigoBanco(codigoBanco);
					domicilioBancario.setNumeroAgencia(numeroAgencia);
					domicilioBancario.setNumeroContaCorrente(numeroContaCorrente);
				} else {
					domicilioBancario = entity;
				}
					
//				domicilioBancarioRepo.save(domicilioBancario);
				
				domicilioBancarioRepo.saveAndFlush(domicilioBancario);
				
				LancamentoContaCorrente lancamentoContaCorrente = new LancamentoContaCorrente();
				lancamentoContaCorrente.setNumeroRemessaBanco(x.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
				lancamentoContaCorrente.setNomeSituacaoRemessa(x.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
				lancamentoContaCorrente.setNomeTipoOperacao(x.getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
				lancamentoContaCorrente.setDomicilioBancario(domicilioBancario);
				lancamentoContaCorrente.setLancamentoFinanceiros(lancamentoFinanceiros);
				lancamentoContaCorrente.setControleLancamento(controleLancamento);
				
				
				lancamentoContaCorrenteRepo.saveAndFlush(lancamentoContaCorrente);
				
				controleLancamento.setLancamentoContaCorrente(lancamentoContaCorrente);
				controleLancamentoRepo.saveAndFlush(controleLancamento);
				
				
						
			}
			
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
	}
}
