package br.com.facisa.competencia.ouvidoria.manifestacao.dto;



import java.time.LocalDateTime;

import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;

public class ManifestacaoDto {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao;
	private String autor;
	private String categoria;
	
	
	public ManifestacaoDto(Manifestacao manifestacao) {
		this.id = manifestacao.getId();
		this.titulo = manifestacao.getTitulo();
		this.descricao = manifestacao.getDescricao();
		this.dataCriacao = manifestacao.getDataCriacao();
		this.autor = manifestacao.getAluno().getNome();
		this.categoria = manifestacao.getTipo().getNome();
	}


	public Integer getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public String getAutor() {
		return autor;
	}


	public String getCategoria() {
		return categoria;
	}
	
		
	
	
		
	
}
