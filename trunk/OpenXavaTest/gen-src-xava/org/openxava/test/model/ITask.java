

// File generated by OpenXava: Tue Apr 21 11:03:48 CEST 2009
// Archivo generado por OpenXava: Tue Apr 21 11:03:48 CEST 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Task		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ITask  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_comments = "comments"; 
	java.lang.String getComments() throws RemoteException;
	void setComments(java.lang.String comments) throws RemoteException; 	
	public static final String PROPERTY_summary = "summary"; 
	java.lang.String getSummary() throws RemoteException;
	void setSummary(java.lang.String summary) throws RemoteException; 	
	public static final String PROPERTY_user = "user"; 
	String getUser() throws RemoteException;
	void setUser(String user) throws RemoteException; 	
	public static final String PROPERTY_userFamilyName = "userFamilyName"; 
	String getUserFamilyName() throws RemoteException;
	void setUserFamilyName(String userFamilyName) throws RemoteException; 	
	public static final String PROPERTY_oid = "oid"; 	
	String getOid() throws RemoteException; 	
	public static final String PROPERTY_userGivenName = "userGivenName"; 
	String getUserGivenName() throws RemoteException;
	void setUserGivenName(String userGivenName) throws RemoteException; 	
	public static final String PROPERTY_date = "date"; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException; 	
	public static final String PROPERTY_userEMail = "userEMail"; 
	String getUserEMail() throws RemoteException;
	void setUserEMail(String userEMail) throws RemoteException;		

	// References/Referencias

	// Methods 


}