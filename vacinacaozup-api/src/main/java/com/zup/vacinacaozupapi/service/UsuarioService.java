package com.zup.vacinacaozupapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.vacinacaozupapi.model.Usuario;
import com.zup.vacinacaozupapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario(Usuario usuario)  {

		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuario buscarporCpf(String cpf) {
		return usuarioRepository.findByCpf(cpf);
	}

}
