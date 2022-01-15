package com.reysl.sweetPetveterinaria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.sweetPetveterinaria.entity.Mascota;

@Repository
public interface MascotaRepository extends CrudRepository<Mascota, Long>{
	
	public Optional<Mascota> findByNombre(String nombre);
	
}
