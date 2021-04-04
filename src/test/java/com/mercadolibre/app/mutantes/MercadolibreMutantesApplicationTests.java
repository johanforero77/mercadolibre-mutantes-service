package com.mercadolibre.app.mutantes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mercadolibre.app.mutantes.models.entity.Adn;

@SpringBootTest
class MercadolibreMutantesApplicationTests {
	


	@Test
	void horizontalValidate() {
		String[] arrayDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		HttpEntity<Adn> body = new HttpEntity<Adn>(dna);
		ResponseEntity<Adn> response = restTemplate().exchange(
				"http://3.131.137.77:80/mutant", 
				HttpMethod.POST, body,  Adn.class);
		assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	void verticalValidate() {
		String[] arrayDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","TCCCTA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		HttpEntity<Adn> body = new HttpEntity<Adn>(dna);
		ResponseEntity<Adn> response = restTemplate().exchange(
				"http://3.131.137.77:80/mutant", 
				HttpMethod.POST, body,  Adn.class);
		assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	void diagonalValidate() {
		String[] arrayDna = {"ATGCTA","CAGTGC","TTATGT","AGAAGG","TCCCTA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		HttpEntity<Adn> body = new HttpEntity<Adn>(dna);
		ResponseEntity<Adn> response = restTemplate().exchange(
				"http://3.131.137.77:80/mutant", 
				HttpMethod.POST, body,  Adn.class);
		assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	void InverseDiagonalValidate() {
		String[] arrayDna = {"GTGCTA","CAGTGC","TTGTGT","AGAGGG","TCCCGA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		HttpEntity<Adn> body = new HttpEntity<Adn>(dna);
		ResponseEntity<Adn> response = restTemplate().exchange(
				"http://3.131.137.77:80/mutant", 
				HttpMethod.POST, body,  Adn.class);
		assertEquals(200, response.getStatusCodeValue());
	}
	
	void humanValidate() {
		String[] arrayDna = {"GTGCTA","CAGTGC","TTATGT","AGAGGG","TCCCGA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		HttpEntity<Adn> body = new HttpEntity<Adn>(dna);
		ResponseEntity<Adn> response = restTemplate().exchange(
				"http://3.131.137.77:80/mutant", 
				HttpMethod.POST, body,  Adn.class);
		assertEquals(403, response.getStatusCodeValue());
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
