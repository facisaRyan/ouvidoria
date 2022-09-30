package br.com.facisa.competencia.ouvidoria.service;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.CadastroDto;
import br.com.facisa.competencia.ouvidoria.modelo.Aluno;

public interface IUserService {
	Aluno registerNewUserAccount(CadastroDto cadastroDto) throws Exception;
}
