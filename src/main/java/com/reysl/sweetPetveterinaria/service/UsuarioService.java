package com.reysl.sweetPetveterinaria.service;

import com.reysl.sweetPetveterinaria.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> getAllUsuarios();
	
	public Usuario crearUsuario(Usuario usuario) throws Exception;
	
	public Usuario getUsuarioById(Long id) throws Exception;
	
	public Usuario updateUsuario(Usuario usuario) throws Exception;
	
	public void deleteUsuario(Long id) throws Exception;
	
}
