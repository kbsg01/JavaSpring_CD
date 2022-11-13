package com.karlasanti.miprimerproyecto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String primerMetodo() {
		return "Hola cliente!! Como te esta yendo?";
	}

	@RequestMapping("/random")
	public String ayuda() {
		return "Spring Boot es genial! es muy facil responder con Strings";
	}

	

}
