package br.com.elo.desafiocielo.dto;

import java.io.Serializable;

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
public class ControleLancamentoTotalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */	
	@Getter @Setter private Integer quantidadeLancamentos;
	@Getter @Setter private Integer quantidadeRemessas;
	@Getter @Setter private Float valorLancamentos;
	
	/**
	 * Contrutor
	 * @param controleLancamentoTotalDTO
	 */
	public ControleLancamentoTotalDTO(ControleLancamentoTotalDTO controleLancamentoTotalDTO) {
		this.quantidadeLancamentos = controleLancamentoTotalDTO.getQuantidadeLancamentos();
		this.quantidadeRemessas = controleLancamentoTotalDTO.getQuantidadeRemessas();
		this.valorLancamentos = controleLancamentoTotalDTO.getValorLancamentos();
	}

}
