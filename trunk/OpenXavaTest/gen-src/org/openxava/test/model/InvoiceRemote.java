/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Remote interface for Invoice.
 */
public interface InvoiceRemote
   extends org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IInvoice
{

   public java.math.BigDecimal getTotal(  )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getVatPercentage(  )
      throws java.rmi.RemoteException;

   public void setVatPercentage( java.math.BigDecimal newVatPercentage )
      throws java.rmi.RemoteException;

   public boolean isConsiderable(  )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getYearDiscount(  )
      throws java.rmi.RemoteException;

   public int getDetailsCount(  )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getVat(  )
      throws java.rmi.RemoteException;

   public int getNumber(  )
      throws java.rmi.RemoteException;

   public java.util.Date getDate(  )
      throws java.rmi.RemoteException;

   public void setDate( java.util.Date newDate )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getAmountsSum(  )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getCustomerDiscount(  )
      throws java.rmi.RemoteException;

   public boolean isPaid(  )
      throws java.rmi.RemoteException;

   public void setPaid( boolean newPaid )
      throws java.rmi.RemoteException;

   public java.lang.String getImportance(  )
      throws java.rmi.RemoteException;

   public int getYear(  )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getCustomerTypeDiscount(  )
      throws java.rmi.RemoteException;

   public java.lang.String getComment(  )
      throws java.rmi.RemoteException;

   public void setComment( java.lang.String newComment )
      throws java.rmi.RemoteException;

   public java.math.BigDecimal getSellerDiscount(  )
      throws java.rmi.RemoteException;

   public java.util.Collection getDetails(  )
      throws java.rmi.RemoteException;

   public java.util.Collection getDeliveries(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.ICustomer getCustomer(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.CustomerRemote getCustomerRemote(  )
      throws java.rmi.RemoteException;

   public void setCustomer( org.openxava.test.model.ICustomer newCustomer )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.CustomerKey getCustomerKey(  )
      throws java.rmi.RemoteException;

   public void setCustomerKey( org.openxava.test.model.CustomerKey key )
      throws java.rmi.RemoteException;

   public int getCustomer_number(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.InvoiceData getData(  )
      throws java.rmi.RemoteException;

   public void setData( org.openxava.test.model.InvoiceData data )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.InvoiceValue getInvoiceValue(  )
      throws java.rmi.RemoteException;

   public void setInvoiceValue( org.openxava.test.model.InvoiceValue value )
      throws java.rmi.RemoteException;

}
