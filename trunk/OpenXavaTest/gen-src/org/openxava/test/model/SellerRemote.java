/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Remote interface for Seller.
 */
public interface SellerRemote
   extends org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ISeller
{

   public java.lang.String getName(  )
      throws java.rmi.RemoteException;

   public void setName( java.lang.String newName )
      throws java.rmi.RemoteException;

   public int getNumber(  )
      throws java.rmi.RemoteException;

   public void addToCustomers( org.openxava.test.model.CustomerRemote newElement )
      throws java.rmi.RemoteException;

   public void removeFromCustomers( org.openxava.test.model.CustomerRemote toRemove )
      throws java.rmi.RemoteException;

   public java.util.Collection getCustomers(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.ISellerLevel getLevel(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SellerLevelRemote getLevelRemote(  )
      throws java.rmi.RemoteException;

   public void setLevel( org.openxava.test.model.ISellerLevel newLevel )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SellerLevelKey getLevelKey(  )
      throws java.rmi.RemoteException;

   public void setLevelKey( org.openxava.test.model.SellerLevelKey key )
      throws java.rmi.RemoteException;

   public java.lang.String getLevel_id(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.ISeller getBoss(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SellerRemote getBossRemote(  )
      throws java.rmi.RemoteException;

   public void setBoss( org.openxava.test.model.ISeller newBoss )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SellerKey getBossKey(  )
      throws java.rmi.RemoteException;

   public void setBossKey( org.openxava.test.model.SellerKey key )
      throws java.rmi.RemoteException;

   public int getBoss_number(  )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SellerData getData(  )
      throws java.rmi.RemoteException;

   public void setData( org.openxava.test.model.SellerData data )
      throws java.rmi.RemoteException;

   public org.openxava.test.model.SellerValue getSellerValue(  )
      throws java.rmi.RemoteException;

   public void setSellerValue( org.openxava.test.model.SellerValue value )
      throws java.rmi.RemoteException;

}
