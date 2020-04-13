package br.com.elo.desafiocielo.dto;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

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
public class LancamentoFinanceiroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private String status;
	
	/**
	 * Construtor
	 * @param lancamentoFinanceiroDTO
	 */
	public LancamentoFinanceiroDTO(LancamentoFinanceiroDTO lancamentoFinanceiroDTO) {
		this.status = lancamentoFinanceiroDTO.getStatus();
	}

}
