package com.diemerson.mobilefood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.diemerson.mobilefood.domain.model.Estado;
import com.diemerson.mobilefood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> buscarTodos() {
		return manager.createQuery("from Estado", Estado.class)
				.getResultList();	}

	@Override
	public Estado buscarPorSigla(String sigla) {
		return manager.createQuery("from Estado where sigla = :sigla", Estado.class)
				.setParameter("sigla", sigla)
				.getSingleResult();
	}

}
