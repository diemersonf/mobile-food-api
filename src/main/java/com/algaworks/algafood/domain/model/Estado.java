package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "tb_estados")
@Getter
@EqualsAndHashCode
public class Estado {
	@Id
	private String sigla;
	private String Nome;
}
