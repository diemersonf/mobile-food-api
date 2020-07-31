package com.diemerson.mobilefood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Restaurante;
import com.diemerson.mobilefood.infrastructure.repository.RestauranteRepositoryImpl;

@Service
public class CadastroRestauranteService {

	@Autowired
	RestauranteRepositoryImpl repository;
	
	public List<Restaurante> listarTodos(){
		return repository.buscarTodos();
	}
	
	public Restaurante buscarPorId(Long restauranteId) {
		Restaurante restaurante = new Restaurante();
		restaurante = repository.buscarPorId(restauranteId);
		if (restaurante == null) {
			throw new EntidadeNaoEncontradaException("Restaurante %d não cadastrado.");
		}
		return restaurante;
	}
	
	public Restaurante adicionar(Restaurante restaurante) {
		return repository.adicionarBD(restaurante);
	}

}
