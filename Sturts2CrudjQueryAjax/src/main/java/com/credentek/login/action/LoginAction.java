package com.credentek.login.action;

import org.apache.log4j.Logger;

import com.credentek.login.model.Login;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport 
{
	
	/**
	 * 
	 */
	protected Logger log = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = -2712156513660713757L;
	
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
		log.info("Email Id :"+login.getEmail());
		
		
		
		
		
		return SUCCESS;
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


