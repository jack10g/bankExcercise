package com.banca.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banca.banca.model.Filiale;

@Repository
public interface FilialeRepository extends JpaRepository<Filiale, Long>{
	
	@Query(nativeQuery = true, value = "SELECT SUM(saldo) AS totale_raccolta FROM `conti_correnti` WHERE id_filiale=?1 AND saldo>0")
	Double raccoltaTotale(Long idFiliale);
	
	@Query(nativeQuery = true, value = "SELECT SUM(saldo) AS totale_perdita FROM `conti_correnti` WHERE id_filiale=?1 AND saldo<0")
	Double scopertoTotale(Long idFiliale);
	
	@Query(nativeQuery = true, value = "SELECT AVG(saldo) AS giacenza_media FROM `conti_correnti` WHERE id_filiale=?1 AND saldo>0")
	Double giacenzaMedia(Long idFiliale);
	
	@Query(nativeQuery = true, value = "SELECT COUNT(id_conto) AS numero_conti FROM `conti_correnti` WHERE id_filiale=?1")
	Long nConti(Long idFiliale);
	
	

}
