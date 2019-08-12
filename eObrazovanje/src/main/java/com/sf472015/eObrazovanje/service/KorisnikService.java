package com.sf472015.eObrazovanje.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.repo.KorisnikRepository;

@Service
public class KorisnikService implements KorisnikServiceInterface {
	
	@Autowired
	private KorisnikRepository kRepo;

	@Override
	public Korisnik save(String kIme, String sifra, Set<Uloga> uloge) {
		return kRepo.save(new Korisnik(kIme, sifra, uloge));
	}

}
