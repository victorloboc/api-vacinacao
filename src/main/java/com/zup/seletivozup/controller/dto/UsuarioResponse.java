package com.zup.seletivozup.controller.dto;

import java.time.LocalDate;
import com.zup.seletivozup.modelo.Usuario;

public class UsuarioResponse {

	private Long id;
	private String nomeUsuario;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;

	public UsuarioResponse(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
	}

	@Deprecated
	public UsuarioResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
}
