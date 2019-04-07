package com.ussd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ussd.config.UssdConfig;

/**
 * Servlet implementation class UssdController
 */
public class UssdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UssdController() {
        super();
        UssdConfig.configure();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Reads the variables sent via POST from our gateway
		String sessionId = request.getParameter("sessionId");
		String serviceCode = request.getParameter("serviceCode");
		String phoneNumber = request.getParameter("phoneNumber");
		String text = request.getParameter("text");

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

		response.setContentType("text/plain");
		response.getWriter().print(strResponse.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
