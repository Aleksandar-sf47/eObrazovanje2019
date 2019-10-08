package com.sf472015.eObrazovanje.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf472015.eObrazovanje.model.Predavanje;

public interface PredavanjeRepository extends JpaRepository<Predavanje, Long>{
	
	List<Predavanje> findByPredmetId(Long id);
	List<Predavanje> findByNastavnikId(Long id);

}
