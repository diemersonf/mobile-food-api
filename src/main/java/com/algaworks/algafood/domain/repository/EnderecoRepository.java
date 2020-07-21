package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Endereco;

public interface EnderecoRepository {
	List<Endereco> buscarTodos();
	List<Endereco> buscarPorCep(String cep);
	List<Endereco> buscarPorLogradouro(String logradouro);
	Endereco adicionarBD(Endereco endereco);
	Endereco atualizarBD(Endereco endereco);
	void removerBD(Endereco endereco);
}
