

// File generated by OpenXava: Wed Mar 14 19:23:18 CET 2007
// Archivo generado por OpenXava: Wed Mar 14 19:23:18 CET 2007

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Service		Java interface for aggregate/Interfaz java para Agregado: AdditionalDetail

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IAdditionalDetail  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	int getCounter() throws RemoteException; 
	int getSubfamily() throws RemoteException;
	void setSubfamily(int subfamily) throws RemoteException;		

	// References/Referencias 

	// Service : Reference/Referencia
	
	org.openxava.test.model.IService getService() throws RemoteException;
	void setService(org.openxava.test.model.IService newService) throws RemoteException; 

	// Type : Reference/Referencia
	
	org.openxava.test.model.IServiceType getType() throws RemoteException;
	void setType(org.openxava.test.model.IServiceType newType) throws RemoteException;

	// Methods 


}