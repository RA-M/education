package com.edutech.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectivity {
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev_db", "root",
					"Ram@9970");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_details_master");
			while (rs.next())
				System.out.println("Email :"+rs.getString(1)+" Password :"+rs.getString(1));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}

