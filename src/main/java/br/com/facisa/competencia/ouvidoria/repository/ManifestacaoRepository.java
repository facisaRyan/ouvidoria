package br.com.facisa.competencia.ouvidoria.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;

@Repository
public interface ManifestacaoRepository extends  PagingAndSortingRepository <Manifestacao, Integer> {

	Iterable<Manifestacao> findByTituloIgnoreCaseStartingWith(String titulo);

	Iterable<Manifestacao> findByAluno_Email(String email);

	Iterable<Manifestacao> findByTituloStartingWithAndAluno_EmailIgnoreCaseStartingWith(String titulo, String email);

}
