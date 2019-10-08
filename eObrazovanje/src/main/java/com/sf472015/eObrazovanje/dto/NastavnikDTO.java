package com.sf472015.eObrazovanje.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.PolaganjeIspita;
import com.sf472015.eObrazovanje.model.Predavanje;

public class NastavnikDTO  implements Serializable{
	
	private Long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String email;
	private String telefon;
	private KorisnikDTO korisnikDTO;
	
	
	
	public NastavnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NastavnikDTO(Long id, String ime, String prezime, String jmbg, String email, String telefon,
			KorisnikDTO korisnikDTO, Set<PredavanjeDTO> listaPredavanjaNastavnika,
			Set<PolaganjeIspita> listaPolaganjaIspita) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.email = email;
		this.telefon = telefon;
		this.korisnikDTO = korisnikDTO;

	}
	
	public NastavnikDTO(Nastavnik n) {
		this.id = n.getId();
		this.ime = n.getIme();
		this.prezime = n.getPrezime();
		this.jmbg = n.getJmbg();
		this.email = n.getEmail();
		this.telefon = n.getTelefon();
		this.korisnikDTO = new KorisnikDTO(n.getKorisnik());
		
		
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

	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}

	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}

	

	

	

	
	
	


	
	

}
