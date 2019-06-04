package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.repo.PohadjanjeRepository;

@Service
public class PohadjanjeService implements PohadjanjeServiceInterface{

	@Autowired
	PohadjanjeRepository pRepo;
	
	@Override
	public PohadjanjeDTO findById(Long id) {
		Pohadjanje p = pRepo.getOne(id);
		return new PohadjanjeDTO(p);
	}

	@Override
	public List<PohadjanjeDTO> findAll() {
		List<Pohadjanje> pohadjanja = pRepo.findAll();
		return pohadjanja.stream().map(P -> new PohadjanjeDTO(P)).collect(Collectors.toList());
	}

	@Override
	public Pohadjanje save(PohadjanjeDTO pDTO) {
		Pohadjanje p = new Pohadjanje(pDTO);
		return pRepo.save(p);
	}

	@Override
	public void remove(Long id) {
		pRepo.deleteById(id);
	}
	
	@Override
	public Pohadjanje put(PohadjanjeDTO pDTO, Long id) {
		Pohadjanje p = pRepo.getOne(id);
		p.setId(pDTO.getId());
		p.setListaUcenika(pDTO.getListaUcenika());
		p.setPredmet(pDTO.getPredmet());
		return pRepo.save(p);
	}

}
