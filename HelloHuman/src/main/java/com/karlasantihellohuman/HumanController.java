package com.karlasantihellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	
	@RequestMapping("")
	public String nombre(@RequestParam(value ="name", required = false) String name, @RequestParam(value ="lastname", required = false) String lastname) {
		if (name == null) {
			return "Hola Humano";
		}
			
			return "Hola "+name+ " "+lastname+" desde Spring!";
		
	}

}
