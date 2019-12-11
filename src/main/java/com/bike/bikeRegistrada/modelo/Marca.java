package com.bike.bikeRegistrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Marca {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private List<Marca> marcas;
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public List<Marca> getMarcas() {
		return marcas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marcas == null) ? 0 : marcas.hashCode());
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
		Marca other = (Marca) obj;
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
		if (marcas == null) {
			if (other.marcas != null)
				return false;
		} else if (!marcas.equals(other.marcas))
			return false;
		return true;
	}

	
}
