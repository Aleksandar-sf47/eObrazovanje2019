package com.sf472015.eObrazovanje.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sf472015.eObrazovanje.dto.LoginForm;
import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.model.Uloga;
import com.sf472015.eObrazovanje.repo.UlogaRepository;
import com.sf472015.eObrazovanje.security.JwtProvider;
import com.sf472015.eObrazovanje.security.JwtResponse;
import com.sf472015.eObrazovanje.service.KorisnikService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	KorisnikService kServ;
	
	@Autowired
	UlogaRepository uRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
		logger.info(loginRequest.getkIme());
		logger.info(loginRequest.getSifra());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getkIme(), loginRequest.getSifra()));
		logger.info("AAAAAAAAAAAAAAAAAAAA");
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	

}
