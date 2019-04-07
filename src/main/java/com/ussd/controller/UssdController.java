package com.ussd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.africastalking.AfricasTalking;
import com.ussd.config.UssdConfig;

@RestController(value="/")
public class UssdController {
	
	@RequestMapping(produces="text/plain")
	public String processRequest(@RequestParam String sessionId, @RequestParam String serviceCode, @RequestParam String phoneNumber, @RequestParam String text)  {
		UssdConfig.configure();
		AfricasTalking.getService(AfricasTalking.SERVICE_USSD);

		StringBuilder strResponse = new StringBuilder();
		if ("".equals(text)) {
		    // This is the first request. Note how we start the response with CON
			strResponse.append("CON Welcome to Pradeep USSD \n");
		    strResponse.append("1. Account\n");
		    strResponse.append("2. Banking\n");
		    strResponse.append("3. Exit");
		    
		} else if ("1".equals(text)) {
			// Business logic for first level response
		    strResponse.append("CON Account \n");
		    strResponse.append("1. My Number \n");
		    strResponse.append("2. Balance");

		} else if ("2".equals(text)) {
			// Business logic for first level response
		    strResponse.append("CON Banking \n");
		    strResponse.append("1. Account Number \n");
		    strResponse.append("2. Balance");

		} else if ("3".equals(text)) {
			// Business logic for first level response
		    strResponse.append("END Have a great day.");
		
		} else if("1*1".equals(text)) { 
		    // This is a terminal request. Note how we start the response with END
		    strResponse.append("END Your phone number : 7668*****41");
		    
		} else if("1*2".equals(text)) { 
		    // This is a terminal request. Note how we start the response with END
		    strResponse.append("END Your call balance is Rs. 500");
		    
		} else if("2*1".equals(text)) { 
		    // This is a terminal request. Note how we start the response with END
		    strResponse.append("END Your Account number : SBIIN093302******334");
		    
		} else if("2*2".equals(text)) { 
		    // This is a terminal request. Note how we start the response with END
		    strResponse.append("END Your fund balance: Rs. 18400");
		    
		}
		return strResponse.toString();
	}

}
