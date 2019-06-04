package com.sf472015.eObrazovanje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;

import com.sf472015.eObrazovanje.dto.UplateDTO;

@Entity
@Table(name="uplate")
public class Uplate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uplate_id", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ucenik_id", referencedColumnName="ucenik_id", nullable=false)
	private Ucenik ucenik;
	
	@Column(name="uplate_suma", unique=false, nullable=false)
	private Double suma;

	//constructor
	public Uplate() {
	}

	public Uplate(Long id, Ucenik ucenik, Double suma) {
		super();
		this.id = id;
		this.ucenik = ucenik;
		this.suma = suma;
	}
	
	public Uplate(UplateDTO uDTO) {
		super();
		this.id = uDTO.getId();
		this.ucenik = uDTO.getUcenik();
		this.suma = uDTO.getSuma();
	}

	
	//getter and setter
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
