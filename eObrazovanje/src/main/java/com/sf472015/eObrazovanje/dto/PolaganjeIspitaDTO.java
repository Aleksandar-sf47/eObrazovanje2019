package com.sf472015.eObrazovanje.dto;

import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.PolaganjeIspita;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.pomocni.Ocena;

public class PolaganjeIspitaDTO {

	private Long id;
	private Ucenik ucenik;
	private Predmet predmet;
	private Nastavnik nastavnik;
	private Ocena ocena;
	private Double cena;
	
	public PolaganjeIspitaDTO(PolaganjeIspita pi) {
		super();
		this.id = pi.getId();
		this.ucenik = pi.getUcenik();
		this.predmet = pi.getPredmet();
		this.nastavnik = pi.getNastavnik();
		this.ocena = pi.getOcena();
		this.cena = pi.getCena();
	}

	public PolaganjeIspitaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

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
