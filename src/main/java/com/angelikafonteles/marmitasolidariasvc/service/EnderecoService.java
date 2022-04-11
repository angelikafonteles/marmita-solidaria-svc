package com.angelikafonteles.marmitasolidariasvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.angelikafonteles.marmitasolidariasvc.dto.EnderecoUpdateDTO;
import com.angelikafonteles.marmitasolidariasvc.exceptions.ObjectNotFoundException;
import com.angelikafonteles.marmitasolidariasvc.model.Endereco;
import com.angelikafonteles.marmitasolidariasvc.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public Endereco findById(String id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Endereco searchByCep(String cep) {

		RestTemplate restTemplate = new RestTemplate();

		Endereco endereco = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", Endereco.class);
		return endereco;
	}

	public Endereco update(String id, EnderecoUpdateDTO obj) {

		Endereco newObj = searchByCep(obj.getCep());
		newObj.setId(id);
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());

		return repo.save(newObj);
	}

}
