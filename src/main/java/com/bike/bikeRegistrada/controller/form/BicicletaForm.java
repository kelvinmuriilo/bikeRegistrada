package com.bike.bikeRegistrada.controller.form;

import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.modelo.Modelo;
import com.bike.bikeRegistrada.repository.ModeloRepository;

public class BicicletaForm {
	
	private String ano;
	private Long idModelo;
	private Long idMarca;
	
	public BicicletaForm(String ano, Long idModelo, Long idMarca) {
		this.ano = ano;
		this.idModelo = idModelo;
		this.idMarca = idMarca;
	}
	
	public BicicletaForm() {}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	
	public Bicicleta converter(ModeloRepository modeloRepository) {
		Modelo modelo = modeloRepository.getOne(idModelo);
		return new Bicicleta(ano, modelo);
	}
}