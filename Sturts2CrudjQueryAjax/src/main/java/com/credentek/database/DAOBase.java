/*******************************************************************/
/*
   COPYRIGHT NOTICE
   Copyright @ 2012 CredenTek Software & Consultancy. All rights reserved.

   These materials are confidential and proprietary to CredenTek Software and Consultancy and no part of these materials should be reproduced, published, transmitted or distributed in any form or by any means, electronic, mechanical, photocopying, recording or otherwise, or stored in any information storage or retrieval system of any nature nor should the materials be disclosed to third parties or used in any other manner for which this is not authorized, without the prior express written authorization of CredenTek Software & Consultancy Pvt Ltd. */
/*                                                                 */
/*******************************************************************/

/**********************************************************************
*
* Module Name         :
*
* File Name           :DAOBase.Java
*
* Description         :
*                             
*            Version Control Block
*            ---------------------
* Date              Version      Author               Description
* ---------         --------   ---------------  ---------------------------
* July 6, 2012         1.0      Credentek Team         Base Version
**********************************************************************/
package com.credentek.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DAOBase implements DAO {

	protected Logger log = Logger.getLogger(DAOBase.class);
	Connection connection = null;

	public Connection getConnection() {

		DataSource dataSource = DataSourceBase.getDataSource();
		if (dataSource != null) {
			try {
				connection = dataSource.getConnection();
				
			} catch (SQLException e) {
				log.error(e);
				
			}
		}
		return connection;
	}

	public String getQuery(String queryID) {

		ResourceBundle resourceBundle = ResourceBundle.getBundle("SQLRepository");
		String queryString = resourceBundle.getString(queryID);
		/*if(!"STAR_SELECT_REASON".equalsIgnoreCase(queryID) || !"SELECT_RBI_PURPOSE_CD".equalsIgnoreCase(queryID) || !"STAR_TXN_SELECT".equalsIgnoreCase(queryID) || !"STAR_TRANSACTION_DTL_SELECT_CHANNEL".equalsIgnoreCase(queryID) || !"STAR_BEN_NATIONALITY_CD".equalsIgnoreCase(queryID) || !"STAR_GET_COUNTRY_CD".equalsIgnoreCase(queryID) || !"STAR_GET_BANK_COUNTRY_NAME".equalsIgnoreCase(queryID) || !"STAR_GET_DEAL_BOOKING_NUMBER".equalsIgnoreCase(queryID) || !"CHECK_TYPE_OF_TRANSACTION".equalsIgnoreCase(queryID) || !"STAR_SELECT_REASON_REMARK".equalsIgnoreCase(queryID) || !"STAR_REM_MST_SELECT_LASTUSER".equalsIgnoreCase(queryID) || !"STAR_REM_MST_SELECT_APPLIID".equalsIgnoreCase(queryID) || !"STAR_GET_USER_NAME".equalsIgnoreCase(queryID)){
			log.info("Query string for ID " + queryID);
		}*//*else{
			if(!"STAR_TRANSACTION_DTL_SELECT_CHANNEL".equalsIgnoreCase(queryID)) {
				log.info("Query string for ID " + queryID + " = ");
			}
			
		}*/
		return queryString;
	}

	
}