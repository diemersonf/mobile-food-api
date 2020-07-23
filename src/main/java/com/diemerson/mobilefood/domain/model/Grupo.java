package com.diemerson.mobilefood.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Grupo {
	
	@Id
	private String nome;
	private String descricao;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "grupo_permissao",
		joinColumns = {@JoinColumn(name="grupo_nome")},
		inverseJoinColumns = {@JoinColumn(name="permissao_nome")})
	private List<Permissao> permissoes;

}
