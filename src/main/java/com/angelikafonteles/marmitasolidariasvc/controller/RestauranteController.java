package com.angelikafonteles.marmitasolidariasvc.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.angelikafonteles.marmitasolidariasvc.dto.RestauranteDTO;
import com.angelikafonteles.marmitasolidariasvc.dto.RestauranteInsertDTO;
import com.angelikafonteles.marmitasolidariasvc.dto.RestauranteUpdateDTO;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;
import com.angelikafonteles.marmitasolidariasvc.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RestauranteDTO>> findAll(){
	
		List<Restaurante> list = service.findAll();
		List<RestauranteDTO> listDto = list.stream().map(x -> new RestauranteDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Restaurante> findById(@PathVariable String id){
		Restaurante obj = service.findById(id);;
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)//, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@RequestBody RestauranteInsertDTO objDto){
		Restaurante obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody RestauranteUpdateDTO objDto, @PathVariable String id){
		service.update(id, objDto);
		return ResponseEntity.noContent().build();
	}

}
