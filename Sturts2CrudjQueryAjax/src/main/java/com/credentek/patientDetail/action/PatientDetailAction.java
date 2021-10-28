package com.credentek.patientDetail.action;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.credentek.patientDetail.dao.PatientDetailDao;
import com.credentek.patientDetail.dao.PatientDetailDaoImpl;
import com.credentek.patientDetail.model.PatientDetail;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.opensymphony.xwork2.ActionSupport;

public class PatientDetailAction extends ActionSupport implements SessionAware 
{

	protected static Logger log = Logger.getLogger(PatientDetailAction.class);
	private Map<String, String> message ;
	private PatientDetail patientDetail;
	private List<PatientDetail> patientDetailList;
	private PatientDetailDao patientDetailDao = new PatientDetailDaoImpl();
	private String ajaxData;
	private String ajaxXmlData;
	
	private String fileName;
	private long contentLength;
	private FileInputStream fileInputStream;
	
	
    public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public String data() {

		return SUCCESS;
		
	}
    
    public String search() 
	{
    	log.info("Inside search of PatientDetailAction ");
    	//message = patientDetailDao.Save(patientDetail);
    	
    	message.put("success", "Record Saved Successfully");
    	
    	
    	return SUCCESS;
	}
    
    public String save() 
	{
    	log.info("Inside save of PatientDetailAction "+patientDetail.getAge()+" "+patientDetail.getName());
    	message = patientDetailDao.Save(patientDetail);
    	//message.put("success", "Record Saved Successfully");
    	return "success";
	}
    
    
    public String txnPrintForm()
	{
		//CBPPC_PRINTFORM_PATH = "D:\Ram\STAR\PrintForm\"
    	String path = "D://Ram//STAR//PrintForm";
		fileName="GaikwadHorticulture";
		String pdfString=patientDetailDao.generateTransactionPDF(ajaxXmlData, "");
		String response1=GeneratePDF("", pdfString,path+"//"+fileName+".pdf");
		if("SUCCESS".equals(response1)){
			try
			{
			//	File file=new File(pathReadObj.getPath("printFormPath")+"/"+fileName+".pdf");
				
				log.info(path);
				File file=new File(path+"//"+fileName+".pdf");
				fileInputStream = new FileInputStream(file);
				fileName = file.getName();
				contentLength = file.length();
			}catch(Exception e){
				log.info(e);
			}
		}
		
		return SUCCESS;
	}
    
    public static String GeneratePDF(String header, String resultStr, String path) {
		ByteArrayOutputStream pdfBytesStream = null; 
  	  	try {
  	  		
  	  		String footer = "";//"Printed by : "+bankApps+", On : " + Utils.formatDate(new Date(), dateFormat);
  	  		File newFile = new File(path);
  	  		resultStr=resultStr.replaceAll("<br>", "<br></br>");
			OutputStream file = new FileOutputStream(newFile);
			pdfBytesStream = CreatePDFStream("", header, resultStr, footer,"");
			byte[] bytes = pdfBytesStream.toByteArray();
			file.write(bytes);
			file.close();
  		} catch (Exception e) {
  			//log.error("file creation failed: "+e);
  			log.info(e);
  			return "FAIL";
  		}
  		return "SUCCESS";
	}
    
    
    public static ByteArrayOutputStream CreatePDFStream(String custName, String header, String htmlIn, String footer, String orientation) {
		StringBuffer htmlstringbuf = new StringBuffer();
		ByteArrayOutputStream pdffinalos = new ByteArrayOutputStream();
		htmlstringbuf.append(htmlIn.toString());		
		int screenWidth = 800;
		int screenHeight = 600;		
		String imageName = "";   
		//String pdfLogo = com.credentek.morpho.common.util.ParameterMaster.parameterMstMap.get("PDF_LOGO");
		String pdfLogo = "";
		//String htmlstring="<body><head><style language='text/css'>@page{margin-top:3.7cm;margin-left:1.0cm;margin-right:1.0cm;margin-bottom:1.5cm;@bottom-center{ content: 'Page ' counter(page) ' of ' counter(pages); font:10px Zurich BT, Helvetica, sans-serif;}}@page:first {margin-top: 3.7cm;}body{font-family:              arial;font-size: 8pt;padding:0;margin:0;}@page land { size:landscape; } @page port { size:portrait; } .landscapePage { page:land; } .portraitPage { page:port; } table { -fs-table-paginate: paginate;}table.viewTableClass {font-family:arial;background-color: gray;font-size: 8pt;border: 1px solid black;} table.viewTableClass thead tr.heading th {background-color: #cb842e;border: 1px solid #FFF;font-size: 7pt;padding: 4px;text-align: center;page-break-inside: avoid;} table.viewTableClass thead tr th {background: url("+ directory +"/images/AGS_NEW.png) 50% 50% repeat-x;font-size: 7pt;padding: 4px;text-align: center;page-break-inside: avoid;color: #FFFFFF;} table.viewTableClass tfoot tr td {background-color: #3a8104;border: 1px solid #FFF;font-size: 7pt;padding: 4px;text-align: center;color: #FFFFFF;} table.viewTableClass tfoot tr.summary td {text-align: right;}table.viewTableClass thead tr.headerClass th {background-color: #cb842e;border: 1px solid #FFF;font-size: 8pt;padding: 4px;text-align: center;color: #FFFFFF;page-break-inside: avoid;}table.viewTableClass thead tr.openClosePos th {background-color: #cb842e;border: 1px solid #FFF;font-size: 7pt;padding: 4px;text-align: center;color: #FFFFFF;}table.viewTableClass thead tr.summary th {background-color: #cb842e;border: 1px solid #FFF;font-size: 7pt;padding: 2px;text-align: right;}table.viewTableClass thead tr .header {	background-image: url(bg.gif);background-repeat: no-repeat;background-position: center right;cursor: pointer;}table.viewTableClass tbody tr.cashload td {background-color: #FCDFDF;text-align: center;}table.viewTableClass tbody tr.summary td {text-align: right;}table.viewTableClass tbody tr.matc td {background-color: #FFFFFF;text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.left {background-color: #FFFFFF;text-align: left;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc1 td {background-color: #FFFFFF;text-align: left;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.olive {color: #000000;background-color: #FACC2E;text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.black {color: #FFF;background-color: black;text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.yellow {background-color: #F3F781;text-align: right;font-weight: bold;color: #FFF;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.red {font-family:arial;font-size: 7pt;color: #FFF;	background-color: red;	text-align: right;font-weight: bold;}table.viewTableClass tbody tr.matc td.green {color: #FFF;background-color: green;text-align: right;font-weight: bold;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.pink {color: black;background-color: pink;text-align: center;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.violet {background-color: #FDB8C3;text-align: right;color : black;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.nocolor {text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.matc td.acDtl {text-align: right;font-family:arial;font-size: 6pt;}table.viewTableClass tbody tr.matc td.hidden {display:none;width: 0;}table.viewTableClass tbody tr.matc td.res_yw {background-color: #FFFF00;text-align: right;font-weight: bold;color: #000;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td {background-color: #E3E8FA;text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass thead tr.headerClass th.green {background-color: #EBFFEB;border: 1px solid #FFF;font-size: 7pt;padding: 4px;color: black;text-align: center;}table.viewTableClass thead tr.headerClass th.pink {background-color: #FFF2E5;border: 1px solid #FFF;font-size: 7pt;padding: 4px;color: black;text-align: center;}table.viewTableClass thead tr.headerClass th.mehandi {background-color: #948B54;border: 1px solid #FFF;font-size: 7pt;padding: 4px;color: #FFF;text-align: center;}table.viewTableClass thead tr.headerClass th.yellow {background-color: #D2E0B2;border: 1px solid #FFF;	font-size: 7pt;	padding: 4px;color: black;text-align: center;}table.viewTableClass thead tr.headerSection th.green {background-color: #003A00;border: 1px solid #FFF;font-size: 7pt;padding: 4px;color: #FFF;text-align: center;}table.viewTableClass thead tr.headerSection th.brown {background-color: #603000;border: 1px solid #FFF;	font-size: 7pt;	padding: 4px;color: #FFF;text-align: center;}table.viewTableClass thead tr.headerSection th.mehandi {background-color: #948B54;border: 1px solid #FFF;font-size: 7pt;padding: 4px;color: #FFF;text-align: center;}table.viewTableClass tbody tr.matched {text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.unmatched {text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody td {padding: 4px;background-color: #FFF;	cursor: pointer;}table.viewTableClass tbody tr.pend td.blue {color: #FFF;background-color: #FFF;text-align: right;font-weight: bold;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.olive {color: #000000;background-color: #FACC2E;text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.black {color: #FFF;background-color: black;text-align: right;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.yellow {background-color: #F3F781;text-align: right;font-weight: bold;color: #FFF;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.red {color: #FFF;background-color: red;text-align: right;font-weight: bold;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.green {color: #FFF;background-color: green;text-align: right;font-weight: bold;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.pink {color: black;background-color: pink;text-align: center;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.violet {background-color: #FDB8C3;text-align: right;color : black;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr.pend td.nocolor {text-align: right;font-family:arial;font-size: 7pt;} table.viewTableClass tbody tr.pend td.hidden {display:none;width: 0;}table.viewTableClass tbody tr.pend td.res_yw {background-color: #FFFF00;text-align: right;font-weight: bold;color: #000;font-family:arial;font-size: 7pt;}table.viewTableClass tbody tr td.cnt {text-align: right;background: #D6D6C2;-moz-box-shadow:inset 0px 8px 1px rgba(255,255,255,.5);-webkit-box-shadow: inset 0px 8px 1px rgba(255,255,255,.5); box-shadow:inset 0px 8px 1px rgba(255,255,255,.5);} .heading{ font-family: arial; background-color:#fff; font-size: 8pt;font-weight: bold;color: black;margin: 0px;padding: 0px;height: 20px;}table.endTableClass thead tr td{text-align: center;font-family:arial;font-size: 7pt;}table.reportTableClass {font-family: arial;background-color: gray;font-size: 8pt;border: 1px solid black;}table.reportTableClass thead tr.heading th {background-color: #fff;border: 1px solid #FFF;font-size: 8pt;padding: 6px;text-align: left;page-break-inside: avoid;}table.reportTableClass thead tr th {background-color: #cb842e;border: 1px solid #FFF;font-size: 7pt;padding: 4px;text-align: center;page-break-inside: avoid;}table.reportTableClass tbody tr.matc td {background-color: #FFFFFF;text-align: left;font-family: arial;font-size: 7pt;}table.reportTableClass tbody tr.matc td.nu {background-color: #FFFFFF;text-align: right;font-family: arial;font-size: 7pt;}</style></head>"
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String directory = request.getSession().getServletContext().getRealPath("");
			 imageName = directory + "/"+pdfLogo;
			
			String htmlstring = "<body><head><style language='text/css'>@page{margin-top:2.6cm;margin-left:1.0cm;margin-right:1.0cm;margin-bottom:1.5cm;@bottom-center{ content: 'Page ' counter(page) ' of ' counter(pages); font:10px Zurich BT, Helvetica, sans-serif;}}@page:first {margin-top: 2.6cm;}body{font-family:Zurich BT, Helvetica;font-size:8pt;padding:0;margin:0;}@page land { size:landscape; } @page port { size:portrait; } .landscapePage { page:land; } .portraitPage { page:port; } table { -fs-table-paginate: paginate;}table.viewTableClass {border-collapse:collapse;} table.viewTableClass,.viewTableClass th,.viewTableClass td{border:1px solid black;page-break-inside: avoid;} ul { margin-left: 20px; list-style-position: outside; } .index{ color:white;background:#990000;font-weight:bold} .tabHeading{color:#990000;} .menuFields{background:#FFFAF0;font-weight:bold;}ul li { padding-left: 35px; } .reportfont{font-family:Zurich Blk BT; font:11pt; font-weight: bold;}.reportfontsize{font-family:Zurich Blk BT; font:12pt; color: #000;background-color: white; font-weight: bold;} .justifyCheck:after{content: ''; display: inline-block; }"
					+".showDtlTable {margin-left: auto;	margin-right: auto;	background-color: gray;}.showDtlTable thead tr {background-color: white; font-size: 13px;page-break-inside: avoid;}.showDtlTable thead tr th.hideTD{display: none;page-break-inside: avoid;}.showDtlTable tbody tr.odd {	margin-left: auto;	margin-right: auto;	background-color: #FFFFFF;page-break-inside: avoid;} .showDtlTable tbody tr.even {margin-left: auto;	margin-right: auto;	background-color: #A0DAFF;page-break-inside: avoid;}.showDtlTable tbody tr {	margin-left: auto;	margin-right: auto;	background-color: #FFF;page-break-inside: avoid;}.showDtlTable tbody tr.odd td, tr.even td {	text-align: right;page-break-inside: avoid;}.showDtlTable tbody tr.odd td.left, tr.even td.left {text-align: left;page-break-inside: avoid;} .showDtlTable tbody tr.odd td.hideTD, tr.even td.hideTD{	display: none;page-break-inside: avoid;}  </style></head>"
					+"<img src='"+imageName+"' alt='ICICILOGO' > </img>"
		+ htmlstringbuf
				.toString()						
				.replaceAll("&nbsp;","  ")
				.replaceAll("&", "&amp;")
				.replaceAll("null", " ")
				.replaceAll("�","�")
				.replaceAll(
						"<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>",
						" ")
				.replaceAll("Â", "<br></br>")
				.replaceAll(
						"<\\?xml version = '1.0' encoding = 'UTF-8'\\?>",
						" ") + "</body>";
			
			
			ByteArrayOutputStream pdfos = new ByteArrayOutputStream();
			ITextRenderer renderer = new ITextRenderer();
			renderer.getFontResolver().addFontDirectory(directory + "/fonts",BaseFont.EMBEDDED);
			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,BaseFont.WINANSI, BaseFont.EMBEDDED);
			
			renderer.setDocumentFromString(htmlstring);
			renderer.layout();
			renderer.createPDF(pdfos);
			PdfReader reader = new PdfReader(new ByteArrayInputStream(pdfos.toByteArray()));
			PdfStamper stamper = new PdfStamper(reader, pdffinalos);
			PdfContentByte over;
			try
            {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
                screenWidth = (int) screenSize.getWidth();
                screenHeight = (int) screenSize.getHeight();
            }
            catch (Exception e)
            {

            }
           
			//log.info("screenWidth : " + screenWidth);
			//log.info("screenHeight : " + screenHeight);
            int ximg1 = 0;
            int yimg1 = 0;
            int ximg2 = 0;
            int yimg2 = 0;
            int yPointHeader = 0;
            int headerCenterPt = 0;
           
            int imgPosY = screenHeight - 10;         
            int headerPosY = screenHeight - 10;      
           
            if(screenHeight >= 500 && screenHeight < 768)
            {
                imgPosY = screenHeight + 145;
                headerPosY = screenHeight + 190;               
            }
            else if(screenHeight >= 768 && screenHeight < 900)
            {
                imgPosY = screenHeight - 55;
                headerPosY = screenHeight - 20;
            }
            else if(screenHeight >= 900 && screenHeight < 1000)
            {
                imgPosY = screenHeight - 155;
                headerPosY = screenHeight - 110;
            }
            else if(screenHeight >= 1000)
            {
                imgPosY = screenHeight - 295;
                headerPosY = screenHeight - 250;
            }
           
            
            if(orientation.equals("landscape"))
            {
                ximg1 = 30;
                yimg1 = 500;
                ximg2 = 670;
                yimg2 = 500;
                yPointHeader = 545;
                headerCenterPt = 400;
            }
            else
            {
                ximg1 = 30;
                ximg2 = 440;
                headerCenterPt = 350;
                yimg1 = imgPosY - 250;
                yimg2 = imgPosY;
                yPointHeader = imgPosY;
            }
           // log.info("yPointHeader : " + yPointHeader);
            //log.info("imgPosY : " + imgPosY);
            //log.info("headerPosY : " + headerPosY);
           
            
            over = stamper.getUnderContent(1);
           
            over.beginText();
            over.setFontAndSize(bf, 9);
            header = "KJ~HJKBJK~BJKB~JB~BJ~BJ~BJ~BJB~JBJ~BJ~BJV~HVH~VH~VH~VH~VHV~H~VH";
            String [] headerArray = header.split("~");
           
            int yPoint = yPointHeader - 220;
            for(int i = 0; i < headerArray.length; i++)
            {
                over.showTextAligned(PdfContentByte.ALIGN_CENTER, header, headerCenterPt, yPoint, 0);
                over.setFontAndSize(bf, 18);
                yPoint -= 15;
                over.newlineText();
            }
           
            over.showTextAligned(PdfContentByte.ALIGN_LEFT, custName, 45,720, 0);
            over.setFontAndSize(bf, 7);
            over.showTextAligned(PdfContentByte.ALIGN_LEFT, footer, 28,30, 0);
            over.endText();
           
            int total = reader.getNumberOfPages() + 1;

            for (int i = 2; i < total; i++)
            {
                over = stamper.getUnderContent(i);
                over.beginText();
                over.setFontAndSize(bf, 9);
                yPoint = yPointHeader;
                for(int j = 0; j < headerArray.length; j++)
                {
                    over.showTextAligned(PdfContentByte.ALIGN_CENTER, headerArray[j], headerCenterPt, yPoint, 0);
                    yPoint -= 15;
                    over.newlineText();
                }
                over.showTextAligned(PdfContentByte.ALIGN_LEFT, custName, 45,720, 0);
                over.setFontAndSize(bf, 7);
                over.showTextAligned(PdfContentByte.ALIGN_LEFT, footer, 28,30, 0);
                over.endText();
            }
            stamper.close();
            pdfos.close();
		} 
		catch (Exception e) 
		{

		}	
		return pdffinalos;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public PatientDetail getPatientDetail() {
		return patientDetail;
	}

	public void setPatientDetail(PatientDetail patientDetail) {
		this.patientDetail = patientDetail;
	}

	public PatientDetailDao getPatientDetailDao() {
		return patientDetailDao;
	}

	public void setPatientDetailDao(PatientDetailDao patientDetailDao) {
		this.patientDetailDao = patientDetailDao;
	}

	public String getAjaxData() {
		return ajaxData;
	}

	public void setAjaxData(String ajaxData) {
		this.ajaxData = ajaxData;
	}

	public String getAjaxXmlData() {
		return ajaxXmlData;
	}

	public void setAjaxXmlData(String ajaxXmlData) {
		this.ajaxXmlData = ajaxXmlData;
	}

}
