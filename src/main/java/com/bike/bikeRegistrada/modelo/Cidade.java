package com.bike.bikeRegistrada.modelo;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Cidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String sigla;
	
	@OneToMany(mappedBy = "bairro")
	private List<Bairro> bairros;
	
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getSigla() {
		return sigla;
	}
	
	public List<Bairro> getBairros() {
		return bairros;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairros == null) ? 0 : bairros.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		Cidade other = (Cidade) obj;
		if (bairros == null) {
			if (other.bairros != null)
				return false;
		} else if (!bairros.equals(other.bairros))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	
	
}
