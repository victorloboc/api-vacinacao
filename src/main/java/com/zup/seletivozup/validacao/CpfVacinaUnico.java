package com.zup.seletivozup.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CpfVacinaUnicoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfVacinaUnico {
	String message() default "CPF já existente no banco de dados de aplicação de vacinas";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String campo();
	Class<?> entidade();
}
