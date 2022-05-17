package com.apixbrain.vendas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apixbrain.vendas.domain.entity.Vendedor;
import com.apixbrain.vendas.domain.repository.VendedorRepository;


@Service
public class CadastroVendedorService {

	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	
	public Vendedor salvar(Vendedor vendedor) {

		return vendedorRepository.save(vendedor);

	}	

}
