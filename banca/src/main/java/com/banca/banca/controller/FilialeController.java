package com.banca.banca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banca.banca.model.Filiale;
import com.banca.banca.service.FilialeServiceImpl;

@RestController
public class FilialeController {
	
	@Autowired
	FilialeServiceImpl gestioneFiliale;
	
	@PostMapping("/addFiliale")
	public void addFiliale(@RequestBody Filiale filiale1) {
		gestioneFiliale.addFiliale(filiale1);
	}
	
	@PostMapping("/removeFiliale/{idFiliale}")
	public void removeFiliale(@PathVariable Long idFiliale) {
		gestioneFiliale.removeFiliale(idFiliale);
	}
	
	@GetMapping("/selectAllFiliale")
	public List<Filiale> selectAll(){
		return gestioneFiliale.selectAll();
	}
	
	@GetMapping("/selectFilialeById/{idFililale}")
	public Optional<Filiale> selectFilialeById(@PathVariable Long idFililale) {
		return gestioneFiliale.searchFilialeById(idFililale);
	}
	
	@GetMapping("/raccoltaTotale/{idFiliale}")
	public Double raccoltaTotale(@PathVariable Long idFiliale) {
		return gestioneFiliale.raccoltaTotale(idFiliale);
	}
	
	@GetMapping("/scopertoTotale/{idFiliale}")
	public Double scopertoTotale(@PathVariable Long idFiliale) {
		return gestioneFiliale.scopertoTotale(idFiliale);
	}
	
	@GetMapping("/giacenzaMedia/{idFiliale}")
	public Double giacenzaMedia(@PathVariable Long idFiliale) {
		return gestioneFiliale.giacenzaMedia(idFiliale);
	}
	
	@GetMapping("/numeroTotaleConti/{idFiliale}")
	public Long nConti(@PathVariable Long idFiliale) {
		return gestioneFiliale.nConti(idFiliale);
	}
	
	@GetMapping("/elencoFilialiNegative")
	public List<Filiale> elencoFilialiNegative(){
		return gestioneFiliale.elencoFilialiNegative();
	}
}
