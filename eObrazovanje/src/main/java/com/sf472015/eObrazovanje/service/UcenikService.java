package com.sf472015.eObrazovanje.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.repo.UcenikRepository;

@Service
public class UcenikService  implements UcenikServiceInterface{

	@Autowired
	UcenikRepository uRepo;
	
	@Override
	public UcenikDTO findById(Long id) {
		Ucenik u = uRepo.getOne(id);
		return new UcenikDTO(u);
	}

	@Override
	public List<UcenikDTO> findAll() {
		List<Ucenik> ucenici =  uRepo.findAll();
		return ucenici.stream().map(X -> new UcenikDTO(X)).collect(Collectors.toList());
	}

	@Override
	public Ucenik save(UcenikDTO uDTO) {
		Ucenik u = new Ucenik(uDTO);
		return uRepo.save(u);
	}

	@Override
	public void remove(Long id) {
		uRepo.deleteById(id);
		
	}

	@Override
	public Ucenik put(UcenikDTO uDTO, Long id) {
		Ucenik u = uRepo.getOne(id);
		u.setBrojIndeksa(uDTO.getBrojIndeksa());
		u.setIme(uDTO.getIme());
		u.setPrezime(uDTO.getPrezime());
		u.setJmbg(uDTO.getJmbg());
		u.setEmail(uDTO.getEmail());
		u.setTelefon(uDTO.getEmail());
		u.setKorisnickoIme(uDTO.getKorisnickoIme());
		u.setSifra(uDTO.getSifra());
		u.setNovcanik(uDTO.getNovcanik());
		u.setListaDokumenataStudenta(uDTO.getListaDokumenataStudenta());
		u.setListaPohadjanjaStudenta(uDTO.getListaPohadjanjaStudenta());
		u.setListaPolaganjaStudenta(uDTO.getListaPolaganjaStudenta());
		u.setListaUplataStudenta(uDTO.getListaUplataStudenta());
		return uRepo.save(u);
		
	}

}
