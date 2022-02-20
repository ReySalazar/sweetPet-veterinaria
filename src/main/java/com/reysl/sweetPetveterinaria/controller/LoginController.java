package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reysl.sweetPetveterinaria.entity.Usuario;
import com.reysl.sweetPetveterinaria.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("loginForm", new Usuario());
		return "index";
	}
	
	@PostMapping("/login")
	public String retornaVista(@ModelAttribute("loginForm") Usuario usuario) throws Exception {
		String vista = null;
		vista = usuarioService.encontrarUsuario(usuario);
		
		return vista;
	}
}
