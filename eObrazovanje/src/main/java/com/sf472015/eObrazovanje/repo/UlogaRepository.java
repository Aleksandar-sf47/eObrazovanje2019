package com.sf472015.eObrazovanje.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf472015.eObrazovanje.model.Uloga;

public interface UlogaRepository extends JpaRepository<Uloga, Long> {

	public Uloga getByUloga(String uloga);
}
