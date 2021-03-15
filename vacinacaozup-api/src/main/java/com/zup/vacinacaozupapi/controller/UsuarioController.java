package com.zup.vacinacaozupapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zup.vacinacaozupapi.model.Usuario;
import com.zup.vacinacaozupapi.service.UsuarioService;


@RestController
@RequestMapping("vacinacaozup/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		
		Usuario usuarioExistenteCpf = usuarioService.buscarporCpf(usuario.getCpf());
		Usuario usuarioExistenteEmail = usuarioService.buscarPorEmail(usuario.getEmail());
		
		//valida se o preenchimento está correto
		if(usuario.getCpf() == null || usuario.getNome() == null || 
				usuario.getEmail() == null || (usuarioExistenteEmail != null 
				&& !usuarioExistenteEmail.equals(usuario))
				|| (usuarioExistenteCpf !=null && usuarioExistenteCpf.equals(usuarioService.buscarporCpf(usuario.getCpf())))) {
		
			
			return ResponseEntity.badRequest().build();			
			
		}

		return new ResponseEntity<>(this.usuarioService.cadastrarUsuario(usuario), HttpStatus.CREATED);
		
	}	
	
}
