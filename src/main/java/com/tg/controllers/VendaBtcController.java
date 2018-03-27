package com.tg.controllers;

import java.util.ArrayList;
import com.tg.utils.*;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tg.endpoints.Endpoints;

@Controller
public class VendaBtcController implements Endpoints {

	@RequestMapping(value = "/vender", method = RequestMethod.GET)
	public String homeVender(HttpServletResponse response) {
		
		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
		parameterCollection.add(new BasicNameValuePair("contacts", "alohadownloads"));
		
		String signature = new AssinaturaHMAC("", parameterCollection).toString();
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
        response.addHeader("Apiauth-Key", 	AUTH_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
		return "painel_vender";
    }
	
	public HttpResponse getSellers() {
		
		return null;
	}
	
}
