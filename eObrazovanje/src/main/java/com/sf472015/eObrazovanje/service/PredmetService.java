package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.repo.PredmetRepository;

@Service
public class PredmetService implements PredmetServiceInterface {
	
	@Autowired
	PredmetRepository pRepo;

	@Override
	public PredmetDTO findById(Long id) {
		Predmet p = pRepo.getOne(id);
		return new PredmetDTO(p);
	}

	@Override
	public List<PredmetDTO> findAll() {
		List<Predmet> listP = pRepo.findAll();
		return listP.stream().map(P -> new PredmetDTO(P)).collect(Collectors.toList());
	}

	@Override
	public Predmet save(PredmetDTO pDTO) {
		return pRepo.save(new Predmet(pDTO));
	}

	@Override
	public void remove(Long id) {
		pRepo.deleteById(id);
		
	}

	@Override
	public Predmet put(PredmetDTO pDTO, Long id) {
		Predmet p = pRepo.getOne(id);
		p.setId(pDTO.getId());
		p.setNaziv(pDTO.getNaziv());
		p.setPohadjanja(pDTO.getPohadjanja());
		return pRepo.save(p);
	}
	

}
