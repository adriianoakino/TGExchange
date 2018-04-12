package com.tg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_CHANGER")
public class OrderChanger  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5439731967944809261L;
	
	private Long id;
	private String email;
	private String send;
	private String recive;
	private Double amount;
	private String receiver_id;
	
	public OrderChanger(String email, String send, String recive, Double amount, String receiver_id) {
		super();
		this.email = email;
		this.send = send;
		this.recive = recive;
		this.amount = amount;
		this.receiver_id = receiver_id;
	}

	public OrderChanger() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "ORDER_EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "ORDER_SEND")
	public String getSend() {
		return send;
	}
	
	public void setSend(String send) {
		this.send = send;
	}
	
	@Column(name = "ORDER_RECIVE")
	public String getRecive() {
		return recive;
	}
	
	public void setRecive(String recive) {
		this.recive = recive;
	}
	
	@Column(name = "ORDER_AMOUNT")
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Column(name = "ORDER_RECEIVER_ID")
	public String getReceiver_id() {
		return receiver_id;
	}
	
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	
	

}
