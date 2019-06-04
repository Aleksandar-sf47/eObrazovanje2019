package com.sf472015.eObrazovanje.dto;

import java.io.Serializable;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;

import com.sf472015.eObrazovanje.model.DokumentaStudenta;
import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.PolaganjeIspita;
import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.model.Uplate;

public class UcenikDTO implements Serializable {
	

	private Long id;
	private String brojIndeksa;
	private String ime;
	private String prezime;
	private String jmbg;
	private String email;
	private String telefon;
	private String korisnickoIme;
	private String sifra;
	private Double novcanik;
	private Set<DokumentaStudenta> listaDokumenataStudenta;
	private Set<Pohadjanje> listaPohadjanjaStudenta;
	private Set<PolaganjeIspita> listaPolaganjaStudenta;
	private Set<Uplate> listaUplataStudenta;
	
	
	
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
		this.korisnickoIme = u.getKorisnickoIme();
		this.sifra = u.getSifra();
		this.novcanik = u.getNovcanik();
		this.listaDokumenataStudenta = u.getListaDokumenataStudenta();
		this.listaPohadjanjaStudenta = u.getListaPohadjanjaStudenta();
		this.listaPolaganjaStudenta = u.getListaPolaganjaStudenta();
		this.listaUplataStudenta = u.getListaUplataStudenta();
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



	public Double getNovcanik() {
		return novcanik;
	}



	public void setNovcanik(Double novcanik) {
		this.novcanik = novcanik;
	}



	public Set<DokumentaStudenta> getListaDokumenataStudenta() {
		return listaDokumenataStudenta;
	}



	public void setListaDokumenataStudenta(Set<DokumentaStudenta> listaDokumenataStudenta) {
		this.listaDokumenataStudenta = listaDokumenataStudenta;
	}



	public Set<Pohadjanje> getListaPohadjanjaStudenta() {
		return listaPohadjanjaStudenta;
	}



	public void setListaPohadjanjaStudenta(Set<Pohadjanje> listaPohadjanjaStudenta) {
		this.listaPohadjanjaStudenta = listaPohadjanjaStudenta;
	}



	public Set<PolaganjeIspita> getListaPolaganjaStudenta() {
		return listaPolaganjaStudenta;
	}



	public void setListaPolaganjaStudenta(Set<PolaganjeIspita> listaPolaganjaStudenta) {
		this.listaPolaganjaStudenta = listaPolaganjaStudenta;
	}



	public Set<Uplate> getListaUplataStudenta() {
		return listaUplataStudenta;
	}



	public void setListaUplataStudenta(Set<Uplate> listaUplataStudenta) {
		this.listaUplataStudenta = listaUplataStudenta;
	}
	
	
	

}
