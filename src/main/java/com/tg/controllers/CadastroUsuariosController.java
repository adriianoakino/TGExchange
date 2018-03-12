package com.tg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tg.entities.Usuarios;
import com.tg.services.SecurityServices;
import com.tg.services.UsuarioServices;
import com.tg.utils.ValidatorUser;

@Controller
public class CadastroUsuariosController {
	
	@Autowired
    private UsuarioServices usuarioService;
	
    @Autowired
    private ValidatorUser usuarioValidador;
    
    @Autowired
    private SecurityServices securityService;
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String registration(Model model) {
        
		model.addAttribute("cadastrar", new Usuarios());
        return "cadastrar";
    }
    
    /**
     * este método vai registrar um usuário no banco de dados;
     * @param user
     * @param result
     * @param model
     * @return  
     */
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String registration(@ModelAttribute("cadastrar") Usuarios user, BindingResult result, Model model) {
		System.out.println(result);
		usuarioValidador.validate(user, result);
        if (result.hasErrors()) { return "redirect:/login"; }
        usuarioService.save(user);
        securityService.autologin(user.getUsername(), user.getPassword());
       
        return "redirect:/login";
    }
	
}
