

// File generated by OpenXava: Wed Feb 24 12:06:10 CET 2016
// Archivo generado por OpenXava: Wed Feb 24 12:06:10 CET 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Task		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ITask  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_summary = "summary"; 
	java.lang.String getSummary() throws RemoteException;
	void setSummary(java.lang.String summary) throws RemoteException; 	
	public static final String PROPERTY_middleName = "middleName"; 
	String getMiddleName() throws RemoteException;
	void setMiddleName(String middleName) throws RemoteException; 	
	public static final String PROPERTY_userFamilyName = "userFamilyName"; 
	String getUserFamilyName() throws RemoteException;
	void setUserFamilyName(String userFamilyName) throws RemoteException; 	
	public static final String PROPERTY_userGivenName = "userGivenName"; 
	String getUserGivenName() throws RemoteException;
	void setUserGivenName(String userGivenName) throws RemoteException; 	
	public static final String PROPERTY_birthDateMonth = "birthDateMonth"; 
	int getBirthDateMonth() throws RemoteException;
	void setBirthDateMonth(int birthDateMonth) throws RemoteException; 	
	public static final String PROPERTY_date = "date"; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException; 	
	public static final String PROPERTY_birthDateYear = "birthDateYear"; 
	int getBirthDateYear() throws RemoteException;
	void setBirthDateYear(int birthDateYear) throws RemoteException; 	
	public static final String PROPERTY_nickName = "nickName"; 
	String getNickName() throws RemoteException;
	void setNickName(String nickName) throws RemoteException; 	
	public static final String PROPERTY_oid = "oid"; 	
	String getOid() throws RemoteException; 	
	public static final String PROPERTY_userEMail = "userEMail"; 
	String getUserEMail() throws RemoteException;
	void setUserEMail(String userEMail) throws RemoteException; 	
	public static final String PROPERTY_user = "user"; 
	String getUser() throws RemoteException;
	void setUser(String user) throws RemoteException; 	
	public static final String PROPERTY_birthDateDay = "birthDateDay"; 
	int getBirthDateDay() throws RemoteException;
	void setBirthDateDay(int birthDateDay) throws RemoteException; 	
	public static final String PROPERTY_comments = "comments"; 
	java.lang.String getComments() throws RemoteException;
	void setComments(java.lang.String comments) throws RemoteException; 	
	public static final String PROPERTY_jobTitle = "jobTitle"; 
	String getJobTitle() throws RemoteException;
	void setJobTitle(String jobTitle) throws RemoteException;		

	// References/Referencias

	// Methods 


}