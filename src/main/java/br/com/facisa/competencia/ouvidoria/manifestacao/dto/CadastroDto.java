package br.com.facisa.competencia.ouvidoria.manifestacao.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.facisa.competencia.ouvidoria.validator.ConfirmarSenha;
import br.com.facisa.competencia.ouvidoria.validator.ValidarEmail;

@ConfirmarSenha
public class CadastroDto {
	
	@NotNull
    @NotEmpty
    private String username;
    
    @NotNull
    @NotEmpty
    private String matricula;
    
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
    
    
    @NotNull
    @NotEmpty
    @ValidarEmail
    private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
    
}
