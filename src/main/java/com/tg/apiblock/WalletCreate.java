package com.tg.apiblock;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tg.dtos.WalletDto;

public class WalletCreate {

	private Long id;
	private String status;

	@JsonProperty("data")
	private WalletDto walletUsuario;

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

	public WalletDto getWalletUsuario() {
		return walletUsuario;
	}

	public void setWalletUsuario(WalletDto walletUsuario) {
		this.walletUsuario = walletUsuario;
	}

	
}
