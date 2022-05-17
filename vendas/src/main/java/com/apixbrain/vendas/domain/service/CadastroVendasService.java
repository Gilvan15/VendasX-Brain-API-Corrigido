package com.apixbrain.vendas.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apixbrain.vendas.domain.entity.ListarVendaTotalVendedores;
import com.apixbrain.vendas.domain.entity.Venda;
import com.apixbrain.vendas.domain.entity.Vendedor;
import com.apixbrain.vendas.domain.repository.VendasRepository;
import com.apixbrain.vendas.domain.repository.VendedorRepository;

@Service
public class CadastroVendasService {
	
	@Autowired
	private VendasRepository vendasRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	

	
	@Transactional
	public Venda salvar(Venda vendas) {
		return vendasRepository.save(vendas);

	}
	
	public List<ListarVendaTotalVendedores> listaPorPeriodo(String dateInicio,  String dateFinal ) throws ParseException{
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		String sDateInicio = dateInicio.replace("-","/");
		String sDateFinal  = dateFinal.replace("-","/");
		Date date1 = formatter1.parse(sDateInicio);
		Date date2 = formatter1.parse(sDateFinal);

		List<ListarVendaTotalVendedores> listTemp = new ArrayList<>();
		List<Vendedor> vendedor = vendedorRepository.findAll();
		
		for (Vendedor rvd : vendedor) {
			
			Long contador = vendasRepository.count(rvd.getId(), date1, date2);
			Double total = vendasRepository.sumValor(rvd.getId(), date1, date2);
			
			if(total != null ) {
				Double media = Math.round((total/contador) * 100.0) /100.0 ;
				listTemp.add(new ListarVendaTotalVendedores(rvd.getId(), rvd.getNome(), total, media, contador));
			}
		}
		return listTemp;
	}
}
