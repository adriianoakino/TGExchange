package com.tg.services;

import com.tg.entities.Usuarios;

public interface UsuarioServices {

	void save(Usuarios user);
	
	Usuarios findByUsername(String username);

}
