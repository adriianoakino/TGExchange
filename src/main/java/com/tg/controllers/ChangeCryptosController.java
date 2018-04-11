package com.tg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChangeCryptosController {

	@RequestMapping(value = "/trocar", method = RequestMethod.GET)
	public String ChangeCrypto(Model model) {
		model.addAttribute("listaPagamento", ListaPag());
		return "painel_troca";
	}

	private String[] ListaPag() {
		String[] pagamentos = 
		{"Perfect Money", "Perfect Money Voucher", "Payeer","AdvCash",
				"Bitcoin","Dogecoin","Litecoin","Ethereum","Dash","Monero"};
		return pagamentos;
	}
}
