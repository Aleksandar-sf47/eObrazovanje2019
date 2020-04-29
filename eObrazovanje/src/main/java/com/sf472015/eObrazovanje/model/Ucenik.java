package com.sf472015.eObrazovanje.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.OnOpen;

import com.sf472015.eObrazovanje.dto.UcenikDTO;

import javax.persistence.GenerationType;

@Entity
@Table(name="ucenici")
public class Ucenik {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ucenik_id", unique=true, nullable=false )
	private Long id;
	
	@Column(name="ucenik_brojIndeksa", unique=true, nullable=false)
	private String brojIndeksa;
	
	@Column(name="ucenik_ime", unique=false, nullable=false)
	private String ime;
	
	@Column(name="ucenik_prezime", unique=false, nullable=false)
	private String prezime;
	
	@Column(name="ucenik_jmbg", unique=true, nullable=false)
	private String jmbg;
	
	@Column(name="ucenik_email", unique=false, nullable=false)
	private String email;
	
	@Column(name="ucenik_telefon", unique=false, nullable=false)
	private String telefon;
	
	@Column(name="novcanik", unique=false, nullable=true)
	private Double novcanik;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ucenik")
	private Set<DokumentaStudenta> listaDokumenataStudenta;
	
	@ManyToMany(mappedBy = "listaUcenika")
	private Set<Pohadjanje> listaPohadjanjaStudenta = new HashSet<Pohadjanje>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ucenik")
	private Set<PolaganjeIspita> listaPolaganjaStudenta;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ucenik")
	private Set<Uplate> listaUplataStudenta;
	
	@OneToOne
	@JoinColumn(name="korisnik_id", referencedColumnName="korisnik_id")
	private Korisnik korisnik;

	
	//constructor
	public Ucenik() {
	}
	
	
	
	public Ucenik(Long id, String brojIndeksa, String ime, String prezime, String jmbg, String email, String telefon,
			Double novcanik, Set<DokumentaStudenta> listaDokumenataStudenta, Set<Pohadjanje> listaPohadjanjaStudenta,
			Set<PolaganjeIspita> listaPolaganjaStudenta, Set<Uplate> listaUplataStudenta, Korisnik korisnik) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.email = email;
		this.telefon = telefon;
		this.novcanik = novcanik;
		this.listaDokumenataStudenta = listaDokumenataStudenta;
		this.listaPohadjanjaStudenta = listaPohadjanjaStudenta;
		this.listaPolaganjaStudenta = listaPolaganjaStudenta;
		this.listaUplataStudenta = listaUplataStudenta;
		this.korisnik = korisnik;
	}



	public Ucenik(UcenikDTO uDTO) {
		this.id = uDTO.getId();
		this.brojIndeksa = uDTO.getBrojIndeksa();
		this.ime = uDTO.getIme();
		this.prezime = uDTO.getPrezime();
		this.jmbg = uDTO.getJmbg();
		this.email = uDTO.getEmail();
		this.telefon = uDTO.getTelefon();
		this.novcanik = uDTO.getNovcanik();
		this.korisnik = new Korisnik(uDTO.getKorisnikDTO());
		
	}

	
	
	
	
	
	//getter and setter 
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
	
	public Double getNovcanik() {
		return novcanik;
	}

	public void setNovcanik(Double novcanik) {
		this.novcanik = novcanik;
	}



	public Korisnik getKorisnik() {
		return korisnik;
	}



	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
 	
	
	
	
}
