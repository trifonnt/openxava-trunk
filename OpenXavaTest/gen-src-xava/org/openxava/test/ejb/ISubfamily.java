

// File generated by OpenXava: Mon Mar 14 10:36:05 CET 2005
// Archivo generado por OpenXava: Mon Mar 14 10:36:05 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Subfamily		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface ISubfamily {	

	// Properties/Propiedades 	
	String getFamily() throws RemoteException; 
	int getFamilyNumber() throws RemoteException;
	void setFamilyNumber(int FamilyNumber) throws RemoteException; 	
	String getOid() throws RemoteException; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String Remarks) throws RemoteException; 
	String getDescription() throws RemoteException;
	void setDescription(String Description) throws RemoteException; 
	int getNumber() throws RemoteException;
	void setNumber(int Number) throws RemoteException;		

	// References/Referencias

	// Methods 


}