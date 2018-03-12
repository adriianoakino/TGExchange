package com.tg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * método para abrir página inicial 
	 * @return
	 */
	@RequestMapping("/") 
	public String index() {
		return "index";
	}
	

	
}
