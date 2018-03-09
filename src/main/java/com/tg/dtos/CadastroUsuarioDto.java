package com.tg.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class CadastroUsuarioDto {

	private Long 	id;
	private String 	name;
	private String 	email;
	private String	username;
	private String 	password;
	private Date	joinDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 100, message = "Nome deve conter entre 3 e 100 caracteres.")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message = "Email não pode ser vazio.")
	@Length(min = 15, max = 100, message = "Nome deve conter entre 15 e 100 caracteres.")
	@Email(message = "Email inválido.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull(message = "Username não pode ser vazio.")
	@Length(min = 3, max = 20, message = "Nome deve conter entre 3 e 20 caracteres.")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotNull(message = "Email não pode ser vazio.")
	@Length(min = 3, max = 15, message = "Nome deve conter entre 3 e 15 caracteres.")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
