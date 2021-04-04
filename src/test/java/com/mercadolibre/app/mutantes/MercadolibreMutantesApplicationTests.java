package com.mercadolibre.app.mutantes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mercadolibre.app.mutantes.controllers.AdnController;
import com.mercadolibre.app.mutantes.models.entity.Adn;

@SpringBootTest
class MercadolibreMutantesApplicationTests {
	
	@Autowired
	private AdnController dnaController;

	@Test
	void horizontalValidate() {
		String[] arrayDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		assertEquals(200, dnaController.mutant(dna).getStatusCodeValue());
	}
	
	@Test
	void verticalValidate() {
		String[] arrayDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","TCCCTA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		assertEquals(200, dnaController.mutant(dna).getStatusCodeValue());
	}
	
	@Test
	void diagonalValidate() {
		String[] arrayDna = {"ATGCTA","CAGTGC","TTATGT","AGAAGG","TCCCTA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		assertEquals(200, dnaController.mutant(dna).getStatusCodeValue());
	}
	
	@Test
	void InverseDiagonalValidate() {
		String[] arrayDna = {"GTGCTA","CAGTGC","TTGTGT","AGAGGG","TCCCGA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		assertEquals(200, dnaController.mutant(dna).getStatusCodeValue());
	}
	
	void humanValidate() {
		String[] arrayDna = {"GTGCTA","CAGTGC","TTATGT","AGAGGG","TCCCGA","TCACTG"};
		Adn dna = new Adn();
		dna.setDna(arrayDna);
		assertEquals(403, dnaController.mutant(dna).getStatusCodeValue());
	}
	

}
