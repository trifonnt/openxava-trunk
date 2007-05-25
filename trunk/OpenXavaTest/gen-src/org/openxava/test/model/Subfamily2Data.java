/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for Subfamily2.
 */
public class Subfamily2Data
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.lang.String _Description;
   private java.lang.String _Remarks;
   private int number;
   private int _Family_number;

   public Subfamily2Data()
   {
   }

   public Subfamily2Data( Subfamily2Data otherData )
   {
      set_Description(otherData.get_Description());
      set_Remarks(otherData.get_Remarks());
      setNumber(otherData.getNumber());
      set_Family_number(otherData.get_Family_number());

   }

   public org.openxava.test.model.Subfamily2Key getPrimaryKey() {
     org.openxava.test.model.Subfamily2Key pk = new org.openxava.test.model.Subfamily2Key(this.getNumber());
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

   public java.lang.String get_Remarks()
   {
      return this._Remarks;
   }
   public void set_Remarks( java.lang.String _Remarks )
   {
      this._Remarks = _Remarks;
   }

   public int getNumber()
   {
      return this.number;
   }
   public void setNumber( int number )
   {
      this.number = number;
   }

   public int get_Family_number()
   {
      return this._Family_number;
   }
   public void set_Family_number( int _Family_number )
   {
      this._Family_number = _Family_number;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Description=" + get_Description() + " " + "_Remarks=" + get_Remarks() + " " + "number=" + getNumber() + " " + "_Family_number=" + get_Family_number());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof Subfamily2Data )
      {
         Subfamily2Data lTest = (Subfamily2Data) pOther;
         boolean lEquals = true;

         if( this._Description == null )
         {
            lEquals = lEquals && ( lTest._Description == null );
         }
         else
         {
            lEquals = lEquals && this._Description.equals( lTest._Description );
         }
         if( this._Remarks == null )
         {
            lEquals = lEquals && ( lTest._Remarks == null );
         }
         else
         {
            lEquals = lEquals && this._Remarks.equals( lTest._Remarks );
         }
         lEquals = lEquals && this.number == lTest.number;
         lEquals = lEquals && this._Family_number == lTest._Family_number;

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

      result = 37*result + ((this._Remarks != null) ? this._Remarks.hashCode() : 0);

      result = 37*result + (int) number;

      result = 37*result + (int) _Family_number;

      return result;
   }

}
