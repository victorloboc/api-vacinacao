package com.zup.seletivozup.controller.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.seletivozup.modelo.Usuario;
import com.zup.seletivozup.validacao.ValorUnico;

public class UsuarioRequest {
	@NotEmpty
	private String nome;
	@ValorUnico(entidade = Usuario.class, campo = "email")
	@Email
	@NotEmpty
	private String email;
	@ValorUnico(entidade = Usuario.class, campo = "cpf")
	@NotEmpty
	@Length(min = 11, max = 11)
	private String cpf;
	@Past
	@NotNull 
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Usuario toUsuario() {

		return new Usuario(this.nome, this.email, this.cpf, this.nascimento);
	}

}
