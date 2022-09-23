package br.com.facisa.competencia.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.service.CrudManifestacaoService;

@Controller
@RequestMapping("home")
public class IndexController {
	
	@Autowired
	private  CrudManifestacaoService crudOuvidoriaService;
	
	
	
	
	@GetMapping
	public String index(Model model) {
		
		Iterable<Manifestacao> manifestacoes = crudOuvidoriaService.listar();
		model.addAttribute("manifestacoes", manifestacoes);
		return "index";
	}
	
	@GetMapping("/buscar")
	public String buscarManifestacaoByNome(@RequestParam("tituloManifestacao") String titulo, Model model) {
		System.out.println(titulo);
		Iterable<Manifestacao> manifestacoes = crudOuvidoriaService.getManifestacoesByNome(titulo);
		
		model.addAttribute("manifestacoes", manifestacoes);
		return "index";
	}
	
	
	
}
