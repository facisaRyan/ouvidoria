package br.com.facisa.competencia.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.UsuarioDto;
import br.com.facisa.competencia.ouvidoria.modelo.Aluno;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.repository.AlunoRepository;
import br.com.facisa.competencia.ouvidoria.service.CrudManifestacaoService;

@Controller
@RequestMapping("home")
public class IndexController {
	
	@Autowired
	private  CrudManifestacaoService crudOuvidoriaService;
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	
	
	@GetMapping
	public String index(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Iterable<Manifestacao> manifestacoes = crudOuvidoriaService.listarByUsuario(userName);
		
		
		model.addAttribute("manifestacoes", manifestacoes);
		Aluno usuario = alunoRepository.findByUsername(userName);
		UsuarioDto usuarioDto = new UsuarioDto(usuario);
		model.addAttribute("usuario", usuarioDto);
		
		return "index";
	}
	
	@GetMapping("/buscar")
	public String buscarManifestacaoByNome(@RequestParam("tituloManifestacao") String titulo, Model model) {
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Aluno usuario = alunoRepository.findByUsername(userName);
		UsuarioDto usuarioDto = new UsuarioDto(usuario);
		Iterable<Manifestacao> manifestacoes = crudOuvidoriaService.getManifestacoesByNomeAndAluno(titulo, usuario.getEmail());
		model.addAttribute("manifestacoes", manifestacoes);
		
		model.addAttribute("usuario", usuarioDto);
		return "index";
	}
	
	
	
}
