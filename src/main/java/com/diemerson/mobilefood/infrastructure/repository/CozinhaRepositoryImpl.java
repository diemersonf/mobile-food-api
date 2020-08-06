package com.diemerson.mobilefood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.diemerson.mobilefood.domain.model.Cozinha;
import com.diemerson.mobilefood.domain.repository.CozinhaRepository;

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
	public void removerBD(Long id) {
		Cozinha cozinha = new Cozinha();
		cozinha = this.buscarPorId(id);
		
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(cozinha);
	}

	@Override
	@Transactional
	public Cozinha atualizarBD(Long cozinhaId, Cozinha cozinha) {
		Cozinha cozinhaBd = new Cozinha();
		cozinhaBd = this.buscarPorId(cozinhaId);
		
		if(cozinhaBd == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(cozinha, cozinhaBd);
		return this.adicionarBD(cozinhaBd);
	}
}
