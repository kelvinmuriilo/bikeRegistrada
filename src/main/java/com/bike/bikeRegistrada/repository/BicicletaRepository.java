package com.bike.bikeRegistrada.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bike.bikeRegistrada.modelo.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
	
	Bicicleta findByCodigo(Long codigo);
	
	@Override
	Page<Bicicleta> findAll(Pageable paginacao);
}
