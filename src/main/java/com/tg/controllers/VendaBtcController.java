package com.tg.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ssi.ResponseIncludeWrapper;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sun.istack.internal.Nullable;
import com.tg.apiblock.AdList;
import com.tg.apiblock.SellersApi;
import com.tg.endpoints.Endpoints;
import com.tg.model.VenderSend;
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
        
        String teste = restTemplate.getForObject(BASE_LoBTC+BRAZILPAYPAL, String.class);
        
        System.out.println(teste);
         model.addAttribute("sellersReady", sell.getData().getAdList());
         
		return "painel_vender";
    }
	
	@RequestMapping(value = "/vender", method = RequestMethod.POST)
	public void VenderBtc(HttpServletResponse response, String msg, int amount) throws UnsupportedEncodingException {
		
		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
		parameterCollection.add(new BasicNameValuePair("amount", "100"));
		parameterCollection.add(new BasicNameValuePair("msg", "100"));
		
		String signature = new AssinaturaHMAC(CONTACTCREATE, parameterCollection).toString();
		
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
        response.addHeader("Apiauth-Key", 	AUTH_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
        UrlEncodedFormEntity form = new UrlEncodedFormEntity(parameterCollection.getParameters(), "UTF-8");
       
        
        VenderSend vender = new VenderSend();
        vender.setAmount(amount);
        vender.setMsg(msg);
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        ResponseEntity<String> retun = restTemplate.postForEntity(BASE_LoBTC + CONTACTCREATE + "535394", vender, String.class ,200);

        System.out.println(retun);

	}
}
