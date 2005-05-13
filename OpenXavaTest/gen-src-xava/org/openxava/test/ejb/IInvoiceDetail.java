

// File generated by OpenXava: Fri May 13 18:32:18 CEST 2005
// Archivo generado por OpenXava: Fri May 13 18:32:18 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice		Java interface for aggregate/Interfaz java para Agregado: InvoiceDetail

package org.openxava.test.ejb;

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
	
	org.openxava.test.ejb.Product getProduct() throws RemoteException;
	void setProduct(org.openxava.test.ejb.Product newProduct) throws RemoteException;
	
	org.openxava.test.ejb.ProductKey getProductKey() throws RemoteException;
	void setProductKey(org.openxava.test.ejb.ProductKey key) throws RemoteException; 

	// SoldBy : Reference/Referencia
	
	org.openxava.test.ejb.Seller getSoldBy() throws RemoteException;
	void setSoldBy(org.openxava.test.ejb.Seller newSoldBy) throws RemoteException;
	
	org.openxava.test.ejb.SellerKey getSoldByKey() throws RemoteException;
	void setSoldByKey(org.openxava.test.ejb.SellerKey key) throws RemoteException; 

	// Invoice : Reference/Referencia
	
	org.openxava.test.ejb.Invoice getInvoice() throws RemoteException;
	void setInvoice(org.openxava.test.ejb.Invoice newInvoice) throws RemoteException;
	
	org.openxava.test.ejb.InvoiceKey getInvoiceKey() throws RemoteException;
	void setInvoiceKey(org.openxava.test.ejb.InvoiceKey key) throws RemoteException;

	// Methods 


}