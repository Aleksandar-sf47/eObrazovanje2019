package com.sf472015.eObrazovanje.dto;

import javax.validation.constraints.NotBlank;

public class LoginForm {

	@NotBlank
	private String kIme;
	@NotBlank
	private String sifra;
	public String getkIme() {
		return kIme;
	}
	public void setkIme(String kIme) {
		this.kIme = kIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	
	
	
}
