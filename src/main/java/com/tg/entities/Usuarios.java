package com.tg.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {
	
	private Long 	id;
	private String 	name;
	private String 	email;
	private String	username;
	private String 	password;
	private Date	joinDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "NOME_USUARIO", nullable = false, length = 100)
	@NotNull(message = "Por favor insira um Nome")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "EMAIL_USUARIO", unique = true, nullable = false)
	@NotNull(message = "Por favor insira um E-mail válido")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	@NotNull(message = "Por favor insira um Username válido")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false)
	@NotNull(message = "Por favor insira um Password.")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "DATA_CRIACAO_USUARIO", nullable = true)
	public Date getJoinDate() {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		if(joinDate == null) {
			joinDate = calendar.getTime();
			return joinDate;
		} else {
			return joinDate;
		}
	}
	
	public void setJoinDate(Date joinDate) {
			this.joinDate = joinDate;		
	}
	
	

}
