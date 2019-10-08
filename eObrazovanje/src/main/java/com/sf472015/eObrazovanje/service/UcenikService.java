package com.sf472015.eObrazovanje.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.controller.LoginController;
import com.sf472015.eObrazovanje.dto.KorisnikDTO;
import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.repo.UcenikRepository;

@Service
public class UcenikService  implements UcenikServiceInterface{

	@Autowired
	UcenikRepository uRepo;
	
	@Autowired
	UlogaService uServ;
	
	@Autowired
	KorisnikService kServ;
	
	@Autowired
	PasswordEncoder encoder;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	public UcenikDTO findById(Long id) {
		Ucenik u = uRepo.getOne(id);
		return new UcenikDTO(u);
	}

	@Override
	public List<UcenikDTO> findAll() {
		List<Ucenik> ucenici =  uRepo.findAll();
		return ucenici.stream().map(X -> new UcenikDTO(X)).collect(Collectors.toList());
	}

	@Override
	public Ucenik save(UcenikDTO uDTO) {
		Set<Uloga> uloge = new HashSet<Uloga>();
		Uloga u = uServ.getUlogaByName("STUDENT");
		logger.info("------------------------" + u.getUloga());
		uloge.add(u);
		uDTO.getKorisnik().setListaUloga(uloge);
		Korisnik k = kServ.save(uDTO.getKorisnik());
		uDTO.setKorisnik(new KorisnikDTO(k));
		encoder.encode(uDTO.getKorisnik().getSifra());
		Ucenik ucenik = new Ucenik(uDTO); 
		return uRepo.save(ucenik);
	}

	@Override
	public void remove(Long id) {
		uRepo.deleteById(id);
		
	}

	@Override
	public Ucenik put(UcenikDTO uDTO, Long id) {
		Ucenik u = uRepo.getOne(id);
		u.setBrojIndeksa(uDTO.getBrojIndeksa());
		u.setIme(uDTO.getIme());
		u.setPrezime(uDTO.getPrezime());
		u.setJmbg(uDTO.getJmbg());
		u.setEmail(uDTO.getEmail());
		u.setTelefon(uDTO.getEmail());
		u.getKorisnik().setKorisnickoIme(uDTO.getKorisnik().getKorisnickoIme());
		u.getKorisnik().setSifra(uDTO.getKorisnik().getSifra());
		u.setNovcanik(uDTO.getNovcanik());

		return uRepo.save(u);
		
	}

}
