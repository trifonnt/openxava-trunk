

// File generated by OpenXava: Thu Mar 25 13:18:41 CET 2010
// Archivo generado por OpenXava: Thu Mar 25 13:18:41 CET 2010

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: ShipmentCharge		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IShipmentCharge  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_amount = "amount"; 
	java.math.BigDecimal getAmount() throws RemoteException;
	void setAmount(java.math.BigDecimal amount) throws RemoteException; 	
	public static final String PROPERTY_oid = "oid"; 	
	String getOid() throws RemoteException; 	
	public static final String PROPERTY_mode = "mode"; 
	int getMode() throws RemoteException;
	void setMode(int mode) throws RemoteException;		

	// References/Referencias 

	// Shipment : Reference/Referencia
	
	org.openxava.test.model.IShipment getShipment() throws RemoteException;
	void setShipment(org.openxava.test.model.IShipment newShipment) throws RemoteException;

	// Methods 


}