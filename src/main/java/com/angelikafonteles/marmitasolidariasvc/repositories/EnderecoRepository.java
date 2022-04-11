package com.angelikafonteles.marmitasolidariasvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.angelikafonteles.marmitasolidariasvc.model.Endereco;
import com.angelikafonteles.marmitasolidariasvc.model.Restaurante;


@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String>{
	
}
