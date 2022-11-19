package com.karlasanti.encuestadojo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultsController {

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "location") String location, 
			@RequestParam(value = "language")String language,
			@RequestParam(value = "comment") String comment,
			HttpSession sesion) {
			sesion.setAttribute("name", name);
			sesion.setAttribute("location", location);
			sesion.setAttribute("language", language);
			sesion.setAttribute("comment", comment);
			if (language.equals("Java")) {
				return "javaresult";
			}else {
				return "result";
			}
	}

}
