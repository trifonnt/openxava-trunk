

// File generated by OpenXava: Thu Mar 10 18:03:52 CET 2005
// Archivo generado por OpenXava: Thu Mar 10 18:03:52 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Service		Java interface for aggregate/Interfaz java para Agregado: AdditionalDetail

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface IAdditionalDetail {	

	// Properties/Propiedades 	
	int getCounter() throws RemoteException; 
	int getSubfamily() throws RemoteException;
	void setSubfamily(int Subfamily) throws RemoteException;		

	// References/Referencias 

	// Service : Reference/Referencia
	
	org.openxava.test.ejb.Service getService() throws RemoteException;
	void setService(org.openxava.test.ejb.Service newService) throws RemoteException;
	
	org.openxava.test.ejb.ServiceKey getServiceKey() throws RemoteException;
	void setServiceKey(org.openxava.test.ejb.ServiceKey key) throws RemoteException; 

	// Type : Reference/Referencia
	
	org.openxava.test.ejb.ServiceType getType() throws RemoteException;
	void setType(org.openxava.test.ejb.ServiceType newType) throws RemoteException;
	
	org.openxava.test.ejb.ServiceTypeKey getTypeKey() throws RemoteException;
	void setTypeKey(org.openxava.test.ejb.ServiceTypeKey key) throws RemoteException;

	// Methods 


}