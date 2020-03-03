package com.bike.bikeRegistrada.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bike.bikeRegistrada.excecao.ExcecaoAplicacao;
import com.bike.bikeRegistrada.model.dto.BicicletaDto;
import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.repository.BicicletaRepository;
import com.bike.bikeRegistrada.repository.ModeloBicicletaRepository;

@Service
public class BicicletaServico {
	@Autowired
	private BicicletaRepository bicicletaRepository;
	
	@Autowired
	private ModeloBicicletaRepository modeloRepository;
	
	/**
	 * Lista todas as bicicletas cadastradas.
	 * 
	 * @param paginacao        - Objeto que contem as informacoes para a consulta paginada
	 *                           {@link Pageable}
	 *
	 * @return 					Lista paginada com todas as bicicletas
	 * 							{@link Page<BicicletaDto>}
	 *                           
	 * @author            		Kelvin Murilo
	 */
	
	public Page<BicicletaDto> listar(Pageable paginacao) {
		Page<Bicicleta> bicicletas = bicicletaRepository.findAll(paginacao);
		return BicicletaDto.converterToPage(bicicletas);
		
	}
	
	/**
	 * Lista todas as bicicletas cadastradas.
	 * 
	 * @param codigo          - Código identificador de uma bicicleta
	 *                           {@link Long}
	 *
	 * @return 					Retorna um objeto que contém as informações 
	 * 							de uma bicicleta
	 * 							{@link BicicletaDto}
	 *                           
	 * @author            		Kelvin Murilo
	 */
	public BicicletaDto listarUmaBicicleta(Long codigo) {
		Bicicleta bicicleta = bicicletaRepository.findByCodigo(codigo);
		if(bicicleta != null) {
			return new BicicletaDto(bicicleta); 
		}else {
			throw new ExcecaoAplicacao("Bicicleta não encontrada.");
		}
	}
	
	public void listarOcorrenciasDeUmaBicicleta() {}
	public void cadastrar() {}
	public void atualizar() {}
	public void deletar() {}

}
