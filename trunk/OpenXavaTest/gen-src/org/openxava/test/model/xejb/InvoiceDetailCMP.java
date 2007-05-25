/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for InvoiceDetail.
 */
public abstract class InvoiceDetailCMP
   extends org.openxava.test.model.xejb.InvoiceDetailBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.InvoiceDetailData getData()
   {
      org.openxava.test.model.InvoiceDetailData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.InvoiceDetailData();

         dataHolder.setOid( getOid() );
         dataHolder.set_Remarks( get_Remarks() );
         dataHolder.setDeliveryDate_day( getDeliveryDate_day() );
         dataHolder.setDeliveryDate_month( getDeliveryDate_month() );
         dataHolder.setDeliveryDate_year( getDeliveryDate_year() );
         dataHolder.set_UnitPrice( get_UnitPrice() );
         dataHolder.set_Quantity( get_Quantity() );
         dataHolder.set_ServiceType( get_ServiceType() );
         dataHolder.set_Product_number( get_Product_number() );
         dataHolder.set_Invoice_year( get_Invoice_year() );
         dataHolder.set_Invoice_number( get_Invoice_number() );
         dataHolder.set_SoldBy_number( get_SoldBy_number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.InvoiceDetailData dataHolder )
   {
      try
      {
         set_Remarks( dataHolder.get_Remarks() );
         setDeliveryDate_day( dataHolder.getDeliveryDate_day() );
         setDeliveryDate_month( dataHolder.getDeliveryDate_month() );
         setDeliveryDate_year( dataHolder.getDeliveryDate_year() );
         set_UnitPrice( dataHolder.get_UnitPrice() );
         set_Quantity( dataHolder.get_Quantity() );
         set_ServiceType( dataHolder.get_ServiceType() );
         set_Product_number( dataHolder.get_Product_number() );
         set_Invoice_year( dataHolder.get_Invoice_year() );
         set_Invoice_number( dataHolder.get_Invoice_number() );
         set_SoldBy_number( dataHolder.get_SoldBy_number() );

      }
      catch (Exception e)
      {
         throw new javax.ejb.EJBException(e);
      }
   }

   public void ejbLoad() 
   {
      super.ejbLoad();
   }

   public void ejbStore() 
   {
         super.ejbStore();
   }

   public void ejbActivate() 
   {
   }

   public void ejbPassivate() 
   {

      InvoiceDetailValue = null;
   }

   public void setEntityContext(javax.ejb.EntityContext ctx) 
   {
      super.setEntityContext(ctx);
   }

   public void unsetEntityContext() 
   {
      super.unsetEntityContext();
   }

   public void ejbRemove() throws javax.ejb.RemoveException
   {
      super.ejbRemove();

   }

 /* Value Objects BEGIN */

   private org.openxava.test.model.InvoiceDetailValue InvoiceDetailValue = null;

   public org.openxava.test.model.InvoiceDetailValue getInvoiceDetailValue()
   {
      InvoiceDetailValue = new org.openxava.test.model.InvoiceDetailValue();
      try
         {
            InvoiceDetailValue.setAmount( getAmount() );
            InvoiceDetailValue.setOid( getOid() );
            InvoiceDetailValue.setRemarks( getRemarks() );
            InvoiceDetailValue.setDeliveryDate( getDeliveryDate() );
            InvoiceDetailValue.setUnitPrice( getUnitPrice() );
            InvoiceDetailValue.setQuantity( getQuantity() );
            InvoiceDetailValue.setServiceType( getServiceType() );
            InvoiceDetailValue.setProduct_number( getProduct_number() );
            InvoiceDetailValue.setInvoice_year( getInvoice_year() );
            InvoiceDetailValue.setInvoice_number( getInvoice_number() );
            InvoiceDetailValue.setSoldBy_number( getSoldBy_number() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return InvoiceDetailValue;
   }

   public void setInvoiceDetailValue( org.openxava.test.model.InvoiceDetailValue valueHolder )
   {

	  try
	  {
		 setAmount( valueHolder.getAmount() );
		 setRemarks( valueHolder.getRemarks() );
		 setDeliveryDate( valueHolder.getDeliveryDate() );
		 setUnitPrice( valueHolder.getUnitPrice() );
		 setQuantity( valueHolder.getQuantity() );
		 setServiceType( valueHolder.getServiceType() );
		 setProduct_number( valueHolder.getProduct_number() );
		 setInvoice_year( valueHolder.getInvoice_year() );
		 setInvoice_number( valueHolder.getInvoice_number() );
		 setSoldBy_number( valueHolder.getSoldBy_number() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.String getOid() ;

   public abstract void setOid( java.lang.String oid ) ;

   public abstract java.lang.String get_Remarks() ;

   public abstract void set_Remarks( java.lang.String _Remarks ) ;

   public abstract int getDeliveryDate_day() ;

   public abstract void setDeliveryDate_day( int deliveryDate_day ) ;

   public abstract int getDeliveryDate_month() ;

   public abstract void setDeliveryDate_month( int deliveryDate_month ) ;

   public abstract int getDeliveryDate_year() ;

   public abstract void setDeliveryDate_year( int deliveryDate_year ) ;

   public abstract java.math.BigDecimal get_UnitPrice() ;

   public abstract void set_UnitPrice( java.math.BigDecimal _UnitPrice ) ;

   public abstract java.lang.Integer get_Quantity() ;

   public abstract void set_Quantity( java.lang.Integer _Quantity ) ;

   public abstract java.lang.Integer get_ServiceType() ;

   public abstract void set_ServiceType( java.lang.Integer _ServiceType ) ;

   public abstract long get_Product_number() ;

   public abstract void set_Product_number( long _Product_number ) ;

   public abstract int get_Invoice_year() ;

   public abstract void set_Invoice_year( int _Invoice_year ) ;

   public abstract int get_Invoice_number() ;

   public abstract void set_Invoice_number( int _Invoice_number ) ;

   public abstract int get_SoldBy_number() ;

   public abstract void set_SoldBy_number( int _SoldBy_number ) ;

}
