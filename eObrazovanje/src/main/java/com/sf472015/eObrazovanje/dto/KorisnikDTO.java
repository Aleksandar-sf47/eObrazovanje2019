package com.sf472015.eObrazovanje.dto;

import java.util.Set;

import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Uloga;

public class KorisnikDTO {

	private Long id;
	private String korisnickoIme;
	private String sifra;
	private Set<Uloga> listaUloga;
	
	public KorisnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikDTO(Long id, String korisnickoIme, String sifra, Set<Uloga> listaUloga) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.listaUloga = listaUloga;
	}
	
	public KorisnikDTO(Korisnik k) {
		this.id = k.getKorisnik_id();
		this.korisnickoIme = k.getKorisnickoIme();
		this.sifra = k.getSifra();
		this.listaUloga = k.getUloge();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Set<Uloga> getListaUloga() {
		return listaUloga;
	}

	public void setListaUloga(Set<Uloga> listaUloga) {
		this.listaUloga = listaUloga;
	}
	
	
}
