package br.com.facisa.competencia.ouvidoria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.facisa.competencia.ouvidoria.modelo.Aluno;

@Repository
public interface AlunoRepository extends  PagingAndSortingRepository <Aluno, Integer> {

}
