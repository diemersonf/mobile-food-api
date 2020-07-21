package com.algaworks.algafood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class CozinhaRemoveMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha = cozinhas.buscarPorId(3L);
		 
		System.out.printf("Nome da Cozinha antes da remoção: %s \n\n", cozinha.getNome());

		try {
			cozinhas.removerBD(cozinha);
			System.out.println("Cozinha removida com sucesso!!!");
		}catch (IllegalArgumentException e) {
			System.out.println("Cozinha não foi removida. " + e);
		}

	}
}
