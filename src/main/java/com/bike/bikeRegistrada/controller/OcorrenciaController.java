package com.bike.bikeRegistrada.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bike.bikeRegistrada.controller.form.OcorrenciaForm;
import com.bike.bikeRegistrada.model.dto.OcorrenciaDto;
import com.bike.bikeRegistrada.modelo.Ocorrencia;
import com.bike.bikeRegistrada.repository.BairroRepository;
import com.bike.bikeRegistrada.repository.BicicletaRepository;
import com.bike.bikeRegistrada.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private BicicletaRepository bicicletaRepository;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@GetMapping
	public List<OcorrenciaDto> lista() {
		List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
		return OcorrenciaDto.converter(ocorrencias);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<OcorrenciaDto> cadastrar(@RequestBody @Valid OcorrenciaForm form, UriComponentsBuilder uriBuilder) {
		Ocorrencia ocorrencia = form.converter(bicicletaRepository, bairroRepository);
		ocorrenciaRepository.save(ocorrencia);
		
		URI uri = uriBuilder.path("/ocorrencias/{id}").buildAndExpand(ocorrencia.getId()).toUri();
		return ResponseEntity.created(uri).body(new OcorrenciaDto(ocorrencia));
		
	}
}
