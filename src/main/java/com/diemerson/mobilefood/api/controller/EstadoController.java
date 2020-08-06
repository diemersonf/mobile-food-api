package com.diemerson.mobilefood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diemerson.mobilefood.domain.exception.AtributoNuloException;
import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Estado;
import com.diemerson.mobilefood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(value = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {
	
	@Autowired
	private CadastroEstadoService cadastroEstadoService;	
	
	@GetMapping
	public List<Estado> listar(){
		return cadastroEstadoService.listarTodos();
	}
	
	@GetMapping(value = "/{estadoSigla}")
	public ResponseEntity<?> listar(@PathVariable String estadoSigla){
		Estado estado = new Estado();
		try {
			estado = cadastroEstadoService.buscarPorSigla(estadoSigla);
			return ResponseEntity.ok().body(estado);
		} catch (AtributoNuloException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
