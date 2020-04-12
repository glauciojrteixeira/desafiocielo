package br.com.elo.desafiocielo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

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
public class ControleLancamentoTotalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Integer quantidadeLancamentos;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Integer quantidadeRemessas;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Getter @Setter private Float valorLancamentos;

}
