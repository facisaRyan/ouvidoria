package br.com.facisa.competencia.ouvidoria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facisa.competencia.ouvidoria.modelo.Aluno;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.repository.AlunoRepository;
import br.com.facisa.competencia.ouvidoria.repository.ManifestacaoRepository;

@Service
public class  CrudManifestacaoService {
	
	@Autowired
	private ManifestacaoRepository manifestacaoRepository;
	@Autowired
	private AlunoRepository alunooRepository;
	

	
	public Iterable<Manifestacao> listar() {
		return manifestacaoRepository.findAll();		
	}

	public void cadastrar(Manifestacao manifestacao) {
		Aluno aluno = alunooRepository.findByUsername("joca");
				
		manifestacao.setAluno(aluno);
				
		manifestacaoRepository.save(manifestacao);
	}

	public void deletarManifestacao(int id) {
		manifestacaoRepository.deleteById(id);
		
	}

	public Iterable<Manifestacao> getManifestacoesByNome(String titulo) {
		return manifestacaoRepository.findByTituloIgnoreCaseStartingWith(titulo);
	}
	
	public Optional<Manifestacao> getManifestacoesById(int id) {
		return manifestacaoRepository.findById(id);
	}
	
	public void updateManifestacao(Manifestacao manifestacao) {
		manifestacaoRepository.save(manifestacao);
	}
	
}
