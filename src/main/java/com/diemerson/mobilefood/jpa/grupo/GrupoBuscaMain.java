package com.diemerson.mobilefood.jpa.grupo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.Grupo;
import com.diemerson.mobilefood.domain.model.Permissao;
import com.diemerson.mobilefood.domain.repository.GrupoRepository;

public class GrupoBuscaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		GrupoRepository grupoRepository = applicationContext.getBean(GrupoRepository.class);

		Grupo grupo = new Grupo();
		grupo = grupoRepository.buscarPorNome("Diretor");
		List<Permissao> permissoes = new ArrayList<>();
		permissoes = grupo.getPermissoes();
		
		try {
			System.out.printf("\nGrupo Encontrado: %s %s\n", grupo.getNome(), grupo.getDescricao());
			
			for(Permissao permissao : permissoes) {
				System.out.printf("Permissão do %s Permissão: %s\n", grupo.getNome(), permissao.getNome());
			}
		}catch (NullPointerException e) {
			System.out.println("Objeto pesquisado não encontrado.");
		} 
	}
}