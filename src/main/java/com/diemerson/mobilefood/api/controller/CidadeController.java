package com.diemerson.mobilefood.api.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Cidade;
import com.diemerson.mobilefood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {
	
	@Autowired
	private CadastroCidadeService cadastroCidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		return cadastroCidadeService.listarTodas();
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<?> buscarPorNome(
			@RequestParam(value = "cidadeNome") String nomeCidade, 
			@RequestParam(value = "estadoSigla", required = false) String siglaEstado) {
		
		Cidade cidade = new Cidade();
		
		try {
			if(siglaEstado != null) 
				cidade = cadastroCidadeService.buscarPorNomeEstado(nomeCidade, siglaEstado);
			else
				cidade = cadastroCidadeService.buscarPorNome(nomeCidade);
				
			return ResponseEntity.ok(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (NoResultException e) {
			return ResponseEntity.noContent().build();
		}
	}
}
