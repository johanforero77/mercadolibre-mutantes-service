package com.mercadolibre.app.mutantes.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadolibre.app.mutantes.models.dao.AdnDao;
import com.mercadolibre.app.mutantes.models.entity.Adn;

@Service
public class AdnServiceImpl implements IAdnService{
	
	@Autowired
	private AdnDao adnDao;

	@Override
	@Transactional (readOnly = true)
	public List<Adn> findAll() {
		return (List<Adn>) adnDao.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Adn findById(Long id) {
		return adnDao.findById(id).orElse(null);
	}

	@Override
	public Adn save(Adn adn) {
		return adnDao.save(adn);
	}

	@Override
	public void delete(Long id) {
		adnDao.deleteById(id);
		
	}

	@Override
	public Adn findByDna(String dna) {
		return adnDao.findByDnaRepo(dna);
	}

	@Override
	public List<Adn> findByisMutantTrue() {
		return adnDao.findByisMutantTrue();
	}

	@Override
	public List<Adn> findByisMutantFalse() {
		return adnDao.findByisMutantFalse();
	}

}
