/*package com.reysl.sweetPetveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reysl.sweetPetveterinaria.entity.Usuario;
import com.reysl.sweetPetveterinaria.repository.RolRepository;
import com.reysl.sweetPetveterinaria.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolRepository rolRepository;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/usuarioForm")
	public String getUserForm(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("listTab", "active");
		
		return "admin/vista-admin";
	}
	
	@PostMapping("/usuarioForm")
	public String crearUsuario(@Validated @ModelAttribute("userForm") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", usuario);
			model.addAttribute("formTab", "active");
		}else {
			try {
				usuarioService.crearUsuario(usuario);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("usuarioForm", usuario);
				model.addAttribute("formTab", "active");
				model.addAttribute("usuarioList", usuarioService.getAllUsers());
				model.addAttribute("roles", rolRepository.findAll());
			}
		}
		
		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles", rolRepository.findAll());
		
		return "admin/vista-admin";
		
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String getEditUserForm(Model model, @PathVariable(name="id")Long id) throws Exception {
		Usuario usuarioEditable = usuarioService.getUsuarioById(id);
		
		model.addAttribute("usuarioForm", usuarioEditable);
		model.addAttribute("usuarioList", usuarioService.getAllUsers());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");
		
		return "admin/vista-admin";		
	}
	
	@PostMapping("/editarUsuario")
	public String postEditUserForm(@Validated @ModelAttribute("usuarioForm")Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", usuario);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode", "true");
		}else {
			try {
				usuarioService.updateUsuario(usuario);
				model.addAttribute("usuarioForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("usuarioForm", usuario);
				model.addAttribute("formTab","active");
				model.addAttribute("usuarioList", usuarioService.getAllUsers());
				model.addAttribute("roles",rolRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}
		
		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles",rolRepository.findAll());
		return "admin/vista-admin";
		
	}
	
	@GetMapping("/borrarUsuario/{id}")
	public String borrarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.borrarUsuario(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","El usuario no existe!!");
		}
		return getUserForm(model);
	}
	
	@GetMapping("/usuarioForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/usuarioForm";
	}
	
}

*/

