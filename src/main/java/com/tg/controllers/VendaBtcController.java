package com.tg.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.tg.apiblock.AdList;
import com.tg.apiblock.SellersApi;
import com.tg.endpoints.Endpoints;
import com.tg.utils.AssinaturaHMAC;
import com.tg.utils.ParameterCollection;

@Controller
public class VendaBtcController implements Endpoints {

	@RequestMapping(value = "/vender", method = RequestMethod.GET)
	public String homeVender(HttpServletResponse response, Model model) {
		
		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
		parameterCollection.add(new BasicNameValuePair("contacts", "alohadownloads"));
		
		String signature = new AssinaturaHMAC(SELLERS, parameterCollection).toString();
		
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
        response.addHeader("Apiauth-Key", 	AUTH_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        SellersApi sell = restTemplate.getForObject(BASE_LoBTC+SELLERSPAYPAL,SellersApi.class);
        
         model.addAttribute("sellersReady", sell.getData().getAdList());
         
		return "painel_vender";
    }
	
	
	public void VenderBtc(HttpServletResponse response, String msg, int ammount) {
		
		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
		parameterCollection.add(new BasicNameValuePair("contacts", "alohadownloads"));
		
		String signature = new AssinaturaHMAC(SELLERS, parameterCollection).toString();
		
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
        response.addHeader("Apiauth-Key", 	AUTH_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
        RestTemplate restTemplate = new RestTemplate();
        String retun = restTemplate.postForObject(BASE_LoBTC + CONTACTCREATE, ammount ,String.class, 200);
        
        System.out.println(retun);

	}
}
