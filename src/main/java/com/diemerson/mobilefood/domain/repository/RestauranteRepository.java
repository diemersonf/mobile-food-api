package com.diemerson.mobilefood.domain.repository;

import java.util.List;

import com.diemerson.mobilefood.domain.model.Restaurante;

public interface RestauranteRepository {
	List<Restaurante> buscarTodos();
	Restaurante buscarPorId(Long id);
	List<Restaurante> buscarPorNome(String nome);
	Restaurante adicionarBD(Restaurante restaurante);
	Restaurante atualizarBD(Long restauranteId, Restaurante restaurante);
	void removerBD(Long restauranteId);
}
