

// File generated by OpenXava: Tue Oct 25 11:52:11 CEST 2016
// Archivo generado por OpenXava: Tue Oct 25 11:52:11 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Driver		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IDriver  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_name = "name"; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	int getNumber() throws RemoteException; 	
	public static final String PROPERTY_type = "type"; 
	String getType() throws RemoteException;
	void setType(String type) throws RemoteException;		

	// References/Referencias 

	// DrivingLicence : Reference/Referencia
	
	org.openxava.test.model.IDrivingLicence getDrivingLicence() throws RemoteException;
	void setDrivingLicence(org.openxava.test.model.IDrivingLicence newDrivingLicence) throws RemoteException;

	// Methods 


}