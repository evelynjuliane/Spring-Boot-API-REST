package com.apititles.services.exception;

public class TitleNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6435966208582949121L;

	public TitleNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public TitleNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
