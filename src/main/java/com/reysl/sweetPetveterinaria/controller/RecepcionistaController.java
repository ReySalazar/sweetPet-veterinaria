package com.reysl.sweetPetveterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecepcionistaController {
	
	@GetMapping("/recepcionista")
	public String getRecepcionistaActions() {
		return "recepcionista/vista-recepcionista";
	}	
	
}
