

// File generated by OpenXava: Fri Feb 20 17:12:33 CET 2009
// Archivo generado por OpenXava: Fri Feb 20 17:12:33 CET 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Issue		Java interface for aggregate/Interfaz java para Agregado: Comment

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IComment  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_comment = "comment"; 
	java.lang.String getComment() throws RemoteException;
	void setComment(java.lang.String comment) throws RemoteException; 	
	public static final String PROPERTY_date = "date"; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException; 	
	public static final String PROPERTY_id = "id"; 	
	Integer getId() throws RemoteException;		

	// References/Referencias 

	// Issue : Reference/Referencia
	
	org.openxava.test.model.IIssue getIssue() throws RemoteException;
	void setIssue(org.openxava.test.model.IIssue newIssue) throws RemoteException;

	// Methods 


}