package com.zup.seletivozup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.seletivozup.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByCpf(String cpf);
}
