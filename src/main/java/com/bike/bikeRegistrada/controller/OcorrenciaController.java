package com.bike.bikeRegistrada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.bikeRegistrada.modelo.Ocorrencia;
import com.bike.bikeRegistrada.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@GetMapping
	public List<Ocorrencia> lista() {
		List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
		return ocorrencias;
	}
}
