/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Home interface for ServiceType.
 */
public interface ServiceTypeHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/ServiceType";
   public static final String JNDI_NAME="@subcontext@/ejb/org.openxava.test.ejb/ServiceType";

   public org.openxava.test.ejb.ServiceType create(java.util.Map values)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.ejb.ServiceType create(org.openxava.test.ejb.ServiceTypeData data)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.ejb.ServiceType create(org.openxava.test.ejb.ServiceTypeValue value)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.ejb.ServiceType findByPrimaryKey(org.openxava.test.ejb.ServiceTypeKey pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
