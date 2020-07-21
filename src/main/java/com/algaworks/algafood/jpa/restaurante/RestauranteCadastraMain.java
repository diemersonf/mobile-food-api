package com.algaworks.algafood.jpa.restaurante;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteCadastraMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Cozinha Gaucha");
		restaurante.setTaxaFrete(new BigDecimal(9.99));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2 = restaurantes.adicionarBD(restaurante);
		
		System.out.printf("Restaurante antes da atualização: Nome: %s Taxa: %.2f ", restaurante2.getNome(), restaurante2.getTaxaFrete());

	}
}
