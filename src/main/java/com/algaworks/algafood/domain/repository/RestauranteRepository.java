package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {
	List<Restaurante> buscarTodas();
	Restaurante buscarPorId(Long id);
	List<Restaurante> buscarPorNome(String nome);
	Restaurante adicionarBD(Restaurante restaurante);
	Restaurante atualizarBD(Restaurante restaurante);
	void removerBD(Restaurante restaurante);
}
