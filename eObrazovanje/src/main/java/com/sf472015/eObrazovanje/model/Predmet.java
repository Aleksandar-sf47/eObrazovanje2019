package com.sf472015.eObrazovanje.model;

import java.util.List;
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
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="predmet")
	private Set<Predavanje> predavanje;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="predmet")
	private Set<PolaganjeIspita> listaPolaganjaIspita;

	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Predmet(Long id, String naziv, Set<Pohadjanje> pohadjanja, Set<Predavanje> predavanje,
			Set<PolaganjeIspita> listaPolaganjaIspita) {
		super();
		this.id = id;
		this.naziv = naziv;
	
		this.predavanje = predavanje;
		this.listaPolaganjaIspita = listaPolaganjaIspita;
	}
	
	public Predmet(PredmetDTO pDTO) {
		this.id = pDTO.getId();
		this.naziv = pDTO.getNaziv();
	
	}

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

	

	public Set<Predavanje> getPredavanje() {
		return predavanje;
	}

	public void setPredavanje(Set<Predavanje> predavanje) {
		this.predavanje = predavanje;
	}

	public Set<PolaganjeIspita> getListaPolaganjaIspita() {
		return listaPolaganjaIspita;
	}

	public void setListaPolaganjaIspita(Set<PolaganjeIspita> listaPolaganjaIspita) {
		this.listaPolaganjaIspita = listaPolaganjaIspita;
	}

	
	
	

	
	
}
