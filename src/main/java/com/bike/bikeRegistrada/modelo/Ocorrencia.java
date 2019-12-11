package com.bike.bikeRegistrada.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Ocorrencia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataOcorrencia;
	private String cidade;
	private String bairro;
	
	@Enumerated
	private TipoOcorrencia tipo;
	private Bicicleta bicicleta;
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getDataOcorrencia() {
		return dataOcorrencia;
	}
	public String getCidade() {
		return cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public TipoOcorrencia getTipo() {
		return tipo;
	}
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	
}
