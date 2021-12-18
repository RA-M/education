package com.edutech.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.edutech.database.DAOBase;

public class LoginDaoImpl extends DAOBase implements LoginDao
{

	protected Logger log = Logger.getLogger(LoginDaoImpl.class);
	@Override
	public String login() 
	{
		//System.out.println(LoginDao.a);
		try {
			Connection conn = getConnection();
			PreparedStatement preStatement = conn.prepareStatement("select * from user_details_master where email_Id = ?");
			preStatement.setString(1, "Ram@gmail.com");
			//Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = preStatement.executeQuery();
			
			while (rs.next()) 
			{
				log.info("Email :"+rs.getString(1)+" Password :"+rs.getString(2));
			}
			conn.close();
		} catch (Exception e) {
			
		}
		
		return null;
	}

}
