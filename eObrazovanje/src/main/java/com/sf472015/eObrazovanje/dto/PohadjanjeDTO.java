package com.sf472015.eObrazovanje.dto;

import java.util.Set;

import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.model.Ucenik;

public class PohadjanjeDTO {
	
	private Long id;
	private Set<Ucenik> listaUcenika;
	private Predmet predmet;
	
	public PohadjanjeDTO() {
		super();
	}

	public PohadjanjeDTO(Pohadjanje p) {
		super();
		this.id = p.getId();
		this.listaUcenika = p.getListaUcenika();
	
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
