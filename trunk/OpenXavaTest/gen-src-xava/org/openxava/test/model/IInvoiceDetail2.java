

// File generated by OpenXava: Tue Jun 09 11:32:11 CEST 2009
// Archivo generado por OpenXava: Tue Jun 09 11:32:11 CEST 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice2		Java interface for aggregate/Interfaz java para Agregado: InvoiceDetail2

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IInvoiceDetail2  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_amount = "amount"; 	
	java.math.BigDecimal getAmount() throws RemoteException; 	
	public static final String PROPERTY_unitPrice = "unitPrice"; 
	java.math.BigDecimal getUnitPrice() throws RemoteException;
	void setUnitPrice(java.math.BigDecimal unitPrice) throws RemoteException; 	
	public static final String PROPERTY_oid = "oid"; 	
	String getOid() throws RemoteException; 	
	public static final String PROPERTY_quantity = "quantity"; 
	int getQuantity() throws RemoteException;
	void setQuantity(int quantity) throws RemoteException;		

	// References/Referencias 

	// Product : Reference/Referencia
	
	org.openxava.test.model.IProduct2 getProduct() throws RemoteException;
	void setProduct(org.openxava.test.model.IProduct2 newProduct) throws RemoteException; 

	// Invoice2 : Reference/Referencia
	
	org.openxava.test.model.IInvoice2 getInvoice2() throws RemoteException;
	void setInvoice2(org.openxava.test.model.IInvoice2 newInvoice2) throws RemoteException;

	// Methods 


}