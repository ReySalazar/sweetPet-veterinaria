package com.reysl.sweetPetveterinaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reysl.sweetPetveterinaria.entity.Usuario;
import com.reysl.sweetPetveterinaria.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	/*@Autowired
	UsuarioRepository repository;

	@Override
	public Iterable<Usuario> getAllUsers() {
		
		return repository.findAll();
		
	}
	
	private boolean checkUsernameAvailable(Usuario usuario) throws Exception {
		
		Optional<Usuario> usuarioEncontrado = repository.findByUsername(usuario.getUsuario());
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
			usuario = repository.save(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe!!"));
	}

	@Override
	public Usuario updateUsuario(Usuario deUsuario) throws Exception {
		Usuario aUsuario = getUsuarioById(deUsuario.getId());
		mapUser(deUsuario, aUsuario);
		return repository.save(aUsuario);
	}
	
	protected void mapUser(Usuario from, Usuario to) {
		to.setUsuario(from.getUsuario());
		to.setNombre(from.getNombre());
		to.setApellido(from.getApellido());
		to.setEmail(from.getEmail());
		to.setRoleSet(from.getRol());
	}

	@Override
	public void borrarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}*/

}
