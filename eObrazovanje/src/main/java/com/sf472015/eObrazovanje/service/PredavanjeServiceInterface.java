package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.model.Predavanje;

public interface PredavanjeServiceInterface {
	
	public PredavanjeDTO findById(Long id);
	public List<PredavanjeDTO> findAll();
	public Predavanje save(PredavanjeDTO pDto);
	public void remove(Long id);
	public Predavanje put(PredavanjeDTO pDTO, Long ID);

}
