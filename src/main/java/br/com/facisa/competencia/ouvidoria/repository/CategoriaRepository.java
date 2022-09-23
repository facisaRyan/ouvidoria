package br.com.facisa.competencia.ouvidoria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.facisa.competencia.ouvidoria.modelo.Categoria;

@Repository
public interface CategoriaRepository extends  PagingAndSortingRepository <Categoria, Integer> {
	
	
}
