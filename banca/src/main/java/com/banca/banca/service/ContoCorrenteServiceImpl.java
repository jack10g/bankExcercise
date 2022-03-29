package com.banca.banca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banca.banca.model.ContoCorrente;
import com.banca.banca.repository.ContoCorrenteRepository;
@Service
public class ContoCorrenteServiceImpl implements ContoCorrenteService{

	@Autowired
	ContoCorrenteRepository gestioneConto;
	
	@Override
	public void addConto(ContoCorrente conto1) {
		gestioneConto.save(conto1);
		
	}

	@Override
	public void removeConto(Long idConto) {
		gestioneConto.deleteById(idConto);
	}

	@Override
	public List<ContoCorrente> selectAll() {
		return gestioneConto.findAll();
	}

	@Override
	public Optional<ContoCorrente> searchById(Long idConto) {
		return gestioneConto.findById(idConto);
	}
	
	public void modifySaldoPrelievo(Long idConto, double somma) {
		ContoCorrente conto1 = gestioneConto.getById(idConto);
		if((conto1.getSaldo()-somma)>-(conto1.getScopertoMassimo())) {
			double sommaSaldo = conto1.getSaldo()-(somma + (somma*conto1.getCommissioni()));
			conto1.setSaldo(sommaSaldo);
			gestioneConto.save(conto1);
		}else {
			throw new IllegalArgumentException("Impossibile effettuare il prelievo");
		}
	}
	
	public void modifySaldoVersamento(Long idConto, double somma) {
		ContoCorrente conto1 = gestioneConto.getById(idConto);
		double sommaSaldo = conto1.getSaldo() + (somma - (somma*conto1.getCommissioni()));
		conto1.setSaldo(sommaSaldo);
		gestioneConto.save(conto1);
	}
	
	public List<ContoCorrente> selectAllContoPositivo() {
		return gestioneConto.findAllPositive();
	}
	
	public List<ContoCorrente> selectAlContoNegativo(){
		return gestioneConto.findAllNegative();
	}
	
	
	

}
