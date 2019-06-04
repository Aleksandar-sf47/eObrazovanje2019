package com.sf472015.eObrazovanje.dto;

import java.util.List;

import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.Predmet;

public class PredmetDTO {
	
	private Long id;
	private String naziv;
	private List<Pohadjanje> pohadjanja;
	
	public PredmetDTO() {
		super();
	}

	public PredmetDTO(Long id, String naziv, List<Pohadjanje> pohadjanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pohadjanja = pohadjanja;
	}
	
	public PredmetDTO(Predmet p) {
		super();
		this.id = p.getId();
		this.naziv = p.getNaziv();
		this.pohadjanja = p.getPohadjanja();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(List<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}
	
	
	

}
