package com.edutech.database;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;



public class PathRead 
{
	protected Logger log = Logger.getLogger(DAOBase.class);

	private static PathRead pathReadObj = null;
	public String getPath(String queryID) {

		ResourceBundle resourceBundle = ResourceBundle.getBundle("CommonPath");
		String queryString = resourceBundle.getString(queryID);

		log.info("Path" + queryID + " = " + queryString);

		return queryString;
	}
	
	public static PathRead getInstance()
	{
		if(pathReadObj==null)
		{
			pathReadObj = new PathRead();
		}
		return pathReadObj;
	}


}
