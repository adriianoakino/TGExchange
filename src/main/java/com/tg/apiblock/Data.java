package com.tg.apiblock;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

	@JsonProperty("ad_list")
	private List<AdList> adList;

	public List<AdList> getAdList() {
		return adList;
	}

	public void setAdList(List<AdList> adList) {
		this.adList = adList;
	}

	
}
