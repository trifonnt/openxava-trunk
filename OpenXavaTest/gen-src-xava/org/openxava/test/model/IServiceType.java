

// File generated by OpenXava: Fri Mar 10 17:46:40 CET 2006
// Archivo generado por OpenXava: Fri Mar 10 17:46:40 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: ServiceType		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IServiceType  extends org.openxava.model.IModel {	

	// Properties/Propiedades 
	int getFamily() throws RemoteException;
	void setFamily(int family) throws RemoteException; 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 
	int getSubfamily() throws RemoteException;
	void setSubfamily(int subfamily) throws RemoteException; 	
	int getNumber() throws RemoteException;		

	// References/Referencias

	// Methods 


}