package com.edutech.patientDetail.dao;

import java.util.List;
import java.util.Map;

import com.edutech.patientDetail.model.PatientDetail;



public interface PatientDetailDao 
{
	public Map<String, String> Save(PatientDetail patientDetail);
	public List<PatientDetail> Search();
	public String generateTransactionPDF(String p_data, String pdfype);

}
