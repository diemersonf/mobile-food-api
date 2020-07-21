package com.diemerson.mobilefood.jpa.formapagamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diemerson.mobilefood.MobileFoodApiApplication;
import com.diemerson.mobilefood.domain.model.FormaPagamento;
import com.diemerson.mobilefood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoBuscaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MobileFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository FormaPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);

		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento = FormaPagamentos.buscarPorNome("cartao de credito");
		
		System.out.printf("\nForma de pagamento: %s", formaPagamento.getNome());
	}
}
