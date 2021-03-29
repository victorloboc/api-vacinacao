package com.zup.seletivozup.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.seletivozup.controller.dto.UsuarioRequest;
import com.zup.seletivozup.controller.dto.UsuarioResponse;
import com.zup.seletivozup.modelo.Usuario;
import com.zup.seletivozup.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest,
			UriComponentsBuilder uriBuilder ) {
		//persistência
		Usuario novoUsuario = usuarioRequest.toUsuario();
		usuarioRepository.save(novoUsuario);
		
		//resposta da requisição
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(novoUsuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UsuarioResponse(novoUsuario));
	
	}
}
