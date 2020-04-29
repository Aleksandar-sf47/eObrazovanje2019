package com.sf472015.eObrazovanje.service;

import java.awt.Label;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Pohadjanje;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.repo.PohadjanjeRepository;
import com.sf472015.eObrazovanje.repo.PredavanjeRepository;
import com.sf472015.eObrazovanje.repo.PredmetRepository;

@Service
public class PredmetService implements PredmetServiceInterface {
	
	@Autowired
	PredmetRepository pRepo;
	
	@Autowired
	PredavanjeRepository predavanjeRepo;
	
	@Autowired
	PohadjanjeRepository pohadjanjeRepo;

	@Override
	public PredmetDTO findById(Long id) {
		Predmet p = pRepo.getOne(id);
		return new PredmetDTO(p);
	}

	@Override
	public List<PredmetDTO> findAll() {
		List<Predmet> listP = pRepo.findAll();
		return listP.stream().map(P -> new PredmetDTO(P)).collect(Collectors.toList());
	}

	@Override
	public Predmet save(PredmetDTO pDTO) {
		return pRepo.save(new Predmet(pDTO));
	}

	@Override
	public void remove(Long id) {
		pRepo.deleteById(id);
		
	}

	@Override
	public Predmet put(PredmetDTO pDTO, Long id) {
		Predmet p = pRepo.getOne(id);
		p.setId(pDTO.getId());
		p.setNaziv(pDTO.getNaziv());
		return pRepo.save(p);
	}

	
	
	

}
