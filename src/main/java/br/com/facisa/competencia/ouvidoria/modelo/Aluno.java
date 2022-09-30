package br.com.facisa.competencia.ouvidoria.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Aluno {
	
	
	@Id
	private String username;
	private String password;
	private String email;
	private Boolean enabled;
	private String matricula;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", fetch = FetchType.LAZY )	
	private List<Manifestacao> manifestacoes;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Manifestacao> getManifestacoes() {
		return manifestacoes;
	}

	public void setManifestacoes(List<Manifestacao> manifestacoes) {
		this.manifestacoes = manifestacoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
