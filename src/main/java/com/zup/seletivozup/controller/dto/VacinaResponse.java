package com.zup.seletivozup.controller.dto;

import java.time.LocalDate;

import com.zup.seletivozup.modelo.Vacina;

public class VacinaResponse {

	private Long id;
	private String nomeVacina;
	private LocalDate dataVacina;
	private String nomeUsuario;
	private String cpfUsuario;
	private String emailUsuario;

	public VacinaResponse(Vacina vacina) {
		super();
		this.id = vacina.getId();
		this.nomeVacina = vacina.getNomeVacina();
		this.dataVacina = vacina.getDataVacina();
		this.nomeUsuario = vacina.getUsuario().getNomeUsuario();
		this.cpfUsuario = vacina.getUsuario().getCpf();
		this.emailUsuario = vacina.getUsuario().getEmail();
	}

	@Deprecated
	public VacinaResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public LocalDate getDataVacina() {
		return dataVacina;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

}
