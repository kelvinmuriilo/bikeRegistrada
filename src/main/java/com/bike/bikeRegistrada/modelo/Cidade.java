package com.bike.bikeRegistrada.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class Cidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String sigla;
	
	@OneToMany(mappedBy ="cidade")
	private List<Bairro> bairros;
	
	public Cidade() {}

	public Cidade(String descricao, String sigla) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.bairros  = new ArrayList<>();
	}

	public Long getId() {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

	
}
