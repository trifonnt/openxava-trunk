

// File generated by OpenXava: Tue Aug 16 09:26:05 CEST 2005
// Archivo generado por OpenXava: Tue Aug 16 09:26:05 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Service		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface IService  {	

	// Properties/Propiedades 
	int getFamily() throws RemoteException;
	void setFamily(int family) throws RemoteException; 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 	
	int getNumber() throws RemoteException;	

	java.util.Collection getAdditionalDetails() throws RemoteException;		

	// References/Referencias  	
	// Detail : Aggregate 
	
	org.openxava.test.ejb.Detail getDetail() throws RemoteException;
	void setDetail(org.openxava.test.ejb.Detail newDetail) throws RemoteException;

	// Methods 


}