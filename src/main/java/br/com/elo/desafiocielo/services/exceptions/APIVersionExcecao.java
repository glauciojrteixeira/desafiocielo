package br.com.elo.desafiocielo.services.exceptions;

public class APIVersionExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public APIVersionExcecao(String message, Throwable cause) {
		super(message, cause);
		
	}

	public APIVersionExcecao(String message) {
		super(message);
		
	}

}
