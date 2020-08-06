package com.diemerson.mobilefood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Cidade;
import com.diemerson.mobilefood.domain.model.Estado;
import com.diemerson.mobilefood.domain.repository.CidadeRepository;
import com.diemerson.mobilefood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Cidade> listarTodas(){
		return cidadeRepository.buscarTodas();
	}
	
	public Cidade buscarPorNome(String nomeCidade){
		return cidadeRepository.buscarPorNome(nomeCidade);
	}
	
	public Cidade buscarPorNomeEstado(String nomeCidade, String sigla){
		Estado estado = new Estado();
		
		estado = estadoRepository.buscarPorSigla(sigla);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException("Estado %s não encontrado.");
		}
		
		return cidadeRepository.buscarPorNomeEstado(nomeCidade, estado);
	}
	
	/* 
	 * TODO adicionar atualização parcial de cidade para ativar 
	 * ou desativar o atendimento do mobilefood em uma cidade
	 */
}