package br.com.elo.desafiocielo.services.exceptions;

public class ObjetoNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoExcecao(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjetoNaoEncontradoExcecao(String message) {
		super(message);
		
	}

	
}
