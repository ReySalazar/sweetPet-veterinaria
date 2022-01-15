package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reysl.sweetPetveterinaria.entity.Mascota;
import com.reysl.sweetPetveterinaria.entity.Producto;
import com.reysl.sweetPetveterinaria.entity.Usuario;
import com.reysl.sweetPetveterinaria.repository.RolRepository;
import com.reysl.sweetPetveterinaria.service.MascotaService;
import com.reysl.sweetPetveterinaria.service.ProductoService;
import com.reysl.sweetPetveterinaria.service.UsuarioService;

@Controller
public class AdminController {
	
	@Autowired
	RolRepository rolRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	MascotaService mascotaService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin")
	public String getAdminAction(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("productoForm", new Producto());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("listaProductos", productoService.getAllProductos());
		model.addAttribute("listUsuarioTab","active");
		
		return "admin/vista-admin";
	}	
	
	@PostMapping("/admin/usuarioForm")
	public String crearUsuario(@Validated @ModelAttribute("usuarioForm") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioForm", usuario);
			model.addAttribute("usuarioFormTab", "active");
		}else {
			try {
				usuarioService.crearUsuario(usuario);
				model.addAttribute("usuarioForm", new Usuario());
				model.addAttribute("usuarioListTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("usuarioForm", usuario);
				model.addAttribute("formUsuarioTab", "active");
				model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
				model.addAttribute("roles", rolRepository.findAll());
			}
		}
		
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("roles", rolRepository.findAll());
		
		return "redirect:/admin";
		//return "admin/vista-admin";
		
	}
	
	@PostMapping("/admin/productoForm")
	public String crearProducto(@Validated @ModelAttribute("productoForm") Producto producto, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("productoForm", producto);
			model.addAttribute("productoFormTab", "active");
		}else {
			try {
				productoService.crearProducto(producto);
				model.addAttribute("productoForm", new Producto());
				model.addAttribute("listProductoTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("productoForm", producto);
				model.addAttribute("formProductoTab", "active");
				model.addAttribute("listaProductos", productoService.getAllProductos());
			}
		}
		
		model.addAttribute("listaProductos", productoService.getAllProductos());
		
		return "redirect:/admin";
		//return "admin/vista-admin";
		
	}
	
	@PostMapping("/admin/mascotaForm")
	public String crearMascota(@Validated @ModelAttribute("mascotaForm") Mascota mascota, BindingResult result, ModelMap model) {
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
		
		return "redirect:/admin";
		
	}
	
}
