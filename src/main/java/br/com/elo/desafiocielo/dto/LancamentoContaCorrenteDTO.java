package br.com.elo.desafiocielo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.elo.desafiocielo.domains.LancamentoContaCorrente;
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
 * Construtores padrões anotados na classe
 * 
 */

@NoArgsConstructor @AllArgsConstructor
public class LancamentoContaCorrenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Long numeroRemessaBanco;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private String nomeSituacaoRemessa;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private String nomeTipoOperacao;
	
	/**
	 * Construtor
	 * @param lancamentoContaCorrenteCliente
	 */
	public LancamentoContaCorrenteDTO(LancamentoContaCorrente lancamentoContaCorrente) {
		this.id = lancamentoContaCorrente.getId();
		this.numeroRemessaBanco = lancamentoContaCorrente.getNumeroRemessaBanco();
		this.nomeSituacaoRemessa = lancamentoContaCorrente.getNomeSituacaoRemessa();
		this.nomeTipoOperacao = lancamentoContaCorrente.getNomeTipoOperacao();
	}

}
