/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Home interface for Ingredient.
 */
public interface IngredientHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/Ingredient";
   public static final String JNDI_NAME="@subcontext@/ejb/org.openxava.test.model/Ingredient";

   public org.openxava.test.model.IngredientRemote create(java.util.Map values)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.IngredientRemote create(org.openxava.test.model.IngredientData data)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public org.openxava.test.model.IngredientRemote create(org.openxava.test.model.IngredientValue value)
      throws javax.ejb.CreateException,org.openxava.validators.ValidationException,java.rmi.RemoteException;

   public java.util.Collection findByFavouriteFormula(java.lang.String oid)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByPartOf(java.lang.String oid)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public org.openxava.test.model.IngredientRemote findByOid(java.lang.String oid)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public org.openxava.test.model.IngredientRemote findByPrimaryKey(org.openxava.test.model.IngredientKey pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
