

// File generated by OpenXava: Wed Jul 08 20:13:00 CEST 2009
// Archivo generado por OpenXava: Wed Jul 08 20:13:00 CEST 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ICustomer  extends org.openxava.model.IModel, org.openxava.test.model.IWithName {	

	// Properties/Propiedades 	
	public static final String PROPERTY_local = "local"; 	
	boolean isLocal() throws RemoteException; 	
	public static final String PROPERTY_type = "type"; 
	int getType() throws RemoteException;
	void setType(int type) throws RemoteException; 	
	public static final String PROPERTY_remarks = "remarks"; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 	
	public static final String PROPERTY_telephone = "telephone"; 
	String getTelephone() throws RemoteException;
	void setTelephone(String telephone) throws RemoteException; 	
	public static final String PROPERTY_email = "email"; 
	String getEmail() throws RemoteException;
	void setEmail(String email) throws RemoteException; 	
	public static final String PROPERTY_relationWithSeller = "relationWithSeller"; 
	String getRelationWithSeller() throws RemoteException;
	void setRelationWithSeller(String relationWithSeller) throws RemoteException; 	
	public static final String PROPERTY_photo = "photo"; 
	byte[] getPhoto() throws RemoteException;
	void setPhoto(byte[] photo) throws RemoteException; 	
	public static final String PROPERTY_name = "name"; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	public static final String PROPERTY_city = "city"; 	
	String getCity() throws RemoteException; 	
	public static final String PROPERTY_website = "website"; 
	String getWebsite() throws RemoteException;
	void setWebsite(String website) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
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