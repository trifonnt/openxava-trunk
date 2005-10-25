

// File generated by OpenXava: Mon Oct 24 20:01:47 CEST 2005
// Archivo generado por OpenXava: Mon Oct 24 20:01:47 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice		Java interface for aggregate/Interfaz java para Agregado: InvoiceDetail

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IInvoiceDetail  {	

	// Properties/Propiedades 	
	java.math.BigDecimal getAmount() throws RemoteException; 
	java.math.BigDecimal getUnitPrice() throws RemoteException;
	void setUnitPrice(java.math.BigDecimal unitPrice) throws RemoteException; 	
	String getOid() throws RemoteException; 
	java.lang.String getRemarks() throws RemoteException;
	void setRemarks(java.lang.String remarks) throws RemoteException; 
	java.util.Date getDeliveryDate() throws RemoteException;
	void setDeliveryDate(java.util.Date deliveryDate) throws RemoteException; 
	int getQuantity() throws RemoteException;
	void setQuantity(int quantity) throws RemoteException; 
	int getServiceType() throws RemoteException;
	void setServiceType(int serviceType) throws RemoteException;		

	// References/Referencias 

	// Product : Reference/Referencia
	
	org.openxava.test.model.IProduct getProduct() throws RemoteException;
	void setProduct(org.openxava.test.model.IProduct newProduct) throws RemoteException; 

	// SoldBy : Reference/Referencia
	
	org.openxava.test.model.ISeller getSoldBy() throws RemoteException;
	void setSoldBy(org.openxava.test.model.ISeller newSoldBy) throws RemoteException; 

	// Invoice : Reference/Referencia
	
	org.openxava.test.model.IInvoice getInvoice() throws RemoteException;
	void setInvoice(org.openxava.test.model.IInvoice newInvoice) throws RemoteException;

	// Methods 


}