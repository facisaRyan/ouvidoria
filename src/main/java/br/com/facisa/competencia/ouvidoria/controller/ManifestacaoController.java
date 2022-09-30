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
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.service.CrudManifestacaoService;

@Controller
@RequestMapping("manifestacao")
public class ManifestacaoController {
	
	@Autowired
	private  CrudManifestacaoService crudOuvidoriaService;
	
	

	
	@GetMapping("formulario")
	public String formularioCadastro(ManifestacaoDto manifestacaoDto, Model model) {
		
		return "manifestacao/formularioCadastro";
	}
	
	@PostMapping("nova")
	public String salvarProduto(@Valid ManifestacaoDto manifestacaoDto, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
			return "manifestacao/formularioCadastro";
		}
				
		Manifestacao manifestacao = manifestacaoDto.toManifestacao();
				
		crudOuvidoriaService.cadastrar(manifestacao);
		return "redirect:/home";
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
	    
	   
	    model.addAttribute("manifestacao", manifestacao);
	    return "manifestacao/editar";
	}
	
	@PostMapping("/update/{id}")
	public String updateManifestacao(@PathVariable("id") long id, @Valid Manifestacao manifestacao, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	
	        return "manifestacao/editar";
	    }
	        
	    crudOuvidoriaService.updateManifestacao(manifestacao);
	    return "redirect:/home";
	}
	
}
