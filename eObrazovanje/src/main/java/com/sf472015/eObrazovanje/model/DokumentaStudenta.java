package com.sf472015.eObrazovanje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sf472015.eObrazovanje.dto.DokumentaStudentaDTO;

@Entity
@Table(name="dokumentStudenta")
public class DokumentaStudenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dokumentStudenta_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="dokumentStudenta_naziv", unique=false, nullable=false)
	private String naziv;
	
	@Column(name="dokumentStudenta_fileName", unique=false, nullable=false)
	private String fileName;
	
	@ManyToOne
	@JoinColumn(name="ucenik_id", referencedColumnName="ucenik_id", nullable=false)
	private Ucenik ucenik;

	//constructor
	public DokumentaStudenta() {
	}
	
	public DokumentaStudenta(Long id, String naziv, String fileName, Ucenik ucenik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fileName = fileName;
		this.ucenik = ucenik;
	}
	
	public DokumentaStudenta(DokumentaStudentaDTO dokStudentaDTO) {
		super();
		this.id = dokStudentaDTO.getId();
		this.naziv = dokStudentaDTO.getNaziv();
		this.fileName = dokStudentaDTO.getFileName();
		this.ucenik = dokStudentaDTO.getUcenik();
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	
	
	
	
	
	

}
