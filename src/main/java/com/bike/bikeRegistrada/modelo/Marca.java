package com.bike.bikeRegistrada.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;


@Entity
public class Marca {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@OneToMany(mappedBy = "marca")
	private List<Modelo> modelos;
	
	@OneToMany(mappedBy = "marca")
	private List<Bicicleta> bicicletas;
	
	public Marca(Long id, String descricao, List<Modelo> modelos, List<Bicicleta> bicicletas) {
		this.id = id;
		this.descricao = descricao;
		this.modelos = new ArrayList<Modelo>();
		this.modelos = modelos;
		this.bicicletas = new ArrayList<Bicicleta>();
		this.bicicletas = bicicletas;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicicletas == null) ? 0 : bicicletas.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelos == null) ? 0 : modelos.hashCode());
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
		if (bicicletas == null) {
			if (other.bicicletas != null)
				return false;
		} else if (!bicicletas.equals(other.bicicletas))
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
		if (modelos == null) {
			if (other.modelos != null)
				return false;
		} else if (!modelos.equals(other.modelos))
			return false;
		return true;
	}
}
