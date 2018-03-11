package com.tg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tg.dtos.UsuarioDto;
import com.tg.services.UsuarioServices;

@RestController
public class LoginController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	/**
	 * esse método fará o login do usuário no sistema onde fará uma pesquisa na base de dados
	 * verificará se o usuário é compatível com o que esta sendo pego no model e se for positivo
	 * o sistema loga se não da erro.
	 * @param model
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("login") UsuarioDto user, BindingResult bindingResult) {
		
		UsuarioDto users = usuarioServices.findByUsername(user.getUsername());
		
		if(user.getUsername().equals(users.getUsername()) && user.getPassword().equals(user.getPassword())) {
			return "redirect:/painel_homeuser";
		}else {
			return "login";
		}	
    }
}
