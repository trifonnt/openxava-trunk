/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Data object for InvoiceDetail.
 */
public class InvoiceDetailData
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.math.BigDecimal _UnitPrice;
   private java.lang.String oid;
   private java.lang.String _Remarks;
   private int deliveryDate_day;
   private int deliveryDate_month;
   private int deliveryDate_year;
   private java.lang.Integer _Quantity;
   private java.lang.Integer _ServiceType;
   private long product_number;
   private int soldBy_number;
   private int invoice_year;
   private int invoice_number;

  /*
  // begin value object
   private org.openxava.test.ejb.InvoiceDetailValue InvoiceDetailValue = null;

   public org.openxava.test.ejb.InvoiceDetailValue getInvoiceDetailValue()
   {
	  if( InvoiceDetailValue == null )
	  {
          InvoiceDetailValue = new org.openxava.test.ejb.InvoiceDetailValue();
	  }
      try
         {
            InvoiceDetailValue.setAmount( getAmount() );
            InvoiceDetailValue.setUnitPrice( getUnitPrice() );
            InvoiceDetailValue.setOid( getOid() );
            InvoiceDetailValue.setRemarks( getRemarks() );
            InvoiceDetailValue.setDeliveryDate( getDeliveryDate() );
            InvoiceDetailValue.setQuantity( getQuantity() );
            InvoiceDetailValue.setServiceType( getServiceType() );
            InvoiceDetailValue.setProduct_number( getProduct_number() );
            InvoiceDetailValue.setSoldBy_number( getSoldBy_number() );
            InvoiceDetailValue.setInvoice_year( getInvoice_year() );
            InvoiceDetailValue.setInvoice_number( getInvoice_number() );
                   }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return InvoiceDetailValue;
   }

   public void setInvoiceDetailValue( org.openxava.test.ejb.InvoiceDetailValue valueHolder )
   {

	  try
	  {
		 setAmount( valueHolder.getAmount() );
		 setUnitPrice( valueHolder.getUnitPrice() );
		 setRemarks( valueHolder.getRemarks() );
		 setDeliveryDate( valueHolder.getDeliveryDate() );
		 setQuantity( valueHolder.getQuantity() );
		 setServiceType( valueHolder.getServiceType() );
		 setProduct_number( valueHolder.getProduct_number() );
		 setSoldBy_number( valueHolder.getSoldBy_number() );
		 setInvoice_year( valueHolder.getInvoice_year() );
		 setInvoice_number( valueHolder.getInvoice_number() );
	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

  // end value object

 */

   public InvoiceDetailData()
   {
   }

  /*
   public InvoiceDetailData( java.math.BigDecimal _UnitPrice,java.lang.String oid,java.lang.String _Remarks,int deliveryDate_day,int deliveryDate_month,int deliveryDate_year,java.lang.Integer _Quantity,java.lang.Integer _ServiceType,long product_number,int soldBy_number,int invoice_year,int invoice_number )
   {
      set_UnitPrice(_UnitPrice);
      setOid(oid);
      set_Remarks(_Remarks);
      setDeliveryDate_day(deliveryDate_day);
      setDeliveryDate_month(deliveryDate_month);
      setDeliveryDate_year(deliveryDate_year);
      set_Quantity(_Quantity);
      set_ServiceType(_ServiceType);
      setProduct_number(product_number);
      setSoldBy_number(soldBy_number);
      setInvoice_year(invoice_year);
      setInvoice_number(invoice_number);
   }
   */

   public InvoiceDetailData( InvoiceDetailData otherData )
   {
      set_UnitPrice(otherData.get_UnitPrice());
      setOid(otherData.getOid());
      set_Remarks(otherData.get_Remarks());
      setDeliveryDate_day(otherData.getDeliveryDate_day());
      setDeliveryDate_month(otherData.getDeliveryDate_month());
      setDeliveryDate_year(otherData.getDeliveryDate_year());
      set_Quantity(otherData.get_Quantity());
      set_ServiceType(otherData.get_ServiceType());
      setProduct_number(otherData.getProduct_number());
      setSoldBy_number(otherData.getSoldBy_number());
      setInvoice_year(otherData.getInvoice_year());
      setInvoice_number(otherData.getInvoice_number());

   }

   public org.openxava.test.ejb.InvoiceDetailKey getPrimaryKey() {
     org.openxava.test.ejb.InvoiceDetailKey pk = new org.openxava.test.ejb.InvoiceDetailKey(this.getOid());
     return pk;
   }

   public java.math.BigDecimal get_UnitPrice()
   {
      return this._UnitPrice;
   }
   public void set_UnitPrice( java.math.BigDecimal _UnitPrice )
   {
      this._UnitPrice = _UnitPrice;
   }

   public java.lang.String getOid()
   {
      return this.oid;
   }
   public void setOid( java.lang.String oid )
   {
      this.oid = oid;
   }

   public java.lang.String get_Remarks()
   {
      return this._Remarks;
   }
   public void set_Remarks( java.lang.String _Remarks )
   {
      this._Remarks = _Remarks;
   }

   public int getDeliveryDate_day()
   {
      return this.deliveryDate_day;
   }
   public void setDeliveryDate_day( int deliveryDate_day )
   {
      this.deliveryDate_day = deliveryDate_day;
   }

   public int getDeliveryDate_month()
   {
      return this.deliveryDate_month;
   }
   public void setDeliveryDate_month( int deliveryDate_month )
   {
      this.deliveryDate_month = deliveryDate_month;
   }

   public int getDeliveryDate_year()
   {
      return this.deliveryDate_year;
   }
   public void setDeliveryDate_year( int deliveryDate_year )
   {
      this.deliveryDate_year = deliveryDate_year;
   }

   public java.lang.Integer get_Quantity()
   {
      return this._Quantity;
   }
   public void set_Quantity( java.lang.Integer _Quantity )
   {
      this._Quantity = _Quantity;
   }

   public java.lang.Integer get_ServiceType()
   {
      return this._ServiceType;
   }
   public void set_ServiceType( java.lang.Integer _ServiceType )
   {
      this._ServiceType = _ServiceType;
   }

   public long getProduct_number()
   {
      return this.product_number;
   }
   public void setProduct_number( long product_number )
   {
      this.product_number = product_number;
   }

   public int getSoldBy_number()
   {
      return this.soldBy_number;
   }
   public void setSoldBy_number( int soldBy_number )
   {
      this.soldBy_number = soldBy_number;
   }

   public int getInvoice_year()
   {
      return this.invoice_year;
   }
   public void setInvoice_year( int invoice_year )
   {
      this.invoice_year = invoice_year;
   }

   public int getInvoice_number()
   {
      return this.invoice_number;
   }
   public void setInvoice_number( int invoice_number )
   {
      this.invoice_number = invoice_number;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_UnitPrice=" + get_UnitPrice() + " " + "oid=" + getOid() + " " + "_Remarks=" + get_Remarks() + " " + "deliveryDate_day=" + getDeliveryDate_day() + " " + "deliveryDate_month=" + getDeliveryDate_month() + " " + "deliveryDate_year=" + getDeliveryDate_year() + " " + "_Quantity=" + get_Quantity() + " " + "_ServiceType=" + get_ServiceType() + " " + "product_number=" + getProduct_number() + " " + "soldBy_number=" + getSoldBy_number() + " " + "invoice_year=" + getInvoice_year() + " " + "invoice_number=" + getInvoice_number());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof InvoiceDetailData )
      {
         InvoiceDetailData lTest = (InvoiceDetailData) pOther;
         boolean lEquals = true;

         if( this._UnitPrice == null )
         {
            lEquals = lEquals && ( lTest._UnitPrice == null );
         }
         else
         {
            lEquals = lEquals && this._UnitPrice.equals( lTest._UnitPrice );
         }
         if( this.oid == null )
         {
            lEquals = lEquals && ( lTest.oid == null );
         }
         else
         {
            lEquals = lEquals && this.oid.equals( lTest.oid );
         }
         if( this._Remarks == null )
         {
            lEquals = lEquals && ( lTest._Remarks == null );
         }
         else
         {
            lEquals = lEquals && this._Remarks.equals( lTest._Remarks );
         }
         lEquals = lEquals && this.deliveryDate_day == lTest.deliveryDate_day;
         lEquals = lEquals && this.deliveryDate_month == lTest.deliveryDate_month;
         lEquals = lEquals && this.deliveryDate_year == lTest.deliveryDate_year;
         if( this._Quantity == null )
         {
            lEquals = lEquals && ( lTest._Quantity == null );
         }
         else
         {
            lEquals = lEquals && this._Quantity.equals( lTest._Quantity );
         }
         if( this._ServiceType == null )
         {
            lEquals = lEquals && ( lTest._ServiceType == null );
         }
         else
         {
            lEquals = lEquals && this._ServiceType.equals( lTest._ServiceType );
         }
         lEquals = lEquals && this.product_number == lTest.product_number;
         lEquals = lEquals && this.soldBy_number == lTest.soldBy_number;
         lEquals = lEquals && this.invoice_year == lTest.invoice_year;
         lEquals = lEquals && this.invoice_number == lTest.invoice_number;

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

      result = 37*result + ((this._UnitPrice != null) ? this._UnitPrice.hashCode() : 0);

      result = 37*result + ((this.oid != null) ? this.oid.hashCode() : 0);

      result = 37*result + ((this._Remarks != null) ? this._Remarks.hashCode() : 0);

      result = 37*result + (int) deliveryDate_day;

      result = 37*result + (int) deliveryDate_month;

      result = 37*result + (int) deliveryDate_year;

      result = 37*result + ((this._Quantity != null) ? this._Quantity.hashCode() : 0);

      result = 37*result + ((this._ServiceType != null) ? this._ServiceType.hashCode() : 0);

      result = 37*result + (int)(product_number^(product_number>>>32));

      result = 37*result + (int) soldBy_number;

      result = 37*result + (int) invoice_year;

      result = 37*result + (int) invoice_number;

      return result;
   }

}
