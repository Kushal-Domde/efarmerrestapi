package com.efarmer.restapi.dao.impl;

import java.sql.Connection;

import org.springframework.stereotype.Component;

import com.efarmer.restapi.dao.EfarmerDAO;
import com.efarmer.restapi.util.SingletonConnection;
import com.efarmer.restapi.vo.User;

@Component
public class EfarmerDAOImpl implements EfarmerDAO {

	@Override
	public void addUser(User user) {
		
		System.out.println("EfarmerDAOImpl -> firm Name = "+user.getFirmName());
		System.out.println("EfarmerDAOImpl -> first Name = "+user.getFirstName());
		System.out.println("EfarmerDAOImpl -> last Name = "+user.getLastName());
		System.out.println("EfarmerDAOImpl -> Address = "+user.getAddress());
		System.out.println("EfarmerDAOImpl -> Phone = "+user.getPhone());
		// add a logic to add in DB and  generate the otp and send it
		Connection connection = SingletonConnection.getConnection();
	}

	 
}
