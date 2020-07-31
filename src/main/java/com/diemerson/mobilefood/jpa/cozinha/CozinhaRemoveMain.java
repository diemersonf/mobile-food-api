package com.diemerson.mobilefood.jpa.cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.repository.CozinhaRepository;

public class CozinhaRemoveMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		System.out.printf("Nome da Cozinha antes da remoção: %s \n\n", cozinhas.buscarPorId(3L).getNome());

		try {
			cozinhas.removerBD(3L);
			System.out.println("Cozinha removida com sucesso!!!");
		}catch (IllegalArgumentException e) {
			System.out.println("Cozinha não foi removida. " + e);
		}

	}
}
