package br.com.facisa.competencia.ouvidoria.manifestacao.dto;

import br.com.facisa.competencia.ouvidoria.modelo.Aluno;

public class UsuarioDto {
	
	private String matricula;
	private String nome;
	
	public UsuarioDto() {}
	
	public UsuarioDto(Aluno usuario) {
		this.matricula = usuario.getMatricula();
		this.nome = usuario.getUsername();
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
