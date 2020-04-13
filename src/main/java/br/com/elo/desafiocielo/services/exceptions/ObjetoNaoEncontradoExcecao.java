package br.com.elo.desafiocielo.services.exceptions;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

public class ObjetoNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoExcecao(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjetoNaoEncontradoExcecao(String message) {
		super(message);
		
	}

	
}
