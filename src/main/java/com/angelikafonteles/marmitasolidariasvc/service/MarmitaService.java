package com.angelikafonteles.marmitasolidariasvc.service;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelikafonteles.marmitasolidariasvc.dto.MarmitaDTO;
import com.angelikafonteles.marmitasolidariasvc.exceptions.ObjectNotFoundException;
import com.angelikafonteles.marmitasolidariasvc.model.Marmita;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;
import com.angelikafonteles.marmitasolidariasvc.repositories.MarmitaRepository;
import com.angelikafonteles.marmitasolidariasvc.repositories.RestauranteRepository;

@Service
public class MarmitaService {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	@Autowired
	private MarmitaRepository repo;
	
	public Marmita findById(String id) {
		Optional<Marmita> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Marmita insert(Marmita obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	
}
