package br.com.elo.desafiocielo.services.exceptions;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

public class ArquivoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ArquivoExcecao(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ArquivoExcecao(String message) {
		super(message);
		
	}

	
}
