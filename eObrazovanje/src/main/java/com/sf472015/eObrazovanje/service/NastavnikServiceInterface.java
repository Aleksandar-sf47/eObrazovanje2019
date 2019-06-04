package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.model.Nastavnik;

public interface NastavnikServiceInterface {
	
	public NastavnikDTO findById(Long id);
	public List<NastavnikDTO> findAll();
	public Nastavnik save(NastavnikDTO nDTO);
	public void remove(Long id);
	public Nastavnik put(NastavnikDTO nDTO, Long id);

}
