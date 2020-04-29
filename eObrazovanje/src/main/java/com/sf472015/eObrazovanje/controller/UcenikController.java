package com.sf472015.eObrazovanje.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.model.Ucenik;
import com.sf472015.eObrazovanje.service.UcenikService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="api/ucenici")

public class UcenikController {
	
	@Autowired
	private UcenikService uServ;
	
	@GetMapping
	public ResponseEntity<List<UcenikDTO>> getUcenici(){
		return new ResponseEntity<List<UcenikDTO>>(uServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UcenikDTO> getUcenik(@PathVariable(value = "id") Long id){
		return new ResponseEntity<UcenikDTO>(uServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UcenikDTO> postUcenik(@RequestBody UcenikDTO uDTO){
		uServ.save(uDTO);
		return new ResponseEntity<UcenikDTO>(uDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UcenikDTO> putUcenik(@RequestBody UcenikDTO uDTO, @PathVariable(value="id") Long id){
		uServ.put(uDTO, id);
		return new ResponseEntity<UcenikDTO>(uDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUcenik(@PathVariable(value="id") Long id){
		uServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	
	
}
