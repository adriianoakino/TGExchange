package com.tg.dtos;

import java.util.Set;

public class WalletDto {

	private Long id;
	private String network;
	private String user_id;
	private String address;
	private String label;
	private Set<UsuarioDto> usuarios;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNetwork() {
		return network;
	}
	
	public void setNetwork(String network) {
		this.network = network;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public Set<UsuarioDto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioDto> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}

