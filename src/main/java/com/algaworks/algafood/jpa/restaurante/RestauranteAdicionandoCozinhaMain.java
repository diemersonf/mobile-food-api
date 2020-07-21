package com.algaworks.algafood.jpa.restaurante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteAdicionandoCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		List<Cozinha> cozinhas = new ArrayList<Cozinha>();
		
		Cozinha chinesa = new Cozinha();
		chinesa.setNome("Chinesa");
		
		Cozinha indiana = new Cozinha();
		indiana.setNome("Indiana");
		
		Cozinha acai = new Cozinha();
		acai.setNome("Acai");
		
		cozinhas.add(indiana);
		cozinhas.add(chinesa);
		cozinhas.add(acai);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("China in Box");
		restaurante.setTaxaFrete(new BigDecimal(3.99));
		restaurante.setCozinhas(cozinhas);
		
		restaurantes.adicionarBD(restaurante);
	}
}
