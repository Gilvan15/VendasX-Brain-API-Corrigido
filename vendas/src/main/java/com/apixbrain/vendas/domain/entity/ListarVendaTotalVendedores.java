package com.apixbrain.vendas.domain.entity;

import lombok.Data;

@Data
public class ListarVendaTotalVendedores {
	
	private Long id;
	
	private String nome;
	
	private Double totalvendasvendedor;
	
	private Double mediavendasdiarias;
	
	private Long quantvendaperiodoinformado;  
	
	
	public ListarVendaTotalVendedores() {
		super();
	}
	
	public ListarVendaTotalVendedores(Long id, String nome, Double totalvendasvendedor, Double mediavendasdiarias,
			Long quantvendaperiodoinformado) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalvendasvendedor = totalvendasvendedor;
		this.mediavendasdiarias = mediavendasdiarias;
		this.quantvendaperiodoinformado = quantvendaperiodoinformado;
	}

}