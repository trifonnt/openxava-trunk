/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Data object for Family2.
 */
public class Family2Data
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.lang.String _Description;
   private int number;

   public Family2Data()
   {
   }

   public Family2Data( Family2Data otherData )
   {
      set_Description(otherData.get_Description());
      setNumber(otherData.getNumber());

   }

   public org.openxava.test.ejb.Family2Key getPrimaryKey() {
     org.openxava.test.ejb.Family2Key pk = new org.openxava.test.ejb.Family2Key(this.getNumber());
     return pk;
   }

   public java.lang.String get_Description()
   {
      return this._Description;
   }
   public void set_Description( java.lang.String _Description )
   {
      this._Description = _Description;
   }

   public int getNumber()
   {
      return this.number;
   }
   public void setNumber( int number )
   {
      this.number = number;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Description=" + get_Description() + " " + "number=" + getNumber());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof Family2Data )
      {
         Family2Data lTest = (Family2Data) pOther;
         boolean lEquals = true;

         if( this._Description == null )
         {
            lEquals = lEquals && ( lTest._Description == null );
         }
         else
         {
            lEquals = lEquals && this._Description.equals( lTest._Description );
         }
         lEquals = lEquals && this.number == lTest.number;

         return lEquals;
      }
      else
      {
         return false;
      }
   }

   public int hashCode()
   {
      int result = 17;

      result = 37*result + ((this._Description != null) ? this._Description.hashCode() : 0);

      result = 37*result + (int) number;

      return result;
   }

}
