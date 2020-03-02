package com.bike.bikeRegistrada.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bike.bikeRegistrada.controller.form.BicicletaForm;
import com.bike.bikeRegistrada.model.dto.BicicletaDto;
import com.bike.bikeRegistrada.model.dto.OcorrenciaDto;
import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.modelo.Ocorrencia;
import com.bike.bikeRegistrada.repository.BicicletaRepository;
import com.bike.bikeRegistrada.repository.ModeloBicicletaRepository;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
	
	@Autowired
	private BicicletaRepository bicicletaRepository;
	
	@Autowired
	private ModeloBicicletaRepository modeloRepository;
	
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
	
	/*@GetMapping("listar-ocorrencias/{codigo}")
	public List<OcorrenciaDto> listarOcorrenciasBike(@PathVariable("codigo") Long codigo) {
		Bicicleta bicicleta = bicicletaRepository.findByCodigo(codigo);
		if(bicicleta != null) {
			List<Ocorrencia> ocorrenciasBicicleta = bicicleta.getOcorrencias();
			return OcorrenciaDto.converter(ocorrenciasBicicleta); 
		}
		return null;
	}*/
	
	@PostMapping
	@Transactional
	public ResponseEntity<BicicletaDto> cadastrar(@RequestBody @Valid BicicletaForm form, UriComponentsBuilder uriBuilder){
		Bicicleta bicicleta = form.converter(modeloRepository);
		bicicletaRepository.save(bicicleta);
		
		URI uri = uriBuilder.path("/bicicletas/{id}").buildAndExpand(bicicleta.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new BicicletaDto(bicicleta));
	}
	
	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<BicicletaDto> atualizar(@RequestBody @Valid BicicletaForm form, @PathVariable("codigo") Long codigo){
		Bicicleta bicicleta = bicicletaRepository.findByCodigo(codigo);
		
		if(bicicleta != null) {
			Bicicleta bicicletaAtualizada = form.atualizar(bicicleta, modeloRepository);
			
			if(bicicletaAtualizada != null) {
				return ResponseEntity.ok(new BicicletaDto(bicicletaAtualizada));
			}
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<BicicletaDto> deletar(@PathVariable("codigo") Long codigo) {
		Bicicleta bicicleta = bicicletaRepository.findByCodigo(codigo);
		
		if(bicicleta != null) {
			bicicletaRepository.delete(bicicleta);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
