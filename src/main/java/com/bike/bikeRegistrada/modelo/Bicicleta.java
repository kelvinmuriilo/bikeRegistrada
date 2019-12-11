package com.bike.bikeRegistrada.modelo;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


@Entity
public class Bicicleta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String ano;
	
	@Enumerated
	private StatusBicicleta status;
	private Usuario usuario;
	private Marca marca;
	private Modelo modelo;
	
	
	
	public Bicicleta(Long codigo, String ano, StatusBicicleta status, Usuario usuario, Marca marca,
			Modelo modelo) {
		this.codigo = codigo;
		this.ano = ano;
		this.status = StatusBicicleta.SEM_RESTRICAO;
		this.usuario = usuario;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public String getAno() {
		return ano;
	}
	public StatusBicicleta getStatus() {
		return status;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Marca getMarca() {
		return marca;
	}
	public Modelo getModelo() {
		return modelo;
	}

	public void setStatus(StatusBicicleta status) {
		this.status = status;
	}
	
	

}
