package com.algaworks.algafood.jpa.restaurante;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteAlteraMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante = restaurantes.buscarPorId(2L);
		
		System.out.printf("Nome do restaurante antes da alteração: %s", restaurante.getNome());
		
		restaurante.setNome("Chinesa");
		restaurantes.adicionarBD(restaurante);

		System.out.printf("Nome do restaurante depois da alteração: %s", restaurantes.buscarPorId(2L).getNome());

	}
}
