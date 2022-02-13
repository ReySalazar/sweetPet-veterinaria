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

	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return usuarioRepository.findById(id).orElseThrow(() -> new Exception("El usuario a editar no existe"));
	}

	@Override
	public Usuario updateUsuario(Usuario fromUsuario) throws Exception {
		Usuario toUsuario = getUsuarioById(fromUsuario.getId());
		mapUsuario(fromUsuario, toUsuario);
		return usuarioRepository.save(toUsuario);
	}
	
	protected void mapUsuario(Usuario from, Usuario to) {
		to.setUsuario(from.getUsuario());
		to.setNombre(from.getNombre());
		to.setApellido(from.getApellido());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
		to.setEspecialidad(from.getEspecialidad());
	}
	
	public void deleteUsuario(Long id) throws Exception {
		//Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new Exception("El usuario no existe!!"));
		Usuario usuario = getUsuarioById(id);
		usuarioRepository.delete(usuario);
	}

}
