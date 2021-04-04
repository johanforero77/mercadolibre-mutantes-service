package com.mercadolibre.app.mutantes.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mercadolibre.app.mutantes.utils.MutanUtils;

@Entity
@Table(name = "adns")
public class Adn implements Serializable{
	
	@Id
	@Column(length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, name = "dna",length = 200, nullable = false)
	private String dnaRepo;
	@Column (name = "ismutant")
	private boolean isMutant;
	
	
	@Transient
	private String[] dna;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDnaRepo() {
		return dnaRepo;
	}


	public void setDnaRepo(String dna) {
		this.dnaRepo = dna;
	}


	
	public String[] getDna() {
		return dna;
	}


	public void setDna(String[] dnaArray) {
		this.dna = dnaArray;
	}
	
	
	public boolean isMutant() {
		return isMutant;
	}


	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}


	public boolean validateAdn(String[] dna) {
		
		MutanUtils mutanUtils = new MutanUtils();
		if (mutanUtils.horizontalValidate(dna)
				|| mutanUtils.verticalValidate(dna)
				|| mutanUtils.diagonalValidate(dna)
				
				) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2429307419373947010L;


}
