package br.com.facisa.competencia.ouvidoria.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Papel {
	
	@EmbeddedId
	private PapelId papelId;
	
	public Papel() {}
	

	public Papel(PapelId papelId) {
		this.papelId = papelId;
	}

	public PapelId getPapelId() {
		return papelId;
	}

	public void setPapelId(PapelId papelId) {
		this.papelId = papelId;
	}
	
	
	
}
