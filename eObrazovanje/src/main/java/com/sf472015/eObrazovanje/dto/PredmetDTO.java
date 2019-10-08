
package com.sf472015.eObrazovanje.dto;

import java.util.List;
import java.util.Set;

import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.PolaganjeIspita;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.model.Predmet;

public class PredmetDTO {
	
	private Long id;
	private String naziv;

	
	public PredmetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PredmetDTO(Long id, String naziv, Set<Pohadjanje> pohadjanja, Set<Predavanje> predavanja,
			Set<PolaganjeIspita> polaganjaIspita) {
		super();
		this.id = id;
		this.naziv = naziv;
		
	}
	
	public PredmetDTO(Predmet p) {
		this.id = p.getId();
		this.naziv = p.getNaziv();
	
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


	
	

}
