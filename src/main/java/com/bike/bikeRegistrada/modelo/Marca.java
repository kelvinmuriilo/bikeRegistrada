package com.bike.bikeRegistrada.modelo;

import java.util.List;

public class Marca {
	
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
