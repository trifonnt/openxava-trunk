

// File generated by OpenXava: Fri Dec 11 13:00:36 CET 2015
// Archivo generado por OpenXava: Fri Dec 11 13:00:36 CET 2015

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Carrier		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface ICarrier  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_name = "name"; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	public static final String PROPERTY_remarks = "remarks"; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	int getNumber() throws RemoteException; 	
	public static final String PROPERTY_calculated = "calculated"; 	
	String getCalculated() throws RemoteException;	

	java.util.Collection getFellowCarriers() throws RemoteException;	

	java.util.Collection getFellowCarriersCalculated() throws RemoteException;		

	// References/Referencias 

	// DrivingLicence : Reference/Referencia
	
	org.openxava.test.model.IDrivingLicence getDrivingLicence() throws RemoteException;
	void setDrivingLicence(org.openxava.test.model.IDrivingLicence newDrivingLicence) throws RemoteException; 

	// Warehouse : Reference/Referencia
	
	org.openxava.test.model.IWarehouse getWarehouse() throws RemoteException;
	void setWarehouse(org.openxava.test.model.IWarehouse newWarehouse) throws RemoteException;

	// Methods 
	void translate() throws RemoteException; 
	void translateToSpanish() throws RemoteException; 
	void translateToEnglish() throws RemoteException; 


}