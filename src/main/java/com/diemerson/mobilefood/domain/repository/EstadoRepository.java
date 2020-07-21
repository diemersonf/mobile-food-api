package com.diemerson.mobilefood.domain.repository;

import java.util.List;

import com.diemerson.mobilefood.domain.model.Estado;

public interface EstadoRepository {
	List<Estado> buscarTodas();
	Estado buscarPorSigla(String sigla);
}
