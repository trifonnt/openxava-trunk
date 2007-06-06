

// File generated by OpenXava: Wed Jun 06 09:38:15 CEST 2007
// Archivo generado por OpenXava: Wed Jun 06 09:38:15 CEST 2007

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ICustomer  extends org.openxava.model.IModel, org.openxava.test.model.IWithName {	

	// Properties/Propiedades 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 	
	int getNumber() throws RemoteException; 	
	boolean isLocal() throws RemoteException; 
	int getType() throws RemoteException;
	void setType(int type) throws RemoteException; 
	byte[] getPhoto() throws RemoteException;
	void setPhoto(byte[] photo) throws RemoteException; 
	String getRelationWithSeller() throws RemoteException;
	void setRelationWithSeller(String relationWithSeller) throws RemoteException; 	
	String getCity() throws RemoteException;	

	java.util.Collection getDeliveryPlaces() throws RemoteException;	

	java.util.Collection getStates() throws RemoteException;		

	// References/Referencias  	
	// Address : Aggregate 
	
	org.openxava.test.model.Address getAddress() throws RemoteException;
	void setAddress(org.openxava.test.model.Address newAddress) throws RemoteException; 

	// AlternateSeller : Reference/Referencia
	
	org.openxava.test.model.ISeller getAlternateSeller() throws RemoteException;
	void setAlternateSeller(org.openxava.test.model.ISeller newAlternateSeller) throws RemoteException; 

	// Seller : Reference/Referencia
	
	org.openxava.test.model.ISeller getSeller() throws RemoteException;
	void setSeller(org.openxava.test.model.ISeller newSeller) throws RemoteException;

	// Methods 
	void calculateShippingAndHandling() throws RemoteException; 


}