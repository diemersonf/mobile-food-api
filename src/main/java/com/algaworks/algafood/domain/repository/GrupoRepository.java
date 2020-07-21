package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Grupo;

public interface GrupoRepository {
	List<Grupo> buscarTodas();
	Grupo buscarPorNome(String nome);
	Grupo adicionarBD(Grupo grupo);
	Grupo atualizarBD(Grupo grupo);
	void removerBD(Grupo grupo);
}
