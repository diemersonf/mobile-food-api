package com.diemerson.mobilefood.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.diemerson.mobilefood.domain.exception.EntidadeNaoEncontradaException;
import com.diemerson.mobilefood.domain.model.Cozinha;
import com.diemerson.mobilefood.domain.model.Restaurante;
import com.diemerson.mobilefood.domain.repository.CozinhaRepository;
import com.diemerson.mobilefood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	CozinhaRepository cozinhaRepository;

	@Override
	public List<Restaurante> buscarTodos() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscarPorId(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Override
	public List<Restaurante> buscarPorNome(String nome) {
		return manager.createQuery("from Restaurante where nome like :nome", Restaurante.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

	@Override
	@Transactional
	public Restaurante adicionarBD(Restaurante restaurante) {
		List<Cozinha> cozinhas = new ArrayList<Cozinha>();
		Cozinha cozinhaBd = new Cozinha();

		if (restaurante.getCozinhas() == null) {
			throw new EmptyResultDataAccessException("Nenhuma cozinha foi informada", 1);
		}

		for (Cozinha cozinha : restaurante.getCozinhas()) {
			cozinhaBd = cozinhaRepository.buscarPorId(cozinha.getId());
			if (cozinhaBd == null) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d.", cozinha.getId()));
			}
			cozinhas.add(cozinhaBd);
		}

		restaurante.setCozinhas(cozinhas);

		return manager.merge(restaurante);
	}

	@Override
	@Transactional
	public Restaurante atualizarBD(Long restauranteId, Restaurante restaurante) {
		List<Cozinha> cozinhas = new ArrayList<Cozinha>();
		Cozinha cozinhaBd = new Cozinha();

		Restaurante restauranteBd = new Restaurante();
		restauranteBd = this.buscarPorId(restauranteId);

		if (restauranteBd == null) {
			throw new EmptyResultDataAccessException("ResourceNotFound", 1);
		}

		if (restaurante.getCozinhas() == null || restaurante.getCozinhas().isEmpty()) {
			throw new EmptyResultDataAccessException("Nenhuma cozinha foi informada no cadastro. Verifique!", 1);
		}

		BeanUtils.copyProperties(restaurante, restauranteBd);

		for (Cozinha cozinha : restaurante.getCozinhas()) {
			if (cozinha.getId() == null) {
				throw new EmptyResultDataAccessException("Cozinha informada não pode ser nula. Verifique!", 1);
			}
			cozinhaBd = cozinhaRepository.buscarPorId(cozinha.getId());
			if (cozinhaBd == null) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d.", cozinha.getId()));
			}
			cozinhas.add(cozinhaBd);
		}
		restauranteBd.setCozinhas(cozinhas);

		return manager.merge(restauranteBd);
	}

	@Override
	@Transactional
	public void removerBD(Long restauranteId) {
		Restaurante restaurante = this.buscarPorId(restauranteId);
		if(restaurante == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(restaurante);
	}
}
