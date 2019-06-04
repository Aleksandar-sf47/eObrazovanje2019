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

import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.service.PohadjanjeService;

@RestController
@RequestMapping(value="api/pohadjanje")
public class PohadjanjeController {
	
	@Autowired
	PohadjanjeService pServ;
	
	@GetMapping
	public ResponseEntity<List<PohadjanjeDTO>> getPohadjanja(){
		return new ResponseEntity<List<PohadjanjeDTO>>(pServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PohadjanjeDTO> getPohadjanje(@PathVariable(value = "id") Long id){
		return new ResponseEntity<PohadjanjeDTO>(pServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<PohadjanjeDTO> postPohadjanje(@RequestBody PohadjanjeDTO pDTO){
		pServ.save(pDTO);
		return new ResponseEntity<PohadjanjeDTO>(pDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PohadjanjeDTO> putPohadjanje(@RequestBody PohadjanjeDTO pDTO, @PathVariable(value="id") Long id){
		pServ.put(pDTO, id);
		return new ResponseEntity<PohadjanjeDTO>(pDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePohadjanje(@PathVariable(value="id") Long id){
		pServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	

}
