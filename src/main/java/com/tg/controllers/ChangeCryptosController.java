package com.tg.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.tg.apiblock.SellersApi;
import com.tg.endpoints.Endpoints;
import com.tg.entities.OrderChanger;
import com.tg.model.Trocas;
import com.tg.utils.AssinaturaHMAC;
import com.tg.utils.HMACSignature;
import com.tg.utils.ParameterCollection;

@Controller
public class ChangeCryptosController implements Endpoints {
	
	@RequestMapping(value = "/trocar", method = RequestMethod.GET)
	public String ChangeCrypto(Model model) {
		//model.addAttribute("enviarPagamento", new Trocas());
		model.addAttribute("listaPagamento", ListaPag());
		System.out.println();
		return "painel_troca";
	}

	private List<Trocas> ListaPag() {
		
		List<Trocas> pagamentos = new ArrayList<Trocas>();
		
		pagamentos.add(new Trocas("Perfect Money"			,"pm"		,"USD"));
		pagamentos.add(new Trocas("Perfect Money Voucher"	,"pmvoucher","USD"));
		pagamentos.add(new Trocas("Payeer"					,"payeer"	,"USD"));
		pagamentos.add(new Trocas("AdvCash"					,"advcash"	,"USD"));
		pagamentos.add(new Trocas("Bitcoin"					,"bitcoin"	,"BTC"));
		pagamentos.add(new Trocas("Dogecoin"				,"dogecoin"	,"DOGE"));
		pagamentos.add(new Trocas("Litecoin"				,"litecoin"	,"LTC"));
		pagamentos.add(new Trocas("Ethereum"				,"ethereum"	,"ETH"));
		pagamentos.add(new Trocas("Dash"					,"dash"		,"DASH"));
		pagamentos.add(new Trocas("Monero"					,"monero"	,"XMR"));
		
		return pagamentos;
	}
	
	@RequestMapping(value="troca", method = RequestMethod.POST)
	public void Troca(HttpServletResponse response) {
		
		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
		parameterCollection.add(new BasicNameValuePair("contacts", "alohadownloads"));
		
		String signature = new HMACSignature("/api/v2/rates/pm_USD/bitcoin_BTC", parameterCollection).toString();
		
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
        response.addHeader("Apiauth-Key", 	API_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String sell = restTemplate.getForObject(BASE_CHANGER+"/api/v2/rates/pm_USD/bitcoin_BTC",String.class);
        
        System.out.println(sell);
	}
	
	@RequestMapping(value="trocar", method = RequestMethod.POST)
	public void Trocar(HttpServletResponse response, @RequestParam String email,  @RequestParam String send,
			@RequestParam String recive, @RequestParam Double amount, @RequestParam String receiver_id) throws UnsupportedEncodingException {
		
 		ParameterCollection parameterCollection = new ParameterCollection(new ArrayList<>());
 		
 		Map<String, String> parameter = new HashMap<>();
		parameter.put("param0", email);
		parameter.put("param1", send);
		parameter.put("param2", recive);
		parameter.put("param3", amount.toString());
		parameter.put("param4", receiver_id);
		
		List<OrderChanger> order = new ArrayList<OrderChanger>();
        order.add(new OrderChanger(email, send, recive, amount, receiver_id));
        
		String signature = new HMACSignature("/api/v2/exchange", parameter).toString();
		
		response.addHeader("Content-Type", 	"application/x-www-form-urlencoded");
		response.addHeader("charset", "utf-8");
        response.addHeader("Apiauth-Key", 	API_KEY);
        response.addHeader("Apiauth-Nonce", NONCE);
        response.addHeader("Apiauth-Signature", signature);
        
        
        
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<OrderChanger> sell = restTemplate.postForEntity(BASE_CHANGER+"/api/v2/exchange", parameter, OrderChanger.class, 200);
        
        
        System.out.println(sell);
	}

}
