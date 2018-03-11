package com.tg.services;

import com.tg.dtos.UsuarioDto;

public interface UsuarioServices {
	
	
	void save(UsuarioDto user);
	
	UsuarioDto findByUsername(String username);

}
