package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;

@Component
public class GrupoRepositoryImpl implements GrupoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Grupo> buscarTodas() {
		return manager.createQuery("from Grupo", Grupo.class)
			.getResultList();
	}

	@Override
	public Grupo buscarPorNome(String nome) {
		System.out.println("Passo 4");

		return manager.createQuery("from Grupo where nome = :nome", Grupo.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	@Transactional
	public Grupo adicionarBD(Grupo grupo) {
		return manager.merge(grupo);
	}

	@Override
	@Transactional
	public Grupo atualizarBD(Grupo grupo) {
		return manager.merge(grupo);
	}

	@Override
	@Transactional
	public void removerBD(Grupo grupo) {
		manager.remove(manager.merge(grupo));
	}

}
