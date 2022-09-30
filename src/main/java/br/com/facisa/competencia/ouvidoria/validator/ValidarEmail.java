package br.com.facisa.competencia.ouvidoria.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorEmail.class)
@Documented
public @interface ValidarEmail {
	String message() default "Email invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
