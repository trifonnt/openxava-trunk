/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for AverageSpeed.
 */
public class AverageSpeedData
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.lang.Integer _Speed;
   private java.lang.String oid;
   private java.lang.String _Vehicle_oid;
   private java.lang.Integer _Driver_number;

   public AverageSpeedData()
   {
   }

   public AverageSpeedData( AverageSpeedData otherData )
   {
      set_Speed(otherData.get_Speed());
      setOid(otherData.getOid());
      set_Vehicle_oid(otherData.get_Vehicle_oid());
      set_Driver_number(otherData.get_Driver_number());

   }

   public org.openxava.test.model.AverageSpeedKey getPrimaryKey() {
     org.openxava.test.model.AverageSpeedKey pk = new org.openxava.test.model.AverageSpeedKey(this.getOid());
     return pk;
   }

   public java.lang.Integer get_Speed()
   {
      return this._Speed;
   }
   public void set_Speed( java.lang.Integer _Speed )
   {
      this._Speed = _Speed;
   }

   public java.lang.String getOid()
   {
      return this.oid;
   }
   public void setOid( java.lang.String oid )
   {
      this.oid = oid;
   }

   public java.lang.String get_Vehicle_oid()
   {
      return this._Vehicle_oid;
   }
   public void set_Vehicle_oid( java.lang.String _Vehicle_oid )
   {
      this._Vehicle_oid = _Vehicle_oid;
   }

   public java.lang.Integer get_Driver_number()
   {
      return this._Driver_number;
   }
   public void set_Driver_number( java.lang.Integer _Driver_number )
   {
      this._Driver_number = _Driver_number;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Speed=" + get_Speed() + " " + "oid=" + getOid() + " " + "_Vehicle_oid=" + get_Vehicle_oid() + " " + "_Driver_number=" + get_Driver_number());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof AverageSpeedData )
      {
         AverageSpeedData lTest = (AverageSpeedData) pOther;
         boolean lEquals = true;

         if( this._Speed == null )
         {
            lEquals = lEquals && ( lTest._Speed == null );
         }
         else
         {
            lEquals = lEquals && this._Speed.equals( lTest._Speed );
         }
         if( this.oid == null )
         {
            lEquals = lEquals && ( lTest.oid == null );
         }
         else
         {
            lEquals = lEquals && this.oid.equals( lTest.oid );
         }
         if( this._Vehicle_oid == null )
         {
            lEquals = lEquals && ( lTest._Vehicle_oid == null );
         }
         else
         {
            lEquals = lEquals && this._Vehicle_oid.equals( lTest._Vehicle_oid );
         }
         if( this._Driver_number == null )
         {
            lEquals = lEquals && ( lTest._Driver_number == null );
         }
         else
         {
            lEquals = lEquals && this._Driver_number.equals( lTest._Driver_number );
         }

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

      result = 37*result + ((this._Speed != null) ? this._Speed.hashCode() : 0);

      result = 37*result + ((this.oid != null) ? this.oid.hashCode() : 0);

      result = 37*result + ((this._Vehicle_oid != null) ? this._Vehicle_oid.hashCode() : 0);

      result = 37*result + ((this._Driver_number != null) ? this._Driver_number.hashCode() : 0);

      return result;
   }

}
