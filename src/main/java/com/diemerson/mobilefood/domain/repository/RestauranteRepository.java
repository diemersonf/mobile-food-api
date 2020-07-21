package com.diemerson.mobilefood.domain.repository;

import java.util.List;

import com.diemerson.mobilefood.domain.model.Restaurante;

public interface RestauranteRepository {
	List<Restaurante> buscarTodas();
	Restaurante buscarPorId(Long id);
	List<Restaurante> buscarPorNome(String nome);
	Restaurante adicionarBD(Restaurante restaurante);
	Restaurante atualizarBD(Restaurante restaurante);
	void removerBD(Restaurante restaurante);
}
