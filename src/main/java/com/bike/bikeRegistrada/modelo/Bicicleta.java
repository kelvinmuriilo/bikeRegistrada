package com.bike.bikeRegistrada.modelo;

import java.time.LocalDateTime;

public class Bicicleta {
	
	private Long codigo;
	private LocalDateTime ano;
	private StatusBicicleta status;
	private Usuario usuario;
	private Marca marca;
	private Modelo modelo;
	
	
	
	public Bicicleta(Long codigo, LocalDateTime ano, StatusBicicleta status, Usuario usuario, Marca marca,
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
	public LocalDateTime getAno() {
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
	
	

}
