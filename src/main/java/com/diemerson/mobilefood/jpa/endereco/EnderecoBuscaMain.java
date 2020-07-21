package com.diemerson.mobilefood.jpa.endereco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.Endereco;
import com.diemerson.mobilefood.domain.repository.EnderecoRepository;

public class EnderecoBuscaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EnderecoRepository enderecos = applicationContext.getBean(EnderecoRepository.class);

		List<Endereco> endereco = new ArrayList<>();
		endereco = enderecos.buscarPorLogradouro("Pira");
		
		for(Endereco end : endereco) {
			System.out.printf("\nEndereco localizado: %s %s %s"
					,end.getCep()
					,end.getId().getLougradouro()
					,end.getId().getNumero()
					,end.getId().getCidade().getNome());
		}
	}
}
