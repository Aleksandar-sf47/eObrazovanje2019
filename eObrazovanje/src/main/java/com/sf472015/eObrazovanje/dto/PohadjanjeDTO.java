package com.sf472015.eObrazovanje.dto;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.engine.internal.Collections;

import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.model.Ucenik;

public class PohadjanjeDTO {
	
	private Long id;
	private List<UcenikDTO> listaUcenika;
	private PredmetDTO predmet;
	
	public PohadjanjeDTO() {
		super();
	}

	public PohadjanjeDTO(Pohadjanje p) {
		super();
		this.id = p.getId();
		this.listaUcenika = p.getListaUcenika().stream().map(U-> new UcenikDTO(U)).collect(Collectors.toList());
		this.predmet = new PredmetDTO(p.getPredmet());
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UcenikDTO> getListaUcenika() {
		return listaUcenika;
	}

	public void setListaUcenika(List<UcenikDTO> listaUcenika) {
		this.listaUcenika = listaUcenika;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	

}
