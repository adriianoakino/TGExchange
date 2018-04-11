package com.tg.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tg.model.Trocas;

@Controller
public class ChangeCryptosController {
	
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
	public void Troca(@RequestParam String enviar, @RequestParam String receber) {
		System.out.println(enviar);
		System.out.println(receber);
	}

}
