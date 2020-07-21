package com.diemerson.mobilefood.jpa.restaurante;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.Restaurante;
import com.diemerson.mobilefood.domain.repository.RestauranteRepository;

public class RestauranteRemoveMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante = restaurantes.buscarPorId(2L);
		
		System.out.printf("Restaurante antes da remoção: Nome: %s Taxa: %.2f ", restaurante.getNome(), restaurante.getTaxaFrete());
		
		restaurantes.removerBD(restaurante);

	}
}
