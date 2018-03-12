package com.tg.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tg.entities.Usuarios;
import com.tg.services.UsuarioServices;

/**
 * @author aasantos9
 * Essa classe é uma validação de login para caso haja username nulo ou vazio, 
 * se não está duplicando username e password não nulo ou vazio
 */

@Component
public class ValidatorUser implements Validator {

	@Autowired
	private UsuarioServices usuarioService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Usuarios.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Usuarios users = (Usuarios) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (users.getUsername().equals(null) || users.getUsername() == null|| users.getUsername().length() < 5 || users.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.registro.username");
		}
		if (usuarioService.findByUsername(users.getUsername()) != null || ! usuarioService.findByUsername(users.getUsername()).equals(null)) {
			errors.rejectValue("username", "Duplicate.registro.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (users.getPassword().length() < 3 || users.getPassword().length() > 16) {
			errors.rejectValue("password", "Size.registro.password");
		}

	}
	
}
