package br.com.elo.desafiocielo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.elo.desafiocielo.domains.DomicilioBancario;
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
public class DomicilioBancarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 3, message = "Tamanho mínimo 3 e no máximo 3 caracteres!")
	@Getter @Setter private String codigoBanco;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 1, max = 1, message = "Tamanho mínimo 1 e no máximo 1 caracteres!")
	@Getter @Setter private String numeroAgencia;
	
	
	
	/**
	 * Construtor
	 * @param dadosDomicilioBancario
	 */
	public DomicilioBancarioDTO(DomicilioBancario domicilioBancario) {
		this.id = domicilioBancario.getId();
		this.codigoBanco = domicilioBancario.getCodigoBanco();
		this.numeroAgencia = domicilioBancario.getNumeroAgencia();
	}

}
