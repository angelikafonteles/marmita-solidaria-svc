package com.angelikafonteles.marmitasolidariasvc.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelikafonteles.marmitasolidariasvc.dto.RestauranteInsertDTO;
import com.angelikafonteles.marmitasolidariasvc.dto.RestauranteUpdateDTO;
import com.angelikafonteles.marmitasolidariasvc.exceptions.ObjectNotFoundException;
import com.angelikafonteles.marmitasolidariasvc.model.Endereco;
import com.angelikafonteles.marmitasolidariasvc.model.Marmita;
import com.angelikafonteles.marmitasolidariasvc.model.RequestWrapper;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;
import com.angelikafonteles.marmitasolidariasvc.repositories.EnderecoRepository;
import com.angelikafonteles.marmitasolidariasvc.repositories.RestauranteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class RestauranteService {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	@Autowired
	private RestauranteRepository repo;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private MarmitaService marmitaService;
	
	public List<Restaurante> findAll(){
		return repo.findAll();
	}
	
	public Restaurante findById(String id) {
		Optional<Restaurante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Restaurante findByEmail(String email) {
		List<Restaurante> list = repo.findByEmail(email);
		if (list != null && !list.isEmpty()) {
			Restaurante obj = list.get(0);
			return obj;
		}
		else {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
	public Restaurante insert(RestauranteInsertDTO objDto) {
		Restaurante restaurante = fromDTO(objDto);
		Endereco endereco = restaurante.getEndereco();
		endereco = enderecoService.insert(endereco);
		restaurante.setEndereco(endereco);
		return repo.insert(restaurante);
	}
	
	public void save(Restaurante obj) {
		repo.save(obj);
	}
	
	public void delete(String id) {
		
		Restaurante restaurante = findById(id);
		enderecoService.delete(restaurante.getEndereco().getId());
		for (Marmita marmita : restaurante.getMarmitas()) {
			marmitaService.delete(marmita.getId());
		}
		repo.deleteById(id);
	}
	
	public Restaurante update(String id, RestauranteUpdateDTO objDto) {
		Restaurante obj = findById(id);
		obj.setEmail(objDto.getEmail());
		obj.setTelefone(objDto.getTelefone());
		return repo.save(obj);
	}
	
	public Restaurante fromDTO(RestauranteInsertDTO objDto) {
		Restaurante resturante = new Restaurante();
		resturante.setRazaoSocial(objDto.getRazaoSocial());
		resturante.setCnpj(objDto.getCnpj());
		resturante.setNomeFantasia(objDto.getNomeFantasia());
		resturante.setEmail(objDto.getEmail());
		resturante.setTelefone(objDto.getTelefone());
		
		Endereco endereco = enderecoService.searchByCep(objDto.getCep());
		endereco.setNumero(objDto.getNumero());
		endereco.setComplemento(objDto.getComplemento());
		
		resturante.setEndereco(endereco);
		return resturante;
		
	}
}
