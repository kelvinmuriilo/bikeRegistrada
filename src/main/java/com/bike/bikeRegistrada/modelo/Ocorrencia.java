package com.bike.bikeRegistrada.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;


@Entity
public class Ocorrencia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataRegistroOcorrencia = LocalDateTime.now();
	private LocalDateTime dataDoFato;
	
	@Enumerated(EnumType.STRING)
	private TipoOcorrencia tipo;
		
	@ManyToOne
	private Cidade cidade;
	
	@ManyToOne
	private Bairro bairro;
	
	@ManyToOne
	private Bicicleta bicicleta;
	
	@ManyToOne
	private Usuario usuario;
	
	public Ocorrencia(String titulo, String descricao, 
			Cidade cidade, Bairro bairro, Bicicleta bicicleta, LocalDateTime dataDoFato, TipoOcorrencia tipo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.cidade = cidade;
		this.bairro = bairro;
		this.bicicleta = bicicleta;
		this.dataDoFato = dataDoFato;
		this.dataRegistroOcorrencia = LocalDateTime.now();
		this.tipo = tipo;
	}
	
	public Ocorrencia() {}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
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

	public Cidade getCidade() {
		return cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((bicicleta == null) ? 0 : bicicleta.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((dataDoFato == null) ? 0 : dataDoFato.hashCode());
		result = prime * result + ((dataRegistroOcorrencia == null) ? 0 : dataRegistroOcorrencia.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ocorrencia other = (Ocorrencia) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (bicicleta == null) {
			if (other.bicicleta != null)
				return false;
		} else if (!bicicleta.equals(other.bicicleta))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (dataDoFato == null) {
			if (other.dataDoFato != null)
				return false;
		} else if (!dataDoFato.equals(other.dataDoFato))
			return false;
		if (dataRegistroOcorrencia == null) {
			if (other.dataRegistroOcorrencia != null)
				return false;
		} else if (!dataRegistroOcorrencia.equals(other.dataRegistroOcorrencia))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
