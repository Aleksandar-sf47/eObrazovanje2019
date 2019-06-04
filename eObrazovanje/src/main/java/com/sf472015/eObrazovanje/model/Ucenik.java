package com.sf472015.eObrazovanje.model;

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
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.UcenikDTO;

import javax.persistence.GenerationType;

@Entity
@Table(name="ucenik")
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
	
	@Column(name="ucenik_korisnickoIme", unique=false, nullable=false)
	private String korisnickoIme;
	
	@Column(name="ucenik_sifra", unique=false, nullable=false)
	private String sifra;
	
	@Column(name="novcanik", unique=false, nullable=true)
	private Double novcanik;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ucenik")
	private Set<DokumentaStudenta> listaDokumenataStudenta;
	
	@ManyToMany
	@JoinTable(name="listaPohadjanjaStudenta", 
	joinColumns=@JoinColumn(name="ucenik_id"),
	inverseJoinColumns=@JoinColumn(name="pohadjanje_id"))
	private Set<Pohadjanje> listaPohadjanjaStudenta;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ucenik")
	private Set<PolaganjeIspita> listaPolaganjaStudenta;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ucenik")
	private Set<Uplate> listaUplataStudenta;

	
	//constructor
	public Ucenik() {
	}
	
	public Ucenik(Long id, String brojIndeksa, String ime, String prezime, String jmbg, String email, String telefon,
			String korisnickoIme, String sifra, Double novcanik, Set<DokumentaStudenta> listaDokumenataStudenta,
			Set<Pohadjanje> listaPohadjanjaStudenta, Set<PolaganjeIspita> listaPolaganjaStudenta,
			Set<Uplate> listaUplataStudenta) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.email = email;
		this.telefon = telefon;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.novcanik = novcanik;
		this.listaDokumenataStudenta = listaDokumenataStudenta;
		this.listaPohadjanjaStudenta = listaPohadjanjaStudenta;
		this.listaPolaganjaStudenta = listaPolaganjaStudenta;
		this.listaUplataStudenta = listaUplataStudenta;
	}
	
	public Ucenik(UcenikDTO uDTO) {
		this.id = uDTO.getId();
		this.brojIndeksa = uDTO.getBrojIndeksa();
		this.ime = uDTO.getIme();
		this.prezime = uDTO.getPrezime();
		this.jmbg = uDTO.getJmbg();
		this.email = uDTO.getEmail();
		this.telefon = uDTO.getTelefon();
		this.korisnickoIme = uDTO.getKorisnickoIme();
		this.sifra = uDTO.getSifra();
		this.novcanik = uDTO.getNovcanik();
		this.listaDokumenataStudenta = uDTO.getListaDokumenataStudenta();
		this.listaPohadjanjaStudenta = uDTO.getListaPohadjanjaStudenta();
		this.listaPolaganjaStudenta = uDTO.getListaPolaganjaStudenta();
		this.listaUplataStudenta = uDTO.getListaUplataStudenta();
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
 	
	
	
	
}
