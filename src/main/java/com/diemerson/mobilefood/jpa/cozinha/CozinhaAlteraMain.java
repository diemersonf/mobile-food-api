package com.diemerson.mobilefood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.Cozinha;
import com.diemerson.mobilefood.domain.repository.CozinhaRepository;

public class CozinhaAlteraMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha = cozinhas.findById(2L).get();
		
		System.out.printf("Nome da Cozinha antes da alteração: %s", cozinha.getNome());
		
		cozinha.setNome("Chinesa");
		cozinhas.save(cozinha);

		System.out.printf("Nome da Cozinha depois da alteração: %s", cozinhas.findById(2L).get().getNome());

	}
}
