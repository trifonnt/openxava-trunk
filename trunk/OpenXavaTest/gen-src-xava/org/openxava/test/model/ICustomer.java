

// File generated by OpenXava: Fri Nov 10 13:06:22 CET 2006
// Archivo generado por OpenXava: Fri Nov 10 13:06:22 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ICustomer  extends org.openxava.model.IModel, org.openxava.test.model.IWithName {	

	// Properties/Propiedades 	
	boolean isLocal() throws RemoteException; 
	int getType() throws RemoteException;
	void setType(int type) throws RemoteException; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 
	String getRelationWithSeller() throws RemoteException;
	void setRelationWithSeller(String relationWithSeller) throws RemoteException; 
	byte[] getPhoto() throws RemoteException;
	void setPhoto(byte[] photo) throws RemoteException; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	String getCity() throws RemoteException; 	
	int getNumber() throws RemoteException;	

	java.util.Collection getStates() throws RemoteException;	

	java.util.Collection getDeliveryPlaces() throws RemoteException;		

	// References/Referencias 

	// Seller : Reference/Referencia
	
	org.openxava.test.model.ISeller getSeller() throws RemoteException;
	void setSeller(org.openxava.test.model.ISeller newSeller) throws RemoteException; 

	// AlternateSeller : Reference/Referencia
	
	org.openxava.test.model.ISeller getAlternateSeller() throws RemoteException;
	void setAlternateSeller(org.openxava.test.model.ISeller newAlternateSeller) throws RemoteException;  	
	// Address : Aggregate 
	
	org.openxava.test.model.Address getAddress() throws RemoteException;
	void setAddress(org.openxava.test.model.Address newAddress) throws RemoteException;

	// Methods 
	void calculateShippingAndHandling() throws RemoteException; 


}