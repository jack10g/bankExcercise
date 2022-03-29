package com.banca.banca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banca.banca.model.ContoCorrente;
import com.banca.banca.service.ContoCorrenteServiceImpl;

@RestController
public class ContoCorrenteController {

	@Autowired
	ContoCorrenteServiceImpl gestioneConto;
	
	@PostMapping("/addConto")
	public void addConto(@RequestBody ContoCorrente conto1) {
		gestioneConto.addConto(conto1);
	}
	
	@PostMapping("/removeConto/{idConto}")
	public void removeConto(@PathVariable Long idConto) {
		gestioneConto.removeConto(idConto);
	}
	
	@GetMapping("/selectAllConto")
	public List<ContoCorrente> selectAll() {
		return gestioneConto.selectAll();
	}
	
	@GetMapping("/selectContoById/{idConto}")
	public Optional<ContoCorrente> selectContoById(@PathVariable Long idConto){
		return gestioneConto.searchById(idConto);
	}
	
	@PutMapping("/prelievo/{idConto}/{somma}")
	public void modifySaldoPrelievo(@PathVariable Long idConto, @PathVariable double somma) {
		gestioneConto.modifySaldoPrelievo(idConto, somma);
	}
	
	@PutMapping("/versamento/{idConto}/{somma}")
	public void modifySaldoVersamento(@PathVariable Long idConto, @PathVariable double somma) {
		gestioneConto.modifySaldoVersamento(idConto, somma);
	}
	
	@GetMapping("/elencoContiPositivi")
	public List<ContoCorrente> elencoContiPositivi(){
		return gestioneConto.selectAllContoPositivo();
	}
	
	@GetMapping("/elencoContiNegativi")
	public List<ContoCorrente> elencoContiNegativi(){
		return gestioneConto.selectAlContoNegativo();
	}
}
