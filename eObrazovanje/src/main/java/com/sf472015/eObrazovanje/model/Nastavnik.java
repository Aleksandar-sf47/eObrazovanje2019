package com.sf472015.eObrazovanje.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.NastavnikDTO;

@Entity
@Table(name="nastavnik")
public class Nastavnik {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nastavnik_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="nastavnik_ime", unique=false, nullable=false)
	private String ime;
	
	@Column(name="nastavnik_prezime", unique=false, nullable=false)
	private String prezime;
	
	@Column(name="nastavnik_jmbg", unique=true, nullable=false)
	private String jmbg;
	
	@Column(name="nastavnik_email", unique=false, nullable=false)
	private String email;
	
	@Column(name="nastavnik_telefon", unique=false, nullable=false)
	private String telefon;
	
	@OneToOne
	@JoinColumn(name="korisnik_id", referencedColumnName="korisnik_id")
	private Korisnik korisnik;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="nastavnik")
	private Set<Predavanje> listaPredavanjaNastavnika;

	//constructor
	public Nastavnik() {
		
	}

	public Nastavnik(Long id, String ime, String prezime, String jmbg, String email, String telefon, Korisnik korisnik,
			Set<Predavanje> listaPredavanjaNastavnika) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.email = email;
		this.telefon = telefon;
		this.korisnik = korisnik;
		this.listaPredavanjaNastavnika = listaPredavanjaNastavnika;
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

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Set<Predavanje> getListaPredavanjaNastavnika() {
		return listaPredavanjaNastavnika;
	}

	public void setListaPredavanjaNastavnika(Set<Predavanje> listaPredavanjaNastavnika) {
		this.listaPredavanjaNastavnika = listaPredavanjaNastavnika;
	}

	public Nastavnik(NastavnikDTO nDTO, Korisnik k) {
		this.id = nDTO.getId();
		this.ime = nDTO.getIme();
		this.prezime = nDTO.getPrezime();
		this.jmbg = nDTO.getJmbg();
		this.email = nDTO.getEmail();
		this.telefon = nDTO.getTelefon();
		this.korisnik = k;
		this.listaPredavanjaNastavnika = nDTO.getListaPredavanjaNastavnika();
	}
	
	
	
 }
