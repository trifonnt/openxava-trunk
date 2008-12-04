/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Home interface for Delivery.
 */
public interface DeliveryHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/Delivery";
   public static final String JNDI_NAME="@subcontext@/ejb/org.openxava.test.model/Delivery";

   public org.openxava.test.model.DeliveryRemote create(java.util.Map values)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.DeliveryRemote create(org.openxava.test.model.DeliveryData data)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.DeliveryRemote create(org.openxava.test.model.DeliveryValue value)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public java.util.Collection findByType(int number)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByShipment(java.lang.String type, int mode, int number)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByCarrier(java.lang.Integer number)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByInvoice(int year, int number)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public org.openxava.test.model.DeliveryRemote findByPrimaryKey(org.openxava.test.model.DeliveryKey pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
