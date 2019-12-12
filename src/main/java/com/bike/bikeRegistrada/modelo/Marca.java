package com.bike.bikeRegistrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Marca {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@OneToMany(mappedBy = "marca")
	private List<Modelo> modelos;
	
	@OneToMany(mappedBy = "marca")
	private List<Bicicleta> bicicletas;

	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public List<Modelo> getModelos() {
		return modelos;
	}
	
	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}
	
	
	
}
