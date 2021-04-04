package com.mercadolibre.app.mutantes.models.service;

import java.util.List;
import com.mercadolibre.app.mutantes.models.entity.Adn;

public interface IAdnService {
	public List<Adn> findAll();
	public Adn findById(Long id);
	public Adn save(Adn adn);
	public void delete(Long id);
	public Adn findByDna(String dna);
	public List<Adn> findByisMutantTrue();
	public List<Adn> findByisMutantFalse();
}
