package com.bike.bikeRegistrada.controller.form;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.bike.bikeRegistrada.modelo.TipoOcorrencia;

public class OcorrenciaForm {
	
	@NotNull 
	private LocalDateTime dataDoFato;
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	@NotNull 
	private TipoOcorrencia tipo;
	@NotNull 
	private String descricaoBairro;
	@NotNull 
	private Long codigoBicicleta;
		
	
	public OcorrenciaForm() {}
	
	public LocalDateTime getDataDoFato() {
		return dataDoFato;
	}
	public void setDataDoFato(String strData) {
		LocalDateTime  data = converterStrToDate(strData);
		this.dataDoFato = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public TipoOcorrencia getTipo() {
		return tipo;
	}
	public void setTipo(TipoOcorrencia tipo) {
		this.tipo = tipo;
	}
	public String getDescricaoBairro() {
		return descricaoBairro;
	}
	public void setDescricaoBairro(String descricaoBairro) {
		this.descricaoBairro = descricaoBairro;
	}
	
	public Long getCodigoBicicleta() {
		return codigoBicicleta;
	}
	public void setCodigoBicicleta(Long codigoBicicleta) {
		this.codigoBicicleta = codigoBicicleta;
	}
	
	public LocalDateTime converterStrToDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
		return dateTime;
	}
}
