package com.diemerson.mobilefood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "tb_cidades")
@Getter
@EqualsAndHashCode
public class Cidade {
	
	@Id
	@JsonIgnore
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@ManyToOne
	@JsonIgnoreProperties("nome")
	private Estado estado;
}
