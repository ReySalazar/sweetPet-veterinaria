package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		model.addAttribute("listProductoTab", "active");
		
		return "veterinario/vista-veterinario";
	}	
	
	@GetMapping("/veterinario/ventaProducto/{id}")
	public String ventaProducto(Model model, @PathVariable(name="id") Long id) {
		try {
			productoService.venderProducto(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","el producto no existe o no hay stock!!");
		}
		
		return "redirect:/veterinario";
	}
	
	@GetMapping("/veterinario/deleteTurno/{id}")
	public String deleteTurno(Model model, @PathVariable(name="id") Long id) {
		try {
			turnoService.deleteTurno(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","El turno no existe!!");
		}
		return getAdminAction(model);
	}
	
}
