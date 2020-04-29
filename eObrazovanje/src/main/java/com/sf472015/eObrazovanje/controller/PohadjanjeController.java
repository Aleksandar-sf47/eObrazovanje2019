package com.sf472015.eObrazovanje.controller;

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

import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.dto.UcenikDTO;
import com.sf472015.eObrazovanje.service.PohadjanjeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/pohadjanje")
public class PohadjanjeController {
	
	@Autowired
	private PohadjanjeService pServ;
	
	@GetMapping("/{predmetId}")
	public ResponseEntity<PohadjanjeDTO> getByPredmetId(@PathVariable(value = "predmetId") Long id){
		return new ResponseEntity<PohadjanjeDTO>(pServ.getPohadjanjeByPredmetId(id), HttpStatus.OK);
	}
	
	//vraca listu studenata koji pohadjaju predmet
	@GetMapping("/{predmetId}/studenti")
	public ResponseEntity<List<UcenikDTO>> getListaStudenataByPredmetId(@PathVariable(value = "predmetId") Long id){
		PohadjanjeDTO pDTO = pServ.getPohadjanjeByPredmetId(id);
		return new ResponseEntity<List<UcenikDTO>>(pDTO.getListaUcenika(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PohadjanjeDTO> post(@RequestBody PohadjanjeDTO pDTO){
		return new ResponseEntity<PohadjanjeDTO>(pServ.save(pDTO), HttpStatus.OK);
	}
	
	@PutMapping("/{predmetId}/addstudent")
	public ResponseEntity<PohadjanjeDTO> addStudentToList(@PathVariable(value = "predmetId") Long id,@RequestBody UcenikDTO uDTO){
		return new ResponseEntity<PohadjanjeDTO>(pServ.addNewStudentByPredmetId(id, uDTO), HttpStatus.OK);
	}
	
	@PutMapping("/{predmetId}/deletestudent")
	public ResponseEntity<PohadjanjeDTO> deleteStudentToList(@PathVariable(value = "predmetId") Long id,@RequestBody UcenikDTO uDTO){
		return new ResponseEntity<PohadjanjeDTO>(pServ.deleteStudentByPredmetId(id, uDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id){
		pServ.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
