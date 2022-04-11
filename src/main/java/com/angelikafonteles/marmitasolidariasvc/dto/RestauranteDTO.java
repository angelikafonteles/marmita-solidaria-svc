package com.angelikafonteles.marmitasolidariasvc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.angelikafonteles.marmitasolidariasvc.model.Endereco;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;

public class RestauranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
	private String cnpj;
	private String nomeFantasia;
	private String email;
	private String telefone;
	private Endereco endereco;

	public RestauranteDTO(Restaurante obj) {
		razaoSocial = obj.getRazaoSocial();
		cnpj = obj.getCnpj();
		nomeFantasia = obj.getNomeFantasia();
		email = obj.getEmail();
		telefone = obj.getTelefone();
		endereco = obj.getEndereco();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
