package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.model.Pohadjanje;

public interface PohadjanjeServiceInterface {
	
	public PohadjanjeDTO findById(Long id);
	public List<PohadjanjeDTO> findAll();
	public Pohadjanje save(PohadjanjeDTO pDTO);
	public void remove(Long id);
	Pohadjanje put(PohadjanjeDTO pDTO, Long id);
	

}
