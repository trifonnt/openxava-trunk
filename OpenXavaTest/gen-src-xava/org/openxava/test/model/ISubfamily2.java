

// File generated by OpenXava: Fri Feb 20 17:12:34 CET 2009
// Archivo generado por OpenXava: Fri Feb 20 17:12:34 CET 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Subfamily2		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ISubfamily2  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_remarks = "remarks"; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 	
	public static final String PROPERTY_description = "description"; 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	int getNumber() throws RemoteException;		

	// References/Referencias 

	// Family : Reference/Referencia
	
	org.openxava.test.model.IFamily2 getFamily() throws RemoteException;
	void setFamily(org.openxava.test.model.IFamily2 newFamily) throws RemoteException;

	// Methods 
	java.util.Collection getProductsValues() throws RemoteException; 


}