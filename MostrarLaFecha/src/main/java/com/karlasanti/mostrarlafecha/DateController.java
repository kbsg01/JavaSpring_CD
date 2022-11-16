package com.karlasanti.mostrarlafecha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DateController {
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String date() {
		return "date";
	}

}
