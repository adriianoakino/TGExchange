package com.tg.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.tg.apiblock.SellersApi;
import com.tg.endpoints.Endpoints;
import com.tg.utils.AssinaturaHMAC;
import com.tg.utils.ParameterCollection;

@Controller
public class VendaBtcController implements Endpoints {

	@RequestMapping(value = "/vender", method = RequestMethod.GET)
	@ResponseBody
	public String homeVender(HttpServletResponse response, Model model) {
		
		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
		parameterCollection.add(new BasicNameValuePair("contacts", "alohadownloads"));
		
		String signature = new AssinaturaHMAC(SELLERS, parameterCollection).toString();
		
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
        response.addHeader("Apiauth-Key", 	AUTH_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
        RestTemplate restTemplate = new RestTemplate();
        //SellersApi sellerApi;
        
        //sellerApi = restTemplate.getForObject(BASE_LoBTC+SELLERSPAYPAL,SellersApi.class, 200);
        ResponseEntity<String> res = restTemplate.getForEntity(BASE_LoBTC+SELLERSPAYPAL, String.class);
        //System.out.println(sellerApi.getSellersProfileApi());
        System.out.println(res.getBody());
        //
        
        ResponseEntity<SellersApi> ress = restTemplate
                .getForEntity(BASE_LoBTC+SELLERSPAYPAL,SellersApi.class);

         System.out.println(ress.getBody());
         System.out.println(ress);
         System.out.println(ress.getBody().getSellersProfileApi());
         
         //model.addAttribute("sellersReady", ressd);
         
		return "painel_vender";
    }
	
	public HttpResponse getSellers() {
		
		return null;
	}
	
}
