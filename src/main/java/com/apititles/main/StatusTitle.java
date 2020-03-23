package com.apititles.main;

public enum StatusTitle {

	PENDENTE("Pendente"), 
	RECEBIDO("Recebido");
	
	
	private String description;
	
	StatusTitle(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
