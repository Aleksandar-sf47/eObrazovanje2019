package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.model.Predmet;

public interface PredmetServiceInterface {
	
	public PredmetDTO findById (Long id);
	public List<PredmetDTO> findAll();
	public Predmet save(PredmetDTO pDTO);
	public void remove(Long id);
	public Predmet put(PredmetDTO pDTO, Long id);

}
