

// File generated by OpenXava: Fri Apr 22 11:48:17 CEST 2005
// Archivo generado por OpenXava: Fri Apr 22 11:48:17 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Delivery		Java interface for aggregate/Interfaz java para Agregado: DeliveryDetail

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface IDeliveryDetail  {	

	// Properties/Propiedades 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 	
	int getNumber() throws RemoteException;		

	// References/Referencias 

	// Delivery : Reference/Referencia
	
	org.openxava.test.ejb.Delivery getDelivery() throws RemoteException;
	void setDelivery(org.openxava.test.ejb.Delivery newDelivery) throws RemoteException;
	
	org.openxava.test.ejb.DeliveryKey getDeliveryKey() throws RemoteException;
	void setDeliveryKey(org.openxava.test.ejb.DeliveryKey key) throws RemoteException;

	// Methods 


}