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

import com.sf472015.eObrazovanje.dto.PolaganjeIspitaDTO;
import com.sf472015.eObrazovanje.service.PolaganjeIspitaService;
import com.sf472015.eObrazovanje.service.PolaganjeIspitaService;

@RestController
@RequestMapping(value="api/polaganjeIspita")
public class PolaganjeIspitaController {
	

	@Autowired
	PolaganjeIspitaService pServ;
	
	@GetMapping
	public ResponseEntity<List<PolaganjeIspitaDTO>> getPolaganjeIspita(){
		return new ResponseEntity<List<PolaganjeIspitaDTO>>(pServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PolaganjeIspitaDTO> getPolaganjeIspita(@PathVariable(value = "id") Long id){
		return new ResponseEntity<PolaganjeIspitaDTO>(pServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<PolaganjeIspitaDTO> postPolaganjeIspita(@RequestBody PolaganjeIspitaDTO pDTO){
		pServ.save(pDTO);
		return new ResponseEntity<PolaganjeIspitaDTO>(pDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PolaganjeIspitaDTO> putPolaganjeIspita(@RequestBody PolaganjeIspitaDTO pDTO, @PathVariable(value="id") Long id){
		pServ.put(pDTO, id);
		return new ResponseEntity<PolaganjeIspitaDTO>(pDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePolaganjeIspita(@PathVariable(value="id") Long id){
		pServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
}
