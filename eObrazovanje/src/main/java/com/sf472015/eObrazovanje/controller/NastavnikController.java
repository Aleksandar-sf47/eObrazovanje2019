package com.sf472015.eObrazovanje.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
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
import com.sf472015.eObrazovanje.dto.PohadjanjeDTO;
import com.sf472015.eObrazovanje.dto.PredavanjeDTO;
import com.sf472015.eObrazovanje.dto.PredmetDTO;
import com.sf472015.eObrazovanje.model.Nastavnik;
import com.sf472015.eObrazovanje.model.Predavanje;
import com.sf472015.eObrazovanje.service.NastavnikService;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/nastavnici")
public class NastavnikController {
	
	@Autowired
	private NastavnikService nServ;
	
	
	
	
	
	@GetMapping
	public ResponseEntity<List<NastavnikDTO>> getNastavnici(){
		return new ResponseEntity<List<NastavnikDTO>>(nServ.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NastavnikDTO> getNastavnik(@PathVariable(value = "id") Long id){
		return new ResponseEntity<NastavnikDTO>(nServ.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<NastavnikDTO> postNastavnik(@RequestBody NastavnikDTO nDTO){
		nServ.save(nDTO);
		return new ResponseEntity<NastavnikDTO>(nDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NastavnikDTO> putNastavnik(@RequestBody NastavnikDTO nDTO, @PathVariable(value="id") Long id){
		nServ.put(nDTO, id);
		return new ResponseEntity<NastavnikDTO>(nDTO, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteNastavnik(@PathVariable(value="id") Long id){
		nServ.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/predavanja")
	public ResponseEntity<List<PredmetDTO>> getNastavniciPredavanja(@PathVariable(value = "id") Long id){
		List<PredmetDTO> predmeti = nServ.getNastavnikPredavanja(id);
		return new ResponseEntity<List<PredmetDTO>>(predmeti, HttpStatus.OK);
		
	}
	
	@PostMapping("/{id}/predavanja")
	public ResponseEntity<HttpStatus> getNastavniciPredavanja(@PathVariable(value = "id") Long id, @RequestBody PredmetDTO pDTO){
		nServ.createPredavanje(id, pDTO);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}/predavanja/{predmetId}")
	public ResponseEntity<HttpStatus> deleteNastavniciPredavanje(@PathVariable(value = "id") Long id, @PathVariable(value = "predmetId") Long predmetId){
		nServ.deletePredavanje(id, predmetId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
