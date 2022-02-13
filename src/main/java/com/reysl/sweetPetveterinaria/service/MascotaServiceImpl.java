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

	@Override
	public Mascota getMascotaById(Long id) throws Exception {
		return mascotaRepository.findById(id).orElseThrow(() -> new Exception("La mascota a editar no existe"));
	}

	@Override
	public Mascota updateMascota(Mascota fromMascota) throws Exception{
		Mascota toMascota = getMascotaById(fromMascota.getId());
		mapMascota(fromMascota, toMascota);
		return mascotaRepository.save(toMascota);
	}
	
	protected void mapMascota(Mascota from, Mascota to) {
		to.setNombre(from.getNombre());
		to.setTipo(from.getTipo());
		to.setDuenio(from.getDuenio());
		to.setContacto(from.getContacto());
	}
	
	@Override
	public void deleteMascota(Long id) throws Exception {
		Mascota mascota = getMascotaById(id);
		mascotaRepository.delete(mascota);		
	}
	
}
