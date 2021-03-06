package com.zup.vacinacaozupapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.vacinacaozupapi.model.Usuario;
import com.zup.vacinacaozupapi.model.Vacinado;
import com.zup.vacinacaozupapi.repository.UsuarioRepository;
import com.zup.vacinacaozupapi.repository.VacinadoRepository;

@Service
public class VacinadoService {

	@Autowired
	private VacinadoRepository vacinadoRepository;

	
	public Vacinado cadastrarVacinado(Vacinado vacinado) {
	
		return vacinadoRepository.save(vacinado);
	}
	
}
