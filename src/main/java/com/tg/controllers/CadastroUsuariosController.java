package com.tg.controllers;

import java.security.NoSuchAlgorithmException;

import javax.naming.Binding;

import com.tg.dtos.CadastroUsuarioDto;
import com.tg.entities.Usuarios;

public class CadastroUsuariosController {

	
	private Usuarios converterDtoParaUsuario(CadastroUsuarioDto cadastroUsuario, Binding result) throws NoSuchAlgorithmException {
		
		Usuarios usuario = new Usuarios();
		usuario.setName(cadastroUsuario.getName());
		usuario.setEmail(cadastroUsuario.getEmail());
		usuario.setUsername(cadastroUsuario.getUsername());
		usuario.setPassword(cadastroUsuario.getPassword());
		usuario.setJoinDate(cadastroUsuario.getJoinDate());
		return usuario;
	}
}
