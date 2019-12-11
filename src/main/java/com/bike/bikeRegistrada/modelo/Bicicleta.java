package com.bike.bikeRegistrada.modelo;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;


@Entity
public class Bicicleta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String ano;
	
	@Enumerated
	private StatusBicicleta status;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Marca marca;
	
	@ManyToOne
	private Modelo modelo;
	
	
	
	public Bicicleta(Long codigo, String ano, StatusBicicleta status, Usuario usuario, Marca marca,
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
	public String getAno() {
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

	public void setStatus(StatusBicicleta status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
