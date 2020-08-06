package com.diemerson.mobilefood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diemerson.mobilefood.domain.exception.AtributoNuloException;
import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Estado;
import com.diemerson.mobilefood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> listarTodos(){
		return estadoRepository.buscarTodos();
	}
	
	public Estado buscarPorSigla(String sigla){
		
		if(sigla == null) {
			throw new AtributoNuloException("Estado não pode ser nulo.");
		}
		
		Estado estado = new Estado();
		estado = estadoRepository.buscarPorSigla(sigla);
		
		if(estado != null) {
			throw new EntidadeNaoEncontradaException(String.format("Estado %s não encontrado.", sigla));
		}
		
		return estado;
	}
	
	/* 
	 * TODO adicionar atualização parcial de estado para ativar 
	 * ou desativar o atendimento a um estado
	 */
}