package com.diemerson.mobilefood.jpa.endereco;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.Cidade;
import com.diemerson.mobilefood.domain.model.Endereco;
import com.diemerson.mobilefood.domain.model.EnderecoId;
import com.diemerson.mobilefood.domain.model.Estado;
import com.diemerson.mobilefood.domain.repository.CidadeRepository;
import com.diemerson.mobilefood.domain.repository.EnderecoRepository;
import com.diemerson.mobilefood.domain.repository.EstadoRepository;

public class EnderecoCadastrarMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EnderecoRepository enderecos = applicationContext.getBean(EnderecoRepository.class);
		CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);

		
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		estado = estados.buscarPorSigla("SP");
		cidade = cidades.buscarPorNomeEstado("Sao Jose do Rio Preto", estado);
				
		EnderecoId enderecoId = new EnderecoId();
		enderecoId.setCidade(cidade);
		enderecoId.setLougradouro("Travessa Arif Meher");
		enderecoId.setNumero("28");
		
		Endereco endereco = new Endereco();
		endereco.setId(enderecoId);
		endereco.setBairro("Vila Curti");
		endereco.setCep("15030567");
		endereco.setComplemento("Casa");
		
		enderecos.adicionarBD(endereco);
	}
}
