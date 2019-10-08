package com.sf472015.eObrazovanje.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.KorisnikDTO;
import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.repo.KorisnikRepository;
import com.sf472015.eObrazovanje.security.UserPrinciple;

@Service
public class KorisnikService implements KorisnikServiceInterface {
	
	@Autowired
	private KorisnikRepository kRepo;

	@Override
	public Korisnik save(KorisnikDTO korisnikDTO) {
		return kRepo.save(new Korisnik(korisnikDTO));
	}

}
