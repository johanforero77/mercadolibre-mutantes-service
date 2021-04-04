package com.mercadolibre.app.mutantes.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mercadolibre.app.mutantes.models.entity.Adn;


public interface AdnDao extends CrudRepository <Adn, Long>{
	
	public Adn findByDnaRepo(String dna);
	public List<Adn> findByisMutantTrue();
	public List<Adn> findByisMutantFalse();

}
