package com.bike.bikeRegistrada.servico;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bike.bikeRegistrada.controller.form.OcorrenciaForm;
import com.bike.bikeRegistrada.excecao.ExcecaoNegocio;
import com.bike.bikeRegistrada.modelo.Bairro;
import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.modelo.Cidade;
import com.bike.bikeRegistrada.modelo.Ocorrencia;
import com.bike.bikeRegistrada.modelo.StatusBicicleta;
import com.bike.bikeRegistrada.repository.BairroRepository;
import com.bike.bikeRegistrada.repository.BicicletaRepository;
import com.bike.bikeRegistrada.repository.OcorrenciaRepository;

@Service
public class OcorrenciaServico {
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepo;
	
	@Autowired
	private BicicletaRepository biciclietaRepo;
	
	@Autowired
	private BairroRepository bairroRepo;
	
	@Autowired
	private Validator validator;
	
	public void cadastrarOcorrencia(OcorrenciaForm form) {
		Assert.notNull(form, "Informe todos os dados!");
		
		Set<ConstraintViolation<OcorrenciaForm>> violacoes = validator.validate(form);
		
		if(violacoes.isEmpty()) {
			Bairro bairro = bairroRepo.findByDescricao(form.getDescricaoBairro());
			Cidade cidade = bairro.getCidade();
			Bicicleta bicicleta = biciclietaRepo.findByCodigo(form.getCodigoBicicleta());
			bicicleta.setStatus(StatusBicicleta.valueOf(form.getTipo().name()));
			
			Ocorrencia ocorrencia = new Ocorrencia(form.getTitulo(), form.getDescricao(), 
					cidade, bairro, bicicleta, form.getDataDoFato(), form.getTipo());
			
			ocorrenciaRepo.save(ocorrencia);

		} else {
			throw new ExcecaoNegocio(violacoes.stream().findFirst().get().getMessage());
		}
	}
}
