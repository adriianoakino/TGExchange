package com.tg.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARTEIRA_USUARIOS")
public class Wallets {

	private Long 	id;
	private String 	network;
	private String 	user_id;
	private String 	address;	
	private String 	label;
	private Set<Usuarios> usuarios;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CARTEIRA")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "network")
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	
	@Column(name = "user_id")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USR_CARTEIRA_USUARIOS",
			joinColumns = { @JoinColumn(name = "ID_CARTEIRA")},
			inverseJoinColumns = { @JoinColumn (name = "ID_USUARIO") })
	public Set<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}	
