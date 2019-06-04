package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.UplateDTO;
import com.sf472015.eObrazovanje.model.Uplate;

public interface UplateServiceInterface {
	
	public UplateDTO findById(Long id);
	public List<UplateDTO> findAll();
	public Uplate save(UplateDTO uDTO);
	public void remove(Long id);
	public Uplate put(UplateDTO uDTO, Long id);
}
