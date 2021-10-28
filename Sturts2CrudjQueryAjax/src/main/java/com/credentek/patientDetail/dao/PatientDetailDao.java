package com.credentek.patientDetail.dao;

import java.util.List;
import java.util.Map;

import com.credentek.patientDetail.model.PatientDetail;



public interface PatientDetailDao 
{
	public Map<String, String> Save(PatientDetail patientDetail);
	public List<PatientDetail> Search();
	public String generateTransactionPDF(String p_data, String pdfype);

}
