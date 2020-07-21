package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> buscarTodas (){
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}
	
	@Override
	public Cozinha buscarPorId(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Override
	public Cozinha buscarPorNome(String nome) {
		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
				.setParameter("nome","%" + nome + "%")
				.getSingleResult();
	}
	
	@Override
	@Transactional
	public Cozinha adicionarBD(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Override
	@Transactional
	public void removerBD(Cozinha cozinha) {
		manager.remove(manager.merge(cozinha));
	}

	@Override
	@Transactional
	public Cozinha atualizarBD(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
}
