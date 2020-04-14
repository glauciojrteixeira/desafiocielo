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
public class ExtratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@JsonFormat(pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	@Getter @Setter private Date dataLancamentoContaCorrenteCliente;
	
	@Getter @Setter private String nomeTipoOperacao;
	@Getter @Setter private Long numeroRemessaBanco;
	@Getter @Setter private String nomeSituacaoRemessa;
	
	@JsonFormat(pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	@Getter @Setter private Date dataEfetivaLancamento;
	
	@Getter @Setter private String nomeBanco;
	@Getter @Setter private String numeroAgencia;
	@Getter @Setter private String numeroContaCorrente;
	@Getter @Setter private Float valorLancamentoRemessa;
	
	
	/**
	 * Construtor
	 * @param extratoDTO
	 */
	public ExtratoDTO(ExtratoDTO extratoDTO) {
		this.dataLancamentoContaCorrenteCliente = extratoDTO.getDataLancamentoContaCorrenteCliente();
		this.nomeTipoOperacao = extratoDTO.getNomeTipoOperacao();
		this.numeroRemessaBanco = extratoDTO.getNumeroRemessaBanco();
		this.nomeSituacaoRemessa = extratoDTO.getNomeSituacaoRemessa();
		this.dataEfetivaLancamento = extratoDTO.getDataEfetivaLancamento();
		this.nomeBanco = extratoDTO.getNomeBanco();
		this.numeroAgencia = extratoDTO.getNumeroAgencia();
		this.numeroContaCorrente = extratoDTO.getNumeroContaCorrente();
		this.valorLancamentoRemessa = extratoDTO.getValorLancamentoRemessa();
	}

}
