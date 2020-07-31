package com.diemerson.mobilefood.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@EqualsAndHashCode.Include
	private Long id;
	
	@Getter @Setter
	@Column(nullable = false)
	private String nome;
	
	@Getter @Setter
	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete = new BigDecimal(0.00);
	
	@Getter @Setter
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "restaurante_cozinha", 
		joinColumns = {@JoinColumn(name="restaurante_id")},
		inverseJoinColumns = {@JoinColumn(name="cozinha_id")})
	private List<Cozinha> cozinhas;
	
	@Getter @Setter
	private Boolean ativo = false;
	
	@Getter @Setter
	private Boolean aberto = false;
	
	@Getter
	private Date dataCadastro = new Date();
	
	@Getter @Setter
	private Date dataAtualizacao = new Date();
}


