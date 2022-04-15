package com.angelikafonteles.marmitasolidariasvc.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MarmitaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	@JsonFormat(pattern=DATE_FORMAT)
	private Date dataFeitura;
	private String descricao;
	private String observacao;
	private Integer quantidade;
	
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
