package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.repo.NastavnikRepository;

@Service
public class NastavnikService implements NastavnikServiceInterface{

	@Autowired
	NastavnikRepository nRepo;
	
	@Override
	public NastavnikDTO findById(Long id) {
		Nastavnik n = nRepo.getOne(id);
		return new NastavnikDTO(n);
	}

	@Override
	public List<NastavnikDTO> findAll() {
		List<Nastavnik> nastavnici = nRepo.findAll();
		return nastavnici.stream().map(N -> new NastavnikDTO(N)).collect(Collectors.toList());
		
	}

	@Override
	public Nastavnik save(NastavnikDTO nDTO) {
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
		n.setKorisnickoIme(nDTO.getKorisnickoIme());
		n.setSifra(nDTO.getSifra());
		n.setEmail(nDTO.getEmail());
		n.setTelefon(nDTO.getTelefon());
		n.setListaPredavanjaNastavnika(nDTO.getListaPredavanjaNastavnika());
		return nRepo.save(n);
	}

}
