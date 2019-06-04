package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.DokumentaStudentaDTO;
import com.sf472015.eObrazovanje.model.DokumentaStudenta;
import com.sf472015.eObrazovanje.model.DokumentaStudenta;
import com.sf472015.eObrazovanje.repo.DokumentStudentaRepository;

@Service
public class DokumentaStudentaService implements DokumentaStudentaServiceInterface {
	
	@Autowired
	DokumentStudentaRepository dsRepo;

	@Override
	public DokumentaStudentaDTO findById(Long id) {
		DokumentaStudenta dokStudenta = dsRepo.getOne(id);
		return new DokumentaStudentaDTO(dokStudenta);
	}

	@Override
	public List<DokumentaStudentaDTO> findAll() {
		List<DokumentaStudenta> ucenici =  dsRepo.findAll();
		return ucenici.stream().map(X -> new DokumentaStudentaDTO(X)).collect(Collectors.toList());
	}

	@Override
	public DokumentaStudenta save(DokumentaStudentaDTO dsDTO) {
		DokumentaStudenta dokStudenta = new DokumentaStudenta(dsDTO);
		return dsRepo.save(dokStudenta);
	}

	@Override
	public void remove(Long id) {
		dsRepo.deleteById(id);
		
	}

	@Override
	public DokumentaStudenta put(DokumentaStudentaDTO dokStudentaDTO, Long id) {
		DokumentaStudenta ds = dsRepo.getOne(id);
		ds.setId(dokStudentaDTO.getId());
		ds.setFileName(dokStudentaDTO.getFileName());
		ds.setNaziv(dokStudentaDTO.getNaziv());
		ds.setUcenik(dokStudentaDTO.getUcenik());
		return dsRepo.save(ds);
	}

}
