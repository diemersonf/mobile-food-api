package com.diemerson.mobilefood.domain.repository;

import java.util.List;

import com.diemerson.mobilefood.domain.model.Cidade;
import com.diemerson.mobilefood.domain.model.Estado;

public interface CidadeRepository {
	List<Cidade> buscarTodas();
	Cidade buscarPorNome(String nome, Estado sigla);
}
