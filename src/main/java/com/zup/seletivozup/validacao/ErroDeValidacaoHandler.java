package com.zup.seletivozup.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDto> argumentoInvalido(MethodArgumentNotValidException exception) {
		
		List<ErroDto> erroDto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		for(FieldError fe : fieldErrors) {
			String mensagem = messageSource.getMessage(fe, LocaleContextHolder.getLocale());
			ErroDto erro = new ErroDto(fe.getField(), mensagem);
			erroDto.add(erro);
		}
		return erroDto;
		
	}
	
//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ErroDto registroDuplicado(ConstraintViolationException exception) {
//		 
//		String campo = exception.getConstraintName();
//		ErroDto erroDto = new ErroDto(campo, "Dado já existente no banco de dados");
//		return erroDto;
//	}

//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(DateTimeParseException.class)
//	public ErroDto dataInvalida(DateTimeParseException exception) { 
//		String campo = exception.getParsedString();
//		ErroDto erroDto = new ErroDto(campo, "Formato da data inválido");
//		
//		return erroDto;
//	}
	
	

}
