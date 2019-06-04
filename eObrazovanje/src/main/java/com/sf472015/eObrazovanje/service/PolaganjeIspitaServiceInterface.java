package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.PolaganjeIspitaDTO;
import com.sf472015.eObrazovanje.model.PolaganjeIspita;

public interface PolaganjeIspitaServiceInterface {
	
	public PolaganjeIspitaDTO findById(Long id);
	public List<PolaganjeIspitaDTO> findAll();
	public PolaganjeIspita save(PolaganjeIspitaDTO piDTO);
	public void remove(Long id);
	public PolaganjeIspita put(PolaganjeIspitaDTO piDTO, Long id);

}
