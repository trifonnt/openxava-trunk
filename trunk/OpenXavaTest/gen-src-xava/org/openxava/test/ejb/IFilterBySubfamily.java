

// File generated by OpenXava: Tue May 03 09:18:46 CEST 2005
// Archivo generado por OpenXava: Tue May 03 09:18:46 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: FilterBySubfamily		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface IFilterBySubfamily  {	

	// Properties/Propiedades 	
	String getOid() throws RemoteException;		

	// References/Referencias 

	// Subfamily : Reference/Referencia
	
	org.openxava.test.ejb.Subfamily2 getSubfamily() throws RemoteException;
	void setSubfamily(org.openxava.test.ejb.Subfamily2 newSubfamily) throws RemoteException;
	
	org.openxava.test.ejb.Subfamily2Key getSubfamilyKey() throws RemoteException;
	void setSubfamilyKey(org.openxava.test.ejb.Subfamily2Key key) throws RemoteException;

	// Methods 


}