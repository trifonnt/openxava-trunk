

// File generated by OpenXava: Mon Mar 27 13:42:01 CEST 2006
// Archivo generado por OpenXava: Mon Mar 27 13:42:01 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Task		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ITask  extends org.openxava.model.IModel {	

	// Properties/Propiedades 
	java.lang.String getComments() throws RemoteException;
	void setComments(java.lang.String comments) throws RemoteException; 
	java.lang.String getSummary() throws RemoteException;
	void setSummary(java.lang.String summary) throws RemoteException; 
	String getUser() throws RemoteException;
	void setUser(String user) throws RemoteException; 	
	String getOid() throws RemoteException; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException;		

	// References/Referencias

	// Methods 


}