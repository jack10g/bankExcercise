package com.banca.banca.service;

import java.util.List;
import java.util.Optional;

import com.banca.banca.model.ContoCorrente;

public interface ContoCorrenteService {
	
	public void addConto(ContoCorrente conto1);
	
	public void removeConto(Long idConto);
	
	public List<ContoCorrente> selectAll();
	
	public Optional<ContoCorrente> searchById(Long idConto);
	
	
}
