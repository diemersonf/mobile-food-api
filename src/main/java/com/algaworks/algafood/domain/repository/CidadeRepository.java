package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;

public interface CidadeRepository {
	List<Cidade> buscarTodas();
	Cidade buscarPorNome(String nome, Estado sigla);
}
