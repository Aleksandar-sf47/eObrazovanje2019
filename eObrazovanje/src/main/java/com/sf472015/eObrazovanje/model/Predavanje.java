package com.sf472015.eObrazovanje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.PredavanjeDTO;

@Entity
@Table(name="predavanje")
public class Predavanje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="predavanje_id", nullable=false, unique=true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="nastavnik_id", referencedColumnName="nastavnik_id", unique=false, nullable=false)
	private Nastavnik nastavnik;
	
	@ManyToOne
	@JoinColumn(name="predmet_id", referencedColumnName="predmet_id", unique=true, nullable=false)
	private Predmet predmet;
	
	//constructor
	public Predavanje() {
	}

	public Predavanje(Long id, Nastavnik nastavnik, Predmet predmet) {
		super();
		this.id = id;
		this.nastavnik = nastavnik;
		this.predmet = predmet;
		
	}
	
	public Predavanje(PredavanjeDTO pDTO) {
		super();
		this.id = pDTO.getId();
		this.nastavnik = new Nastavnik(pDTO.getNastavnik());
		this.predmet = new Predmet(pDTO.getPredmet());
	}

	//getter and setter
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
