package com.sf472015.eObrazovanje.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf472015.eObrazovanje.model.Pohadjanje;

public interface PohadjanjeRepository extends JpaRepository<Pohadjanje, Long> {

	Pohadjanje findByPredmetId(Long id);
}
