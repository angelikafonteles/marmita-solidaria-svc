package com.angelikafonteles.marmitasolidariasvc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, String>{
	
	List<Restaurante> findByEmail(String email);
}
