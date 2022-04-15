package com.angelikafonteles.marmitasolidariasvc.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.angelikafonteles.marmitasolidariasvc.dto.MarmitaDTO;
import com.angelikafonteles.marmitasolidariasvc.model.Marmita;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;
import com.angelikafonteles.marmitasolidariasvc.service.MarmitaService;
import com.angelikafonteles.marmitasolidariasvc.service.RestauranteService;

@RestController
@RequestMapping(value = "/marmitas")
public class MarmitaController {
	
	@Autowired
	private MarmitaService service;
	@Autowired
	private RestauranteService restauranteService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Marmita> findById(@PathVariable String id){
		Marmita obj = service.findById(id);;
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)//, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insert(@RequestBody Marmita obj){
		obj = service.insert(obj);
		Restaurante restaurante = restauranteService.findById(obj.getRestauranteId());
		restaurante.getMarmitas().add(obj);
		restauranteService.save(restaurante);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj.getId());
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		Marmita marmita = service.findById(id);
		Restaurante restaurante = restauranteService.findById(marmita.getRestauranteId());
		restaurante.getMarmitas().removeIf(obj -> obj.getId().equals(id));
		restauranteService.save(restaurante);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
