package br.com.facisa.competencia.ouvidoria.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ManifestacaoForm {
	
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
	private String descricao;
	private Integer categoriaId;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
	
}
