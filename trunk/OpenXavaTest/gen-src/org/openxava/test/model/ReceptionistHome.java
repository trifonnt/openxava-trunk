/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Home interface for Receptionist.
 */
public interface ReceptionistHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/Receptionist";
   public static final String JNDI_NAME="@subcontext@/ejb/org.openxava.test.model/Receptionist";

   public org.openxava.test.model.ReceptionistRemote create(org.openxava.test.model.DeliveryPlaceRemote container , int counter , java.util.Map values)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.ReceptionistRemote create(org.openxava.test.model.DeliveryPlaceKey containerKey , int counter , java.util.Map values)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.ReceptionistRemote create(org.openxava.test.model.DeliveryPlaceRemote container , int counter , org.openxava.test.model.ReceptionistData data)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.ReceptionistRemote create(org.openxava.test.model.DeliveryPlaceRemote container , int counter , org.openxava.test.model.ReceptionistValue value)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.ReceptionistRemote create(org.openxava.test.model.DeliveryPlaceKey containerKey , int counter , org.openxava.test.model.ReceptionistValue value)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public java.util.Collection findByDeliveryPlace(int oid)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public org.openxava.test.model.ReceptionistRemote findByPrimaryKey(org.openxava.test.model.ReceptionistKey pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
