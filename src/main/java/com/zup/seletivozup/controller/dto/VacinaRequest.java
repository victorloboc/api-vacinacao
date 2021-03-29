package com.zup.seletivozup.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.seletivozup.modelo.Usuario;
import com.zup.seletivozup.modelo.Vacina;
import com.zup.seletivozup.repository.UsuarioRepository;
import com.zup.seletivozup.validacao.CpfVacinaCadastrado;
import com.zup.seletivozup.validacao.CpfVacinaUnico;

public class VacinaRequest {

	@NotEmpty
	private String nome;
	@PastOrPresent
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	@CpfVacinaUnico(entidade = Vacina.class, campo = "cpf")
	@CpfVacinaCadastrado(campo = "cpf")
	@NotEmpty
	@Length(min = 11, max = 11)
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Vacina toVacina(UsuarioRepository usuarioRepository) {
		Usuario usuarioVacinado = usuarioRepository.findByCpf(this.cpf);

		return new Vacina(this.nome, usuarioVacinado, this.data);
	}
}
