package com.diemerson.mobilefood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Restaurante;
import com.diemerson.mobilefood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar(){
		return cadastroRestauranteService.listarTodos();				
	}
	
	@GetMapping("{restauranteId}")
	public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long restauranteId){
		try {
			return ResponseEntity.ok(cadastroRestauranteService.buscarPorId(restauranteId));
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Restaurante adicionar(@RequestBody Restaurante restaurante) {
		return cadastroRestauranteService.adicionar(restaurante);
	}

}
