package com.diemerson.mobilefood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.diemerson.mobilefood.domain.model.Cidade;
import com.diemerson.mobilefood.domain.model.Estado;
import com.diemerson.mobilefood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cidade> buscarTodas() {
		return manager.createQuery("from Cidade", Cidade.class)
				.getResultList();	
	}
	
	@Override
	public Cidade buscarPorNome(String nome, Estado sigla){
		return manager.createQuery("from Cidade where nome = :nome and estado = :sigla", Cidade.class)
				.setParameter("nome", nome)
				.setParameter("sigla", sigla)
				.getSingleResult();	
	}

}
