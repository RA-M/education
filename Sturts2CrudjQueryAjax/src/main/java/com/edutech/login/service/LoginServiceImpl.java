package com.edutech.login.service;

import org.apache.log4j.Logger;

import com.edutech.login.dao.LoginDao;
import com.edutech.login.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginServiceDao{

	protected Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Override
	public String loginCheck() {
		log.info("Inside LoginServiceImpl loginCheck method");
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.login();
		
		
		return null;
	}

	
}
