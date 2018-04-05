package com.tg.apiblock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdList {

	@JsonProperty("data")
	private DataLista dataLista;

	public DataLista getDataLista() {
		return dataLista;
	}

	public void setDataLista(DataLista dataLista) {
		this.dataLista = dataLista;
	}
	
	
}
