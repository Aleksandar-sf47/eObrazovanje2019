package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.UplateDTO;
import com.sf472015.eObrazovanje.model.Uplate;
import com.sf472015.eObrazovanje.repo.UplateRepository;

@Service
public class UplateService implements UplateServiceInterface{

	@Autowired
	UplateRepository uRepo;
	
	@Override
	public UplateDTO findById(Long id) {
		Uplate u = uRepo.getOne(id);
		return new UplateDTO(u);
	}

	@Override
	public List<UplateDTO> findAll() {
		List<Uplate> uplate =  uRepo.findAll();
		return uplate.stream().map(U -> new UplateDTO(U)).collect(Collectors.toList());	
	}

	@Override
	public Uplate save(UplateDTO uDTO) {
		return uRepo.save(new Uplate(uDTO));
	}

	@Override
	public void remove(Long id) {
		uRepo.deleteById(id);
	}

	@Override
	public Uplate put(UplateDTO uDTO, Long id) {
		Uplate u = uRepo.getOne(id);
		u.setId(uDTO.getId());
		u.setSuma(uDTO.getSuma());
		u.setUcenik(uDTO.getUcenik());
		return uRepo.save(u);
	}
	
	

}
