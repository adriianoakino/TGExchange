package com.tg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.tg.endpoints.Endpoints;
import com.tg.entities.Wallets;
import com.tg.services.SecurityServices;
import com.tg.services.UsuarioServices;
import com.tg.services.WalletService;

@Controller
public class WalletController implements Endpoints{
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private UsuarioServices usuarioService;
	
	@Autowired
	private SecurityServices securityService;
	
	@RequestMapping("/carteira")
	public String wallet(Model model) {
		
		model.addAttribute("wallets", new Wallets());
		requestWalletCreated();
		model.addAttribute("walletsready", requestWalletCreated());
		return "painel_wallet";
	}
	
	
	private List<?> requestWalletCreated() {
		List<Wallets> wall = walletService.findByUsuarios(usuarioService.findByUsername(securityService.findLoggedInUsername()));
		System.out.println(wall.get(0).getLabel());

		return wall;

	}
	
	
	/**
	 * 
	 * @param nameWallet
	 * @param tipoMoeda
	 * @return
	 */
	
	@RequestMapping(value="/carteira", method = RequestMethod.POST)
	private String createWallet(@RequestParam("nomeWallet") String nameWallet, @RequestParam("tipoWallet") String tipoMoeda) {
		
		/*WalletCreate walletCreate = null; 
		RestTemplate restTemplate = new RestTemplate();
		
		if(tipoMoeda.equals("ltc")) {
			walletCreate = restTemplate.postForObject(BASE + "api/v2/get_new_address/?api_key=" + LTCKEY + "&label=" + 	nameWallet, nameWallet, WalletCreate.class, 200);
		} 	else if(tipoMoeda.equals("btc")) {
			walletCreate = restTemplate.postForObject(BASE + "api/v2/get_new_address/?api_key=" + BTCKEY + "&label=" + 	nameWallet, nameWallet, WalletCreate.class, 200);
		}	else if(tipoMoeda.equals("doge")) {
			walletCreate = restTemplate.postForObject(BASE + "api/v2/get_new_address/?api_key=" + DOGEKEY + "&label=" + nameWallet, nameWallet, WalletCreate.class, 200);
		}
			
		System.out.println(walletCreate.getWalletUsuario().getAddress());*/
		
		Wallets wal = new Wallets();
		wal.setAddress("teste");
		wal.setLabel("teste");
		wal.setNetwork("teste");
		wal.setUser_id("teste");
		walletService.save(wal);
		
        
        return "redirect:/carteira";
	}
}
