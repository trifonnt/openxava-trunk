

// File generated by OpenXava: Mon May 09 13:02:16 CEST 2016
// Archivo generado por OpenXava: Mon May 09 13:02:16 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Worker		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IWorker  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_id = "id"; 	
	Integer getId() throws RemoteException; 	
	public static final String PROPERTY_nickName = "nickName"; 
	String getNickName() throws RemoteException;
	void setNickName(String nickName) throws RemoteException; 	
	public static final String PROPERTY_fullName = "fullName"; 
	String getFullName() throws RemoteException;
	void setFullName(String fullName) throws RemoteException;		

	// References/Referencias

	// Methods 


}