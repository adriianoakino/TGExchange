package com.tg.apiblock;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tg.entities.Wallets;

public class WalletCreate {

	private Long id;
	private String status;

	@JsonProperty("data")
	private Wallets walletUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Wallets getWalletUsuario() {
		return walletUsuario;
	}

	public void setWalletUsuario(Wallets walletUsuario) {
		this.walletUsuario = walletUsuario;
	}

	
}
