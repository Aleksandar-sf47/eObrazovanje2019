package com.sf472015.eObrazovanje.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.controller.LoginController;
import com.sf472015.eObrazovanje.dto.KorisnikDTO;
import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.repo.NastavnikRepository;
import com.sf472015.eObrazovanje.repo.PredavanjeRepository;

@Service
public class NastavnikService implements NastavnikServiceInterface{

	@Autowired
	NastavnikRepository nRepo;

	@Autowired
	KorisnikService kServ;
	
	@Autowired
	UlogaService uServ;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	PredavanjeRepository pRepo;
	
	
	

	
	 org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	@Override
	public NastavnikDTO findById(Long id) {
		Nastavnik n = nRepo.getOne(id);
		NastavnikDTO nDTO = new NastavnikDTO(n);
		return nDTO;
	}

	@Override
	public List<NastavnikDTO> findAll() {
		List<Nastavnik> nastavnici = nRepo.findAll();
		return nastavnici.stream().map(N -> new NastavnikDTO(N)).collect(Collectors.toList());
		
	}

	@Override
	public Nastavnik save(NastavnikDTO nDTO) {
		Set<Uloga> uloge = new HashSet<Uloga>();
		Uloga u = uServ.getUlogaByName("NASTAVNIK");
		uloge.add(u);
		nDTO.getKorisnikDTO().setListaUloga(uloge);
		Korisnik k = kServ.save(nDTO.getKorisnikDTO());
		nDTO.setKorisnikDTO(new KorisnikDTO(k));
		encoder.encode(nDTO.getKorisnikDTO().getSifra());
		Nastavnik n = new Nastavnik(nDTO); 
		return nRepo.save(n);
	}

	@Override
	public void remove(Long id) {
		nRepo.deleteById(id);
	}

	@Override
	public Nastavnik put(NastavnikDTO nDTO, Long id) {
		Nastavnik n = nRepo.getOne(id);
		n.setIme(nDTO.getIme());
		n.setPrezime(nDTO.getPrezime());
		n.setJmbg(nDTO.getJmbg());
		n.getKorisnik().setKorisnickoIme(nDTO.getKorisnikDTO().getKorisnickoIme());
		n.getKorisnik().setSifra(nDTO.getKorisnikDTO().getSifra());
		n.setEmail(nDTO.getEmail());
		n.setTelefon(nDTO.getTelefon());
		
	
		return nRepo.save(n);
	}
	
	public List<PredmetDTO> getNastavnikPredavanja(Long id){
		List<Predavanje> predavanja = pRepo.findByNastavnikId(id);
		return predavanja.stream().map(P -> new PredmetDTO(P.getPredmet())).collect(Collectors.toList());
	}
	
	public void createPredavanje(Long nastavnikId, PredmetDTO pDTO){
		Nastavnik n = nRepo.getOne(nastavnikId);
		Predmet p = new Predmet(pDTO);
		Predavanje predavanje = new Predavanje(new Long(hashCode()), n, p);
		pRepo.save(predavanje);
	}
	
	public void deletePredavanje(Long nastavnikId, Long predavanjeId) {
		List<Predavanje> predavanja = pRepo.findByNastavnikId(nastavnikId);
		predavanja.forEach(P->{
			if(P.getPredmet().getId().equals(predavanjeId)) {
				pRepo.delete(P);
			}
		});
		
	}
	
	


}
