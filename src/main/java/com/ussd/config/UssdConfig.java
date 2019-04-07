package com.ussd.config;

import java.util.Locale;
import java.util.ResourceBundle;

import com.africastalking.AfricasTalking;

public class UssdConfig {
	
	private static boolean isConfigured=false;
	
	private UssdConfig() {
		
	}
	
	public static void configure() {
		if (!isConfigured) {
			ResourceBundle config = ResourceBundle.getBundle("ussd-config", Locale.ROOT);
			String username = config.getString("username");
			String apiKey = config.getString("apikey");
			AfricasTalking.initialize(username, apiKey);
		}
	}
}
