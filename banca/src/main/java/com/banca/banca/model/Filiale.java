package com.banca.banca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "filiale")
public class Filiale implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_filiale")
	private Long idFiliale;
	@Column(name="indirizzo")
	private String indirizzo;
	
	public Filiale(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public Filiale() {
		
	}

	public Long getIdFiliale() {
		return idFiliale;
	}

	public void setIdFiliale(Long idFiliale) {
		this.idFiliale = idFiliale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	
	

}
