

// File generated by OpenXava: Wed Apr 06 16:42:10 CEST 2005
// Archivo generado por OpenXava: Wed Apr 06 16:42:10 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Product2		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.ejb;

import java.math.*;
import java.rmi.RemoteException;


public interface IProduct2  {	

	// Properties/Propiedades 
	java.math.BigDecimal getUnitPrice() throws RemoteException;
	void setUnitPrice(java.math.BigDecimal unitPrice) throws RemoteException; 
	String getDescription() throws RemoteException;
	void setDescription(String description) throws RemoteException; 	
	java.math.BigDecimal getUnitPriceInPesetas() throws RemoteException; 	
	long getNumber() throws RemoteException;		

	// References/Referencias 

	// Warehouse : Reference/Referencia
	
	org.openxava.test.ejb.Warehouse2 getWarehouse() throws RemoteException;
	void setWarehouse(org.openxava.test.ejb.Warehouse2 newWarehouse) throws RemoteException;
	
	org.openxava.test.ejb.Warehouse2Key getWarehouseKey() throws RemoteException;
	void setWarehouseKey(org.openxava.test.ejb.Warehouse2Key key) throws RemoteException; 

	// Family : Reference/Referencia
	
	org.openxava.test.ejb.Family2 getFamily() throws RemoteException;
	void setFamily(org.openxava.test.ejb.Family2 newFamily) throws RemoteException;
	
	org.openxava.test.ejb.Family2Key getFamilyKey() throws RemoteException;
	void setFamilyKey(org.openxava.test.ejb.Family2Key key) throws RemoteException; 

	// Subfamily : Reference/Referencia
	
	org.openxava.test.ejb.Subfamily2 getSubfamily() throws RemoteException;
	void setSubfamily(org.openxava.test.ejb.Subfamily2 newSubfamily) throws RemoteException;
	
	org.openxava.test.ejb.Subfamily2Key getSubfamilyKey() throws RemoteException;
	void setSubfamilyKey(org.openxava.test.ejb.Subfamily2Key key) throws RemoteException;

	// Methods 


}