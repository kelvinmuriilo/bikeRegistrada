package com.bike.bikeRegistrada.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Bicicleta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String ano;
	
	@Enumerated(EnumType.STRING)
	private StatusBicicleta status;
	
	@ManyToOne
	private Modelo modelo;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Marca marca;
	
	@OneToMany(mappedBy = "bicicleta")
	private List<Ocorrencia> ocorrencias;
	
	
	public Bicicleta(Long codigo, String ano, StatusBicicleta status,
			Modelo modelo, Usuario usuario, List<Ocorrencia> ocorrencias) {
		this.codigo = codigo;
		this.ano = ano;
		this.status = StatusBicicleta.SEM_RESTRICAO;
		this.modelo = modelo;
		this.usuario = usuario;
		this.ocorrencias = new ArrayList<Ocorrencia>();
		this.ocorrencias = ocorrencias;
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


	public Modelo getModelo() {
		return modelo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public Marca getMarca() {
		return marca;
	}


	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((ocorrencias == null) ? 0 : ocorrencias.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Bicicleta other = (Bicicleta) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (ocorrencias == null) {
			if (other.ocorrencias != null)
				return false;
		} else if (!ocorrencias.equals(other.ocorrencias))
			return false;
		if (status != other.status)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
