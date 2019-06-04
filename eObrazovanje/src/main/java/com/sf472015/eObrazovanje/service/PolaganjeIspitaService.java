package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.PolaganjeIspitaDTO;
import com.sf472015.eObrazovanje.model.PolaganjeIspita;
import com.sf472015.eObrazovanje.repo.PolaganjeIspitaRepository;
@Service
public class PolaganjeIspitaService implements PolaganjeIspitaServiceInterface {

	@Autowired
	PolaganjeIspitaRepository piRepo;
	
	@Override
	public PolaganjeIspitaDTO findById(Long id) {
		PolaganjeIspita pi = piRepo.getOne(id);
		return new PolaganjeIspitaDTO(pi);
	}

	@Override
	public List<PolaganjeIspitaDTO> findAll() {
		List<PolaganjeIspita> listPi = piRepo.findAll();
		return listPi.stream().map(PI -> new PolaganjeIspitaDTO(PI)).collect(Collectors.toList());
	}

	@Override
	public PolaganjeIspita save(PolaganjeIspitaDTO piDTO) {
		return piRepo.save(new PolaganjeIspita(piDTO));
	}

	@Override
	public void remove(Long id) {
		piRepo.deleteById(id);
		
	}

	@Override
	public PolaganjeIspita put(PolaganjeIspitaDTO piDTO, Long id) {
		PolaganjeIspita pi = piRepo.getOne(id);
		pi.setId(piDTO.getId());
		pi.setCena(piDTO.getCena());
		pi.setNastavnik(piDTO.getNastavnik());
		pi.setOcena(piDTO.getOcena());
		pi.setPredmet(piDTO.getPredmet());
		pi.setUcenik(piDTO.getUcenik());
		return piRepo.save(pi);
	}
	
	

}
