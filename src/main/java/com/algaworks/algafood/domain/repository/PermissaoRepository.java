package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {
	List<Permissao> buscarTodas();
	Permissao buscarPorNome(String nome);
	Permissao adicionarBD(Permissao permissao);
	Permissao atualizarBD(Permissao permissao);
	void removerBD(Permissao permissao);
}
