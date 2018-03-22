package com.tg.utils;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import com.tg.endpoints.Endpoints;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class HMACSignature implements Endpoints {

	private final String message;

	public HMACSignature(String path, String parameters, String nonce) {
		this.message = nonce + AUTH_KEY + path + parameters;
	}

	/**
	 * Essa classe cria o HMAC para de acesso de troca de bitcoins.
	 * 
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
