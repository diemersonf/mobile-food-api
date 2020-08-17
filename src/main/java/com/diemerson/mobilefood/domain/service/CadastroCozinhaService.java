package com.diemerson.mobilefood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
		return cozinhaRepository.save(cozinha);
	}
	
	public List<Cozinha> listarTodas(){
		return cozinhaRepository.findAll();
	}
	
	public Cozinha buscar(Long id){
		
		if(id == null) {
			throw new AtributoNuloException("Id da Cozinha não pode ser nulo.");
		}
		
		Cozinha cozinha = cozinhaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Cozinha com id %d não foi encontradas.", id)));

		return cozinha;
	}
	
	public Cozinha atualizar(Long id, Cozinha cozinha){	
		try {
			Cozinha cozinhaAtual = cozinhaRepository.findById(id)
					.orElseThrow(() -> new EntidadeNaoEncontradaException(
							String.format("Cozinha com id %d não foi encontradas.", id)));

			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			return cozinhaRepository.save(cozinhaAtual);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cozinha não existe com o código %d", id));
		} 
	}
	
	public void remover(Long cozinhaId){
		try {
			cozinhaRepository.deleteById(cozinhaId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cozinha não existe com o código %d", cozinhaId));
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}
}
