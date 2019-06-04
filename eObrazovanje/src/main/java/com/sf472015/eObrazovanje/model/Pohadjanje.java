package com.sf472015.eObrazovanje.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;

@Entity
@Table(name="pohadjanje")
public class Pohadjanje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pohadjanje_id", nullable=false, unique=true)
	private Long id;
	
	@ManyToMany(mappedBy="listaPohadjanjaStudenta")
	private Set<Ucenik> listaUcenika;
	
	@ManyToOne
	@JoinColumn(name="predmet_id", referencedColumnName="predmet_id", nullable=false)
	private Predmet predmet;

	public Pohadjanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pohadjanje(Long id, Set<Ucenik> listaUcenika, Predmet predmet) {
		super();
		this.id = id;
		this.listaUcenika = listaUcenika;
		this.predmet = predmet;
	}
	
	public Pohadjanje(PohadjanjeDTO pDTO) {
		this.id = pDTO.getId();
		this.listaUcenika = pDTO.getListaUcenika();
		this.predmet = pDTO.getPredmet();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Ucenik> getListaUcenika() {
		return listaUcenika;
	}

	public void setListaUcenika(Set<Ucenik> listaUcenika) {
		this.listaUcenika = listaUcenika;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	
	
}
