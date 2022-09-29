package br.com.facisa.competencia.ouvidoria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facisa.competencia.ouvidoria.controller.form.ManifestacaoForm;
import br.com.facisa.competencia.ouvidoria.manifestacao.dto.ManifestacaoDto;
import br.com.facisa.competencia.ouvidoria.modelo.Aluno;
import br.com.facisa.competencia.ouvidoria.modelo.Categoria;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.repository.AlunoRepository;
import br.com.facisa.competencia.ouvidoria.repository.CategoriaRepository;
import br.com.facisa.competencia.ouvidoria.repository.ManifestacaoRepository;

@Service
public class  CrudManifestacaoService {
	
	@Autowired
	private ManifestacaoRepository manifestacaoRepository;
	@Autowired
	private AlunoRepository alunooRepository;
	@Autowired CategoriaRepository categoriaRepository;

	
	public Iterable<Manifestacao> getManifestacoes() {
		return manifestacaoRepository.findAll();		
	}

	public ManifestacaoDto cadastrar(ManifestacaoForm manifestacaoForm) {
		
		Manifestacao manifestacao = converter(manifestacaoForm);		
		manifestacaoRepository.save(manifestacao);
		return new ManifestacaoDto(manifestacao);
	}

	private Manifestacao converter(ManifestacaoForm manifestacaoForm) {
		
		Optional<Aluno> optionalAluno = alunooRepository.findById(1);
		Aluno aluno = optionalAluno.get();
		
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(manifestacaoForm.getCategoriaId());
		Categoria categoria = optionalCategoria.get();
		return new Manifestacao(manifestacaoForm, categoria, aluno);
	}

	public void deletarManifestacao(int id) {
		manifestacaoRepository.deleteById(id);
		
	}

	public Iterable<Manifestacao> getManifestacoesByNome(String titulo) {
		return manifestacaoRepository.findByTituloIgnoreCaseStartingWith(titulo);
	}
	
	public Optional<Manifestacao> getById(int id) {
		return manifestacaoRepository.findById(id);
	}
	
	public ManifestacaoDto updateManifestacao(Manifestacao manifestacao, ManifestacaoForm manifestacaoForm) {
		
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(manifestacaoForm.getCategoriaId());
		Categoria categoria = optionalCategoria.get();
		
		manifestacao.setTitulo(manifestacaoForm.getTitulo());
		manifestacao.setDescricao(manifestacaoForm.getDescricao());
		manifestacao.setTipo(categoria);
		
		manifestacaoRepository.save(manifestacao);
		
		return new ManifestacaoDto(manifestacao);
	}
	
}
