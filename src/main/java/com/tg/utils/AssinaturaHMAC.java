package com.tg.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.tg.endpoints.Endpoints;

public class AssinaturaHMAC implements Endpoints{
	
	
	private final String nonce = String.valueOf(System.currentTimeMillis());
	private final String message;
	
	public AssinaturaHMAC(String path, ParameterCollection parameters) {
        this.message = this.nonce + AUTH_KEY + path + parameters;
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
