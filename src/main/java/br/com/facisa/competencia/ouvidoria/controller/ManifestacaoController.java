package br.com.facisa.competencia.ouvidoria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.ManifestacaoDto;
import br.com.facisa.competencia.ouvidoria.modelo.Categoria;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.service.CrudCategoriaService;
import br.com.facisa.competencia.ouvidoria.service.CrudManifestacaoService;

@Controller
@RequestMapping("manifestacao")
public class ManifestacaoController {
	
	@Autowired
	private  CrudManifestacaoService crudOuvidoriaService;
	
	@Autowired
	private CrudCategoriaService crudCategoriaService;

	
	@GetMapping("formulario")
	public String formularioCadastro(ManifestacaoDto manifestacaoDto, Model model) {
		
		Iterable<Categoria> categorias = crudCategoriaService.getCategorias();
		model.addAttribute("categorias", categorias);
		return "manifestacao/formularioCadastro";
	}
	
	@PostMapping("nova")
	public String salvarProduto(@Valid ManifestacaoDto manifestacaoDto, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			Iterable<Categoria> categorias = crudCategoriaService.getCategorias();
			model.addAttribute("categorias", categorias);
			return "manifestacao/formularioCadastro";
		}
				
		Manifestacao manifestacao = manifestacaoDto.toManifestacao();
		Categoria categoria = crudCategoriaService.getCategoriaById(manifestacaoDto.getCategoriaId());
		
		manifestacao.setTipo(categoria);
		
		crudOuvidoriaService.cadastrar(manifestacao);
		return "manifestacao/sucessoCriacao";
	}
	
	@PostMapping("/delete/{id}")
	public String deletarManifestacao(@PathVariable("id") int id) {
		crudOuvidoriaService.deletarManifestacao(id);
		return "redirect:/home";
	}
	
	
	@GetMapping("/edit/formulario/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Manifestacao manifestacao = crudOuvidoriaService.getManifestacoesById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Manifestcao id invalida:" + id));
	    
	    Iterable<Categoria> categorias = crudCategoriaService.getCategorias();
		model.addAttribute("categorias", categorias);
	    model.addAttribute("manifestacao", manifestacao);
	    return "manifestacao/editar";
	}
	
	@PostMapping("/update/{id}")
	public String updateManifestacao(@PathVariable("id") long id, @Valid Manifestacao manifestacao, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	Iterable<Categoria> categorias = crudCategoriaService.getCategorias();
			model.addAttribute("categorias", categorias);
	        return "manifestacao/editar";
	    }
	        
	    crudOuvidoriaService.updateManifestacao(manifestacao);
	    return "redirect:/home";
	}
	
}
