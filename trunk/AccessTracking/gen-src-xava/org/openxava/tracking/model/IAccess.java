

// File generated by OpenXava: Thu Jun 29 12:31:01 CEST 2006
// Archivo generado por OpenXava: Thu Jun 29 12:31:01 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Access		Java interface for entity/Interfaz java para Entidad

package org.openxava.tracking.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IAccess  extends org.openxava.model.IModel {	

	// Properties/Propiedades 
	String getTable() throws RemoteException;
	void setTable(String table) throws RemoteException; 
	String getUser() throws RemoteException;
	void setUser(String user) throws RemoteException; 
	String getRecordId() throws RemoteException;
	void setRecordId(String recordId) throws RemoteException; 
	boolean isAuthorized() throws RemoteException;
	void setAuthorized(boolean authorized) throws RemoteException; 
	int getType() throws RemoteException;
	void setType(int type) throws RemoteException; 
	String getTime() throws RemoteException;
	void setTime(String time) throws RemoteException; 	
	int getOid() throws RemoteException; 
	String getModel() throws RemoteException;
	void setModel(String model) throws RemoteException; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException; 
	String getApplication() throws RemoteException;
	void setApplication(String application) throws RemoteException;		

	// References/Referencias

	// Methods 


}