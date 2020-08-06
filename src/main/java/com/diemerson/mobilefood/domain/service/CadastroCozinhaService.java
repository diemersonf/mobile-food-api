package com.diemerson.mobilefood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diemerson.mobilefood.domain.exception.AtributoNuloException;
import com.diemerson.mobilefood.domain.exception.EntidadeEmUsoException;
import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Cozinha;
import com.diemerson.mobilefood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha adicionar(Cozinha cozinha) {
		return cozinhaRepository.adicionarBD(cozinha);
	}
	
	public List<Cozinha> listarTodas(){
		return cozinhaRepository.buscarTodas();
	}
	
	public Cozinha buscar(Long id){
		
		if(id == null) {
			throw new AtributoNuloException("Id da Cozinha não pode ser nulo.");
		}
		
		Cozinha cozinha = cozinhaRepository.buscarPorId(id);
		
		if(cozinha != null) {
			throw new EntidadeNaoEncontradaException(String.format("Cozinha com id %d não foi encontradas.", id));
		} 
		
		return cozinhaRepository.buscarPorId(id);
	}
	
	public Cozinha atualizar(Long id, Cozinha cozinha){	
		try {
			return cozinhaRepository.atualizarBD(id, cozinha);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cozinha não existe com o código %d", id));
		} 
	}
	
	public void remover(Long cozinhaId){
		try {
			cozinhaRepository.removerBD(cozinhaId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cozinha não existe com o código %d", cozinhaId));
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}
}
