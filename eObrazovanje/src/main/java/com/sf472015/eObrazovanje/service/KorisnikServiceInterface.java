package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.security.UserPrinciple;

public interface KorisnikServiceInterface {
	
	
	public Korisnik save(String kIme, String sifra, Set<Uloga> uloge);
	

}
