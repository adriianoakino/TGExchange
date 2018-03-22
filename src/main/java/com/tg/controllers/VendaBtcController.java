package com.tg.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tg.endpoints.Endpoints;
import com.tg.utils.HMACSignature;
import com.tg.utils.ParameterCollection;


@Controller
public class VendaBtcController implements Endpoints {

	private final String 		path;
    private final String 		nonce;
    private final HttpType 		type;
    private ParameterCollection parameters;

	@RequestMapping("/vender")
	public String homeVender() {
		getContent();
        return "painel_vender";
    }
	
	
	public VendaBtcController(String path, ParameterCollection parameters, HttpType type) {
        this.nonce = String.valueOf(System.currentTimeMillis());
        this.path = path.startsWith("/api") ? path : ("/api" + path);
        this.parameters = parameters;
        this.type = type;
    }
	
	public enum HttpType {
        GET, POST, DELETE, PUT
    }
	
	 private HttpResponse getContent() {
	        try {
	            HttpClient client = HttpClientBuilder.create().build();
	            UrlEncodedFormEntity form = new UrlEncodedFormEntity(parameters.getParameters(), "UTF-8");
	            BufferedReader inputStream = new BufferedReader(new InputStreamReader(form.getContent()));
	            String parametersString = inputStream.readLine();
	            if (parametersString == null)
	                parametersString = "";
	            System.out.println(parametersString);
	            HttpRequestBase base;
	            switch (type) {
	                case GET:
	                default:
	                    base = new HttpGet(constructUrl());
	                    break;
	                case POST:
	                    base = new HttpPost(constructUrl());
	                    ((HttpPost) base).setEntity(form);
	                    break;
	                case DELETE:
	                    base = new HttpDelete(constructUrl());
	                    break;
	                case PUT:
	                    base = new HttpPut(constructUrl());
	                    break;
	            }
	            String signature = new HMACSignature(this.path, parametersString, nonce).toString();
	            base.addHeader("Content-Type", "application/x-www-form-urlencoded");
	            base.addHeader("Apiauth-Key", AUTH_KEY);
	            base.addHeader("Apiauth-Nonce", nonce);
	            base.addHeader("Apiauth-Signature", signature);
	            return client.execute(base);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public String pullData() {
	        StringBuilder builder = new StringBuilder();
	        HttpResponse response = getContent();
	        if (response != null) {
	            try {
	                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    builder.append(line);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return builder.toString();
	    }

	    private String constructUrl() {
	        return BASE_LoBTC + path;
	    }

	    public static final String WALLET = "/wallet/";
	    public static final String WALLET_BALANCE = "/wallet-balance/";
	    public static final String DASHBOARD = "/dashboard/";
	    public static final String RELEASED = DASHBOARD + "released/";
	    public static final String CANCELED = DASHBOARD + "canceled/";
	    public static final String CLOSED = DASHBOARD + "closed/";
	
}
