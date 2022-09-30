package br.com.facisa.competencia.ouvidoria.manifestacao.dto;



import javax.validation.constraints.NotBlank;

import br.com.facisa.competencia.ouvidoria.modelo.Categoria;
import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;

public class ManifestacaoDto {
	
	@NotBlank
	private String tituloManifestacao;
	private Categoria categoria;
	@NotBlank
	private String descricaoManifestacao;
	
	
	public String getTituloManifestacao() {
		return tituloManifestacao;
	}
	public void setTituloManifestacao(String tituloManifestacao) {
		this.tituloManifestacao = tituloManifestacao;
	}
	public String getDescricaoManifestacao() {
		return descricaoManifestacao;
	}
	public void setDescricaoManifestacao(String descricaoManifestacao) {
		this.descricaoManifestacao = descricaoManifestacao;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Manifestacao toManifestacao() {
		Manifestacao manifestacao = new Manifestacao();
		manifestacao.setTitulo(tituloManifestacao);
		manifestacao.setDescricao(descricaoManifestacao);
		manifestacao.setTipo(categoria);
		return manifestacao;
	}
	
	
}
