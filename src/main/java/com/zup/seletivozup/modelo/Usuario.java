package com.zup.seletivozup.modelo;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import com.zup.seletivozup.validacao.ValorUnico;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "email"), 
		@UniqueConstraint(columnNames = "cpf") })
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nomeUsuario;
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
	@Column(columnDefinition = "DATE")
	private LocalDate dataNascimento;

	public Usuario(@NotEmpty String nomeUsuario, @Email @NotEmpty String email,
			@NotEmpty @Length(min = 11, max = 11) String cpf, @Past @NotNull LocalDate dataNascimento) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	@Deprecated
	public Usuario() {
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
