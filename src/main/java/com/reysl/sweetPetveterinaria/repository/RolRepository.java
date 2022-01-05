package com.reysl.sweetPetveterinaria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.sweetPetveterinaria.entity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long>{
	
}
