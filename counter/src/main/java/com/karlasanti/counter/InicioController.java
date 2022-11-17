package com.karlasanti.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	int counter = 0;
	@RequestMapping("/")
	public String home(HttpSession sesion) {
		counter++;
		return "home";
	}
	
	@RequestMapping("/home")
	public String home2(HttpSession sesion2) {
		counter += 2;
		return "home2";
	}

	@RequestMapping("/counter")
	public String counter(Model model) {
		model.addAttribute("counter", counter);
		return "counter";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession sesion) {
		sesion.invalidate();
		counter = 0;
		return "redirect:/";
	}


}
