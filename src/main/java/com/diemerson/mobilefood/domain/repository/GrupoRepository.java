package com.diemerson.mobilefood.domain.repository;

import java.util.List;

import com.diemerson.mobilefood.domain.model.Grupo;

public interface GrupoRepository {
	List<Grupo> buscarTodas();
	Grupo buscarPorNome(String nome);
	Grupo adicionarBD(Grupo grupo);
	Grupo atualizarBD(Grupo grupo);
	void removerBD(Grupo grupo);
}
