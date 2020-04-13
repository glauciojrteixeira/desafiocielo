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
public class IntegracaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private ControleLancamentoTotalDTO totalControleLancamento;
	@Getter @Setter private List<ControleLancamentoDTO> listaControleLancamento = new ArrayList<>();
	

	/**
	 * Construtor
	 * @param integracaoDTO
	 */
	public IntegracaoDTO(IntegracaoDTO integracaoDTO) {
		this.totalControleLancamento = integracaoDTO.totalControleLancamento;
		this.listaControleLancamento = integracaoDTO.listaControleLancamento;
	}

}
