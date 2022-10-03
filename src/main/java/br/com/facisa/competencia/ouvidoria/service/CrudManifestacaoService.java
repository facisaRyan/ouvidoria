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
	private AlunoRepository alunoRepository;	
	
	public Iterable<Manifestacao> listar() {
		return manifestacaoRepository.findAll();		
	}

	public void cadastrar(Manifestacao manifestacao) {

				
		manifestacaoRepository.save(manifestacao);
	}

	public void deletarManifestacao(int id) {
		manifestacaoRepository.deleteById(id);
		
	}

	public Iterable<Manifestacao> getManifestacoesByNomeAndAluno(String titulo, String email) {
		return manifestacaoRepository.findByTituloStartingWithAndAluno_EmailIgnoreCaseStartingWith(titulo, email);
	}
	
	public Optional<Manifestacao> getManifestacoesById(int id) {
		return manifestacaoRepository.findById(id);
	}
	
	public void updateManifestacao(Manifestacao manifestacao) {
		manifestacaoRepository.save(manifestacao);
	}

	public Iterable<Manifestacao> listarByUsuario(String userName) {
		Aluno user = alunoRepository.findByUsername(userName);
		String email = user.getEmail();
		return manifestacaoRepository.findByAluno_Email(email);
	}
	
}
