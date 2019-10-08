package com.sf472015.eObrazovanje.dto;

import java.io.Serializable;

import com.sf472015.eObrazovanje.model.Ucenik;

public class UcenikDTO implements Serializable {
	

	private Long id;
	private String brojIndeksa;
	private String ime;
	private String prezime;
	private String jmbg;
	private String email;
	private String telefon;
	private KorisnikDTO korisnikDTO;
	private Double novcanik;

	
	
	
	public UcenikDTO() {
	}



	public UcenikDTO(Ucenik u) {
		super();
		this.id = u.getId();
		this.brojIndeksa = u.getBrojIndeksa();
		this.ime = u.getIme();
		this.prezime =u.getPrezime();
		this.jmbg = u.getPrezime();
		this.email = u.getEmail();
		this.telefon = u.getTelefon();
		this.novcanik = u.getNovcanik();
		this.korisnikDTO = new KorisnikDTO(u.getKorisnik());
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getBrojIndeksa() {
		return brojIndeksa;
	}



	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getJmbg() {
		return jmbg;
	}



	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefon() {
		return telefon;
	}



	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}




	public Double getNovcanik() {
		return novcanik;
	}



	public void setNovcanik(Double novcanik) {
		this.novcanik = novcanik;
	}



	public KorisnikDTO getKorisnik() {
		return korisnikDTO;
	}



	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnikDTO = korisnik;
	}
	
	
	
	

}
