/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Primary key for SellerLevel.
 */
public class SellerLevelKey
   extends java.lang.Object
   implements java.io.Serializable
{

   public java.lang.String id;

   public SellerLevelKey()
   {
   }

   public SellerLevelKey( java.lang.String id )
   {
      this.id = id;
   }

   public java.lang.String getId()
   {
      return id;
   }

   public void setId(java.lang.String id)
   {
      this.id = id;
   }

   public int hashCode()
   {
      int _hashCode = 0;
         if (this.id != null) _hashCode += this.id.hashCode();

      return _hashCode;
   }

   public boolean equals(Object obj)
   {
      if( !(obj instanceof org.openxava.test.ejb.SellerLevelKey) )
         return false;

      org.openxava.test.ejb.SellerLevelKey pk = (org.openxava.test.ejb.SellerLevelKey)obj;
      boolean eq = true;

      if( obj == null )
      {
         eq = false;
      }
      else
      {
         if( this.id != null )
         {
            eq = eq && this.id.equals( pk.getId() );
         }
         else  // this.id == null
         {
            eq = eq && ( pk.getId() == null );
         }
      }

      return eq;
   }

   /** @return String representation of this pk in the form of [.field1.field2.field3]. */
   public String toString()
   {
      StringBuffer toStringValue = new StringBuffer("[.");
         toStringValue.append(this.id).append('.');
      toStringValue.append(']');
      return toStringValue.toString();
   }

}
