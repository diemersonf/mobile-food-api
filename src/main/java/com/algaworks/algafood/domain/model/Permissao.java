package com.algaworks.algafood.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Permissao {

	@Id
	private String nome;
	private String descricao;
	
	@ManyToMany(mappedBy = "permissoes")
	private List<Grupo> grupos;
}
