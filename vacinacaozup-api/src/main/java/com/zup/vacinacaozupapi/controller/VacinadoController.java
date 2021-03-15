package com.zup.vacinacaozupapi.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.vacinacaozupapi.model.Usuario;
import com.zup.vacinacaozupapi.model.Vacinado;
import com.zup.vacinacaozupapi.service.UsuarioService;
import com.zup.vacinacaozupapi.service.VacinadoService;

@RestController
@RequestMapping("vacinacaozup/vacinados")
public class VacinadoController {
	
	@Autowired
	private VacinadoService vacinadoService;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@PostMapping("")
	public ResponseEntity<Vacinado> cadastrar(@RequestBody Vacinado vacinado, Usuario usuario)  {
		
		Usuario usuarioMapeado = usuarioService.buscarPorEmail(vacinado.getEmail());
		
		vacinado.setUsuario(usuarioMapeado);
		vacinado.setEmail(vacinado.getEmail());
		
		//valida se o preenchimento está correto e se o usuario existe
			if(vacinado.getVacina() == null || vacinado.getUsuario() == null || 
				(vacinado.getEmail() == null && !usuario.equals(usuarioMapeado))) {
			
			return ResponseEntity.badRequest().build();
		}		
		
		vacinado.setData(OffsetDateTime.now());
		
		return new ResponseEntity<>(this.vacinadoService.cadastrarVacinado(vacinado), HttpStatus.CREATED);
	}
	

}


