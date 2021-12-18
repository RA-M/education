package com.edutech.patientDetail.model;

import java.sql.Date;

public class PatientDetail 
{
	private String name;
	private String mobileNumber;
	private String policeBakalNumber;
	private String age;
	private Date isolationDate;
	private Date firstTestResultDate;
	private String testResult;
	private String hospitalName;
	private Date oxygenStartDate;
	private Date oxygenEndDate;
	private Date ventilatorStartDate;
	private Date ventilatorEndDate;
	private String arsenicTaken;
	private String bloodGroup;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPoliceBakalNumber() {
		return policeBakalNumber;
	}
	public void setPoliceBakalNumber(String policeBakalNumber) {
		this.policeBakalNumber = policeBakalNumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getIsolationDate() {
		return isolationDate;
	}
	public void setIsolationDate(Date isolationDate) {
		this.isolationDate = isolationDate;
	}
	public Date getFirstTestResultDate() {
		return firstTestResultDate;
	}
	public void setFirstTestResultDate(Date firstTestResultDate) {
		this.firstTestResultDate = firstTestResultDate;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Date getOxygenStartDate() {
		return oxygenStartDate;
	}
	public void setOxygenStartDate(Date oxygenStartDate) {
		this.oxygenStartDate = oxygenStartDate;
	}
	public Date getOxygenEndDate() {
		return oxygenEndDate;
	}
	public void setOxygenEndDate(Date oxygenEndDate) {
		this.oxygenEndDate = oxygenEndDate;
	}
	public Date getVentilatorStartDate() {
		return ventilatorStartDate;
	}
	public void setVentilatorStartDate(Date ventilatorStartDate) {
		this.ventilatorStartDate = ventilatorStartDate;
	}
	public Date getVentilatorEndDate() {
		return ventilatorEndDate;
	}
	public void setVentilatorEndDate(Date ventilatorEndDate) {
		this.ventilatorEndDate = ventilatorEndDate;
	}
	public String getArsenicTaken() {
		return arsenicTaken;
	}
	public void setArsenicTaken(String arsenicTaken) {
		this.arsenicTaken = arsenicTaken;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
}
