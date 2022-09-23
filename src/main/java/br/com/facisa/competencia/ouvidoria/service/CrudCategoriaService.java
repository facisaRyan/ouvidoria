package br.com.facisa.competencia.ouvidoria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.facisa.competencia.ouvidoria.modelo.Categoria;
import br.com.facisa.competencia.ouvidoria.repository.CategoriaRepository;

@Service
public class CrudCategoriaService {
	
	@Autowired
	private  CategoriaRepository categoriaRepository;
	
	@Cacheable("categorias")
	public Iterable<Categoria> getCategorias() {
		Sort sortNome = Sort.by(Sort.Direction.ASC,"nome" );
		return categoriaRepository.findAll(sortNome);
	}

	public Categoria getCategoriaById(int categoriaId) {
		Optional<Categoria> findById = categoriaRepository.findById(categoriaId);
		return findById.get();
	}
}
