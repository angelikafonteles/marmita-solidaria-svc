package com.angelikafonteles.marmitasolidariasvc.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Marmita  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	@Id
	private String id;
	@JsonFormat(pattern=DATE_FORMAT)
	private Date dataFeitura;
	private String descricao;
	private String observacao;
	private Integer quantidade;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDataFeitura() {
		return dataFeitura;
	}
	public void setDataFeitura(Date dataFeitura) {
		this.dataFeitura = dataFeitura;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
