package com.mycompany.tondeuse.controllers;

/*************************************************************************************************************
*
* @author khalil
* 
* 
**************************************************************************************************************/

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tondeuse")
public class TondeuseController extends HttpServlet {
	
	
	// index
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "tondeuse/index";
	}
	
	// test and return result
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model,@RequestParam("entree") String entree) {
		List<String> results=new  ArrayList<>();
		 entree = entree.replaceAll ("\r", "\n");
		Pelouse lawn = null;
		try {
			lawn = Pelouse.readConfig(entree);
			results=lawn.move();
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message", 'F');
		}
		model.addAttribute("result", results);
		return "tondeuse/index";
	}
}
