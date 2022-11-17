package com.karlasanti.mostrarlafecha;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DateController {
	
	String date = new SimpleDateFormat("EEEEE, d, MMMMMM, yyyy").format(new Date());
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String date(Model model) {
		model.addAttribute("date", date);
		return "date";
	}
 
}
