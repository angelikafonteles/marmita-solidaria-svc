package com.angelikafonteles.marmitasolidariasvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="restaurante")
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String razaoSocial;
	private String cnpj;
	private String nomeFantasia;
	private String email;
	private String telefone;
	private Endereco endereco;
	@DBRef(lazy = true)
	private List<Marmita> marmitas = new ArrayList<>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public List<Marmita> getMarmitas() {
		return marmitas;
	}
	public void setMarmitas(List<Marmita> marmitas) {
		this.marmitas = marmitas;
	}

	
}
