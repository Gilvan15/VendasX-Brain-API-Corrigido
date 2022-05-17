package com.apixbrain.vendas.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apixbrain.vendas.domain.entity.Vendedor;
import com.apixbrain.vendas.domain.repository.VendedorRepository;
import com.apixbrain.vendas.domain.service.CadastroVendedorService;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private CadastroVendedorService cadastroVendedor;
	
	@GetMapping
	public List<Vendedor> listar(){
		return vendedorRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor adicionar(@RequestBody Vendedor vendedor ) {
		return cadastroVendedor.salvar(vendedor);
	}
	
	
	@GetMapping("/por-nome")
	public List<Vendedor> vendedorPorNome(String nome, Long Id) {
		return vendedorRepository.consultarPorNome(nome, Id);
	}
	
	@GetMapping("/por-unico-nome")
	public Optional<Vendedor> vendedorPorUnicoNome(@RequestParam("nome") String nome) {
		return vendedorRepository.findUnicoByNome(nome);
	}
	
}
