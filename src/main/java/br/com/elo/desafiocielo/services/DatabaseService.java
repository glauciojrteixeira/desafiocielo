package br.com.elo.desafiocielo.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.Cliente;
import br.com.elo.desafiocielo.domains.enums.TipoCliente;
import br.com.elo.desafiocielo.domains.enums.TipoPerfil;
import br.com.elo.desafiocielo.repositories.ClienteRepository;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Service
public class DatabaseService {

	/**
	 * Injeções de Dependencia
	 */
	@Autowired
	private ClienteRepository clienteRepo;
	
//	@Autowired
//	private DomicilioBancarioRepository domicilioBancarioRepo;
//	@Autowired
//	private ControleLancamentoRepository controleLancamentoRepo;
//	@Autowired
//	private LancamentoContaCorrenteRepository lancamentoContaCorrenteRepo;
//	@Autowired
//	private LancamentoFinanceiroRepository lancamentoFinanceiroRepo;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * Método :: Instancia a base de dados utilizada no profile test.
	 * @throws ParseException
	 */
	public void instantiateDatabaseTest() throws ParseException {
//		SimpleDateFormat sdfSemHora = new SimpleDateFormat("dd/MM/yyyy");
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Cliente cli1 = new Cliente(null, "Gláucio Júnior Teixeira", "glaucio.teixeira@outlook.com", "36378912377", TipoCliente.PESSOAFISICA, passwordEncoder.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("31999500593", "93838393"));
		
		cli1.addTipoPerfil(TipoPerfil.ADMIN);
		
		clienteRepo.saveAll(Arrays.asList(cli1));
		
		/*
		DomicilioBancario domicilioBancario_01 = new DomicilioBancario(null, "123", "1", "00000000065470", null);
		DomicilioBancario domicilioBancario_02 = new DomicilioBancario(null, "123", "2", "00000000065400", null);
		domicilioBancarioRepo.saveAll(Arrays.asList(domicilioBancario_01, domicilioBancario_02));
		
		
		
		LancamentoContaCorrente lancamentoContaCorrente_01 = new LancamentoContaCorrente(null, 64320236054L, "Pago", "regular", domicilioBancario_01, null, null);
		LancamentoContaCorrente lancamentoContaCorrente_02 = new LancamentoContaCorrente(null, 64320236054L, "Pago", "regular", domicilioBancario_01, null, null);
		lancamentoContaCorrenteRepo.saveAll(Arrays.asList(lancamentoContaCorrente_01, lancamentoContaCorrente_02));
		
		
		LancamentoFinanceiro lancamentoFinanceiro_01 = new LancamentoFinanceiro(null, "Ativo", lancamentoContaCorrente_02);
		lancamentoFinanceiroRepo.saveAll(Arrays.asList(lancamentoFinanceiro_01));
		
		
		ControleLancamento controleLancamento_01 = new ControleLancamento(null, sdfSemHora.parse("03/06/2016"), sdfSemHora.parse("03/06/2016"), 42236790L, "LA-56", 1, 
				"BANCO ABCD S.A.             ", 22, "12996721", "1597", 11499.10F, 1464922800000L, 1464922800000L, lancamentoContaCorrente_01);
		ControleLancamento controleLancamento_02 = new ControleLancamento(null, sdfSemHora.parse("02/06/2016"), sdfSemHora.parse("02/06/2016"), 42592397L, "LA-56", 25, 
				"BANCO ABCD S.A.             ", 2, "12996721", "1597", 1960.0F, 1464836400000L, 1464836400000L, lancamentoContaCorrente_02);
		controleLancamentoRepo.saveAll(Arrays.asList(controleLancamento_01, controleLancamento_02));
		*/
		
		/*
		 * 
		 */
		
	}
}
