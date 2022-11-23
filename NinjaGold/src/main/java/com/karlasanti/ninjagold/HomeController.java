package com.karlasanti.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@SuppressWarnings("rawtypes")
	ArrayList<ArrayList> updates = new ArrayList<ArrayList>();
	int gold = 0;
	int amnt;
	String date  = new SimpleDateFormat("MMMMMM, d, yyyy, HH:mm a").format(new Date());
	
	@GetMapping("/")
	public String home(HttpSession session) {
		session.setAttribute("gold", gold);
		return "home";
	}
	a
	@GetMapping("/reset")
	public String reset(@RequestParam(value="reset")String reset, HttpSession session) {
		switch (reset) {
		case "delete": 
			session.removeAttribute("gold");
			session.removeAttribute("updates");
		}	
		return "redirect:/";
	}
	

	@PostMapping("/process")
	public  String process(@RequestParam(value="building") 
					String building, 
					HttpSession session) {
			
		switch (building) {
		case "farm": 
			int amnt = ThreadLocalRandom.current().nextInt(10, 21);
			gold += amnt;
			String color = "green";
			String msg = "You earned "+amnt+" from the fram! ";
			ArrayList<String> data = new ArrayList<String>();
			data.add(color);
			data.add(msg);
			data.add(date);
			updates.add(data);
			break;
		case "cave":
			amnt = ThreadLocalRandom.current().nextInt(5, 11);
			gold += amnt;
			color = "green";
			msg = "You earned "+amnt+" from the cave! ";
			data = new ArrayList<String>();
			data.add(color);
			data.add(msg);
			data.add(date);
			updates.add(data);
			break;
		case "house":
			amnt = ThreadLocalRandom.current().nextInt(2, 6);
			gold += amnt;
			color = "green";
			msg = "You earned "+amnt+" from the house! ";
			data = new ArrayList<String>();
			data.add(color);
			data.add(msg);
			data.add(date);
			updates.add(data);
			break;
		case "casino":
			amnt = ThreadLocalRandom.current().nextInt(-50, 51);
			gold += amnt;
			if (amnt < 0) {
				color = "red";
				msg= "You lost "+amnt+" at the casino ";
			}
			else if (amnt == 0) {
				color = "black";
				msg="you get nothing ";
			}
			else {
				color = "green";
				msg= "You won "+amnt+" at the casino! ";
			}
			data = new ArrayList<String>();
			data.add(color);
			data.add(msg);
			data.add(date);
			updates.add(data);
			break;
		case "spa":
			amnt = ThreadLocalRandom.current().nextInt(-10, -5);
			gold+=amnt;
			color = "red";
			msg = "You lost "+amnt+" at the Spa! ";
			data = new ArrayList<String>();
			data.add(color);
			data.add(msg);
			data.add(date);
			updates.add(data);
			break;
		}
		session.setAttribute("updates", updates);
		session.setAttribute("size", updates.size() - 1);
		return "redirect:/";
	}
}
