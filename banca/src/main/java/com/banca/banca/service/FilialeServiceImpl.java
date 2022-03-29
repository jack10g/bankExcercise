package com.banca.banca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banca.banca.model.Filiale;
import com.banca.banca.repository.FilialeRepository;

@Service
public class FilialeServiceImpl implements FilialeService{

	
	@Autowired
	FilialeRepository gestioneFiliale;
	
	@Override
	public void addFiliale(Filiale filiale1) {
		gestioneFiliale.save(filiale1);
	}

	@Override
	public void removeFiliale(Long idFiliale) {
		gestioneFiliale.deleteById(idFiliale);
	}

	@Override
	public List<Filiale> selectAll() {
		return gestioneFiliale.findAll();
	}

	@Override
	public Optional<Filiale> searchFilialeById(Long idFiliale) {
		return gestioneFiliale.findById(idFiliale);
	}
	
	public Double raccoltaTotale(Long idFiliale) {
		return gestioneFiliale.raccoltaTotale(idFiliale);
	}
	
	public Double scopertoTotale(Long idFiliale) {
		return gestioneFiliale.scopertoTotale(idFiliale);
	}
	
	public Double giacenzaMedia(Long idFiliale) {
		return gestioneFiliale.giacenzaMedia(idFiliale);
	}
	
	public List<Filiale> elencoFilialiNegative(){
		List<Filiale> allFiliali = gestioneFiliale.findAll();
		List<Filiale> filialiNegative = new ArrayList<Filiale>();
		Long n = 1L;
		for(int i = 0; i<allFiliali.size();i++) {
			if(scopertoTotale(n)>raccoltaTotale(n)) {
				filialiNegative.add(allFiliali.get(i));
			}
			n++;
		}
		return filialiNegative;
	}
	
	public Long nConti(Long idFiliale) {
		return gestioneFiliale.nConti(idFiliale);
	}
	
	

}
