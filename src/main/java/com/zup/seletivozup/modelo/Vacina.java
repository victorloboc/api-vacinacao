package com.zup.seletivozup.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Vacina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nomeVacina;
	@OneToOne
	@JoinColumn(unique = true)
	private Usuario usuario;
	@PastOrPresent
	@NotNull
	@Column(columnDefinition = "DATE")
	private LocalDate dataVacina;

	public Vacina(@NotEmpty String nomeVacina, Usuario usuario, @PastOrPresent @NotNull LocalDate dataVacina) {
		super();
		this.nomeVacina = nomeVacina;
		this.usuario = usuario;
		this.dataVacina = dataVacina;
	}

	@Deprecated
	public Vacina() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getDataVacina() {
		return dataVacina;
	}

}
