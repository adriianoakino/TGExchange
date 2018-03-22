package com.tg.services;

import java.util.List;

import com.tg.entities.Usuarios;
import com.tg.entities.Wallets;

public interface WalletService {

	void save(Wallets walletUsuario);
		
	List<Wallets> findByUsuarios(Usuarios user);
}
