package com.bike.bikeRegistrada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.bikeRegistrada.controller.dto.BicicletaDto;
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

}
