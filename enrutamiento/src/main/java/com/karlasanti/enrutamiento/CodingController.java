package com.karlasanti.enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/coding")
	public String greet() {
		return "¡Hola Coding Dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String py() {
		return "¡Python/Django fue increíble!";
	}
	
	@RequestMapping("/coding/java")
	public String java() {
		return "¡Java/Spring es mejor!";
	}

}
