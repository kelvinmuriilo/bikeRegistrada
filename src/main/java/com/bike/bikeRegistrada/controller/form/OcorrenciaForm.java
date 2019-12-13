package com.bike.bikeRegistrada.controller.form;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.bike.bikeRegistrada.modelo.Bairro;
import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.modelo.Cidade;
import com.bike.bikeRegistrada.modelo.Ocorrencia;
import com.bike.bikeRegistrada.modelo.TipoOcorrencia;
import com.bike.bikeRegistrada.repository.BairroRepository;
import com.bike.bikeRegistrada.repository.BicicletaRepository;

public class OcorrenciaForm {
	
	@NotNull @NotEmpty
	private LocalDateTime dataDoFato;
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	@NotNull @NotEmpty
	private TipoOcorrencia tipo;
	@NotNull @NotEmpty
	private String descricaoBairro;
	@NotNull @NotEmpty
	private Long codigoBicicleta;
		
	public LocalDateTime getDataDoFato() {
		return dataDoFato;
	}
	public void setDataDoFato(String dataDoFato) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dataDoFato, formatter);
		this.dataDoFato = dateTime;
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
	public  Ocorrencia converter(BicicletaRepository bicicletaRepo, BairroRepository bairroRepo) {
		Bairro bairro = bairroRepo.findByDescricao(descricaoBairro);
		Cidade cidade = bairro.getCidade();
		Bicicleta bicicleta = bicicletaRepo.findByCodigo(codigoBicicleta);
		
		return new Ocorrencia(titulo, descricao, cidade, bairro, bicicleta, dataDoFato);
	}
}
