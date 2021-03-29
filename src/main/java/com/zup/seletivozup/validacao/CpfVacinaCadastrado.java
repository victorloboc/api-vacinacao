package com.zup.seletivozup.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CpfVacinaCadastradoValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfVacinaCadastrado {
	String message() default "Usuário não cadastrado";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String campo();

}
