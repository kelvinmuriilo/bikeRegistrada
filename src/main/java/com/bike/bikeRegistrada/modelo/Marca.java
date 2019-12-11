package com.bike.bikeRegistrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Marca {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private List<Marca> marcas;
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public List<Marca> getMarcas() {
		return marcas;
	}

	
}
