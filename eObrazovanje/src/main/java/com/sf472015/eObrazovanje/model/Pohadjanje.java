package com.sf472015.eObrazovanje.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.dto.UcenikDTO;

@Entity
@Table(name="pohadjanja")
public class Pohadjanje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pohadjanje_id", nullable=false, unique=true)
	private Long id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "pohadjanje_ucenik", joinColumns = @JoinColumn(name = "pohadjanje_id"), inverseJoinColumns = @JoinColumn(name = "ucenik_id"))
	private Set<Ucenik> listaUcenika = new HashSet<Ucenik>();
	
	@OneToOne
	@JoinColumn(name="predmet_id", referencedColumnName="predmet_id")
	private Predmet predmet;


	public Pohadjanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pohadjanje(Long id, Set<Ucenik> listaUcenika, Predmet predmet) {
		super();
		this.id = id;
		this.listaUcenika = listaUcenika;

	}
	
	public Pohadjanje(PohadjanjeDTO pDTO) {
		this.id = pDTO.getId();
		this.listaUcenika = new HashSet<Ucenik>(pDTO.getListaUcenika().stream().map(U-> new Ucenik(U)).collect(Collectors.toSet()));
		this.predmet = new Predmet(pDTO.getPredmet());

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
