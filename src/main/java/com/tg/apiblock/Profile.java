package com.tg.apiblock;

import java.util.Date;

public class Profile {

	private String 	username;
	private String 	trade_count;
	private String 	name;
	private int 	feedback_score;
	private Date 	last_online;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTrade_count() {
		return trade_count;
	}
	
	public void setTrade_count(String trade_count) {
		this.trade_count = trade_count;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getFeedback_score() {
		return feedback_score;
	}

	public void setFeedback_score(int feedback_score) {
		this.feedback_score = feedback_score;
	}
	
	public Date getLast_online() {
		return last_online;
	}
	
	public void setLast_online(Date last_online) {
		this.last_online = last_online;
	}

	
}
