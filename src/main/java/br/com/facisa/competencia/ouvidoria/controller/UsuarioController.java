package br.com.facisa.competencia.ouvidoria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.CadastroDto;
import br.com.facisa.competencia.ouvidoria.modelo.Aluno;
import br.com.facisa.competencia.ouvidoria.service.CadastroService;

@Controller
@RequestMapping("autenticacao")
public class UsuarioController {
	
	@Autowired
	CadastroService cadastroService;
	
	@GetMapping("/login")	
	public String formLogin() {
		return ("login");
	}
	
	@GetMapping("/cadastro")
	public String showRegistrationForm(WebRequest request, Model model) {
	    CadastroDto userDto = new CadastroDto();
	    model.addAttribute("user", userDto);
	    return "autenticacao/cadastro";
	}
	
	@PostMapping("/usuario/cadastro")
	public String registerUserAccount(
	  @ModelAttribute("user") @Valid CadastroDto cadastroDto,
	  BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
					
			return "autenticacao/cadastro";
		}
	    
	    try {
	        Aluno aluno = cadastroService.registerNewUserAccount(cadastroDto);
	        cadastroService.setRoles(aluno.getEmail());
	    } catch (Exception uaeEx) {
	    	ModelAndView mav = new ModelAndView();
	    	mav.addObject("message", "An account for that username/email already exists.");
	    	return "redirect:/autenticacao/cadastro";
	    }

	    return "redirect:/autenticacao/login";
	}
	
}
