package com.credentek.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class DataSourceBase 
{
	protected static Logger log = Logger.getLogger(DataSourceBase.class);

	protected static DataSource dataSource;
	protected static DataSource dataSourceAccuity;
	

	private static Context initContext;
	private String datasourceName;
	private String datasourceAccuityName;
	

	private static PathRead path;

	static {
		try {
			initContext = new InitialContext();
			/* for Tomcat deployment */
			path = new PathRead();
			log.info("Connected datasource Name *****************"+path.getPath("dataSource"));
			log.info("Connected dataSourceAccuity Name *****************"+path.getPath("dataSourceAccuity"));
			dataSource = (DataSource) initContext.lookup(path.getPath("dataSource").trim());
			dataSourceAccuity = (DataSource) initContext.lookup(path.getPath("dataSourceAccuity").trim());

			log.info("Connected datasource::"+dataSource +" & "+ dataSourceAccuity);
						
		} catch (Exception e) {
			log.error(e);
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public String getDatasourceName() {
		return datasourceName;
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}
	public String getDatasourceAccuityName() {
		return datasourceAccuityName;
	}

	public void setDatasourceAccuityName(String datasourceAccuityName) {
		this.datasourceAccuityName = datasourceAccuityName;
	}

	public static DataSource getDataSourceAccuity() {
		return dataSourceAccuity;
	}


}
