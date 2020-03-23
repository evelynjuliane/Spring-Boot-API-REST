package com.apititles.services.exception;

public class TitleAlreadyExistsException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1409969479092466029L;

	public  TitleAlreadyExistsException(String mensagem) {
		super(mensagem);
	}
	
	public  TitleAlreadyExistsException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
