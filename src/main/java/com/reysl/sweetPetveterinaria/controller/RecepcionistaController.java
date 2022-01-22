package com.reysl.sweetPetveterinaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reysl.sweetPetveterinaria.entity.Mascota;
import com.reysl.sweetPetveterinaria.entity.Turno;
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
		model.addAttribute("mascotaForm", new Mascota());
		model.addAttribute("turnoForm", new Turno());
		model.addAttribute("listaProductos", productoService.getAllProductos());
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		
		return "recepcionista/vista-recepcionista";
	}	
	
	
	@PostMapping("/recepcionista/mascotaForm")
	public String crearMascota(@Valid @ModelAttribute("mascotaForm") Mascota mascota, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("mascotaForm", mascota);
			model.addAttribute("mascotaFormTab", "active");
		}else {
			try {
				mascotaService.crearMascota(mascota);
				model.addAttribute("mascotaForm", new Mascota());
				model.addAttribute("mascotaListTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("mascotaForm", mascota);
				model.addAttribute("mascotaFormTab", "active");
				model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
			}
		}
		
		model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
		
		return "redirect:/recepcionista";
		
	}
	
	@PostMapping("/recepcionista/turnoForm")
	public String crearTurno(@Valid @ModelAttribute("turnoForm") Turno turno, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("turnoForm", turno);
			model.addAttribute("turnoFormTab", "active");
		}else {
			try {
				turnoService.crearTurno(turno);
				model.addAttribute("turnoForm", new Turno());
				model.addAttribute("turnoListTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("turnoForm", turno);
				model.addAttribute("turnoFormTab", "active");
				model.addAttribute("listaTurnos", turnoService.getAllTurnos());
			}
		}
		
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		
		return "redirect:/recepcionista";
		
	}
	
}
