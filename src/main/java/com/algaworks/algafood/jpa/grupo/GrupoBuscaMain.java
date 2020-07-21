package com.algaworks.algafood.jpa.grupo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.MobileFoodApiApplication;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;

public class GrupoBuscaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		GrupoRepository grupoRepository = applicationContext.getBean(GrupoRepository.class);

		Grupo grupo = new Grupo();
		grupo = grupoRepository.buscarPorNome("Funcionario");
		
		try {
			System.out.println("Grupo Encontrado: " + grupo.getNome() + " - " + grupo.getDescricao());
		}catch (NullPointerException e) {
			System.out.println("Objeto pesquisado não encontrado.");
		} 
	}
}