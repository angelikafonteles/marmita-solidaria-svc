package com.angelikafonteles.marmitasolidariasvc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;

public class RestauranteUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String telefone;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
