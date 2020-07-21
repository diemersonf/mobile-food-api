package com.diemerson.mobilefood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.diemerson.mobilefood.domain.model.Endereco;
import com.diemerson.mobilefood.domain.repository.EnderecoRepository;

@Component
public class EnderecoRepositoryImpl implements EnderecoRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Endereco> buscarTodos (){
		return manager.createQuery("from Endereco", Endereco.class)
				.getResultList();
	}
	
	@Override
	public List<Endereco> buscarPorCep(String cep) {
		return manager.createQuery("from Endereco where cep = :cep", Endereco.class)
				.setParameter("cep", cep)
				.getResultList();
	}

	@Override
	public List<Endereco> buscarPorLogradouro(String lougradouro) {
		return manager.createQuery("from Endereco where lougradouro like :lougradouro", Endereco.class)
				.setParameter("lougradouro", "%" + lougradouro + "%")
				.getResultList();
	}

	@Override
	@Transactional
	public Endereco adicionarBD(Endereco endereco) {
		return manager.merge(endereco);
	}
	
	@Override
	@Transactional
	public void removerBD(Endereco endereco) {
		manager.remove(manager.merge(endereco));
	}

	@Override
	@Transactional
	public Endereco atualizarBD(Endereco endereco) {
		return manager.merge(endereco);
	}
}
