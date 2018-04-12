package com.tg.utils;

import org.apache.commons.codec.binary.Hex;

import com.tg.endpoints.Endpoints;
import com.tg.entities.OrderChanger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


public class HMACSignature implements Endpoints {

	
	

	private final String nonce = String.valueOf(System.currentTimeMillis());
    private final String message;

    public HMACSignature(String path, ParameterCollection parameters) {
    	this.message = path + parameters +this.nonce;
    }
    public HMACSignature(String path,  Map<String, String> params) throws UnsupportedEncodingException {
    	
    	//this.message = path + converter(params) + this.nonce;
    	this.message = path + ""
    			+ ":param0=max.seexy%40hotmail.com&param1=pm_USD&param2=bitcoin_BTC&param3=10.3&param4=3QdatXeBguSo3pAwZQZ3hVE7MpNV3a7tr2:" + this.nonce + ":" + API_SECURITY;
    	System.out.println(message);
    }
    
    public String converter(Map<String, String> params) throws UnsupportedEncodingException {
    	 StringBuilder result = new StringBuilder();
    	 
    	 for (Map.Entry<String, String> entry : params.entrySet()) {
             result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
             result.append("=");
             result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
             result.append("&");
           }
    
           String resultString = result.toString();
             return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1): resultString;
    }
    

    /**
     * Creates a HMACSHA1 key.
     *
     * @return the created HMAC signature.
     */
    @Override
    public String toString() {
        try {
        	Mac sha256_HMAC = Mac.getInstance(METHOD);
            SecretKeySpec secret_key = new SecretKeySpec(API_SECURITY.getBytes(CHARSET), METHOD);
            sha256_HMAC.init(secret_key);
            return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes(CHARSET)));
        	
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }
}
