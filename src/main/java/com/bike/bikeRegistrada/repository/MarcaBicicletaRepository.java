package com.bike.bikeRegistrada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bikeRegistrada.modelo.Marca;

public interface MarcaBicicletaRepository extends JpaRepository<Marca, Long>{

}
