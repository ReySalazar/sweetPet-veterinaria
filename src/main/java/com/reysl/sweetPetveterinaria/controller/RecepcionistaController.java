package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reysl.sweetPetveterinaria.service.MascotaService;
import com.reysl.sweetPetveterinaria.service.ProductoService;
import com.reysl.sweetPetveterinaria.service.TurnoService;
import com.reysl.sweetPetveterinaria.service.UsuarioService;

@Controller
public class RecepcionistaController {
	
	@Autowired
	MascotaService mascotaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	TurnoService turnoService;
	
	@GetMapping("/recepcionista")
	public String getRecepcionistaActions(Model model) {
		model.addAttribute("listaProductos", productoService.getAllProductos());
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		
		return "recepcionista/vista-recepcionista";
	}	
	
}
