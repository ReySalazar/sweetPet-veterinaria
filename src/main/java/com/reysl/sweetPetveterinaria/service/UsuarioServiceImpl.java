package com.reysl.sweetPetveterinaria.service;

import java.util.Optional;

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
	
	private boolean checkUsernameAvailable(Usuario usuario) throws Exception {
		
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsuario(usuario.getUsuario());
		if (usuarioEncontrado.isPresent()) {
			throw new Exception("El usuario ingresado no está disponible");
		}
		return true;
		
	}

	private boolean chekPasswordValid(Usuario usuario) throws Exception {
		
		if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			throw new Exception("La confirmacion de password no coincide");
		}
		return true;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		if (checkUsernameAvailable(usuario) && chekPasswordValid(usuario)) {
			usuario = usuarioRepository.save(usuario);
		}
		
		return usuario;
	}

}
