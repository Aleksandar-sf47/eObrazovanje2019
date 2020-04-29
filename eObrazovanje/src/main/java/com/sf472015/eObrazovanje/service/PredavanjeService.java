package com.sf472015.eObrazovanje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.repo.PredavanjeRepository;

@Service
public class PredavanjeService {
	
	@Autowired
	private PredavanjeRepository pRepo;

	
	public PredavanjeDTO getPredavanjeById(Long id) {
		Predavanje p = pRepo.getOne(id);
		return new PredavanjeDTO(p);
	}
	
	public PredavanjeDTO getPredavanjeByPredmetID(Long predmetID) {
		Predavanje p = pRepo.findByPredmetId(predmetID);
		return new PredavanjeDTO(p);
	}
	
	public PredavanjeDTO post(PredavanjeDTO pDTO) {
		Predavanje p = new Predavanje(pDTO);
		Predavanje pDB = pRepo.save(p);
		return this.getPredavanjeById(pDB.getId());
	}
	
	public void delete(Long id) {
		pRepo.deleteById(id);
	}
}
