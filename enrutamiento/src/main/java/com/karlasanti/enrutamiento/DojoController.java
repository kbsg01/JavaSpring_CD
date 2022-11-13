package com.karlasanti.enrutamiento;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("{bootcamp}")
	public String dojos(@PathVariable("bootcamp")String bootcamp) {
		if (bootcamp.equals("dojo")) {
			return "¡El Dojo es increíble!";
		}
		if (bootcamp.equals("burbank-dojo")) {
			return "El Dojo Burbank está localizado al sur de California";
		}
		if (bootcamp.equals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		}
		
		return "";
	}

}
