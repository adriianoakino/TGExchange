package com.tg.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	/**
	 * método para abrir página inicial 
	 * @return
	 */
	@RequestMapping("/") 
	public String index() {
		return "index";
	}
	
	/**
	 * método para abrir página de login pegando os dados do usuário
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() { 
		return "login";
    }
	
}
