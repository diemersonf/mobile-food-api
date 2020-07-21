package com.diemerson.mobilefood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.diemerson.mobilefood.domain.model.FormaPagamento;
import com.diemerson.mobilefood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> buscarTodas (){
		return manager.createQuery("from FormaPagamento", FormaPagamento.class)
				.getResultList();
	}
	
	@Override
	public FormaPagamento buscarPorId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Override
	public FormaPagamento buscarPorNome(String nome) {
		return manager.createQuery("from FormaPagamento where nome = :nome", FormaPagamento.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
	
	@Override
	@Transactional
	public FormaPagamento adicionarBD(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
	
	@Override
	@Transactional
	public void removerBD(FormaPagamento formaPagamento) {
		manager.remove(manager.merge(formaPagamento));
	}

	@Override
	@Transactional
	public FormaPagamento atualizarBD(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
}
