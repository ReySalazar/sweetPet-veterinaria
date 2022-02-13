package com.reysl.sweetPetveterinaria.service;

import com.reysl.sweetPetveterinaria.entity.Mascota;

public interface MascotaService {
	
	public Iterable<Mascota> getAllMascotas();

	public Mascota crearMascota(Mascota mascota) throws Exception;
	
	public Mascota getMascotaById(Long id) throws Exception;

	public Mascota updateMascota(Mascota mascota) throws Exception;

	public void deleteMascota(Long id) throws Exception;
	
}
