package com.sf472015.eObrazovanje.dto;

import java.io.Serializable;
import java.util.Set;

import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Predavanje;

public class NastavnikDTO  implements Serializable{
	
	private Long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String email;
	private String telefon;
	private String korisnickoIme;
	private String sifra;
	private Set<Predavanje> listaPredavanjaNastavnika;
	
	public NastavnikDTO() {
		super();
	}

	public NastavnikDTO(Nastavnik n) {
		super();
		this.id = n.getId();
		this.ime = n.getIme();
		this.prezime = n.getPrezime();
		this.jmbg = n.getJmbg();
		this.email = n.getEmail();
		this.telefon = n.getTelefon();
		this.korisnickoIme = n.getKorisnickoIme();
		this.sifra = n.getSifra();
		this.listaPredavanjaNastavnika = n.getListaPredavanjaNastavnika();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Predavanje> getListaPredavanjaNastavnika() {
		return listaPredavanjaNastavnika;
	}

	public void setListaPredavanjaNastavnika(Set<Predavanje> listaPredavanjaNastavnika) {
		this.listaPredavanjaNastavnika = listaPredavanjaNastavnika;
	}
	
	
	
	
	
	
	

}
