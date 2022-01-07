package com.reysl.sweetPetveterinaria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.sweetPetveterinaria.entity.Turno;

@Repository
public interface TurnoRepository extends CrudRepository<Turno, Long>{
	
	public Optional<Turno> findByMascota(String mascota);
	
}
