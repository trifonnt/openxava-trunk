/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb.xejb;

/**
 * CMP layer for Invoice.
 */
public abstract class InvoiceCMP
   extends org.openxava.test.ejb.xejb.InvoiceBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.ejb.InvoiceData getData()
   {
      org.openxava.test.ejb.InvoiceData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.ejb.InvoiceData();

         dataHolder.set_Comment( get_Comment() );
         dataHolder.setDate( getDate() );
         dataHolder.set_Paid( get_Paid() );
         dataHolder.setYear( getYear() );
         dataHolder.set_VatPercentage( get_VatPercentage() );
         dataHolder.setNumber( getNumber() );
         dataHolder.setCustomer_number( getCustomer_number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.ejb.InvoiceData dataHolder )
   {
      try
      {
         set_Comment( dataHolder.get_Comment() );
         setDate( dataHolder.getDate() );
         set_Paid( dataHolder.get_Paid() );
         set_VatPercentage( dataHolder.get_VatPercentage() );
         setCustomer_number( dataHolder.getCustomer_number() );

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

      InvoiceValue = null;
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

   }

 /* Value Objects BEGIN */

   private org.openxava.test.ejb.InvoiceValue InvoiceValue = null;

   public org.openxava.test.ejb.InvoiceValue getInvoiceValue()
   {
      InvoiceValue = new org.openxava.test.ejb.InvoiceValue();
      try
         {
            InvoiceValue.setComment( getComment() );
            InvoiceValue.setDate( getDate() );
            InvoiceValue.setPaid( isPaid() );
            InvoiceValue.setDetailsCount( getDetailsCount() );
            InvoiceValue.setYearDiscount( getYearDiscount() );
            InvoiceValue.setAmountsSum( getAmountsSum() );
            InvoiceValue.setImportance( getImportance() );
            InvoiceValue.setYear( getYear() );
            InvoiceValue.setCustomerDiscount( getCustomerDiscount() );
            InvoiceValue.setVatPercentage( getVatPercentage() );
            InvoiceValue.setCustomerTypeDiscount( getCustomerTypeDiscount() );
            InvoiceValue.setVat( getVat() );
            InvoiceValue.setNumber( getNumber() );
            InvoiceValue.setCustomer_number( getCustomer_number() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return InvoiceValue;
   }

   public void setInvoiceValue( org.openxava.test.ejb.InvoiceValue valueHolder )
   {

	  try
	  {
		 setComment( valueHolder.getComment() );
		 setDate( valueHolder.getDate() );
		 setPaid( valueHolder.isPaid() );
		 setDetailsCount( valueHolder.getDetailsCount() );
		 setYearDiscount( valueHolder.getYearDiscount() );
		 setAmountsSum( valueHolder.getAmountsSum() );
		 setImportance( valueHolder.getImportance() );
		 setCustomerDiscount( valueHolder.getCustomerDiscount() );
		 setVatPercentage( valueHolder.getVatPercentage() );
		 setCustomerTypeDiscount( valueHolder.getCustomerTypeDiscount() );
		 setVat( valueHolder.getVat() );
		 setCustomer_number( valueHolder.getCustomer_number() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.String get_Comment() ;

   public abstract void set_Comment( java.lang.String _Comment ) ;

   public abstract java.util.Date getDate() ;

   public abstract void setDate( java.util.Date date ) ;

   public abstract java.lang.String get_Paid() ;

   public abstract void set_Paid( java.lang.String _Paid ) ;

   public abstract int getYear() ;

   public abstract void setYear( int year ) ;

   public abstract java.math.BigDecimal get_VatPercentage() ;

   public abstract void set_VatPercentage( java.math.BigDecimal _VatPercentage ) ;

   public abstract int getNumber() ;

   public abstract void setNumber( int number ) ;

   public abstract int getCustomer_number() ;

   public abstract void setCustomer_number( int customer_number ) ;

}
