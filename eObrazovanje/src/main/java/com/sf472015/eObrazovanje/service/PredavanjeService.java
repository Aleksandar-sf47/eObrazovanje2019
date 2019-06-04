package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.repo.PredavanjeRepository;

@Service
public class PredavanjeService implements PredavanjeServiceInterface{

	@Autowired
	PredavanjeRepository pRepo;
	
	@Override
	public PredavanjeDTO findById(Long id) {
		Predavanje p = pRepo.getOne(id);
		return new PredavanjeDTO(p);
	}

	@Override
	public List<PredavanjeDTO> findAll() {
		List<Predavanje> listP = pRepo.findAll();
		return listP.stream().map(P -> new PredavanjeDTO(P)).collect(Collectors.toList());
	}

	@Override
	public Predavanje save(PredavanjeDTO pDTO) {
		return pRepo.save(new Predavanje(pDTO));
	}

	@Override
	public void remove(Long id) {
		pRepo.deleteById(id);
		
	}

	@Override
	public Predavanje put(PredavanjeDTO pDTO, Long id) {
		Predavanje p = pRepo.getOne(id);
		p.setId(pDTO.getId());
		p.setNastavnik(p.getNastavnik());
		p.setPredmet(pDTO.getPredmet());
		return pRepo.save(p);
	}
	
	

}
