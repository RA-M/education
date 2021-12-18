package com.edutech.login.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.edutech.login.model.Login;
import com.edutech.login.service.LoginServiceDao;
import com.edutech.login.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport 
{
	
	
	
	/**
	 * 
	 */
	protected Logger log = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = -2712156513660713757L;
	private static final Map<String, String> map = new HashMap<String, String>();
	public LoginAction()
	{
		map.put("Karuna@gmail.com", "Karuna@95");
		map.put("Ram@gmail.com", "Ram@9970");
		map.put("Winky@gmail.com", "Winky123");
		map.put("Kasturi@gmail.com", "Kasturi@23");
	}
	
	
	
	private Login login;
	private String ajaxXmlData;

	public String getAjaxXmlData() {
		return ajaxXmlData;
	}

	public void setAjaxXmlData(String ajaxXmlData) {
		this.ajaxXmlData = ajaxXmlData;
	}


	public Login getLogin() {
		return login;
	}



	public void setLogin(Login login) {
		this.login = login;
	}



	public String data() {
		log.info(map);
		log.info("Email Id :"+login.getEmail()+""+login.getPassword());
		
		LoginServiceDao  loginServiceDao = new LoginServiceImpl();
		
		loginServiceDao.loginCheck();
		
		if(map.containsKey(login.getEmail()))
		{
			String password = map.get(login.getEmail());
			if(password.equals(login.getPassword()))
			{
				return SUCCESS;
			}else {
				return ERROR;
			}
		}else {
			return ERROR;
		}
		
	//	return SUCCESS;
	}
	
	public String registerEmployee() {
		log.info("Inside registerEmployee method of LoginAction class");
		return SUCCESS;
	}
	
	public String register() {
		log.info("Inside register method of LoginAction class"+ajaxXmlData);
		log.info("Successfully Registered...");
		
		return SUCCESS;
	}
	
	
		
}


