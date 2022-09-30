package br.com.facisa.competencia.ouvidoria.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manifestacoes")
public class Manifestacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate dataCriacao = LocalDate.now();
	@Enumerated(EnumType.STRING)
	private Categoria tipo;
	@ManyToOne(fetch = FetchType.LAZY)
	private Aluno aluno;
	
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
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
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
	
	
	
	
}
