package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.model.Ucenik;

public interface UcenikServiceInterface {
	
	public UcenikDTO findById(Long id);
	public List<UcenikDTO> findAll();
	public Ucenik save(UcenikDTO uDTO);
	public void remove(Long id);
	public Ucenik put(UcenikDTO uDTO, Long id);
 
}
