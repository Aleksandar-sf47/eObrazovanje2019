package com.sf472015.eObrazovanje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.repo.UlogaRepository;

@Service
public class UlogaService implements UlogaServiceInterface{

	@Autowired
	UlogaRepository uRepo;
	
	@Override
	public Uloga getUlogaByName(String uloga) {
		return uRepo.getByUloga(uloga);
	}

}
