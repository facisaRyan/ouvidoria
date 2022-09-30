package br.com.facisa.competencia.ouvidoria.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.facisa.competencia.ouvidoria.manifestacao.dto.CadastroDto;

public class ValidarConfimacaoSenha implements ConstraintValidator<ConfirmarSenha, Object> {
	
	 @Override
	    public void initialize(ConfirmarSenha constraintAnnotation) {
	    }
	    @Override
	    public boolean isValid(Object obj, ConstraintValidatorContext context){
	        CadastroDto user = (CadastroDto) obj;
	        return user.getPassword().equals(user.getMatchingPassword());
	    }
}
