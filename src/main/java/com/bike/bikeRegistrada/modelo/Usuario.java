package com.bike.bikeRegistrada.modelo;

import java.time.LocalDateTime;

public class Usuario {
	private String nome;
	private Long cpf;
	private LocalDateTime dataDeNascimento;
	
	public String getNome() {
		return nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public LocalDateTime getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	

}
