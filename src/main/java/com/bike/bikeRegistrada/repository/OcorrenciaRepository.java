package com.bike.bikeRegistrada.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bikeRegistrada.modelo.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
	
	@Override
	public Page<Ocorrencia> findAll(Pageable paginacao);

}
