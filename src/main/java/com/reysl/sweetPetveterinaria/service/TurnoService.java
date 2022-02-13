package com.reysl.sweetPetveterinaria.service;

import com.reysl.sweetPetveterinaria.entity.Turno;

public interface TurnoService {
	
	public Iterable<Turno> getAllTurnos();

	public Turno crearTurno(Turno turno) throws Exception;
	
	public Turno getTurnoById(Long id) throws Exception;
	
	public Turno updateTurno(Turno turno) throws Exception;
	
	public void deleteTurno(Long id) throws Exception;

	public void deleteAllTurnos(String veterinario);
	
}
