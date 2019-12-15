package com.bike.bikeRegistrada.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.bikeRegistrada.model.dto.BicicletaDto;
import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.repository.BicicletaRepository;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
	
	@Autowired
	private BicicletaRepository bicicletaRepository;
	
	@GetMapping
	public List<BicicletaDto> listar(){
		List<Bicicleta> bicicletas = bicicletaRepository.findAll();
		return BicicletaDto.converter(bicicletas);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<BicicletaDto> listarUmaBicicleta(@PathVariable("codigo") Long codigo) {
		Bicicleta bicicleta = bicicletaRepository.findByCodigo(codigo);
		
		if(bicicleta != null) {
			return ResponseEntity.ok( new BicicletaDto(bicicleta));
		}
		
		return ResponseEntity.notFound().build();
	}

}
