

// File generated by OpenXava: Thu Apr 21 12:17:35 CEST 2016
// Archivo generado por OpenXava: Thu Apr 21 12:17:35 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Seller		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ISeller  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_name = "name"; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	int getNumber() throws RemoteException; 	
	public static final String PROPERTY_regions = "regions"; 
	String [] getRegions() throws RemoteException;
	void setRegions(String [] regions) throws RemoteException; 
	void addToCustomers(org.openxava.test.model.ICustomer newElement) throws RemoteException;
	void removeFromCustomers(org.openxava.test.model.ICustomer toRemove) throws RemoteException;	

	java.util.Collection getCustomers() throws RemoteException;		

	// References/Referencias 

	// Level : Reference/Referencia
	
	org.openxava.test.model.ISellerLevel getLevel() throws RemoteException;
	void setLevel(org.openxava.test.model.ISellerLevel newLevel) throws RemoteException; 

	// Boss : Reference/Referencia
	
	org.openxava.test.model.ISeller getBoss() throws RemoteException;
	void setBoss(org.openxava.test.model.ISeller newBoss) throws RemoteException;

	// Methods 


}