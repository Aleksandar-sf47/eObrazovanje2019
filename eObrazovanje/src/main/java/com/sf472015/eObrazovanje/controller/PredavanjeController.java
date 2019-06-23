package com.sf472015.eObrazovanje.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.service.PredavanjeService;

@RestController
@RequestMapping(value="api/predavanje")
public class PredavanjeController {
	

	@Autowired
	PredavanjeService pServ;
	
	@GetMapping
	public ResponseEntity<List<PredavanjeDTO>> getPredavanja(){
		return new ResponseEntity<List<PredavanjeDTO>>(pServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PredavanjeDTO> getPredavanje(@PathVariable(value = "id") Long id){
		return new ResponseEntity<PredavanjeDTO>(pServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PredavanjeDTO> postPredavanje(@RequestBody PredavanjeDTO pDTO){
		pServ.save(pDTO);
		return new ResponseEntity<PredavanjeDTO>(pDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PredavanjeDTO> putPredavanje(@RequestBody PredavanjeDTO pDTO, @PathVariable(value="id") Long id){
		pServ.put(pDTO, id);
		return new ResponseEntity<PredavanjeDTO>(pDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePredavanje(@PathVariable(value="id") Long id){
		pServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

}
