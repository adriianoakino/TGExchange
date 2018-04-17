package com.tg;

import static org.mockito.Mockito.mock;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tg.controllers.ChangeCryptosController;
import com.tg.controllers.VendaBtcController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void testRates() {
		HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);   
		ChangeCryptosController c = new ChangeCryptosController();
		c.Troca(response);
	}

	@Test
	public void testExchange() throws UnsupportedEncodingException {
		HttpServletRequest request = mock(HttpServletRequest.class);
	    HttpServletResponse response = mock(HttpServletResponse.class);    
		ChangeCryptosController c = new ChangeCryptosController();
		c.Trocar(response,  "max.seexy@hotmail.com", "pm_USD", "bitcoin_BTC", 10.30, "3QdatXeBguSo3pAwZQZ3hVE7MpNV3a7tr2");
		
	}
	
	@Test
	public void testVender() throws UnsupportedEncodingException {
	    HttpServletResponse response = mock(HttpServletResponse.class);    
		VendaBtcController btc = new VendaBtcController();
		btc.VenderBtc(response, "asdasd", 35);
		
	}

}
