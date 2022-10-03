package br.com.facisa.competencia.ouvidoria.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.ManifestacaoDto;
import br.com.facisa.competencia.ouvidoria.modelo.Aluno;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.repository.AlunoRepository;
import br.com.facisa.competencia.ouvidoria.service.CrudManifestacaoService;

@Controller
@RequestMapping("manifestacao")
public class ManifestacaoController {
	
	@Autowired
	private  CrudManifestacaoService crudOuvidoriaService;
	@Autowired
	private AlunoRepository alunoRepository;
	
	

	
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
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Aluno user = alunoRepository.findByUsername(userName);
		manifestacao.setAluno(user);
				
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
	    
	    ManifestacaoDto manifestacaoDto = new ManifestacaoDto(manifestacao);
	    model.addAttribute("manifestacaoDto",  manifestacaoDto);
	    return "manifestacao/editar";
	}
	
	@PostMapping("/update")
	public String updateManifestacao (@Valid ManifestacaoDto manifestacaoDto, BindingResult bindingResult, Model model) {
		
	    if (bindingResult.hasErrors()) {
	    	
	        return "manifestacao/editar";
	    }
	    
	    Optional<Manifestacao> optional = crudOuvidoriaService.getManifestacoesById(manifestacaoDto.getId()); 
	    Manifestacao manifestacao = optional.get();
	    manifestacao.setTitulo(manifestacaoDto.getTituloManifestacao());
	    manifestacao.setDescricao(manifestacaoDto.getDescricaoManifestacao());
	    manifestacao.setTipo(manifestacaoDto.getCategoria());
	    crudOuvidoriaService.updateManifestacao(manifestacao);
	    return "redirect:/home";
	}
	
}
