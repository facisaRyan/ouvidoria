package br.com.facisa.competencia.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.CadastroDto;
import br.com.facisa.competencia.ouvidoria.modelo.Aluno;
import br.com.facisa.competencia.ouvidoria.modelo.Papel;
import br.com.facisa.competencia.ouvidoria.modelo.PapelId;
import br.com.facisa.competencia.ouvidoria.repository.AlunoRepository;
import br.com.facisa.competencia.ouvidoria.repository.PapelRepository;

@Service
@Transactional
public class CadastroService implements IUserService {
	
	@Autowired
    private AlunoRepository alunoRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	
    
    @Override
    public Aluno registerNewUserAccount(CadastroDto cadastroDto) throws Exception  {
        if (emailExists(cadastroDto.getEmail())) {
            throw new Exception("Já existe uma conta com este email: "
              + cadastroDto.getEmail());
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCripto = encoder.encode(cadastroDto.getPassword());
        Aluno user = new Aluno();
        user.setUsername(cadastroDto.getUsername());
        user.setPassword("{bcrypt}" + senhaCripto);
        user.setMatricula(cadastroDto.getMatricula());
        user.setEmail(cadastroDto.getEmail());
        user.setEnabled(true);
       
        return alunoRepository.save(user);
    }
    private boolean emailExists(String email) {
        return alunoRepository.findByEmail(email) != null;
    }
	public void setRoles(String email) {
		Aluno aluno = alunoRepository.findByEmail(email);
		Papel papel = new Papel(new PapelId("ALUNO", aluno));
		
		papelRepository.save(papel);
	}
}
