

// File generated by OpenXava: Tue Feb 22 11:45:08 CET 2005
// Archivo generado por OpenXava: Tue Feb 22 11:45:08 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface ICustomer {	

	// Properties/Propiedades 
	int getType() throws RemoteException;
	void setType(int Type) throws RemoteException; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String Remarks) throws RemoteException; 
	String getRelationWithSeller() throws RemoteException;
	void setRelationWithSeller(String RelationWithSeller) throws RemoteException; 
	byte[] getPhoto() throws RemoteException;
	void setPhoto(byte[] Photo) throws RemoteException; 
	String getName() throws RemoteException;
	void setName(String Name) throws RemoteException; 	
	int getNumber() throws RemoteException;	

	java.util.Collection getDeliveryPlaces() throws RemoteException;		

	// References/Referencias 

	// Seller : Reference/Referencia
	
	org.openxava.test.ejb.Seller getSeller() throws RemoteException;
	void setSeller(org.openxava.test.ejb.Seller newSeller) throws RemoteException;
	
	org.openxava.test.ejb.SellerKey getSellerKey() throws RemoteException;
	void setSellerKey(org.openxava.test.ejb.SellerKey key) throws RemoteException; 

	// AlternateSeller : Reference/Referencia
	
	org.openxava.test.ejb.Seller getAlternateSeller() throws RemoteException;
	void setAlternateSeller(org.openxava.test.ejb.Seller newAlternateSeller) throws RemoteException;
	
	org.openxava.test.ejb.SellerKey getAlternateSellerKey() throws RemoteException;
	void setAlternateSellerKey(org.openxava.test.ejb.SellerKey key) throws RemoteException;  	
	// Address : Aggregate 
	
	org.openxava.test.ejb.Address getAddress() throws RemoteException;
	void setAddress(org.openxava.test.ejb.Address newAddress) throws RemoteException;

	// Methods 


}