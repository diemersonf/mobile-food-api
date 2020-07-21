package com.diemerson.mobilefood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.diemerson.mobilefood.domain.model.Permissao;
import com.diemerson.mobilefood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permissao> buscarTodas() {
		return manager.createQuery("from Permissao", Permissao.class)
			.getResultList();
	}

	@Override
	public Permissao buscarPorNome(String nome) {
		return manager.createQuery("from Permissao where nome = :nome", Permissao.class)	
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	@Transactional
	public Permissao adicionarBD(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	@Transactional
	public Permissao atualizarBD(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	@Transactional
	public void removerBD(Permissao permissao) {
		manager.remove(manager.merge(permissao));
	}

}
