package com.edutech.patientDetail.dao;

import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import com.edutech.database.DAOBase;
import com.edutech.patientDetail.model.PatientDetail;


public class PatientDetailDaoImpl extends DAOBase implements PatientDetailDao
{
		
	protected Logger log = Logger.getLogger(PatientDetailDaoImpl.class);
	@Override
	public Map<String, String> Save(PatientDetail patientDetail) 
	{
		System.out.println("Inside save");
		Map<String, String> message = new LinkedHashMap<String, String>();
		Connection connection = null;
		ResultSet resultSet = null;
		String aesenicTaken = "N";
		PreparedStatement pStatement = null;
		try
		{
			connection = getConnection();
			
			pStatement = connection.prepareStatement(getQuery("PATIENT_INSERT_DATA"));
			pStatement.setString(1, patientDetail.getName());
			pStatement.setLong(2, Long.parseLong(patientDetail.getMobileNumber()));
			pStatement.setString(3, patientDetail.getPoliceBakalNumber());
			pStatement.setInt(4, Integer.parseInt(patientDetail.getAge()));
			pStatement.setDate(5, patientDetail.getIsolationDate());
			pStatement.setDate(6, patientDetail.getFirstTestResultDate());
			pStatement.setString(7, patientDetail.getTestResult());
			pStatement.setString(8, patientDetail.getHospitalName());
			pStatement.setDate(9, patientDetail.getOxygenStartDate());
			pStatement.setDate(10, patientDetail.getOxygenEndDate());
			pStatement.setDate(11, patientDetail.getVentilatorStartDate());
			pStatement.setDate(12, patientDetail.getVentilatorEndDate());
			if("YES".equals(patientDetail.getArsenicTaken().toUpperCase()))
			{
				aesenicTaken = "Y";
			}
			pStatement.setString(13, aesenicTaken);
			pStatement.setString(14, patientDetail.getBloodGroup());
			pStatement.setString(15, "N");
			pStatement.executeUpdate();
			pStatement.close();
			
			
			message.put("success", "Record Saved Successfully");
			
		}
		catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			message.put("error", "Save Record Failed");
			return message;
		} finally {
			try {
				if(resultSet!=null){
					resultSet.close();
					
				}
				if(pStatement!=null){
					pStatement.close();
				}
				if(connection!=null){
					connection.close();
				}
			} catch (SQLException ex) {
				//log.error(ex);
			}
		}
		
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public List<PatientDetail> Search() 
	{
		System.out.println("Inside search");
		List<PatientDetail> matchRecords = new ArrayList<PatientDetail>();	
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement pStatement = null;
		try
		{
			connection = getConnection();
			PatientDetail patientDetail1 = new PatientDetail();
			pStatement = connection.prepareStatement(getQuery("PATIENT_SEARCH_DATA"));
			pStatement.setString(1, "x");
			patientDetail1.setName("abc");
			patientDetail1.setMobileNumber("12345678");
			
			matchRecords.add(patientDetail1);
		}
		catch(Exception e)
		{
			
		}
		PatientDetail patientDetail1 = new PatientDetail();
		
		// TODO Auto-generated method stub
		return matchRecords;
	}
	
	
	public String generateTransactionPDF(String p_data, String pdfype) {

        String inputXML = BuildXml(p_data, "NA");
        //log.info("inputXML"+ inputXML);
        return generatePdf(p_data, inputXML.trim(), pdfype);
    }
	
	public String generatePdf(String stopID, String inputXML, String letterType) {

        //System.out.println("Inside then gen pdf");
        Source xslDoc = null;
        //PathRead pathReadObj = PathRead.getInstance();
        log.info("In generatePdf Method.....");
        String htmlString = "";
        String printFormTempletePath = "";
        try {

           // printFormTempletePath = pathReadObj.getPath("printFormTempletePath");
        	//printFormTempletePath = ParameterMaster.parameterMstMap.get("CBPPC_PRINTFORM_TEMPLETE_PATH");
        	printFormTempletePath = "D:\\Ram\\STAR\\PrintForm\\";
            //OutputStream outputPath = new FileOutputStream("printFormTempletePath");
        } catch (Exception e1) {
            log.error(e1);
        }
        TransformerFactory tFactory = TransformerFactory.newInstance();
        try {

            xslDoc = new StreamSource(printFormTempletePath + "/ICICIBANK.xsl");
            Transformer trasform = tFactory.newTransformer(xslDoc);

            StringWriter outWriter = new StringWriter();
            StreamResult result = new StreamResult(outWriter);

            trasform.transform(new StreamSource(new StringReader(inputXML)), result);

            StringBuffer sb = outWriter.getBuffer();
            htmlString = sb.toString();

            /*
             Document document = new Document();
             PdfWriter.getInstance(document, outputPath);
             document.open();
             HTMLWorker htmlWorker = new HTMLWorker(document);
             htmlWorker.parse(new StringReader(htmlString));
             document.close();
             outputPath.close();*/
        } catch (Exception e) {
            log.error(e);
        }
        return htmlString;
    }
	
	 @SuppressWarnings({ "null", "resource" })
	    public String BuildXml(String p_data,String serviceCd) {

	    	log.info("inside BuildXml CHANGE 21-March-2017 :"+p_data +"::"+serviceCd);
	    		    	String  TRREFNO="";
	    	String  ORGBRID= "";//session.get("userID").toString(); // branch user ID
	    	String  BRCID="";
	    	String BRCIDNO="";
	    	String  SCANBRID="";
	    	String  ADCODE="";
	    	String  ADDINFO="";
	    	String  NAMEOFAPPLI="";
	    	String  ADDRESS="";
	    	String  APPLIPHNO="";
	    	String  PANNO="";
	    	String  REMCURRENCY="";
	    	String  FCAMTWORDS="";
	    	String  FCAMTFIG="";
	    	String  REMCURRENCYFOREIN="";
	    	String  INRAMTWORDS="";
	    	String  INRAMTFIG="";
	    	String  WHTLRS="";
	    	String  PURCODE="";
	    	String  PURDESC="";
	    	String  ADDPURDETL="";
	    	String  MAINTENANCE="";
	    	String  PURIMMOPROPERTY="";
	    	String  STUDNAME="";
	    	String  STUDID="";
	    	String  STUDCOUNTRY="";
	    	String  INVESTABOARD="";
	    	String  AUTHORIZEDEBIT="";
	    	String  LIMITCATEGORY=" ";
	    	String  BENEFINAME=" ";
	    	String  BENEFIADDRESS="";
	    	String  BENEFIACCOUNT="";
	    	String  BENEFIACCOUNTMAINTAIN="";
	    	String  SWIFTCODE="";
	    	String  ROUTINGABABSB="";
	    	String  BENEFIADDRESSCOUNTRY="";
	    	String  BENEFICIARYSWIFTCODE="";
	    	String  BENEFICIARYBANKNAME="";
	    	String  PRINTADDINFO="";
	    	String  SOURCEFUND="";
	    	String  BMAKERNAME="";
	    	String  BMAKEREMPNO="";
	    	String  BVARIFIERNAME="";
	    	String  BVARIFIEREMPNO="";
	    	String  BDATE="";
	    	String  BPLACE="";
	    	String  PRINTCUSTNAME="";
	    	String  PRINTIDPROOFNAME="";
	    	String  PRINTIDPROOFNO="";
	    	String  PRINTADDRESSNAME="";
	    	String  PRINTADDRESSNO="";
	    	String LRSNONLRS = "";
	    	String NAMECOMPANY="";
	    	String COUNTRYINC="";
	    	String LISTUNLIST="";
	    	String STOCKEXCH="";
	    	String RELATIONSHIP="";
	    	String TYPECOMPANY="";
	    	String NUMBEROF="";
	    	String PERCENTAGEOF="";
	    	String CORRSWIFTCODE="";
	    	String CORRBANKNAME="";
	    	String remFirstName="";
	    	String remMiddelName="";
	    	String remLastName="";
	    	String remAddress1="";
	    	String remAddress2="";
	    	String remPanNo="";
	    	String remMobileNumber="";
	    	String DynamicXML = "";
	    	String remFullName="";
	    	String modeOfTransfer="";
	    	String beneFullName="";
	    	String beneAdd="";
	    	String beneAccountNumber="";
	    	String beneNameOfBank="";
	    	String beneSwiftCode="";
	    	String routingCode="";
	    	String beneBankAddress="";
	    	String beneCorrBankAddress="";
	    	String beneCorrBankName="";
	    	String beneCorrBankSwiftCode="";
	    	String ccyCode="";
	    	String countryCode="";
	    	String inrCurrency="";
	    	int currencyAmt=0;
	    	int currencyAmtInPaise = 0;
	    	String currencyAmtWords="";
	    	String currencyPaiseInWords = "";
	    	String additionInfo="";
	    	String TXNMODENRO = "";
	    	String TXNMODEDD = "";
	    	String TXNMODETT = "";
	    	String SELECTCURRENCY="";
	    	String ADDINFOFIRST="";
	    	String PURPOSECODE="";
	    	String subUnit = " Paise";
	    	String fcySubUnit = " Sub Units";
	    	String unit = "";
	    	String fcyUnit = " Units";
	    	String beneCountryName = "";
	    	int RBIFEMALIMIT=0;
	    	String EMPTY="";
	    	String DESIREDRATE="";
	    	String strategicTieUpFlag = "";
	    	String typeOfReciver = "";
	    	String strategicRefNo = "";
	    	String strategicAmountAsPerA2Form = "";
	    	// ADDEED BY HARSHADA FOR A2 FORM
	    	String regulatoryAppRefNumber = "";
	    	String scheduleIITransaction = "";
	    	String checkScheduleTransaction = "";
	    	String purposeDesc = "";
	    	// String dinNumber="";
	    	String remOccupation = "";
	    	String staffCase = "";
	    	String taCase = "";
	    	String empId = "";
	    	String ta = "";
	    	String companypoint = "";
	    	String dinNumber = "";
	    	String remitterOccupation = "";
	    	String secDinNumber = "";
	    	String secDinOccupation = "";
	    	String requiredAnnexure = "";
	    	String refNumber = "";
	    	String inrAmount = "";
	    	String typeOfReceiver="";
	    	String amendmentFlg="N";
	    	String l_regulatoryCountryCode = "";
	    	String l_slctCCILDeal="";
	    	String l_txnCCILRefNo="";
		String strategicTieupFlag=""; // strategic tieup CR
		String fcAmount=""; // strategic tieup CR
		String amountInWords="";
	    	// ADDEED BY HARSHADA FOR A2 FORM

	    	try {
	    		//p_data = "JFHJF~NJNB~NJN~JBJB~NM~KNK~NK~NK~NK~N~M";
	    		//String userData[] = p_data.split("\\~");
	    		//SELECTCURRENCY = userData[1];
	    		//log.info("userData :" + p_data + "userData length :: " + userData.length);
	    		String bankcustFlag = "";
	    		
	    		if (!remMiddelName.equalsIgnoreCase("")) {
	    			remFullName = remFirstName + " " + remMiddelName + " " + remLastName;
	    		} else {
	    			remFullName = remFirstName + " " + remLastName;
	    		}
	    		//2279
	    		 if (remFullName.contains("&")) {
	    			 remFullName = remFullName.replaceAll("&", "and");
	             }
	    		 
	    		/*if (userData[4].equalsIgnoreCase("LRS")) {
	    			LRSNONLRS = userData[4];
	    			WHTLRS = "Yes";
	    			SOURCEFUND = userData[10];
	    		} else {
	    			WHTLRS = "No";
	    		}*/
	    		String slctPurpose= "";//userData[2].trim();
	    		String txnsolID = "";//userData[19].trim();
	    		log.info("txnsolID :: "+txnsolID);

	    		if (!"".equals(txnsolID)){

	    			//ADCODE  = fetchADCode(txnsolID);
	    			log.info("adCode :: "+ADCODE);
	    		}

	    		SCANBRID = txnsolID;
	    		log.info("slctPurpose:"+slctPurpose);
	    		if(slctPurpose.equalsIgnoreCase("RP1") ||  slctPurpose.trim().equalsIgnoreCase("RP18"))
	    		{
	    			//var slctRelatives = $("#slctRelatives").val();
	    			//MAINTENANCE = userData[3];	
	    		}
	    		else if(slctPurpose.equalsIgnoreCase("RP2"))
	    		{
	    			//---for Education	
	    			//STUDNAME = userData[3].split("\\|")[0];
	    			//Condition added by 2351 as student id is non mandatory 
	    			/*if(userData[3].split("\\|").length>1) {
	    				STUDID =  userData[3].split("\\|")[1];
	    			}*/
	    		} else if (slctPurpose.equalsIgnoreCase("RP27") || slctPurpose.equalsIgnoreCase("RP28")
	    				|| slctPurpose.equalsIgnoreCase("RP19") || slctPurpose.equalsIgnoreCase("RP30")
	    				|| slctPurpose.equalsIgnoreCase("RP29")) {
	    			PURPOSECODE = slctPurpose;
	    			//ADDINFO = userData[3].replaceAll("|", " ");
	    		}
	    		//PURCODE=userData[2].trim();	

	    		/*modeOfTransfer=userData[6];
	    		inrCurrency = userData[11];*/
	    		log.info("ModeOfTransfer : "+modeOfTransfer);
	    		if("DD".equalsIgnoreCase(modeOfTransfer))
	    		{
	    			TXNMODEDD = "DD";
	    			TXNMODETT = "";
	    			TXNMODENRO = "";

	    		}else if("TT".equalsIgnoreCase(modeOfTransfer))
	    		{

	    			TXNMODEDD = "";
	    			TXNMODETT = "TT";
	    			TXNMODENRO = "";
	    		}else
	    		{
	    			TXNMODEDD = "";
	    			TXNMODETT = "";
	    			TXNMODENRO = "NRO-NRE";
	    		}

	    		//String amtTmp[]=userData[12].split("\\.");
	    		//log.info("amtLen :"+userData[12]);
	    		/*if(!("".equalsIgnoreCase(amtTmp[0])))
	    		{
	    			currencyAmt = Integer.parseInt(amtTmp[0]);
	    			log.info("amtLen :"+amtTmp.length);
	    			if(amtTmp.length>1)
	    			{
	    				currencyAmtInPaise = Integer.parseInt(userData[12].split("\\.")[1]);
	    			}else
	    			{
	    				currencyAmtInPaise = 0;
	    			}
	    			//currencyAmtWords = amountInWords(currencyAmt);
	    		} */

	    		if(!ccyCode.equalsIgnoreCase("INR")){
	    			currencyAmtWords += fcyUnit; 
	    		}
	    		else {
	    			currencyAmtWords += unit; 
	    		}

	    		if(currencyAmtInPaise > 0){
	    			currencyAmtWords +=" and ";
	    			//currencyPaiseInWords = amountInWords(currencyAmtInPaise);
	    			if(!ccyCode.equalsIgnoreCase("INR")){
	    				currencyPaiseInWords += fcySubUnit; 
	    			}
	    			else {
	    				currencyPaiseInWords += subUnit; 
	    			}
	    		}

	    		/*if (userData.length > 42) {
	    			typeOfReciver = userData[42];
	    		}*/

	    		log.info("inrCurrency :-"+inrCurrency+"currencyAmt :-"+currencyAmt);
	    		log.info("currencyAmtWords :-"+currencyAmtWords + "currencyPaiseInWords :: "+currencyPaiseInWords);
	    		//SELECT nvl(FULL_NAME,' '),nvl(ADDRESS_1,' '),nvl(ADDRESS_2,' '),nvl(ACCOUNT_NO,' '),nvl(BANK_ADDRESS,' '),nvl(BANK_SWIFT_CD,' '),nvl(BANK_NAME,' '),nvl(CORR_BANK_ADDRESS,' '),nvl(IBAN_ABA_BSB_CD,' '),nvl(CORR_BANK_NAME,' '),nvl(CORR_BANK_SWIFT_CD,' '),nvl(CCY_CD,' ') from STAR_BEN_MST where ACCOUNT_NO=?
	    if (!"Western Union".equalsIgnoreCase(typeOfReciver)) {/*		
	    pStatement = connection.prepareStatement(getQuery("STAR_GET_BENE_DATA"));	
	    		pStatement.setString(1, userData[9]);
	    		pStatement.setInt(2, Integer.parseInt(userData[0]));
	    		rSet=pStatement.executeQuery();

	    		if(rSet.next())
	    		{
	    			beneFullName=rSet.getString(1);
	    			beneAdd=rSet.getString(2).replaceAll("&"," and ")+" "+rSet.getString(3).replaceAll("&"," and ");
	    			beneBankAddress=rSet.getString(5).replaceAll("&"," and ");
	    			log.info("Country Code :: "+rSet.getString(13));

	    			if(!"".equals(rSet.getString(13))){

	    				String sql = "SELECT nvl(COUNTRY_NAME,' ') FROM STAR_COUNTRY_MST WHERE COUNTRY_CD = ?";
	    				pStatement3 = connection.prepareStatement(sql);
	    				pStatement3.setString(1, rSet.getString(13));
	    				rSet3=pStatement3.executeQuery();

	    				if(rSet3.next()){
	    					beneCountryName = rSet3.getString(1); 
	    				}
	    				log.info("beneCountryName :: "+beneCountryName);
	    				rSet3.close();
	    				pStatement3.close();
	    			}


	    			if(modeOfTransfer.equalsIgnoreCase("TT"))
	    			{
	    				beneAccountNumber=rSet.getString(4);
	    				beneNameOfBank=rSet.getString(7);
	    				beneSwiftCode=rSet.getString(6);
	    				routingCode=rSet.getString(9);
	    			}
	    			if(modeOfTransfer.equalsIgnoreCase("DD"))
	    			{
	    				beneNameOfBank = rSet.getString(7);
	    			}


	    			beneCorrBankAddress=rSet.getString(8).replaceAll("&"," and ");
	    			beneCorrBankName=rSet.getString(10);
	    			beneCorrBankSwiftCode=rSet.getString(11);
	    			ccyCode=rSet.getString(12);
	    			countryCode=rSet.getString(13);
	    			log.info("Check::"+rSet.getString(14)+":"+rSet.getString(15));

	    			if(!ccyCode.equalsIgnoreCase("INR"))
	    			{
	    				CORRSWIFTCODE=rSet.getString(14);
	    				CORRBANKNAME=rSet.getString(15);
	    			}

	    		}
	    		rSet.close();
	    		pStatement.close();
	    */}else {/*
	    			pStatement = connection.prepareStatement(getQuery("STAR_GET_BENE_DATA_STRATERGY"));
	    			pStatement.setString(1, userData[9]);
	    			rSet = pStatement.executeQuery();

	    			if (rSet.next()) {
	    				beneFullName = rSet.getString(1);
	    				beneAdd = rSet.getString(2).replaceAll("&", " and ");
	    				beneBankAddress = rSet.getString(4).replaceAll("&", " and ") + " "
	    						+ rSet.getString(5).replaceAll("&", " and ");
	    				log.info("Country Code :: " + rSet.getString(12));

	    				if (!"".equals(rSet.getString(12))) {

	    					String sql = "SELECT nvl(COUNTRY_NAME,' ') FROM STAR_COUNTRY_MST WHERE COUNTRY_CD = ?";
	    					pStatement3 = connection.prepareStatement(sql);
	    					pStatement3.setString(1, rSet.getString(12));
	    					rSet3 = pStatement3.executeQuery();

	    					if (rSet3.next()) {
	    						beneCountryName = rSet3.getString(1);
	    					}
	    					log.info("beneCountryName :: " + beneCountryName);
	    					rSet3.close();
	    					pStatement3.close();
	    				}

	    				if (modeOfTransfer.equalsIgnoreCase("TT")) {
	    					beneAccountNumber = rSet.getString(3);
	    					beneNameOfBank = rSet.getString(7);
	    					beneSwiftCode = rSet.getString(6);
	    					routingCode = rSet.getString(15);
	    					
	    					 * routingCode=rSet.getString(9);
	    					  }
	    				if (modeOfTransfer.equalsIgnoreCase("DD")) {
	    					beneNameOfBank = rSet.getString(7);
	    				}

	    				beneCorrBankAddress = rSet.getString(8).replaceAll("&", " and ");
	    				beneCorrBankName = rSet.getString(9);
	    				beneCorrBankSwiftCode = rSet.getString(10);
	    				ccyCode = rSet.getString(11);
	    				countryCode = rSet.getString(12);

	    				if (!ccyCode.equalsIgnoreCase("INR")) {
	    					CORRSWIFTCODE = rSet.getString(10);
	    					CORRBANKNAME = rSet.getString(9);
	    				}

	    			}
	    			rSet.close();
	    			pStatement.close();
	    		*/}
	    		//AUTHORIZEDEBIT = userData[5];
	    		log.info(" AUTHORIZEDEBIT :"+AUTHORIZEDEBIT);
	    		/*pStatement = connection.prepareStatement(getQuery("STAR_GET_LIMIT_DESCRIPTION"));	
	    		pStatement.setString(1, userData[8]);
	    		rSet=pStatement.executeQuery();	
	    		if(rSet.next())
	    		{
	    			LIMITCATEGORY = rSet.getString(1);
	    			RBIFEMALIMIT =  rSet.getInt(2);
	    			//log.info(" LIMIT DESCRIPTION :"+rSet.getString(1));
	    			log.info(" LIMIT :"+rSet.getString(2));
	    		}
	    		rSet.close();
	    		pStatement.close();*/
	    		if(modeOfTransfer.equalsIgnoreCase("TT"))
	    		{
	    			BENEFIACCOUNTMAINTAIN=beneNameOfBank;
	    			SWIFTCODE=beneSwiftCode;
	    			ROUTINGABABSB=routingCode;
	    			if(ccyCode.equalsIgnoreCase("CAD") || ccyCode.equalsIgnoreCase("QAR") || ccyCode.equalsIgnoreCase("JPY"))
	    			{
	    				BENEFIADDRESSCOUNTRY = beneBankAddress;
	    			}
	    		}
	    		//nana 7-1-2017
	    		/*pStatement = connection.prepareStatement(getQuery("STAR_PURPOSE_DESCRIPTION_STAR_PURPOSE_CODE_MST"));	
	    		pStatement.setString(1,PURCODE);
	    		rSet=pStatement.executeQuery();	
	    		if(rSet.next())
	    		{
	    			PURDESC=rSet.getString(1);
	    			PURCODE=rSet.getString(3);
	    		}
	    		Date sysDate = new Date();
	    		nana 09-01-17
	    		if(userData.length > 13)
	    		{
	    			MAINTENANCE=userData[13];
	    		}
	    		if(userData.length > 14)
	    		{
	    			STUDNAME=userData[14];
	    		}
	    		//added by harshada on 21-june in case of student id is not mandatory
	    		if(userData.length > 15)
	    		{
	    			if("Student ID".equalsIgnoreCase(userData[15])){
	    				STUDID="";
	    			}
	    			else{
	    				STUDID=userData[15];
	    			}
	    		}
	    		if(userData.length > 16)
	    		{
	    			PURIMMOPROPERTY=userData[16];
	    		}
	    		rSet.close();
	    		pStatement.close();*/
	    		//nana 7-1-2017
	    		/*pStatement = connection.prepareStatement(getQuery("STAR_FTP_USER_MST_NAME_EMPID"));	
	    		pStatement.setString(1,ORGBRID);
	    		rSet=pStatement.executeQuery();	
	    		if(rSet.next())
	    		{
	    			BMAKERNAME=rSet.getString(1);
	    			BMAKEREMPNO=rSet.getString(2);
	    		}
	    		rSet.close();
	    		pStatement.close();*/
	    		log.info("Maker Name :- "+BMAKERNAME +"Maker Emp Id"+BMAKEREMPNO);
	    		log.info("MAINTENANCE :-"+MAINTENANCE +"STUDNAME :-"+STUDNAME+"STUDID :-"+STUDID+"PURIMMOPROPERTY :-"+PURIMMOPROPERTY);

	    		
	    		log.info("INVESTABOARD 21-March-2017 :-"+INVESTABOARD);
	    		log.info("NAMECOMPANY :-"+NAMECOMPANY +"COUNTRYINC :-"+COUNTRYINC+"LISTUNLIST :-"+LISTUNLIST+"STOCKEXCH :-"+STOCKEXCH);

	    		/*pStatement = connection.prepareStatement("SELECT TXN_REF_NO FROM STAR_TRANSACTION_DTL WHERE CUST_UID = ?");	
	    		pStatement.setString(1, userData[0]);
	    		rSet=pStatement.executeQuery();	
	    		if(rSet.next())
	    		{
	    			TRREFNO = rSet.getString(1);
	    		}
	    		rSet.close();
	    		pStatement.close();*/
	    		//log.info("add info:"+userData[18]);
	    		
	    		
	    		

	    		/*Add by 2251*/

	    		

	    		
	    		
	    		int recordCount=1; 
	    		int numberOfRecords=1;
	    		String DATALRS="";
	    		String currencyStrategic="INR";//Added by Harshada for Strategic Tieup CR


	    		log.info("LRS DATA With Extra Columns::-"+DATALRS);	    

	    		if(!("".equals(DATALRS)))
	    		{
	    			DATALRS=DATALRS.substring(0, DATALRS.length() - 1);	
	    		}		
	    		//END
	    		if(!((TRREFNO).trim()).equalsIgnoreCase("")){
	    			TRREFNO = "M2WB"+TRREFNO;
	    		}

	    		
	    	
	    			    	
	    // ADDEED BY HARSHADA FOR A2 FORM
	    			
	    		
	    		if ("Schedule II Transaction".equalsIgnoreCase(scheduleIITransaction)) {
	    			checkScheduleTransaction = "Yes";

	    		} else {
	    			checkScheduleTransaction = "No";
	    		}
	    		
	    		
	    		if(!"".equals(l_regulatoryCountryCode) && l_regulatoryCountryCode.contains("|")){
	    			l_regulatoryCountryCode = l_regulatoryCountryCode.split("\\|")[1];
	    		}
	    		
	    		if(("".equalsIgnoreCase(l_txnCCILRefNo) && "N".equalsIgnoreCase(l_slctCCILDeal)) || ("N".equals(bankcustFlag))){
	    			l_txnCCILRefNo="NA";
	    		}
	    		
	    		if("".equalsIgnoreCase(strategicTieupFlag) || strategicTieupFlag == null ){
	    			//added in case of block your rate
	    			fcAmount=currencyAmt + "." + currencyAmtInPaise;
	    			amountInWords=currencyAmtWords + " " + currencyPaiseInWords + " Only ";
	    		}
	    		else{
	    		
	    			if("Y".equalsIgnoreCase(strategicTieupFlag)){
	        			fcAmount="*****";
	        			amountInWords="";
	        			
	        		}
	        		else{
	        			fcAmount=currencyAmt + "." + currencyAmtInPaise;
	        			amountInWords=currencyAmtWords + " " + currencyPaiseInWords + " Only ";
	        		}
	    		}
	    		
	    	
	    		//ended by harshada on 17-june
	    		if("Western Union".equalsIgnoreCase(typeOfReceiver)){
	    			if(!"".equalsIgnoreCase(beneAccountNumber) || beneAccountNumber!=null){
	    				beneAccountNumber="******";

	    			}
	    			if(!"".equalsIgnoreCase(BENEFIACCOUNTMAINTAIN) || BENEFIACCOUNTMAINTAIN!=null){
	    				BENEFIACCOUNTMAINTAIN="******";

	    			}
	    			if(!"".equalsIgnoreCase(SWIFTCODE) || SWIFTCODE!=null){
	    				SWIFTCODE="******";

	    			}
	    			if(!"".equalsIgnoreCase(ROUTINGABABSB) || ROUTINGABABSB!=null){
	    				ROUTINGABABSB="******";

	    			}
	    			if(!"".equalsIgnoreCase(BENEFIADDRESSCOUNTRY) || BENEFIADDRESSCOUNTRY!=null){
	    				BENEFIADDRESSCOUNTRY="******";

	    			}
	    			
	    			if(!"".equalsIgnoreCase(beneFullName) || beneFullName!=null){
	    				beneFullName="******";

	    			}
	    			
	    			if(!"".equalsIgnoreCase(beneAdd) || beneAdd!=null){
	    				beneAdd="******";

	    			}
	    			
	    			if(!"".equalsIgnoreCase(beneCountryName) || beneCountryName!=null){
	    				beneCountryName="******";

	    			}
	    		}
	    		//ended by harshada for a2 form
	    		String RBIFEMALIMITINWORDSTR= "";//convertNumberToWords(RBIFEMALIMIT);
	    		//log.info("convertNumberToWords ::"+RBIFEMALIMIT+"="+convertNumberToWords(250000000));
	    		//BDATE = Utils.formatDate(sysDate,"dd-MM-yyyy");
	    		DynamicXML = "<?xml version='1.0' encoding='UTF-8'?>" + "<DATA>" + "<TRREFNO>" + TRREFNO + "</TRREFNO>"
	    				+ "<ORGBRID>" + ORGBRID + "</ORGBRID>" + "<SCANBRID>" + SCANBRID + "</SCANBRID>" + "<ADCODE>"
	    				+ ADCODE + "</ADCODE>" + "<ADDINFO>" + ADDINFO + "</ADDINFO>" + "<NAMEOFAPPLI>" + remFullName.toUpperCase()
	    				+ "</NAMEOFAPPLI>" + "<ADDRESS>" + remAddress1 + " " + remAddress2 + "</ADDRESS>" + "<APPLIPHNO>"
	    				+ remMobileNumber + "</APPLIPHNO>" + "<PANNO>" + remPanNo.toUpperCase() + "</PANNO>" + "<REMCURRENCY>"
	    				+ REMCURRENCY + "</REMCURRENCY>" + "<FCAMTWORDS>" + FCAMTWORDS + "</FCAMTWORDS>" + "<FCAMTFIG>"
	    				+ FCAMTFIG + "</FCAMTFIG>" + "<REMCURRENCYFOREIN>" + REMCURRENCYFOREIN + "</REMCURRENCYFOREIN>"
	    				+ "<INRAMTWORDS>" + INRAMTWORDS + "</INRAMTWORDS>" + "<INRAMTFIG>" + INRAMTFIG + "</INRAMTFIG>"
	    				+ "<WHTLRS>" + WHTLRS + "</WHTLRS>" + "<PURCODE>" + PURCODE + "</PURCODE>" + "<PURDESC>" + PURDESC
	    				+ "</PURDESC>" + "<ADDPURDETL>" + ADDPURDETL + "</ADDPURDETL>" + "<MAINTENANCE>" + MAINTENANCE
	    				+ "</MAINTENANCE>" + "<PURIMMOPROPERTY>" + PURIMMOPROPERTY + "</PURIMMOPROPERTY>" + "<STUDNAME>"
	    				+ STUDNAME + "</STUDNAME>" + "<STUDID>" + STUDID + "</STUDID>" + "<STUDCOUNTRY>" + STUDCOUNTRY
	    				+ "</STUDCOUNTRY>" + "<AUTHORIZEDEBIT>" + AUTHORIZEDEBIT + "</AUTHORIZEDEBIT>" + "<LIMITCATEGORY>"
	    				+ LIMITCATEGORY + "</LIMITCATEGORY>" + "<BENEFINAME>" + beneFullName + "</BENEFINAME>"
	    				+ "<BENEFIADDRESS>" + beneAdd + " " + beneCountryName + "</BENEFIADDRESS>" + "<BENEFIACCOUNT>"
	    				+ beneAccountNumber + "</BENEFIACCOUNT>" + "<BENEFIACCOUNTMAINTAIN>" + BENEFIACCOUNTMAINTAIN
	    				+ "</BENEFIACCOUNTMAINTAIN>" + "<SWIFTCODE>" + SWIFTCODE + "</SWIFTCODE>" + "<ROUTINGABABSB>"
	    				+ ROUTINGABABSB + "</ROUTINGABABSB>" + "<BENEFIADDRESSCOUNTRY>" + BENEFIADDRESSCOUNTRY
	    				+ "</BENEFIADDRESSCOUNTRY>" + "<BENEFICIARYSWIFTCODE>" + BENEFICIARYSWIFTCODE
	    				+ "</BENEFICIARYSWIFTCODE>" + "<BENEFICIARYBANKNAME>" + BENEFICIARYBANKNAME
	    				+ "</BENEFICIARYBANKNAME>" + "<PRINTADDINFO>" + PRINTADDINFO + "</PRINTADDINFO>" + "<SOURCEFUND>"
	    				+ SOURCEFUND + "</SOURCEFUND>" + "<BMAKERNAME>" + BMAKERNAME + "</BMAKERNAME>" + "<BMAKEREMPNO>"
	    				+ BMAKEREMPNO + "</BMAKEREMPNO>" + "<BCHECKERNAME>" + BRCID + "</BCHECKERNAME>" + "<BCHECKERNO>"
	    				+ BRCIDNO + "</BCHECKERNO>" + "<BVARIFIERNAME>" + BVARIFIERNAME + "</BVARIFIERNAME>"
	    				+ "<BVARIFIEREMPNO>" + BVARIFIEREMPNO + "</BVARIFIEREMPNO>" + "<BDATE>" + BDATE + "</BDATE>"
	    				+ "<BPLACE>" + BPLACE + "</BPLACE>" + "<PRINTCUSTNAME>" + remFullName + "</PRINTCUSTNAME>"
	    				+ "<PRINTIDPROOFNAME>" + PRINTIDPROOFNAME + "</PRINTIDPROOFNAME>" + "<PRINTIDPROOFNO>"
	    				+ PRINTIDPROOFNO + "</PRINTIDPROOFNO>" + "<PRINTADDRESSNAME>" + PRINTADDRESSNAME
	    				+ "</PRINTADDRESSNAME>" + "<PRINTADDRESSNO>" + PRINTADDRESSNO + "</PRINTADDRESSNO>" + "<LRS>"
	    				+ LRSNONLRS + "</LRS>" + "<PURCODE>" + PURCODE + "</PURCODE>" + "<REMSELECTCURRENCY>" + inrCurrency
	    				+ "</REMSELECTCURRENCY>" + "<AMTWORDS>" + amountInWords
	    				+ "</AMTWORDS>" + "<AMTFIG>" +fcAmount + "</AMTFIG>" + "<EMPTY>"
	    				+ EMPTY + "</EMPTY>" + "<NAMECOMPANY>" + NAMECOMPANY + "</NAMECOMPANY>" + "<COUNTRYINC>"
	    				+ COUNTRYINC + "</COUNTRYINC>" + "<LISTUNLIST>" + LISTUNLIST + "</LISTUNLIST>" + "<STOCKEXCH>"
	    				+ STOCKEXCH + "</STOCKEXCH>" + "<RELATIONSHIP>" + RELATIONSHIP + "</RELATIONSHIP>" + "<TYPECOMPANY>"
	    				+ TYPECOMPANY + "</TYPECOMPANY>" + "<NUMBEROF>" + NUMBEROF + "</NUMBEROF>" + "<PERCENTAGEOF>"
	    				+ PERCENTAGEOF + "</PERCENTAGEOF>" + "<CORRSWIFTCODE>" + CORRSWIFTCODE + "</CORRSWIFTCODE>"
	    				+ "<CORRBANKNAME>" + CORRBANKNAME + "</CORRBANKNAME>" + "<TXNMODENRO>" + TXNMODENRO
	    				+ "</TXNMODENRO>" + "<TXNMODETT>" + TXNMODETT + "</TXNMODETT>" + "<TXNMODEDD>" + TXNMODEDD
	    				+ "</TXNMODEDD>" + "<SELECTCURRENCY>" + SELECTCURRENCY + "</SELECTCURRENCY>" + "<ADDINFOFIRST>"
	    				+ ADDINFOFIRST + "</ADDINFOFIRST>" + "<PURPOSECODE>" + PURPOSECODE + "</PURPOSECODE>"
	    				+ "<RBIFEMALIMIT>" + RBIFEMALIMIT + "</RBIFEMALIMIT>" + "<RBIFEMALIMITINWORD>"
	    				+ RBIFEMALIMITINWORDSTR + "</RBIFEMALIMITINWORD>" + "<SN1>" + DATALRS + "</SN1>" + "<DESIREDRATE>"
	    				+ DESIREDRATE + "</DESIREDRATE>" + "<REGAPPREFNO>" + regulatoryAppRefNumber + "</REGAPPREFNO>"
	    				+ "<SCHEDULEIITXN>" + checkScheduleTransaction + "</SCHEDULEIITXN>" + "<STAFFCASE>" + staffCase
	    				+ "</STAFFCASE>" + "<TACASE>" + taCase + "</TACASE>" + "<EMPID>" + empId + "</EMPID>" + "<TA>" + ta
	    				+ "</TA>" + "<COMPANYPOINT>" + companypoint + "</COMPANYPOINT>" + "<DINNUMBER>" + dinNumber
	    				+ "</DINNUMBER>" + "<REMOCCUPATION>" + remitterOccupation + "</REMOCCUPATION>" + "<SECDINNO>"
	    				+ secDinNumber + "</SECDINNO>" + "<SECDINOCCUPATION>" + secDinOccupation + "</SECDINOCCUPATION>"
	    				+ "<REQUIREDANNEXURE>" + requiredAnnexure + "</REQUIREDANNEXURE>" + "<REFNUMBER>" + refNumber
	    				+ "</REFNUMBER>" + "<INRAMOUNT>" + inrAmount + "</INRAMOUNT>" + "<SRVC_CNTRY_NAME>" + l_regulatoryCountryCode + "</SRVC_CNTRY_NAME>"+
	    				"<CCIL_REFERENCE_NUMBER>" + l_txnCCILRefNo + "</CCIL_REFERENCE_NUMBER>"+"</DATA>";

	    		// ADDEED BY HARSHADA FOR A2 FORM

	    	}catch(Exception e)
	    	{
	    		log.info("Exception :",e);
	    	}finally {
	    		try {
	    			
	    		}catch (Exception e) {
	    			log.error(e);
	    		}

	    	}
	    	//log.info("DynamicXML : "+DynamicXML);
	    	return DynamicXML;
	    }
	
	

}
