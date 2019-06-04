package com.sf472015.eObrazovanje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.PolaganjeIspitaDTO;
import com.sf472015.eObrazovanje.pomocni.Ocena;

@Entity
@Table(name="polaganjeIspita")
public class PolaganjeIspita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="polaganjeIspita_id", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ucenik_id", referencedColumnName="ucenik_id", nullable=false)
	private Ucenik ucenik;
	
	@ManyToOne
	@JoinColumn(name="predmet_id", referencedColumnName="predmet_id", unique=false, nullable=false)
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name="nastavnik_id", referencedColumnName="nastavnik_id", unique=false, nullable=false)
	private Nastavnik nastavnik;
	
	@Column(name="ocena", unique=false, nullable=true)
	private Ocena ocena;
	
	@Column(name="cena", unique=false, nullable=false)
	private Double cena;

	//constructor
	public PolaganjeIspita() {
	}

	public PolaganjeIspita(Long id, Ucenik ucenik, Predmet predmet, Nastavnik nastavnik, Ocena ocena, Double cena) {
		super();
		this.id = id;
		this.ucenik = ucenik;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.ocena = ocena;
		this.cena = cena;
	}
	
	public PolaganjeIspita(PolaganjeIspitaDTO piDTO) {
		super();
		this.id = piDTO.getId();
		this.ucenik = piDTO.getUcenik();
		this.predmet = piDTO.getPredmet();
		this.nastavnik = piDTO.getNastavnik();
		this.ocena = piDTO.getOcena();
		this.cena = piDTO.getCena();
	}

	//getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Ocena getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	
	

	
}
