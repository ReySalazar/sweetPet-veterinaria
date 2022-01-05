package com.reysl.sweetPetveterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VeterinarioController {
	
	@GetMapping("/veterinario")
	public String getAdminAction() {
		return "veterinario/vista-veterinario";
	}	
	
}
