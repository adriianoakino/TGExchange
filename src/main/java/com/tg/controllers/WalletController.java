package com.tg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.tg.apiblock.WalletCreate;
import com.tg.endpoints.Endpoints;
import com.tg.entities.Wallets;
import com.tg.services.WalletService;

@Controller
public class WalletController implements Endpoints{
	
	@Autowired
	private WalletService walletService;
	
	
	@RequestMapping("/carteira")
	public String wallet(Model model) {
		model.addAttribute("wallets", new Wallets());
		return "painel_walletuser";
	}
	
	
	/**
	 * 
	 * @param nameWallet
	 * @param tipoMoeda
	 * @return
	 */
	
	@RequestMapping(value="createWallet", method = RequestMethod.POST)
	private String createWallet(@RequestParam("nameWallet") String nameWallet, @RequestParam("tipoWallet") String tipoMoeda) {
		
		WalletCreate walletCreate = null; 
		RestTemplate restTemplate = new RestTemplate();
		
		if(tipoMoeda.equals("ltc")) {
			walletCreate = restTemplate.postForObject(BASE + "api/v2/get_new_address/?api_key=" + LTCKEY + "&label=" + 	nameWallet, nameWallet, WalletCreate.class, 200);
		} 	else if(tipoMoeda.equals("btc")) {
			walletCreate = restTemplate.postForObject(BASE + "api/v2/get_new_address/?api_key=" + BTCKEY + "&label=" + 	nameWallet, nameWallet, WalletCreate.class, 200);
		}	else if(tipoMoeda.equals("doge")) {
			walletCreate = restTemplate.postForObject(BASE + "api/v2/get_new_address/?api_key=" + DOGEKEY + "&label=" + nameWallet, nameWallet, WalletCreate.class, 200);
		}
			
		
		walletService.save(walletCreate.getWalletUsuario());
		
        
        return "redirect:/carteira";
	}
}
