package com.algaworks.algafood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class CozinhaBuscaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		Cozinha cozinha = new Cozinha();
		
		cozinha = cozinhas.buscarPorId(4L);
		
		try {
			System.out.println("Cozinha Encontrada: " + cozinha.getId() + " - " + cozinha.getNome());
		}catch (NullPointerException e) {
			System.out.println("Objeto pesquisado não encontrado.");
		} 
	}
}
