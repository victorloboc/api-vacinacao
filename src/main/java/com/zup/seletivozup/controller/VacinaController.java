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

import com.zup.seletivozup.controller.dto.VacinaRequest;
import com.zup.seletivozup.controller.dto.VacinaResponse;
import com.zup.seletivozup.modelo.Vacina;
import com.zup.seletivozup.repository.UsuarioRepository;
import com.zup.seletivozup.repository.VacinaRepository;

@RestController
@RequestMapping("/vacina")
public class VacinaController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<VacinaResponse> cadastrarVacina(@RequestBody @Valid VacinaRequest vacinaRequest,
			UriComponentsBuilder uriBuilder) {
		//persistência
		Vacina novaVacina = vacinaRequest.toVacina(usuarioRepository);
		vacinaRepository.save(novaVacina);
		
		//resposta
		URI uri = uriBuilder.path("/vacina/{id}").buildAndExpand(novaVacina.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new VacinaResponse(novaVacina));
	}
}
