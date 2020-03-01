package com.bike.bikeRegistrada.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bikeRegistrada.modelo.Modelo;

public interface ModeloBicicletaRepository extends JpaRepository<Modelo, Long>{

	Modelo findByDescricao(String descricaoModelo);

}
