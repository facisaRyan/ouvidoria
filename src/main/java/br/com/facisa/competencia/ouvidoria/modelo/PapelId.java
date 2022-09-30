package br.com.facisa.competencia.ouvidoria.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable	
public class PapelId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String authority;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="username")
	private Aluno username;
	
	public PapelId() { }
    
	public PapelId(String authority, Aluno username) {
		this.authority = authority;
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Aluno getUsername() {
		return username;
	}

	public void setUsername(Aluno username) {
		this.username = username;
	}
	
	
}
