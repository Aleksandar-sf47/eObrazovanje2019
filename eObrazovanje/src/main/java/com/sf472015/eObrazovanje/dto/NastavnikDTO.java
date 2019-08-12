package com.sf472015.eObrazovanje.dto;

import java.io.Serializable;
import java.util.Set;

import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Predavanje;

public class NastavnikDTO  implements Serializable{
	
	private Long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String email;
	private String telefon;
	private String kIme;
	private String sifra;
	private Set<Predavanje> listaPredavanjaNastavnika;
	
	public NastavnikDTO() {
		super();
	}

	
	
	public NastavnikDTO(Long id, String ime, String prezime, String jmbg, String email, String telefon, String kIme,
			String sifra, Set<Predavanje> listaPredavanjaNastavnika) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.email = email;
		this.telefon = telefon;
		this.kIme = kIme;
		this.sifra = sifra;
		this.listaPredavanjaNastavnika = listaPredavanjaNastavnika;
	}



	public NastavnikDTO(Nastavnik n) {
		this.id = n.getId();
		this.ime = n.getIme();
		this.prezime = n.getPrezime();
		this.jmbg = n.getJmbg();
		this.email = n.getEmail();
		this.telefon = n.getTelefon();
		this.kIme = n.getKorisnik().getKorisnickoIme();
		this.sifra = n.getKorisnik().getSifra();
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

	

	public String getkIme() {
		return kIme;
	}



	public void setkIme(String kIme) {
		this.kIme = kIme;
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
