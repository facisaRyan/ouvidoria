package br.com.facisa.competencia.ouvidoria.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.facisa.competencia.ouvidoria.controller.form.ManifestacaoForm;
import br.com.facisa.competencia.ouvidoria.manifestacao.dto.ManifestacaoDto;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;
import br.com.facisa.competencia.ouvidoria.service.CrudManifestacaoService;


@RestController
@RequestMapping("/manifestacoes")
public class ManifestacoesControllerRest {
	
	@Autowired
	private  CrudManifestacaoService crudOuvidoriaService;
	
	
	@GetMapping
	public ResponseEntity<List<ManifestacaoDto>> listar(){
		Iterable<Manifestacao> manifestacoes = crudOuvidoriaService.getManifestacoes();
		List<ManifestacaoDto> manifestacoesDto = new ArrayList<ManifestacaoDto>();
		manifestacoes.iterator().forEachRemaining(m -> {
			manifestacoesDto.add(new ManifestacaoDto(m));
		});
		return ResponseEntity.status(HttpStatus.OK).body(manifestacoesDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable int id){
		Optional<Manifestacao> optional = crudOuvidoriaService.getById(id);
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manifestação não encontrada");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(new ManifestacaoDto(optional.get()));
	}
	
	@GetMapping("/buscar/{titulo}")
	public ResponseEntity<List<ManifestacaoDto>> buscarPorTitulo(@PathVariable String titulo){
		Iterable<Manifestacao> manifestacoes = crudOuvidoriaService.getManifestacoesByNome(titulo);
		List<ManifestacaoDto> manifestacoesDto = new ArrayList<ManifestacaoDto>();
		manifestacoes.iterator().forEachRemaining(m -> {
			manifestacoesDto.add(new ManifestacaoDto(m));
		});
		return ResponseEntity.status(HttpStatus.OK).body(manifestacoesDto);
	}
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid  ManifestacaoForm manifestacaoForm) {
								
		ManifestacaoDto manifestacaoDto = crudOuvidoriaService.cadastrar(manifestacaoForm);
		return ResponseEntity.status(HttpStatus.CREATED).body(manifestacaoDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable int id){
		
		Optional<Manifestacao> optional = crudOuvidoriaService.getById(id);
				 
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manifestação não encontrada");
		}
		
		crudOuvidoriaService.deletarManifestacao(id);
					
		return ResponseEntity.status(HttpStatus.OK).body("Manifestação excluído com sucesso");
	}
	
	
}
