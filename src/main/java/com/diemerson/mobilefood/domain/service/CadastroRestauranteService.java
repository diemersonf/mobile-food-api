package com.diemerson.mobilefood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Restaurante;
import com.diemerson.mobilefood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;
	
	public List<Restaurante> listarTodos(){
		return restauranteRepository.buscarTodos();
	}
	
	public Restaurante buscarPorId(Long restauranteId) {
		Restaurante restaurante = new Restaurante();
		restaurante = restauranteRepository.buscarPorId(restauranteId);
		if (restaurante == null) {
			throw new EntidadeNaoEncontradaException("Restaurante %d não cadastrado.");
		}
		return restaurante;
	}
	
	public Restaurante adicionar(Restaurante restaurante) {	
		return restauranteRepository.adicionarBD(restaurante);
	}
	
	public Restaurante atualizar(Long restauranteId, Restaurante restaurante) {
		return restauranteRepository.atualizarBD(restauranteId, restaurante);
	}

}
