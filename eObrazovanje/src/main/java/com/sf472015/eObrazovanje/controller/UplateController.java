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

import com.sf472015.eObrazovanje.dto.UplateDTO;
import com.sf472015.eObrazovanje.service.UplateService;

@RestController
@RequestMapping(value="api/uplate")
public class UplateController {
	
	@Autowired
	UplateService uServ;
	
	@GetMapping
	public ResponseEntity<List<UplateDTO>> getUplate(){
		return new ResponseEntity<List<UplateDTO>>(uServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UplateDTO> getUplata(@PathVariable(value="id") Long id ){
		return new ResponseEntity<UplateDTO>(uServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<UplateDTO> postUplate(@RequestBody UplateDTO uDTO){
		uServ.save(uDTO);
		return new ResponseEntity<UplateDTO>(uDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UplateDTO> putUplate(@RequestBody UplateDTO uDTO, @PathVariable(value="id") Long id){
		uServ.put(uDTO, id);
		return new ResponseEntity<UplateDTO>(uDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUplata(@PathVariable(value="id") Long id){
		uServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
