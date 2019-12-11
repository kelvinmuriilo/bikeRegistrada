package com.bike.bikeRegistrada.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Usuario {
	private String nome;
	
	@Id
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
