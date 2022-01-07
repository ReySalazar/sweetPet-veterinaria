package com.reysl.sweetPetveterinaria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.sweetPetveterinaria.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
	public Optional<Producto> findByDescripcion(String descripcion);
	
}
