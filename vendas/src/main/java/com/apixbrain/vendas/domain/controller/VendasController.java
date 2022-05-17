package com.apixbrain.vendas.domain.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apixbrain.vendas.domain.entity.ListarVendaTotalVendedores;
import com.apixbrain.vendas.domain.entity.Venda;
import com.apixbrain.vendas.domain.repository.VendasRepository;
import com.apixbrain.vendas.domain.service.CadastroVendasService;


@RestController
@RequestMapping(value = "/vendas")
public class VendasController {

	@Autowired
	private VendasRepository vendasRepository;

	@Autowired
	private CadastroVendasService vendasService;

	@Autowired
	private CadastroVendasService cadastroVendas;
	
//	ListarVendaTotalVendedores lv = new ListarVendaTotalVendedores();

	@GetMapping
	public List<Venda> listar() {
		return vendasRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Venda adicionar(@RequestBody Venda venda) {
		return cadastroVendas.salvar(venda);
	}
	
	@GetMapping("/listafiltrada")
	public List<ListarVendaTotalVendedores> listarVendedores(@RequestParam String dateInicio, @RequestParam String dateFinal ) throws ParseException  {
		return vendasService.listaPorPeriodo(dateInicio, dateFinal);
	}

}