package com.bike.bikeRegistrada.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.bike.bikeRegistrada.modelo.Ocorrencia;
import com.bike.bikeRegistrada.modelo.TipoOcorrencia;

public class OcorrenciaDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String descricaoCidade;
	private String descricaoBairro;
	private String bicicleta;
	private String nomeUsuario;
	private LocalDateTime dataRegistroOcorrencia;
	private LocalDateTime dataDoFato;
	private TipoOcorrencia tipo;
	
	
	public OcorrenciaDto(Long id, String titulo, String descricao, String descricaoCidade, String descricaoBairro,
			String bicicleta, String nomeUsuario, LocalDateTime dataRegistroOcorrencia, LocalDateTime dataDoFato,
			TipoOcorrencia tipo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.descricaoCidade = descricaoCidade;
		this.descricaoBairro = descricaoBairro;
		this.bicicleta = bicicleta;
		this.nomeUsuario = nomeUsuario;
		this.dataRegistroOcorrencia = dataRegistroOcorrencia;
		this.dataDoFato = dataDoFato;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getDescricaoCidade() {
		return descricaoCidade;
	}
	public String getDescricaoBairro() {
		return descricaoBairro;
	}
	public String getBicicleta() {
		return bicicleta;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public LocalDateTime getDataRegistroOcorrencia() {
		return dataRegistroOcorrencia;
	}
	public LocalDateTime getDataDoFato() {
		return dataDoFato;
	}
	public TipoOcorrencia getTipo() {
		return tipo;
	}
	
	public static List<OcorrenciaDto> converter(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream().map(OcorrenciaDto::new).collect(Collectors.toList());
	}
	
	
	
}
