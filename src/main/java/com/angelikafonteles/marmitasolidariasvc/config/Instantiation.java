package com.angelikafonteles.marmitasolidariasvc.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.angelikafonteles.marmitasolidariasvc.model.Endereco;
import com.angelikafonteles.marmitasolidariasvc.model.Marmita;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;
import com.angelikafonteles.marmitasolidariasvc.repositories.EnderecoRepository;
import com.angelikafonteles.marmitasolidariasvc.repositories.MarmitaRepository;
import com.angelikafonteles.marmitasolidariasvc.repositories.RestauranteRepository;


@Configuration
public class Instantiation implements CommandLineRunner{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Autowired
	RestauranteRepository restauranteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	MarmitaRepository marmitaRepository;
	
	public void run(String... args) throws Exception {
		
		
		restauranteRepository.deleteAll();
		enderecoRepository.deleteAll();
		marmitaRepository.deleteAll();
		
		obterMock();
		
	}	
	
	private Restaurante obterMock() throws ParseException {
		
		Restaurante restaurante = new Restaurante();
		restaurante.setRazaoSocial("MARIA JOSE ME");
		restaurante.setCnpj("10.123.456/0001-00");
		restaurante.setNomeFantasia("Comida Caseira");
		restaurante.setEmail("comida-caseira@gmail.com");
		restaurante.setTelefone("32323434");
		
		restauranteRepository.save(restaurante);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Imaginaria");
		endereco.setNumero("100");
		endereco.setComplemento("");
		endereco.setBairro("Imbiribeira");
		endereco.setCidade("Recife");
		endereco.setUf("PE");
		
		enderecoRepository.save(endereco);
		
		Marmita marmita = new Marmita();
		marmita.setDataFeitura(sdf.parse("09/04/2022 18:48:12"));
		marmita.setDescricao("arroz, feijão, frango e verdura");
		marmita.setObservacao("");
		marmita.setQuantidade(5);
		
		Marmita marmita2 = new Marmita();
		marmita2.setDataFeitura(sdf.parse("09/04/2022 18:40:12"));
		marmita2.setDescricao("arroz, feijão, carne e purê");
		marmita2.setObservacao("");
		marmita2.setQuantidade(3);
		
		marmitaRepository.saveAll(Arrays.asList(marmita, marmita2));
		
		restaurante.setEndereco(endereco);
		restaurante.getMarmitas().add(marmita);
		restaurante.getMarmitas().add(marmita2);
		
		restauranteRepository.save(restaurante);
		
		return restaurante;
	}
}
