package com.sf472015.eObrazovanje.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.model.Predmet;

public class PredavanjeDTO {

	private Long id;
	private Nastavnik nastavnik;
	private Predmet predmet;
	
	public PredavanjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PredavanjeDTO(Long id, Nastavnik nastavnik, Predmet predmet) {
		super();
		this.id = id;
		this.nastavnik = nastavnik;
		this.predmet = predmet;
	}

	public PredavanjeDTO(Predavanje p) {
		super();
		this.id = p.getId();
		this.nastavnik = p.getNastavnik();
		this.predmet = p.getPredmet();
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	
	
}
