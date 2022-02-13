package com.reysl.sweetPetveterinaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("listProductoTab", "active");
		
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
				model.addAttribute("listUsuarios", usuarioService.getAllUsuarios());
				model.addAttribute("listaUsuarios", mascotaService.getAllMascotas());
			}
		}
		
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		
		return "redirect:/recepcionista";
		
	}
	
	@GetMapping("/recepcionista/editTurno/{id}")
	public String getEditTurnoForm(Model model, @PathVariable(name="id")Long id) throws Exception {
		Turno turnoEditable = turnoService.getTurnoById(id);
		
		model.addAttribute("mascotaForm", new Mascota());// vvvvvvvvvvvvvvvvvv
		model.addAttribute("turnoForm", turnoEditable);
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		model.addAttribute("formTurnoTab", "active");
		model.addAttribute("editTurnoMode", "true");
		
		return "recepcionista/vista-recepcionista";
	
	}
	
	@PostMapping("/recepcionista/editTurno")
	public String postEditTurnoForm(@Valid @ModelAttribute("turnoForm")Turno turno, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("turnoForm", turno);
			model.addAttribute("formTurnoTab","active");
			model.addAttribute("editTurnoMode", "true");
		}else {
			try {
				turnoService.updateTurno(turno);
				model.addAttribute("turnoForm", new Turno());
				model.addAttribute("listTurnoTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("turnoForm", turno);
				model.addAttribute("formTurnoTab","active");
				model.addAttribute("listaTurnos", turnoService.getAllTurnos());
				model.addAttribute("editTurnoMode", "true");
			}
		}
		
		model.addAttribute("listaTurnos", turnoService.getAllTurnos());
		
		return "redirect:/recepcionista";
		
	}
	
	@GetMapping("/recepcionista/deleteTurno/{id}")
	public String deleteTurno(Model model, @PathVariable(name="id") Long id) {
		try {
			turnoService.deleteTurno(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","El turno no existe!!");
		}
		return getRecepcionistaActions(model);
	}
	
	@GetMapping("/recepcionista/deleteAllTurno/{veterinario}")
	public String deleteAllTurno(Model model, @PathVariable(name="veterinario") String veterinario) {
		try {
			turnoService.deleteAllTurnos(veterinario);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","El veterinario no existe!!");
		}
		//return getRecepcionistaActions(model);
		return "redirect:/recepcionista";
	}
	
	@GetMapping("/recepcionista/turnoForm/cancel")
	public String cancelEditTurno(ModelMap model) {
		return "redirect:/recepcionista";
	}
	
	@GetMapping("/recepcionista/editMascota/{id}")
	public String getEditMascotaForm(Model model, @PathVariable(name="id")Long id) throws Exception {
		Mascota mascotaEditable = mascotaService.getMascotaById(id);
		
		model.addAttribute("turnoForm", new Turno());
		model.addAttribute("mascotaForm", mascotaEditable);
		model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
		model.addAttribute("mascotaFormTab", "active");
		model.addAttribute("editMascotaMode", "true");
		
		return "recepcionista/vista-recepcionista";
	
	}
	
	@PostMapping("/recepcionista/editMascota")
	public String postEditMascotaForm(@Valid @ModelAttribute("mascotaForm")Mascota mascota, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("mascotaForm", mascota);
			model.addAttribute("mascotaFormTab","active");
			model.addAttribute("editMascotaMode", "true");
		}else {
			try {
				mascotaService.updateMascota(mascota);
				model.addAttribute("mascotaForm", new Turno());
				model.addAttribute("listMascotaTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("mascotaForm", mascota);
				model.addAttribute("mascotaFormTab","active");
				model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
				model.addAttribute("editMascotaMode", "true");
			}
		}
		
		model.addAttribute("listaMascotas", mascotaService.getAllMascotas());
		
		return "redirect:/recepcionista";
		
	}
	
	@GetMapping("/recepcionista/deleteMascota/{id}")
	public String deleteMascota(Model model, @PathVariable(name="id") Long id) {
		try {
			mascotaService.deleteMascota(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","La mascota no existe!!");
		}
		//return getRecepcionistaActions(model);
		return "redirect:/recepcionista";
	}
	
	@GetMapping("/recepcionista/ventaProducto/{id}")
	public String ventaProducto(Model model, @PathVariable(name="id") Long id) {
		try {
			productoService.venderProducto(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","el producto no existe o no hay stock!!");
		}
		//return getRecepcionistaActions(model);
		return "redirect:/recepcionista";
	}
	
}
