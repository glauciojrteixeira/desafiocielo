package br.com.elo.desafiocielo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ControleLancamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@JsonFormat(pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	@Getter @Setter private Date dataEfetivaLancamento;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	@Getter @Setter private Date dataLancamentoContaCorrenteCliente;
	
	@Getter @Setter private Long numeroEvento;
	@Getter @Setter private String descricaoGrupoPagamento;
	@Getter @Setter private Integer codigoIdentificadorUnico;
	@Getter @Setter private String nomeBanco;
	@Getter @Setter private Integer quantidadeLancamentoRemessa;
	@Getter @Setter private String numeroRaizCNPJ;
	@Getter @Setter private String numeroSufixoCNPJ;
	@Getter @Setter private Float valorLancamentoRemessa;
	@Getter @Setter private Long dateLancamentoContaCorrenteCliente;
	@Getter @Setter private Long dateEfetivaLancamento;
	
	@Getter @Setter private LancamentoContaCorrenteDTO lancamentoContaCorrenteCliente;
	
	/**
	 * Construtor
	 * @param controleLancamentoDTO
	 */
	public ControleLancamentoDTO(ControleLancamentoDTO controleLancamentoDTO) {		
		this.dataEfetivaLancamento = controleLancamentoDTO.getDataEfetivaLancamento();
		this.dataLancamentoContaCorrenteCliente = controleLancamentoDTO.getDataLancamentoContaCorrenteCliente();
		this.numeroEvento = controleLancamentoDTO.getNumeroEvento();
		this.descricaoGrupoPagamento = controleLancamentoDTO.getDescricaoGrupoPagamento();
		this.codigoIdentificadorUnico = controleLancamentoDTO.getCodigoIdentificadorUnico();
		this.nomeBanco = controleLancamentoDTO.getNomeBanco();
		this.quantidadeLancamentoRemessa = controleLancamentoDTO.getQuantidadeLancamentoRemessa();
		this.numeroRaizCNPJ = controleLancamentoDTO.getNumeroRaizCNPJ();
		this.numeroSufixoCNPJ = controleLancamentoDTO.getNumeroSufixoCNPJ();
		this.valorLancamentoRemessa = controleLancamentoDTO.getValorLancamentoRemessa();
		this.dateLancamentoContaCorrenteCliente = controleLancamentoDTO.getDateLancamentoContaCorrenteCliente();
		this.dateEfetivaLancamento = controleLancamentoDTO.getDateEfetivaLancamento();
		this.lancamentoContaCorrenteCliente = controleLancamentoDTO.getLancamentoContaCorrenteCliente();
	}

}
