package br.com.facisa.competencia.ouvidoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facisa.competencia.ouvidoria.modelo.Papel;
import br.com.facisa.competencia.ouvidoria.modelo.PapelId;

@Repository
public interface PapelRepository extends JpaRepository<Papel, PapelId> {

}
