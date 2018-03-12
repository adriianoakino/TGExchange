package com.tg.servicesImp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.entities.Usuarios;
import com.tg.entities.Wallets;
import com.tg.services.SecurityServices;
import com.tg.services.UsuarioServices;
import com.tg.services.WalletService;

@Service
public class WalletServiceImp implements WalletService {

	@Autowired
	private WalletService walletService;
		
	@Autowired
	private SecurityServices securityService;
	
	@Autowired
	private UsuarioServices usuarioService;
	
	@Override
	public void save(Wallets walletUsuario) {
		
		Set<Usuarios> user = new HashSet<Usuarios>();	
		
		usuarioService.findByUsername(securityService.findLoggedInUsername());
		
		walletUsuario.setUsuarios(user);
		
		walletService.save(walletUsuario);
		
	}

}
