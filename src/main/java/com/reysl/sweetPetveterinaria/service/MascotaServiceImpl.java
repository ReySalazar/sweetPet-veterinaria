package com.reysl.sweetPetveterinaria.service;

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
	
	
	
}
