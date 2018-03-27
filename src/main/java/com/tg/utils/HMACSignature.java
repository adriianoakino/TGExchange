package com.tg.utils;

import org.apache.commons.codec.binary.Hex;

import com.tg.endpoints.Endpoints;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class HMACSignature implements Endpoints {

	
	/*private final String nonce = String.valueOf(System.currentTimeMillis());
	private final String parameters = "application/x-www-form-urlencoded";
	private final String path = "/wallet/";
	private final String message = nonce + AUTH_KEY + path + parameters;
	
	
	
	public String HMACSing() {
		try {
			System.out.println("message: " + message);
			Mac sha256_HMAC = Mac.getInstance(METHOD);
			SecretKeySpec secret_key = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), METHOD);
			sha256_HMAC.init(secret_key);
			return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes(CHARSET))).toUpperCase();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		return "";
	}*/
	


    private final String message;

    public HMACSignature(String path, String parameters, String nonce) {
        this.message = nonce + AUTH_KEY + path + parameters;
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
            SecretKeySpec secret_key = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), METHOD);
            sha256_HMAC.init(secret_key);
            return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes(CHARSET))).toUpperCase();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }
}
