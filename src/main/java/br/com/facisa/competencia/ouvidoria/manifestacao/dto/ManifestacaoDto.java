package br.com.facisa.competencia.ouvidoria.manifestacao.dto;



import javax.validation.constraints.NotBlank;

import br.com.facisa.competencia.ouvidoria.modelo.Manifestacao;

public class ManifestacaoDto {
	
	@NotBlank
	private String tituloManifestacao;
	private int categoriaId;
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
	
	
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	public Manifestacao toManifestacao() {
		Manifestacao manifestacao = new Manifestacao();
		manifestacao.setTitulo(tituloManifestacao);
		manifestacao.setDescricao(descricaoManifestacao);
		return manifestacao;
	}
	
	
}
