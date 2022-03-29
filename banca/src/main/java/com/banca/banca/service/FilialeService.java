package com.banca.banca.service;

import java.util.List;
import java.util.Optional;

import com.banca.banca.model.Filiale;

public interface FilialeService {
	
	public void addFiliale(Filiale filiale1);
	
	public void removeFiliale(Long idFiliale);
	
	public List<Filiale> selectAll();
	
	public Optional<Filiale> searchFilialeById(Long idFiliale);
	
}
