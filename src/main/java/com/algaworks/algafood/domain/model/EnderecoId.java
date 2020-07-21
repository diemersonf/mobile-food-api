package com.algaworks.algafood.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class EnderecoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String lougradouro;
	private String numero;
	@ManyToOne
	private Cidade cidade;

}
