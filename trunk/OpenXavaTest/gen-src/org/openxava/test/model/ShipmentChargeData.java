/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for ShipmentCharge.
 */
public class ShipmentChargeData
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.math.BigDecimal _Amount;
   private java.lang.String oid;
   private java.lang.Integer _Mode;
   private java.lang.String _Shipment_type;
   private int _Shipment_number;

   public ShipmentChargeData()
   {
   }

   public ShipmentChargeData( ShipmentChargeData otherData )
   {
      set_Amount(otherData.get_Amount());
      setOid(otherData.getOid());
      set_Mode(otherData.get_Mode());
      set_Shipment_type(otherData.get_Shipment_type());
      set_Shipment_number(otherData.get_Shipment_number());

   }

   public org.openxava.test.model.ShipmentChargeKey getPrimaryKey() {
     org.openxava.test.model.ShipmentChargeKey pk = new org.openxava.test.model.ShipmentChargeKey(this.getOid());
     return pk;
   }

   public java.math.BigDecimal get_Amount()
   {
      return this._Amount;
   }
   public void set_Amount( java.math.BigDecimal _Amount )
   {
      this._Amount = _Amount;
   }

   public java.lang.String getOid()
   {
      return this.oid;
   }
   public void setOid( java.lang.String oid )
   {
      this.oid = oid;
   }

   public java.lang.Integer get_Mode()
   {
      return this._Mode;
   }
   public void set_Mode( java.lang.Integer _Mode )
   {
      this._Mode = _Mode;
   }

   public java.lang.String get_Shipment_type()
   {
      return this._Shipment_type;
   }
   public void set_Shipment_type( java.lang.String _Shipment_type )
   {
      this._Shipment_type = _Shipment_type;
   }

   public int get_Shipment_number()
   {
      return this._Shipment_number;
   }
   public void set_Shipment_number( int _Shipment_number )
   {
      this._Shipment_number = _Shipment_number;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Amount=" + get_Amount() + " " + "oid=" + getOid() + " " + "_Mode=" + get_Mode() + " " + "_Shipment_type=" + get_Shipment_type() + " " + "_Shipment_number=" + get_Shipment_number());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof ShipmentChargeData )
      {
         ShipmentChargeData lTest = (ShipmentChargeData) pOther;
         boolean lEquals = true;

         if( this._Amount == null )
         {
            lEquals = lEquals && ( lTest._Amount == null );
         }
         else
         {
            lEquals = lEquals && this._Amount.equals( lTest._Amount );
         }
         if( this.oid == null )
         {
            lEquals = lEquals && ( lTest.oid == null );
         }
         else
         {
            lEquals = lEquals && this.oid.equals( lTest.oid );
         }
         if( this._Mode == null )
         {
            lEquals = lEquals && ( lTest._Mode == null );
         }
         else
         {
            lEquals = lEquals && this._Mode.equals( lTest._Mode );
         }
         if( this._Shipment_type == null )
         {
            lEquals = lEquals && ( lTest._Shipment_type == null );
         }
         else
         {
            lEquals = lEquals && this._Shipment_type.equals( lTest._Shipment_type );
         }
         lEquals = lEquals && this._Shipment_number == lTest._Shipment_number;

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

      result = 37*result + ((this._Amount != null) ? this._Amount.hashCode() : 0);

      result = 37*result + ((this.oid != null) ? this.oid.hashCode() : 0);

      result = 37*result + ((this._Mode != null) ? this._Mode.hashCode() : 0);

      result = 37*result + ((this._Shipment_type != null) ? this._Shipment_type.hashCode() : 0);

      result = 37*result + (int) _Shipment_number;

      return result;
   }

}
