/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Remote interface for Size.
 */
public interface SizeRemote
   extends org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ISize
{

   public java.lang.String getName(  )
      throws java.rmi.RemoteException;

   public void setName( java.lang.String newName )
      throws java.rmi.RemoteException;

   public int getId(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SizeData getData(  )
      throws java.rmi.RemoteException;

   public void setData( org.openxava.test.model.SizeData data )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SizeValue getSizeValue(  )
      throws java.rmi.RemoteException;

   public void setSizeValue( org.openxava.test.model.SizeValue value )
      throws java.rmi.RemoteException;

}
