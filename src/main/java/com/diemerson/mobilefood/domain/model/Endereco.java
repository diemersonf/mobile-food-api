package com.diemerson.mobilefood.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Endereco {
	
	@EmbeddedId
	private EnderecoId id;
	private String cep;
	private String complemento;
	private String bairro;
}
