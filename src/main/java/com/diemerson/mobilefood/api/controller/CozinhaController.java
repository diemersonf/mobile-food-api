package com.diemerson.mobilefood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diemerson.mobilefood.domain.exception.EntidadeEmUsoException;
import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Cozinha;
import com.diemerson.mobilefood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinhaService.adicionar(cozinha);
	}
	
	@GetMapping
	public List<Cozinha> listar(){
		return cadastroCozinhaService.listarTodas();
	}
	
	@GetMapping(value = "/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){	
		Cozinha cozinha = cadastroCozinhaService.buscar(cozinhaId);
	
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		} 
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value = "/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, 
			@RequestBody Cozinha cozinha) {
		try {
			cozinha = cadastroCozinhaService.atualizar(cozinhaId, cozinha);
			return ResponseEntity.ok(cozinha);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping(value = "{cozinhaId}")
	public ResponseEntity<Cozinha> deletar(@PathVariable Long cozinhaId) {		
		try{
			cadastroCozinhaService.remover(cozinhaId);
			return ResponseEntity.noContent().build();
			
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
