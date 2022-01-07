package com.reysl.sweetPetveterinaria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.sweetPetveterinaria.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);
	
	//public Optional findByPassword(Long id, String password);
	
}
