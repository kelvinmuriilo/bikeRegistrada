package com.bike.bikeRegistrada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bikeRegistrada.modelo.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
