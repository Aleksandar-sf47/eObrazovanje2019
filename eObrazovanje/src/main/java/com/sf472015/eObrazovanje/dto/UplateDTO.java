package com.sf472015.eObrazovanje.dto;

import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.model.Uplate;

public class UplateDTO {

	private Long id;
	private Ucenik ucenik;
	private Double suma;
	
	public UplateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UplateDTO(Long id, Ucenik ucenik, Double suma) {
		super();
		this.id = id;
		this.ucenik = ucenik;
		this.suma = suma;
	}
	
	public UplateDTO(Uplate u) {
		super();
		this.id = u.getId();
		this.ucenik = u.getUcenik();
		this.suma = u.getSuma();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}
	
	
	
}
