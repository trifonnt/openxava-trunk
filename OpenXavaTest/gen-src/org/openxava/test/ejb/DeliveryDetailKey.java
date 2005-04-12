/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Primary key for DeliveryDetail.
 */
public class DeliveryDetailKey
   extends java.lang.Object
   implements java.io.Serializable
{

   public int number;

   public DeliveryDetailKey()
   {
   }

   public DeliveryDetailKey( int number )
   {
      this.number = number;
   }

   public int getNumber()
   {
      return number;
   }

   public void setNumber(int number)
   {
      this.number = number;
   }

   public int hashCode()
   {
      int _hashCode = 0;
         _hashCode += (int)this.number;

      return _hashCode;
   }

   public boolean equals(Object obj)
   {
      if( !(obj instanceof org.openxava.test.ejb.DeliveryDetailKey) )
         return false;

      org.openxava.test.ejb.DeliveryDetailKey pk = (org.openxava.test.ejb.DeliveryDetailKey)obj;
      boolean eq = true;

      if( obj == null )
      {
         eq = false;
      }
      else
      {
         eq = eq && this.number == pk.number;
      }

      return eq;
   }

   /** @return String representation of this pk in the form of [.field1.field2.field3]. */
   public String toString()
   {
      StringBuffer toStringValue = new StringBuffer("[.");
         toStringValue.append(this.number).append('.');
      toStringValue.append(']');
      return toStringValue.toString();
   }

}
