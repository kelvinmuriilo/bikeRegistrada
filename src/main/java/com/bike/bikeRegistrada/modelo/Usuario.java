package com.bike.bikeRegistrada.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	
	@Id
	private Long cpf;
	private String nome;
	private String email;
	private String senha;
	private LocalDateTime dataDeNascimento;
	
	@OneToMany(mappedBy = "usuario")
	private List<Ocorrencia> ocorrencias;
	
	@OneToMany(mappedBy = "usuario")
	private List<Bicicleta> bicicletas;

	public Usuario(Long cpf, String nome, LocalDateTime dataDeNascimento, List<Ocorrencia> ocorrencias,
			List<Bicicleta> bicicletas) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.ocorrencias = ocorrencias;
		this.bicicletas = new ArrayList<Bicicleta>();
		this.bicicletas = bicicletas;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDataDeNascimento() {
		return dataDeNascimento;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicicletas == null) ? 0 : bicicletas.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ocorrencias == null) ? 0 : ocorrencias.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (bicicletas == null) {
			if (other.bicicletas != null)
				return false;
		} else if (!bicicletas.equals(other.bicicletas))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null)
				return false;
		} else if (!dataDeNascimento.equals(other.dataDeNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ocorrencias == null) {
			if (other.ocorrencias != null)
				return false;
		} else if (!ocorrencias.equals(other.ocorrencias))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	
}
