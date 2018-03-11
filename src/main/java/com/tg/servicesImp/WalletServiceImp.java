package com.tg.servicesImp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.dtos.UsuarioDto;
import com.tg.dtos.WalletDto;
import com.tg.repository.WalletRepository;
import com.tg.services.SecurityServices;
import com.tg.services.UsuarioServices;
import com.tg.services.WalletService;

@Service
public class WalletServiceImp implements WalletService {

	@Autowired
	private WalletRepository walletRepository;
		
	@Autowired
	private SecurityServices securityService;
	
	@Autowired
	private UsuarioServices usuarioService;
	
	@Override
	public void save(WalletDto walletUsuario) {
		
		Set<UsuarioDto> user = new HashSet<UsuarioDto>();	
		
		usuarioService.findByUsername(securityService.findLoggedInUsername());
		
		walletUsuario.setUsuarios(user);
		
		walletRepository.save(walletUsuario);
		
	}

}
