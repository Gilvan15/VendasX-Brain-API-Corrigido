package com.apixbrain.vendas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apixbrain.vendas.domain.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	
	@Query("from Vendedor where nome like %:nome% and id = :id")
	List<Vendedor> consultarPorNome(String nome, @Param("id") Long id );
	
	Optional<Vendedor> findUnicoByNome(String nome);

}