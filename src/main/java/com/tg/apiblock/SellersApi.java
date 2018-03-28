package com.tg.apiblock;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SellersApi {
	
	@JsonProperty("profile")
	@JsonDeserialize
	private List<SellersProfileApi> sellersProfileApi;

	public List<SellersProfileApi> getSellersProfileApi() {
		return sellersProfileApi;
	}

	public void setSellersProfileApi(List<SellersProfileApi> sellersProfileApi) {
		this.sellersProfileApi = sellersProfileApi;
	}



	
}
