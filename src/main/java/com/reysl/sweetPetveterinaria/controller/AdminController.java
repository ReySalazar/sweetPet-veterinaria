package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reysl.sweetPetveterinaria.entity.Producto;
import com.reysl.sweetPetveterinaria.entity.Usuario;
import com.reysl.sweetPetveterinaria.repository.RolRepository;
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
		model.addAttribute("listaTabla","active");
		
		return "admin/vista-admin";
	}	
	
}
