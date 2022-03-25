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
	
	/*@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}*/
	
	@GetMapping("/admin")
	public String getAdminAction(Model model) {
		model.addAttribute("loginForm", new Usuario());
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("productoForm", new Producto());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("listaProductos", productoService.getAllProductos());
		model.addAttribute("listUsuarioTab","active");
		
		return "admin/vista-admin";
	}	
	
	@PostMapping("/admin/usuarioForm")
	public String crearUsuario(@Valid @ModelAttribute("usuarioForm") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioForm", usuario);
			model.addAttribute("usuarioFormTab", "active");
		}else {
			try {
				usuarioService.crearUsuario(usuario);
				model.addAttribute("usuarioForm", new Usuario());
				model.addAttribute("listUsuarioTab", "active");
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
	public String crearProducto(@Valid @ModelAttribute("productoForm") Producto producto, BindingResult result, ModelMap model) {
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
		
	}
	
	@GetMapping("/admin/editUsuario/{id}")
	public String getEditUsuarioForm(Model model, @PathVariable(name="id")Long id) throws Exception {
		Usuario usuarioEditable = usuarioService.getUsuarioById(id);
		
		model.addAttribute("productoForm", new Producto());// 223333
		model.addAttribute("usuarioForm", usuarioEditable);
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("formUsuarioTab", "active"); // activa en la vista el form  -- th:classappend=" ${formUserTab}" --
		model.addAttribute("editUserMode", "true");
		
		return "admin/vista-admin";
	
	}
	
	@PostMapping("/admin/editUsuario")
	public String postEditUsuarioForm(@Valid @ModelAttribute("usuarioForm")Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioForm", usuario);
			model.addAttribute("formUserTab","active");
			model.addAttribute("editUserMode", "true");
		}else {
			try {
				usuarioService.updateUsuario(usuario);
				model.addAttribute("usuarioForm", new Usuario());//ssssssssss
				model.addAttribute("listUsuarioTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("usuarioForm", usuario);//ssss
				model.addAttribute("formUsuarioTab","active");
				model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
				model.addAttribute("roles",rolRepository.findAll());
				model.addAttribute("editUserMode", "true");
			}
		}
		
		model.addAttribute("listaUsuarios", usuarioService.getAllUsuarios());
		model.addAttribute("roles",rolRepository.findAll());
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/admin/deleteUsuario/{id}")
	public String deleteUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.deleteUsuario(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","El usuario no existe!!");
		}
		//return getAdminAction(model); // Para mantener el mensaje de error si llega a ocurrir
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/editProducto/{id}")
	public String getEditProductoForm(Model model, @PathVariable(name="id")Long id) throws Exception {
		Producto productoEditable = productoService.getProductoById(id);
		
		model.addAttribute("usuarioForm", new Usuario());// vvvvvvvvvvvvvvvvvv
		model.addAttribute("productoForm", productoEditable);
		model.addAttribute("listaProductos", productoService.getAllProductos());
		model.addAttribute("formProductoTab", "active");
		model.addAttribute("editProductMode", "true");
		
		return "admin/vista-admin";
		//return "redirect:/admin";
	
	}
	
	@PostMapping("/admin/editProducto")
	public String postEditProductoForm(@Valid @ModelAttribute("productoForm")Producto producto, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("productoForm", producto);
			model.addAttribute("formProductoTab","active");
			model.addAttribute("editProductMode", "true");
		}else {
			try {
				productoService.updateProducto(producto);
				model.addAttribute("productoForm", new Producto());
				model.addAttribute("listProductoTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("productoForm", producto);
				model.addAttribute("formProductoTab","active");
				model.addAttribute("listaProductos", productoService.getAllProductos());
				model.addAttribute("editProductMode", "true");
			}
		}
		
		model.addAttribute("listaProductos", productoService.getAllProductos());
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/admin/deleteProducto/{id}")
	public String deleteProducto(Model model, @PathVariable(name="id") Long id) {
		try {
			productoService.deleteProducto(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage","El producto no existe!!");
		}
		//return getAdminAction(model);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/usuarioForm/cancel")
	public String cancelEditUsuario(ModelMap model) {
		return "redirect:/admin";
	}
	
}
