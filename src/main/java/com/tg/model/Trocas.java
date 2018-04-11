package com.tg.model;

public class Trocas {

	private String nome;
	private String tipo;
	private String currency;
	private String enviar;
	private String receber;

	public Trocas(String nome, String tipo, String currency) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.currency = currency;
	}
	
	public Trocas() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getEnviar() {
		return enviar;
	}
	public void setEnviar(String enviar) {
		this.enviar = enviar;
	}
	public String getReceber() {
		return receber;
	}
	public void setReceber(String receber) {
		this.receber = receber;
	}
	
	
}
