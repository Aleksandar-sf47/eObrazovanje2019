package com.sf472015.eObrazovanje.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
		uDTO.setBrojIndeksa(getNewNumberOfIndex());
		Set<Uloga> uloge = new HashSet<Uloga>();
		Uloga u = uServ.getUlogaByName("STUDENT");
		uloge.add(u);
		uDTO.getKorisnikDTO().setListaUloga(uloge);
		Korisnik k = kServ.save(uDTO.getKorisnikDTO());
		uDTO.setKorisnikDTO(new KorisnikDTO(k));
		encoder.encode(uDTO.getKorisnikDTO().getSifra());
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
		u.setTelefon(uDTO.getTelefon());
		u.getKorisnik().setKorisnickoIme(uDTO.getKorisnikDTO().getKorisnickoIme());
		u.getKorisnik().setSifra(uDTO.getKorisnikDTO().getSifra());
		u.setNovcanik(uDTO.getNovcanik());

		return uRepo.save(u);
		
	}
	
	public String getNewNumberOfIndex() {
		List<Ucenik> ucenici =  uRepo.findAll();
		Ucenik u = ucenici.get(ucenici.size() -1);
		
		String stariBrojIndeksa = u.getBrojIndeksa().split("/")[0];
		LocalDateTime now = LocalDateTime.now();
		
		
		return new String(Integer.parseInt(stariBrojIndeksa)+ 1 + "/" + now.getYear());
	}

}
