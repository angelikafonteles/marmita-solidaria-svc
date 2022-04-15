package com.angelikafonteles.marmitasolidariasvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelikafonteles.marmitasolidariasvc.dto.EnderecoUpdateDTO;
import com.angelikafonteles.marmitasolidariasvc.model.Endereco;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;
import com.angelikafonteles.marmitasolidariasvc.service.EnderecoService;
import com.angelikafonteles.marmitasolidariasvc.service.RestauranteService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	@Autowired
	private RestauranteService restauranteService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findById(@PathVariable String id){
		Endereco obj = service.findById(id);;
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody EnderecoUpdateDTO objDto, @PathVariable String id){
		Endereco endereco = service.update(id, objDto);
		Restaurante restaurante = restauranteService.findById(objDto.getRestauranteId());
		restaurante.setEndereco(endereco);
		restauranteService.save(restaurante);
		return ResponseEntity.noContent().build();
	}

}
