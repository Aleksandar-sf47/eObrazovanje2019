package com.sf472015.eObrazovanje.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="korisnici")
public class Korisnik {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="korisnik_id")
	private Long korisnik_id;
	
	@Column(name="kIme")
	private String korisnickoIme;
	
	@Column(name="sifra")
	private String sifra;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="korisnik_uloge", joinColumns=@JoinColumn(name="korisnik_id"),
	inverseJoinColumns=@JoinColumn(name="uloga_id"))
	private Set<Uloga> uloge = new HashSet<>();

	@OneToOne(mappedBy="korisnik")
	private Nastavnik n;
	
	public Korisnik(String korisnickoIme, String sifra, Set<Uloga> uloge) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.uloge = uloge;
	}

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getKorisnik_id() {
		return korisnik_id;
	}

	public void setKorisnik_id(Long korisnik_id) {
		this.korisnik_id = korisnik_id;
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

	public Set<Uloga> getUloge() {
		return uloge;
	}

	public void setUloge(Set<Uloga> uloge) {
		this.uloge = uloge;
	}
	
	
	
}
