package com.bike.bikeRegistrada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bikeRegistrada.modelo.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, Long>{
	Bairro findByDescricao(String descricaoBairro);
}
