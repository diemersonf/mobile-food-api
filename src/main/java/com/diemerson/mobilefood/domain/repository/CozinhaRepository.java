package com.diemerson.mobilefood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diemerson.mobilefood.domain.model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
//	Cozinha buscarPorNome(String nome);
}
