package com.angelikafonteles.marmitasolidariasvc.dto;

public class EnderecoUpdateDTO {

	private String restauranteId;
	private String cep;
	private String numero;
	private String complemento;
	
	public String getRestauranteId() {
		return restauranteId;
	}
	public void setRestauranteId(String restauranteId) {
		this.restauranteId = restauranteId;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
