package br.com.facisa.competencia.ouvidoria.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.facisa.competencia.ouvidoria.controller.form.ManifestacaoForm;

@Entity
@Table(name = "manifestacoes")
public class Manifestacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
	private Categoria tipo;
	@ManyToOne
	private Aluno aluno;
	
	public Manifestacao() {
		
	}
	
	public Manifestacao(ManifestacaoForm manifestacaoForm, Categoria categoria, Aluno aluno) {
		this.titulo = manifestacaoForm.getTitulo();
		this.descricao = manifestacaoForm.getDescricao();
		this.tipo = categoria;
		this.aluno = aluno;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Categoria getTipo() {
		return tipo;
	}
	public void setTipo(Categoria tipo) {
		this.tipo = tipo;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public int getCategoriaId() {
		return this.tipo.getId();
	}
	
	
}
