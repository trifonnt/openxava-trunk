

// File generated by OpenXava: Mon May 24 17:50:54 CEST 2010
// Archivo generado por OpenXava: Mon May 24 17:50:54 CEST 2010

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Issue		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IIssue  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_description = "description"; 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 	
	public static final String PROPERTY_id = "id"; 	
	String getId() throws RemoteException;	

	java.util.Collection getComments() throws RemoteException;		

	// References/Referencias 

	// Worker : Reference/Referencia
	
	org.openxava.test.model.IWorker getWorker() throws RemoteException;
	void setWorker(org.openxava.test.model.IWorker newWorker) throws RemoteException;

	// Methods 


}