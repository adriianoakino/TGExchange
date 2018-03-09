package com.tg.services;

public interface SecurityServices {

	String findLoggedInUsername();

    void autologin(String username, String password);
}
