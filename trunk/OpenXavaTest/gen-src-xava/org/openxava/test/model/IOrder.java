

// File generated by OpenXava: Fri Nov 30 13:12:44 CET 2012
// Archivo generado por OpenXava: Fri Nov 30 13:12:44 CET 2012

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Order		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IOrder  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_amount = "amount"; 	
	java.math.BigDecimal getAmount() throws RemoteException; 	
	public static final String PROPERTY_year = "year"; 
	int getYear() throws RemoteException;
	void setYear(int year) throws RemoteException; 	
	public static final String PROPERTY_remarks = "remarks"; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 	
	public static final String PROPERTY_date = "date"; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException; 	
	public static final String PROPERTY_id = "id"; 	
	String getId() throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 
	int getNumber() throws RemoteException;
	void setNumber(int number) throws RemoteException;	

	java.util.Collection getDetails() throws RemoteException;		

	// References/Referencias 

	// Customer : Reference/Referencia
	
	org.openxava.test.model.ICustomer getCustomer() throws RemoteException;
	void setCustomer(org.openxava.test.model.ICustomer newCustomer) throws RemoteException;

	// Methods 


}