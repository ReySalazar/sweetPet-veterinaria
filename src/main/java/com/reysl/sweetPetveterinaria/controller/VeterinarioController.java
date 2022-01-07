package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reysl.sweetPetveterinaria.service.ProductoService;
import com.reysl.sweetPetveterinaria.service.TurnoService;

@Controller
public class VeterinarioController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	TurnoService turnoService;
	
	@GetMapping("/veterinario")
	public String getAdminAction(Model model) {
		model.addAttribute("listaProductos", productoService.getAllProductos());
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		
		return "veterinario/vista-veterinario";
	}	
	
}
