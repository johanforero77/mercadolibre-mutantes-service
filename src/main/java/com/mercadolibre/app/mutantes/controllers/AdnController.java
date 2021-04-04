package com.mercadolibre.app.mutantes.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolibre.app.mutantes.models.entity.Adn;
import com.mercadolibre.app.mutantes.models.service.IAdnService;


@RestController
public class AdnController {

	@Autowired
	private IAdnService adnService;

	@PostMapping("/mutant")
	public ResponseEntity<Adn> mutant(@RequestBody Adn dna) {
		boolean isMutant = isMutant(dna);
		dna.setMutant(isMutant);
		save(dna);
		if (isMutant) {
			return new ResponseEntity<Adn>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Adn>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/stats")
    public ResponseEntity<?> stats(){
		Map<String, String> json = new HashMap<>();
		
		int mutants = adnService.findByisMutantTrue().size();
		int humans = adnService.findByisMutantFalse().size();
		double ratio = (double) mutants/humans;
		json.put("count_mutant_dna", String.valueOf(mutants));
		json.put("count_human_dna", String.valueOf(humans));
		json.put("ratio", String.valueOf(ratio));
		
		return new ResponseEntity<Map<String, String>>(json,HttpStatus.OK);
		
	}

	private boolean isMutant(Adn dna) {
		return dna.validateAdn(dna.getDna());
	}

	private void save(Adn dna) {
		arrayTostring(dna);
		Adn adn = adnExist(dna);
		if (adn == null) {
			adnService.save(dna);
		}

	}

	private Adn adnExist(Adn dna) {
		return adnService.findByDna(dna.getDnaRepo());
	}

	private void arrayTostring(Adn dna) {
		StringBuffer chain = new StringBuffer();
		for (int i = 0; i < dna.getDna().length; i++) {
			chain = chain.append(dna.getDna()[i]);
		}
		dna.setDnaRepo(chain.toString());
	}

	@GetMapping("/list")
	public List<Adn> listar() {
		return adnService.findAll();
	}

}
