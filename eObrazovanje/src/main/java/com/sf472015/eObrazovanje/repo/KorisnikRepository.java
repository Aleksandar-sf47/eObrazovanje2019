package com.sf472015.eObrazovanje.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf472015.eObrazovanje.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	

	public Optional<Korisnik> getByKorisnickoIme(String username);

}
