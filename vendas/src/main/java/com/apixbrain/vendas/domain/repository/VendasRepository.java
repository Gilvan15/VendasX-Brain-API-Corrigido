package com.apixbrain.vendas.domain.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apixbrain.vendas.domain.entity.Venda;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long> {
	

//	@Query(value = "SELECT sum(valor) FROM Venda where vendedor_id = :id")
//	public Double sumValor(Long id);

	
	@Query(value = "SELECT sum(valor * 100.0)/100.0 FROM Venda where vendedor_id = :id and dataVenda between :dataInicial and :dataFinal")
	public Double sumValor(Long id, Date dataInicial, Date dataFinal);
	
	
	@Query(value = "SELECT count(id) FROM Venda where vendedor_id = :id and dataVenda between :dataInicial and :dataFinal")
	public Long count(Long id, Date dataInicial, Date dataFinal );
	
	


}
