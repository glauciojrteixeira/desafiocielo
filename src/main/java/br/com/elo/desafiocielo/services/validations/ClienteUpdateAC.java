package br.com.elo.desafiocielo.services.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Constraint(validatedBy = ClienteUpdateACValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClienteUpdateAC {
	
	/*
	 * Anotações Customizadas para novos registros
	 */
	
	String message() default "Error de validação";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
