package com.bike.bikeRegistrada.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.bikeRegistrada.controller.form.OcorrenciaForm;
import com.bike.bikeRegistrada.model.dto.OcorrenciaDto;
import com.bike.bikeRegistrada.servico.OcorrenciaServico;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaServico ocorrenciaServico;
	
	@GetMapping
	public ResponseEntity<List<OcorrenciaDto>> listar() {
		return ResponseEntity.ok(ocorrenciaServico.listarOcorrencias());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OcorrenciaDto> listarUmaOcorrencia(@PathVariable Long id) {
		return ResponseEntity.ok(ocorrenciaServico.listarUmaOcorrencia(id));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastrar(@RequestBody @Valid OcorrenciaForm form) {
		ocorrenciaServico.cadastrarOcorrencia(form);
		return ResponseEntity.ok("Ocorrência registrada com sucesso!");
	}
}
