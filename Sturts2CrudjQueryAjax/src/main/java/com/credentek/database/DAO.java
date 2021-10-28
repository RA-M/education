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
* File Name           :DAO.Java
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

public interface DAO {
	public Connection getConnection() throws Exception;
}
