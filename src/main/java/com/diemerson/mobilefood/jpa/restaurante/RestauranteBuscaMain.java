package com.diemerson.mobilefood.jpa.restaurante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.Restaurante;
import com.diemerson.mobilefood.domain.repository.RestauranteRepository;

public class RestauranteBuscaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante = new Restaurante();
		restaurante = restaurantes.buscarPorId(4L);
		
		try {
			System.out.println("Cozinha Encontrada: " + restaurante.getId() + " - " + restaurante.getNome());
		}catch (NullPointerException e) {
			System.out.println("Objeto pesquisado não encontrado.");
		} 
		
		List<Restaurante> restaurante2 = new ArrayList<>();
		restaurante2 = restaurantes.buscarPorNome("maria");
		
		for(Restaurante rest : restaurante2) {
			System.out.printf("\nRestaurante: %s", rest.getNome());
		}
	}
}
