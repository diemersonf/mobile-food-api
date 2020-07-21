package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> buscarTodas() {
		return manager.createQuery("from Estado", Estado.class)
				.getResultList();	}

	@Override
	public Estado buscarPorSigla(String sigla) {
		return manager.createQuery("from Estado where sigla = :sigla", Estado.class)
				.setParameter("sigla", sigla)
				.getSingleResult();
	}

}
