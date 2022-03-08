package com.efarmer.restapi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class EfarmerController {

	@RequestMapping("/efarmer/{phone}")

	public String testefarmer(@PathVariable("phone") String sms) {

		System.out.println("SMS = " + sms);
		return "Goodbye from Spring Boot SMS = "+sms;
	}

	@RequestMapping("/")

	public String testefarmer1() {

		System.out.println("this is default page on / = ");
		return "Goodbye from Spring Boot";
	}

}
