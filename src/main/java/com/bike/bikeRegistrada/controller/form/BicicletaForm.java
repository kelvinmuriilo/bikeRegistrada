package com.bike.bikeRegistrada.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.modelo.Modelo;
import com.bike.bikeRegistrada.repository.ModeloRepository;

public class BicicletaForm {
	
	@NotNull @Size(min = 4, max=4)
	private String ano;
	
	@NotNull
	private Long idModelo;
	

	
	public BicicletaForm(String ano, Long idModelo) {
		this.ano = ano;
		this.idModelo = idModelo;
		
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

	
	
	
	public Bicicleta converter(ModeloRepository modeloRepository) {
		Modelo modelo = modeloRepository.getOne(idModelo);
		return new Bicicleta(ano, modelo);
	}
	
	public Bicicleta atualizar(Bicicleta bicicleta, ModeloRepository modeloRepository) {
		Optional<Modelo> modelo = modeloRepository.findById(idModelo);
		
		if(modelo.isPresent()) {
			bicicleta.setAno(ano);
			bicicleta.setModelo(modelo.get());
			bicicleta.setMarca(modelo.get().getMarca());
			
			return bicicleta;
		}
		
		return null;
	}
}