

// File generated by OpenXava: Tue Dec 05 11:56:37 CET 2006
// Archivo generado por OpenXava: Tue Dec 05 11:56:37 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Product3		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IProduct3  extends org.openxava.model.IModel {	

	// Properties/Propiedades 
	java.lang.String getComments() throws RemoteException;
	void setComments(java.lang.String comments) throws RemoteException; 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 	
	long getNumber() throws RemoteException;		

	// References/Referencias  	
	// Subfamily1 : Aggregate 
	
	org.openxava.test.model.SubfamilyInfo getSubfamily1() throws RemoteException;
	void setSubfamily1(org.openxava.test.model.SubfamilyInfo newSubfamily1) throws RemoteException; 

	// Family : Reference/Referencia
	
	org.openxava.test.model.IFamily getFamily() throws RemoteException;
	void setFamily(org.openxava.test.model.IFamily newFamily) throws RemoteException;  	
	// Subfamily2 : Aggregate 
	
	org.openxava.test.model.SubfamilyInfo getSubfamily2() throws RemoteException;
	void setSubfamily2(org.openxava.test.model.SubfamilyInfo newSubfamily2) throws RemoteException;

	// Methods 


}