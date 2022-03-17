package com.efarmer.restapi.dao.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.efarmer.restapi.dao.EfarmerDAO;
import com.efarmer.restapi.util.SingletonConnection;
import com.efarmer.restapi.vo.User;

@Component
public class EfarmerDAOImpl implements EfarmerDAO 
{

	@Override
	public void addUser(User user)
	{
		
		System.out.println("EfarmerDAOImpl -> firm Name = "+user.getFirmName());
		System.out.println("EfarmerDAOImpl -> first Name = "+user.getFirstName());
		System.out.println("EfarmerDAOImpl -> last Name = "+user.getLastName());
		System.out.println("EfarmerDAOImpl -> Address = "+user.getAddress());
		System.out.println("EfarmerDAOImpl -> Phone = "+user.getPhone());
		// add a logic to add in DB and  generate the otp and send it
		Connection connection = SingletonConnection.getConnection();
	
		try
		{
			String numbers = "0123456789";

		// 	Using random method
			Random rndm_method = new Random();
			char[] otp = new char[6];

			for (int i = 0; i < 6; i++)
			{
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
				otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
			}
			System.out.println(otp);

			String recipient = "919503968622";
			String message = "  Have a nice day!";
			String username = "kaustubh23dom";
			String password = "56905093";
			String originator = "UPDATE";
			String requestUrl = "https://www.txtguru.in/imobile/api.php?username=kaustubh23dom&password=56905093&source=UPDATE&"
				+ "dmobile=919503968622&" + "message=TEST+SMS+FROM+TextGuru+SMS+GATEWAY" + "username="
				+ URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8")
				+ "&recipient=" + URLEncoder.encode(recipient, "UTF-8") + "&messagetype=SMS:TEXT" + "&messagedata="
				+ URLEncoder.encode(message, "UTF-8") + "&originator=" + URLEncoder.encode(originator, "UTF-8")
				+ "&serviceprovider=GSMModem1" + "&responseformat=html";

			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			System.out.println(uc.getResponseMessage());
			uc.disconnect();
		} 
		catch (Exception ex) 
		{
		System.out.println(ex.getMessage());
		}
	}
}
	 

