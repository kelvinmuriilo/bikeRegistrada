package com.bike.bikeRegistrada.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.bike.bikeRegistrada.modelo.Bicicleta;
import com.bike.bikeRegistrada.modelo.StatusBicicleta;

public class BicicletaDto {
	
	private Long codigo;
	private String ano;
	private String descricaoModelo;
	private String descricaoMarca;
	private StatusBicicleta status;
	
	public BicicletaDto(){}
	
	public BicicletaDto(Bicicleta  bicicleta) {
	
		this.codigo = bicicleta.getCodigo();
		this.ano = bicicleta.getAno();
		this.descricaoModelo = bicicleta.getModelo().getDescricao();
		this.descricaoMarca = bicicleta.getModelo().getMarca().getDescricao();
		this.status = bicicleta.getStatus();
	}
	public Long getCodigo() {
		return codigo;
	}
	public String getAno() {
		return ano;
	}
	public String getDescricaoModelo() {
		return descricaoModelo;
	}
	public String getDescricaoMarca() {
		return descricaoMarca;
	}
	public StatusBicicleta getStatus() {
		return status;
	}
	
	public static List<BicicletaDto> converterToList(List<Bicicleta> bicicletas) {
		return  bicicletas.stream()
				.map(BicicletaDto::new)
				.collect(Collectors.toList());
	}
	
	public static Page<BicicletaDto> converterToPage(Page<Bicicleta> bicicletas){
		return bicicletas.map(BicicletaDto::new);
	}
}
