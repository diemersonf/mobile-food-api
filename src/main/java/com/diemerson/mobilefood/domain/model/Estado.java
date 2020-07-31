package com.diemerson.mobilefood.domain.model;

import javax.persistence.Column;
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
	
	@Column(nullable = false)
	private String Nome;
}
