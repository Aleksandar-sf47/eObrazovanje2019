package com.sf472015.eObrazovanje.service;

import java.util.List;

import com.sf472015.eObrazovanje.dto.DokumentaStudentaDTO;
import com.sf472015.eObrazovanje.model.DokumentaStudenta;

public interface DokumentaStudentaServiceInterface {
	
	public DokumentaStudentaDTO findById(Long id);
	public List<DokumentaStudentaDTO> findAll();
	public DokumentaStudenta save(DokumentaStudentaDTO dsDTO);
	public void remove(Long id);
	public DokumentaStudenta put(DokumentaStudentaDTO dokStudenta, Long id);
}
