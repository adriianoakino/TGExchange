package com.tg.endpoints;

public interface Endpoints {

	public static final String 	BASE_BLOCK 	= 	"https://block.io/";
	public static final String 	BTCKEY  	= 	"6bf2-0059-2b8e-b7d1";
	public static final String 	LTCKEY  	= 	"1e97-3956-9aaf-cc56";
	public static final String 	DOGEKEY 	= 	"baaa-0cf8-46e3-8316";
	
	//
	public static final String 	BASE_LoBTC 	= 	"https://localbitcoins.com";
	public static final String  APIENDPOINT	= 	"/api/notifications/";
	public static final String 	SECRET_KEY	=   "a29215a68a97052ba9edca120a05059320a72195a73196ccf82ccd1b0c01b5cc";
    public static final String 	AUTH_KEY 	=	"883531de1e1d8e41f253c4a1f4f821ad";
	
    public static final String SELLERS		=	"/sell-bitcoins-online/.json";
    public static final String SELLERSPAYPAL=	"/sell-bitcoins-online/paypal/.json";
    public static final String CONTACT_INFO =	"/api/contact_info/";
    public static final String CONTACTCREATE=	"/api/contact_create/";
    public static final String PAYMENT		=	"/api/payment_methods/";
    
    public static final String 	METHOD 		= 	"HmacSHA256";
	public static final String 	CHARSET 	= 	"UTF-8";
	
	public static final String 	NONCE 		= 	String.valueOf(System.currentTimeMillis());
}
