package br.com.elo.desafiocielo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.com.elo.desafiocielo.domains.ControleLancamento;
import lombok.AllArgsConstructor;
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

// Construtores padrões anotados na classe 

@NoArgsConstructor @AllArgsConstructor
public class ControleLancamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Date dataEfetivaLancamento;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Date dataLancamentoContaCorrenteCliente;
		
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Long numeroEvento;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private String descricaoGrupoPagamento;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Integer codigoIdentificadorUnico;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private String nomeBanco;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Integer quantidadeLancamentoRemessa;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private String numeroRaizCNPJ;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private String numeroSufixoCNPJ;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Float valorLancamentoRemessa;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Long dateLancamentoContaCorrenteCliente;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Long dateEfetivaLancamento;
	
	/**
	 * Construtor
	 * @param controleLancamento
	 */
	public ControleLancamentoDTO(ControleLancamento controleLancamento) {
		this.id = controleLancamento.getId();
		this.dataEfetivaLancamento = controleLancamento.getDataEfetivaLancamento();
		this.dataLancamentoContaCorrenteCliente = controleLancamento.getDataLancamentoContaCorrenteCliente();
		this.numeroEvento = controleLancamento.getNumeroEvento();
		this.descricaoGrupoPagamento = controleLancamento.getDescricaoGrupoPagamento();
		this.codigoIdentificadorUnico = controleLancamento.getCodigoIdentificadorUnico();
		this.nomeBanco = controleLancamento.getNomeBanco();
		this.quantidadeLancamentoRemessa = controleLancamento.getQuantidadeLancamentoRemessa();
		this.numeroRaizCNPJ = controleLancamento.getNumeroRaizCNPJ();
		this.numeroSufixoCNPJ = controleLancamento.getNumeroSufixoCNPJ();
		this.valorLancamentoRemessa = controleLancamento.getValorLancamentoRemessa();
		this.dateLancamentoContaCorrenteCliente = controleLancamento.getDateLancamentoContaCorrenteCliente();
		this.dateEfetivaLancamento = controleLancamento.getDateEfetivaLancamento();
	}

}
