/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Remote interface for Color.
 */
public interface ColorRemote
   extends org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IColor
{

   public java.lang.String getName(  )
      throws java.rmi.RemoteException;

   public void setName( java.lang.String newName )
      throws java.rmi.RemoteException;

   public java.lang.Integer getNumber(  )
      throws java.rmi.RemoteException;

   public java.lang.String getSample(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.ColorData getData(  )
      throws java.rmi.RemoteException;

   public void setData( org.openxava.test.model.ColorData data )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.ColorValue getColorValue(  )
      throws java.rmi.RemoteException;

   public void setColorValue( org.openxava.test.model.ColorValue value )
      throws java.rmi.RemoteException;

}
