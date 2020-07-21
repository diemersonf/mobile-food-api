package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {
	List<Estado> buscarTodas();
	Estado buscarPorSigla(String sigla);
}