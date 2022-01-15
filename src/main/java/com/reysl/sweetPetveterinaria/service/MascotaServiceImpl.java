package com.reysl.sweetPetveterinaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reysl.sweetPetveterinaria.entity.Mascota;
import com.reysl.sweetPetveterinaria.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{
	
	@Autowired
	MascotaRepository mascotaRepository;

	@Override
	public Iterable<Mascota> getAllMascotas() {
		
		return mascotaRepository.findAll();
	}
	
	private boolean checkNombreAvailable(Mascota mascota) throws Exception {
		
		Optional<Mascota> mascotaEncontrada = mascotaRepository.findByNombre(mascota.getNombre());
		if (mascotaEncontrada.isPresent()) {
			throw new Exception("El nombre ingresado ya existe");
		}
		return true;
		
	}

	@Override
	public Mascota crearMascota(Mascota mascota) throws Exception {
		if (checkNombreAvailable(mascota)) {
			mascota = mascotaRepository.save(mascota);
		}
		
		return mascota;
		
	}
	
}
