package br.com.elo.desafiocielo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 * 
 */

@NoArgsConstructor
public class LancamentoContaCorrenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private Long numeroRemessaBanco;
	@Getter @Setter private String nomeSituacaoRemessa;
	@Getter @Setter private String nomeTipoOperacao;
	
	@Getter @Setter private DomicilioBancarioDTO dadosDomicilioBancario;
	
	@Getter @Setter private List<LancamentoFinanceiroDTO> dadosAnaliticoLancamentoFinanceiroCliente = new ArrayList<>();
	
	/**
	 * Construtor
	 * @param lancamentoContaCorrenteDTO
	 */
	public LancamentoContaCorrenteDTO(LancamentoContaCorrenteDTO lancamentoContaCorrenteDTO) {
		this.numeroRemessaBanco = lancamentoContaCorrenteDTO.getNumeroRemessaBanco();
		this.nomeSituacaoRemessa = lancamentoContaCorrenteDTO.getNomeSituacaoRemessa();
		this.nomeTipoOperacao = lancamentoContaCorrenteDTO.getNomeTipoOperacao();
		this.dadosDomicilioBancario = lancamentoContaCorrenteDTO.getDadosDomicilioBancario();
		this.dadosAnaliticoLancamentoFinanceiroCliente = lancamentoContaCorrenteDTO.getDadosAnaliticoLancamentoFinanceiroCliente();
	}

}
