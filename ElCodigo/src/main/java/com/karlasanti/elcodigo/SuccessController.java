package com.karlasanti.elcodigo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SuccessController {

	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public String succes(@RequestParam(value="code") String code, RedirectAttributes errormsg) {
		if (code.equals("bushido")) {
				return "/code";
		}else {
			errormsg.addFlashAttribute("error", "¡Entrena Más Duro!");
			return "redirect:/";
		}
	}

}
