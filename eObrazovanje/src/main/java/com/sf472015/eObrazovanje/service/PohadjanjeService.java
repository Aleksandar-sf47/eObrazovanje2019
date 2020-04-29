package com.sf472015.eObrazovanje.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.repo.PohadjanjeRepository;

@Service
public class PohadjanjeService {
	
	private Logger loggger = LoggerFactory.getLogger(PohadjanjeService.class);
	
	@Autowired
	private PohadjanjeRepository pRepo;
	
	public PohadjanjeDTO getById(Long id) {
		Pohadjanje p = pRepo.getOne(id);
		return new PohadjanjeDTO(p);
	}
	
	public PohadjanjeDTO getPohadjanjeByPredmetId(Long id) {
		Pohadjanje p = pRepo.findByPredmetId(id);
		return new PohadjanjeDTO(p);
	}
	
	public PohadjanjeDTO save(PohadjanjeDTO pDTO) {	
		Pohadjanje p = new Pohadjanje(pDTO);
		Pohadjanje pDB = pRepo.save(p);
		return this.getById(pDB.getId());
	}
	
	public PohadjanjeDTO addNewStudentByPredmetId(Long predmetId, UcenikDTO uDTO) {
		Pohadjanje p = pRepo.getOne(predmetId);
		p.getListaUcenika().add(new Ucenik(uDTO));
		Pohadjanje pDB = pRepo.save(p);
		return this.getById(pDB.getId());
	}
	
	public PohadjanjeDTO deleteStudentByPredmetId(Long predmetId, UcenikDTO uDTO) {
		Pohadjanje p = pRepo.getOne(predmetId);
		p.getListaUcenika().removeIf(U->U.getId() == uDTO.getId());
		Pohadjanje pDB = pRepo.save(p);
		return this.getById(pDB.getId());
	}
	
	public void delete(Long id) {
		pRepo.deleteById(id);
	}
	
	


}
