package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	List<FormaPagamento> buscarTodas();
	FormaPagamento buscarPorId(Long id);
	FormaPagamento buscarPorNome(String nome);
	FormaPagamento adicionarBD(FormaPagamento formaPagamento);
	FormaPagamento atualizarBD(FormaPagamento formaPagamento);
	void removerBD(FormaPagamento formaPagamento);
}
