package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "tb_cidades")
@Getter
@EqualsAndHashCode
public class Cidade {
	
	@Id
	private Long id;
	
	@ManyToOne
	private Estado estado;
	
	private String nome;
}
