package com.reysl.sweetPetveterinaria.service;

import com.reysl.sweetPetveterinaria.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> getAllUsuarios();
	
	public Usuario crearUsuario(Usuario usuario) throws Exception;
	
}
