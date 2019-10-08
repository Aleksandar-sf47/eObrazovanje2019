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
	private NastavnikDTO nastavnik;
	private PredmetDTO predmet;
	
	public PredavanjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PredavanjeDTO(Long id, Nastavnik nastavnik, Predmet predmet) {
		super();
		this.id = id;
		this.nastavnik = new NastavnikDTO(nastavnik);
		this.predmet = new PredmetDTO(predmet);
	}

	public PredavanjeDTO(Predavanje p) {
		this.id = p.getId();
		this.nastavnik = new NastavnikDTO(p.getNastavnik());
		this.predmet = new PredmetDTO(p.getPredmet());
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	
	
}
