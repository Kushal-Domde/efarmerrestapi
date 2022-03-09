package com.efarmer.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmer.restapi.dao.EfarmerDAO;
import com.efarmer.restapi.service.EfarmerService;
import com.efarmer.restapi.vo.User;

@Service
public class EfarmerServiceImpl implements EfarmerService {

	@Autowired
	private EfarmerDAO efarmerDAO;
	@Override
	public void addUser(User user) {
		efarmerDAO.addUser(user);		
	}

}
