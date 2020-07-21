package com.algaworks.algafood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class CozinhaCadastraMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Acai");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Francesa");
//		
//		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
//		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());

		cozinha1 = cozinhas.adicionarBD(cozinha1);
		cozinha2 = cozinhas.adicionarBD(cozinha2);
	
//		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
//		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}
}
