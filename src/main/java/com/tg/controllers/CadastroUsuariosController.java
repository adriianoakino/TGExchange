package com.tg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tg.dtos.UsuarioDto;
import com.tg.services.SecurityServices;
import com.tg.services.UsuarioServices;
import com.tg.utils.ValidatorUser;

@RestController
public class CadastroUsuariosController {

	@Autowired
    private UsuarioServices usuarioService;
	
    @Autowired
    private ValidatorUser usuarioValidador;
    
    @Autowired
    private SecurityServices securityService;
    
    /**
     * este método vai registrar um usuário no banco de dados;
     * @param user
     * @param result
     * @param model
     * @return  
     */
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String registration(@ModelAttribute("cadastroUsuario") UsuarioDto user, BindingResult result, Model model) {

		usuarioValidador.validate(user, result);
        if (result.hasErrors()) { return "registro"; }
        usuarioService.save(user);
        securityService.autologin(user.getUsername(), user.getPassword());
       
        return "redirect:/login";
    }
	
}
