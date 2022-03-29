package com.banca.banca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banca.banca.model.ContoCorrente;

@Repository
public interface ContoCorrenteRepository extends JpaRepository<ContoCorrente, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM `conti_correnti` WHERE conti_correnti.saldo>0")
	List<ContoCorrente> findAllPositive();
	
	@Query(nativeQuery = true, value = "SELECT * FROM `conti_correnti` WHERE conti_correnti.saldo<0")
	List<ContoCorrente> findAllNegative();
	
}
