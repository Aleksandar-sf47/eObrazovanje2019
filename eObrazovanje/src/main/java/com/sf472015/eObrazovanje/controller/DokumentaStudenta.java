package com.sf472015.eObrazovanje.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.sf472015.eObrazovanje.dto.DokumentaStudentaDTO;
import com.sf472015.eObrazovanje.dto.DokumentaStudentaDTO;
import com.sf472015.eObrazovanje.service.DokumentaStudentaService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="api/dokumentastudenta")
public class DokumentaStudenta {
	
	@Autowired
	private DokumentaStudentaService dokServ;
	
	@GetMapping
	public ResponseEntity<List<DokumentaStudentaDTO>> getDokumentaStudenta(){
		return new ResponseEntity<List<DokumentaStudentaDTO>>(dokServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DokumentaStudentaDTO> getDokumentaStudenta(@PathVariable(value = "id") Long id){
		return new ResponseEntity<DokumentaStudentaDTO>(dokServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<DokumentaStudentaDTO> postDokumentaStudenta(@RequestBody DokumentaStudentaDTO dsDTO){
		dokServ.save(dsDTO);
		return new ResponseEntity<DokumentaStudentaDTO>(dsDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DokumentaStudentaDTO> putDokumentaStudenta(@RequestBody DokumentaStudentaDTO dsDTO, @PathVariable(value="id") Long id){
		dokServ.put(dsDTO, id);
		return new ResponseEntity<DokumentaStudentaDTO>(dsDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteDokumentaStudenta(@PathVariable(value="id") Long id){
		dokServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

}
