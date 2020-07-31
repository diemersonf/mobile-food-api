package com.diemerson.mobilefood.domain.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Endereco {
	
	@EmbeddedId
	private EnderecoId id;
	
	@Column(nullable = false)
	private String cep;
	
	private String complemento;
	
	@Column(nullable = false)
	private String bairro;
}
