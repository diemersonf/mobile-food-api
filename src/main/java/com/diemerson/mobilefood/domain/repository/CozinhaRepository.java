package com.diemerson.mobilefood.domain.repository;

import java.util.List;

import com.diemerson.mobilefood.domain.model.Cozinha;

public interface CozinhaRepository {
	List<Cozinha> buscarTodas();
	Cozinha buscarPorId(Long id);
	Cozinha adicionarBD(Cozinha cozinha);
	Cozinha atualizarBD(Cozinha cozinha);
	void removerBD(Cozinha cozinha);
	Cozinha buscarPorNome(String nome);
}
