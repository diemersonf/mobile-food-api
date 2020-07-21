package com.algaworks.algafood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class CozinhaAlteraMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha = cozinhas.buscarPorId(2L);
		
		System.out.printf("Nome da Cozinha antes da alteração: %s", cozinha.getNome());
		
		cozinha.setNome("Chinesa");
		cozinhas.adicionarBD(cozinha);

		System.out.printf("Nome da Cozinha depois da alteração: %s", cozinhas.buscarPorId(2L).getNome());

	}
}
