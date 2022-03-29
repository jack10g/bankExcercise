package com.banca.banca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="conti_correnti")
public class ContoCorrente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_conto")
	private Long idConto;
	@Column(name="intestatario")
	private String intestatario;
	@Column(name="saldo")
	private double saldo;
	@Column(name="commissioni")
	private double commissioni;
	@Column(name="scoperto_massimo")
	private double scopertoMassimo;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_filiale", referencedColumnName = "id_filiale")
	private Filiale filiale;
	
	public ContoCorrente(String intestatario, double saldo, double commissioni, double scopertoMassimo,
			Filiale filiale) {
		this.intestatario = intestatario;
		this.saldo = saldo;
		this.commissioni = commissioni;
		this.scopertoMassimo = scopertoMassimo;
		this.filiale = filiale;
	}
	
	public ContoCorrente() {
		
	}

	public Long getIdConto() {
		return idConto;
	}

	public void setIdConto(Long idConto) {
		this.idConto = idConto;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getCommissioni() {
		return commissioni;
	}

	public void setCommissioni(double commissioni) {
		this.commissioni = commissioni;
	}

	public double getScopertoMassimo() {
		return scopertoMassimo;
	}

	public void setScopertoMassimo(double scopertoMassimo) {
		this.scopertoMassimo = scopertoMassimo;
	}

	public Filiale getFiliale() {
		return filiale;
	}

	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}
	
	
	
	
}
