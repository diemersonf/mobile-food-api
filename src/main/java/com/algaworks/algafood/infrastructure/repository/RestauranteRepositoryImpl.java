package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> buscarTodas (){
		return manager.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}
	
	@Override
	public Restaurante buscarPorId(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Override
	public List<Restaurante> buscarPorNome(String nome){
		return manager.createQuery("from Restaurante where nome like :nome", Restaurante.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

	@Override
	@Transactional
	public Restaurante adicionarBD(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	
	@Override
	@Transactional
	public void removerBD(Restaurante restaurante) {
		manager.remove(manager.merge(restaurante));
	}

	@Override
	@Transactional
	public Restaurante atualizarBD(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
}
