package com.efarmer.restapi.controller;

import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmer.restapi.service.EfarmerService;
import com.efarmer.restapi.util.SingletonConnection;
import com.efarmer.restapi.vo.User;

@RestController(value = "/")
public class EfarmerController 
{
	
	@Autowired
	private EfarmerService efarmerService;

	@RequestMapping("/efarmer/{phone}")
	public String testefarmer(@PathVariable("phone") String sms) 
	{

		System.out.println("SMS = " + sms);
		Connection connection = SingletonConnection.getConnection();
		System.out.println("connection = "+ connection);
		return "Goodbye from Spring Boot SMS = "+sms;
	}

	@RequestMapping("/")

	public String testefarmer1() 
	{

		System.out.println("this is default page on / = ");
		return "Goodbye from Spring Boot";
	}
	@RequestMapping("/efarmer/{phone}/{firstName}/{lastName}/{firmName}/{address}")
	public String getdetails(@PathVariable("phone") String sms,@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName,
			@PathVariable("firmName") String firmName,@PathVariable("address") String address) 
	{
		User user = new User();
		user.setFirmName(firmName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setPhone(sms);
		efarmerService.addUser(user);
		System.out.println("Phone = " + sms+"firstname="+firstName+"last name="+lastName+"firmname="+firmName+"address="+address);
		return "Goodbye from Spring Boot name = "+sms;

	}
}