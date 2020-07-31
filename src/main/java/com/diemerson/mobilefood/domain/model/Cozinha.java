package com.diemerson.mobilefood.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@EqualsAndHashCode.Include
	@JsonIgnore
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private String nome;	
	
	@ManyToMany(mappedBy = "cozinhas")
	private List<Restaurante> restaurantes;
	
}
