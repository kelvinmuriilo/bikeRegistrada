package com.bike.bikeRegistrada.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Modelo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Marca marca;
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public Marca getMarca() {
		return marca;
	}
	
	
}
