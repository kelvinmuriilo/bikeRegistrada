package com.bike.bikeRegistrada.servico;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bike.bikeRegistrada.controller.form.OcorrenciaForm;
import com.bike.bikeRegistrada.excecao.ExcecaoNegocio;
import com.bike.bikeRegistrada.model.dto.OcorrenciaDto;
import com.bike.bikeRegistrada.excecao.ExcecaoAplicacao;
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

	/**
	 * Efetua o cadastro de uma ocorrência
	 * 
	 * @param form - Objeto que representa uma ocorrência {@link OcorrenciaForm}
	 * 
	 * @author Kelvin Murilo
	 */

	@Transactional
	public void cadastrarOcorrencia(OcorrenciaForm form) {
		Assert.notNull(form, "Todos os dados devem ser informados.");

		Set<ConstraintViolation<OcorrenciaForm>> violacoes = validator.validate(form);

		if (violacoes.isEmpty()) {
			Bairro bairro = bairroRepo.findByDescricao(form.getDescricaoBairro());
			if (bairro == null) {
				throw new ExcecaoAplicacao("Bairro não encontrado.");
			}

			Cidade cidade = bairro.getCidade();
			if (cidade == null) {
				throw new ExcecaoAplicacao("Cidade não encontrada");
			}

			Bicicleta bicicleta = biciclietaRepo.findByCodigo(form.getCodigoBicicleta());
			if (bicicleta == null) {
				throw new ExcecaoAplicacao("Bicicleta não encontrada");
			}
			if (bicicleta.getStatus().equals(StatusBicicleta.FURTO)
					|| bicicleta.getStatus().equals(StatusBicicleta.ROUBO)) {
				throw new ExcecaoNegocio("A bicicleta informada já contém restrição de " + bicicleta.getStatus().toString());
			} else {
				bicicleta.setStatus(StatusBicicleta.valueOf(form.getTipo().name()));
			}

			Ocorrencia ocorrencia = new Ocorrencia(form.getTitulo(), form.getDescricao(), cidade, bairro, bicicleta,
					form.getDataDoFato(), form.getTipo());

			ocorrenciaRepo.save(ocorrencia);

		} else {
			throw new ExcecaoNegocio("Todos os dados devem ser informados.");
		}
	}

	/**
	 * Retorna uma ocorrência cadastrada.
	 * 
	 * @param id - Número identificador de uma ocorrência {@link Integer}
	 * @return - Ocorrencia buscada {@link OcorrenciaDto}
	 * 
	 * @author Kelvin Murilo
	 */

	public OcorrenciaDto listarUmaOcorrencia(Long id) {
		Optional<Ocorrencia> ocorrencia = ocorrenciaRepo.findById(id);

		if (ocorrencia.isPresent()) {
			return new OcorrenciaDto(ocorrencia.get());
		} else {
			throw new ExcecaoAplicacao("Nenhuma ocorrência foi encontrada.");
		}
	}

	/**
	 * Retorna uma lista com todas as ocorrências cadastradas.
	 * 
	 * @param paginacao - Objeto que contém os dados para paginação
	 *                  {@link Pageable}}
	 * 
	 * 
	 * @return - Lista paginada com ocorrências cadastradas
	 *         {@link Page<OcorrenciaDto>}
	 * 
	 * @author Kelvin Murilo
	 */

	public Page<OcorrenciaDto> listarOcorrencias(Pageable paginacao) {
		Page<Ocorrencia> ocorrencias = ocorrenciaRepo.findAll(paginacao);
		return OcorrenciaDto.converterToPage(ocorrencias);
	}
}
