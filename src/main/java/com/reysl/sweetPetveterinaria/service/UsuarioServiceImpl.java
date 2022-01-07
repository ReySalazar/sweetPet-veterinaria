package com.reysl.sweetPetveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reysl.sweetPetveterinaria.entity.Usuario;
import com.reysl.sweetPetveterinaria.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Iterable<Usuario> getAllUsuarios() {
		
		return usuarioRepository.findAll();
		
	}

}
