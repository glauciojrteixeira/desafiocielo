package br.com.elo.desafiocielo.dto;

import java.io.Serializable;

import br.com.elo.desafiocielo.domains.DomicilioBancario;
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
public class DomicilioBancarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Getter @Setter private Integer id;
	@Getter @Setter private String codigoBanco;
	@Getter @Setter private String numeroAgencia;
	@Getter @Setter private String numeroContaCorrente;
	
	/**
	 * Construtor
	 * @param dadosDomicilioBancario
	 */
	public DomicilioBancarioDTO(DomicilioBancarioDTO domicilioBancarioDTO) {
		this.codigoBanco = domicilioBancarioDTO.getCodigoBanco();
		this.numeroAgencia = domicilioBancarioDTO.getNumeroAgencia();
		this.numeroContaCorrente = domicilioBancarioDTO.getNumeroContaCorrente();
	}
	
	public DomicilioBancarioDTO(DomicilioBancario domicilioBancario) {
		this.id = domicilioBancario.getId();
		this.codigoBanco = domicilioBancario.getCodigoBanco();
		this.numeroAgencia = domicilioBancario.getNumeroAgencia();
		this.numeroContaCorrente = domicilioBancario.getNumeroContaCorrente();
	}
}
