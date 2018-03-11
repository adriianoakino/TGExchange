package com.tg.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tg.dtos.UsuarioDto;
import com.tg.repository.UsuarioRepository;
import com.tg.services.UsuarioServices;


@Service
public class UsuarioServicesImp implements UsuarioServices{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(UsuarioDto user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
	}
	
	@Override
	public UsuarioDto findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}




}
