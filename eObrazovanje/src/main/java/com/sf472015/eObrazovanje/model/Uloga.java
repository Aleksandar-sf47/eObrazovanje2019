package com.sf472015.eObrazovanje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uloga")
public class Uloga {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uloga_id")
	private Long uloga_id;
	
	@Column(name="uloga")
	private String uloga;
	
	

	public Uloga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Uloga(Long id, String uloga) {
		super();
		this.uloga_id = id;
		this.uloga = uloga;
	}

	public Long getId() {
		return uloga_id;
	}

	public void setId(Long id) {
		this.uloga_id = id;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	
}
