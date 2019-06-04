package com.sf472015.eObrazovanje.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sf472015.eObrazovanje.model.DokumentaStudenta;
import com.sf472015.eObrazovanje.model.Ucenik;

public class DokumentaStudentaDTO implements Serializable {

	private Long id;
	private String naziv;
	private String fileName;
	private Ucenik ucenik;
	
		
	public DokumentaStudentaDTO() {
		super();
	}

	public DokumentaStudentaDTO(DokumentaStudenta dokStudenta) {
		super();
		this.id = dokStudenta.getId();
		this.naziv = dokStudenta.getNaziv();
		this.fileName = dokStudenta.getFileName();
		this.ucenik = dokStudenta.getUcenik();
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
