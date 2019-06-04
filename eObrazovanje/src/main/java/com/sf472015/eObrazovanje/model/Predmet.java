package com.sf472015.eObrazovanje.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.PredmetDTO;



@Entity
@Table(name="predmet")
public class Predmet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="predmet_id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="predmet_naziv", nullable=false, unique=true)
	private String naziv;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "predmet")
	private List<Pohadjanje> pohadjanja;
	
	//constructor
	public Predmet() {
	}

	public Predmet(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	
	public Predmet(PredmetDTO pDTO) {
		super();
		this.id = pDTO.getId();
		this.naziv = pDTO.getNaziv();
		this.pohadjanja = pDTO.getPohadjanja();
	}

	//getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(List<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}
	
	

	
	
}
