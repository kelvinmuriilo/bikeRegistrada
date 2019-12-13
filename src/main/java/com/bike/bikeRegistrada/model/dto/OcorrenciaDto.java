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
	
	
	public OcorrenciaDto(Ocorrencia ocorrencia) {
		this.id = ocorrencia.getId();
		this.titulo = ocorrencia.getTitulo();
		this.descricao = ocorrencia.getDescricao();
		this.descricaoCidade = ocorrencia.getCidade().getDescricao();
		this.descricaoBairro = ocorrencia.getBairro().getDescricao();
		this.bicicleta = ocorrencia.getBicicleta().getModelo().getDescricao();
		this.nomeUsuario = ocorrencia.getUsuario().getNome();
		this.dataRegistroOcorrencia = ocorrencia.getDataRegistroOcorrencia();
		this.dataDoFato = ocorrencia.getDataDoFato();
		this.tipo = ocorrencia.getTipo();
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
		return ocorrencias.stream()
				.map(OcorrenciaDto::new)
				.collect(Collectors.toList());
	}
	
	
	
}
