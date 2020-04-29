package com.sf472015.eObrazovanje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.service.PredavanjeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/predavanja")
public class PredavanjeController {
	
	@Autowired
	private PredavanjeService pServ;
	
	
	@GetMapping("/{predmetID}")
	public ResponseEntity<PredavanjeDTO> getPredavanjeByPredmetId(@PathVariable(value = "predmetID")Long id) {
		return new ResponseEntity<PredavanjeDTO>(pServ.getPredavanjeByPredmetID(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PredavanjeDTO> post(@RequestBody PredavanjeDTO pDTO){
		return new ResponseEntity<PredavanjeDTO>(pServ.post(pDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id){
		pServ.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
