package com.tg.servicesImp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.entities.Usuarios;
import com.tg.entities.Wallets;
import com.tg.repository.UsuarioRepository;
import com.tg.repository.WalletRepository;
import com.tg.services.SecurityServices;
import com.tg.services.WalletService;

@Service
public class WalletServiceImp implements WalletService {

	@Autowired
	private WalletRepository walletRepository;
		
	@Autowired
	private SecurityServices securityService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void save(Wallets walletUsuario) {
		
		Set<Usuarios> user = new HashSet<Usuarios>();	
	
		user.add(usuarioRepository.findByUsername(securityService.findLoggedInUsername()));
		
		walletUsuario.setUsuarios(user);
		walletRepository.save(walletUsuario);
		
	}

	@Override
	public List<Wallets> findByUsuarios(Usuarios user) {
		return walletRepository.findByUsuarios(user);		
	}

}
