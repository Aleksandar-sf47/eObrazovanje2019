package com.sf472015.eObrazovanje.controller;

import java.util.Collection;
import java.util.List;import java.util.stream.Collectors;

import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf472015.eObrazovanje.dto.NastavnikDTO;
import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.model.Predmet;
import com.sf472015.eObrazovanje.repo.PredavanjeRepository;

import com.sf472015.eObrazovanje.service.PredmetService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="api/predmeti")
public class PredmetController {

	@Autowired
	PredmetService pServ;
	

	@Autowired
	PredavanjeRepository pRepo;
	

	
	@GetMapping
	public ResponseEntity<List<PredmetDTO>> getPredmet(){
		return new ResponseEntity<List<PredmetDTO>>(pServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PredmetDTO> getPredmeti(@PathVariable(value = "id") Long id){
		return new ResponseEntity<PredmetDTO>(pServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PredmetDTO> postPredmeti(@RequestBody PredmetDTO pDTO){
		pServ.save(pDTO);
		return new ResponseEntity<PredmetDTO>(pDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PredmetDTO> putPredmeti(@RequestBody PredmetDTO pDTO, @PathVariable(value="id") Long id){
		pServ.put(pDTO, id);
		return new ResponseEntity<PredmetDTO>(pDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete	(@PathVariable(value="id") Long id){
		pServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	

}
