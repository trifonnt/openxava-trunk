

// File generated by OpenXava: Thu Apr 21 12:17:35 CEST 2016
// Archivo generado por OpenXava: Thu Apr 21 12:17:35 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IInvoice  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_total = "total"; 	
	java.math.BigDecimal getTotal() throws RemoteException; 	
	public static final String PROPERTY_vatPercentage = "vatPercentage"; 
	java.math.BigDecimal getVatPercentage() throws RemoteException;
	void setVatPercentage(java.math.BigDecimal vatPercentage) throws RemoteException; 	
	public static final String PROPERTY_considerable = "considerable"; 	
	boolean isConsiderable() throws RemoteException; 	
	public static final String PROPERTY_yearDiscount = "yearDiscount"; 	
	java.math.BigDecimal getYearDiscount() throws RemoteException; 	
	public static final String PROPERTY_detailsCount = "detailsCount"; 	
	int getDetailsCount() throws RemoteException; 	
	public static final String PROPERTY_vat = "vat"; 	
	java.math.BigDecimal getVat() throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	int getNumber() throws RemoteException; 	
	public static final String PROPERTY_productUnitPriceSum = "productUnitPriceSum"; 	
	java.math.BigDecimal getProductUnitPriceSum() throws RemoteException; 	
	public static final String PROPERTY_date = "date"; 
	java.util.Date getDate() throws RemoteException;
	void setDate(java.util.Date date) throws RemoteException; 	
	public static final String PROPERTY_amountsSum = "amountsSum"; 	
	java.math.BigDecimal getAmountsSum() throws RemoteException; 	
	public static final String PROPERTY_customerDiscount = "customerDiscount"; 	
	java.math.BigDecimal getCustomerDiscount() throws RemoteException; 	
	public static final String PROPERTY_paid = "paid"; 
	boolean isPaid() throws RemoteException;
	void setPaid(boolean paid) throws RemoteException; 	
	public static final String PROPERTY_importance = "importance"; 	
	String getImportance() throws RemoteException; 	
	public static final String PROPERTY_year = "year"; 	
	int getYear() throws RemoteException; 	
	public static final String PROPERTY_deliveryDate = "deliveryDate"; 	
	java.util.Date getDeliveryDate() throws RemoteException; 	
	public static final String PROPERTY_customerTypeDiscount = "customerTypeDiscount"; 	
	java.math.BigDecimal getCustomerTypeDiscount() throws RemoteException; 	
	public static final String PROPERTY_comment = "comment"; 
	String getComment() throws RemoteException;
	void setComment(String comment) throws RemoteException; 	
	public static final String PROPERTY_sellerDiscount = "sellerDiscount"; 	
	java.math.BigDecimal getSellerDiscount() throws RemoteException;	

	java.util.Collection getDetails() throws RemoteException;	

	java.util.Collection getCalculatedDetails() throws RemoteException;	

	java.util.Collection getDeliveries() throws RemoteException;		

	// References/Referencias 

	// Customer : Reference/Referencia
	
	org.openxava.test.model.ICustomer getCustomer() throws RemoteException;
	void setCustomer(org.openxava.test.model.ICustomer newCustomer) throws RemoteException;

	// Methods 


}