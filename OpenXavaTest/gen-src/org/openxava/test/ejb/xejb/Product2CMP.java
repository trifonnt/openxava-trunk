/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb.xejb;

/**
 * CMP layer for Product2.
 */
public abstract class Product2CMP
   extends org.openxava.test.ejb.xejb.Product2Bean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.ejb.Product2Data getData()
   {
      org.openxava.test.ejb.Product2Data dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.ejb.Product2Data();

         dataHolder.set_UnitPrice( get_UnitPrice() );
         dataHolder.set_Description( get_Description() );
         dataHolder.setNumber( getNumber() );
         dataHolder.setWarehouse_zoneNumber( getWarehouse_zoneNumber() );
         dataHolder.setWarehouse_number( getWarehouse_number() );
         dataHolder.setFamily_number( getFamily_number() );
         dataHolder.setSubfamily_number( getSubfamily_number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.ejb.Product2Data dataHolder )
   {
      try
      {
         set_UnitPrice( dataHolder.get_UnitPrice() );
         set_Description( dataHolder.get_Description() );
         setWarehouse_zoneNumber( dataHolder.getWarehouse_zoneNumber() );
         setWarehouse_number( dataHolder.getWarehouse_number() );
         setFamily_number( dataHolder.getFamily_number() );
         setSubfamily_number( dataHolder.getSubfamily_number() );

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

      Product2Value = null;
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

   private org.openxava.test.ejb.Product2Value Product2Value = null;

   public org.openxava.test.ejb.Product2Value getProduct2Value()
   {
      Product2Value = new org.openxava.test.ejb.Product2Value();
      try
         {
            Product2Value.setUnitPrice( getUnitPrice() );
            Product2Value.setDescription( getDescription() );
            Product2Value.setUnitPriceInPesetas( getUnitPriceInPesetas() );
            Product2Value.setNumber( getNumber() );
            Product2Value.setWarehouse_zoneNumber( getWarehouse_zoneNumber() );
            Product2Value.setWarehouse_number( getWarehouse_number() );
            Product2Value.setFamily_number( getFamily_number() );
            Product2Value.setSubfamily_number( getSubfamily_number() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return Product2Value;
   }

   public void setProduct2Value( org.openxava.test.ejb.Product2Value valueHolder )
   {

	  try
	  {
		 setUnitPrice( valueHolder.getUnitPrice() );
		 setDescription( valueHolder.getDescription() );
		 setUnitPriceInPesetas( valueHolder.getUnitPriceInPesetas() );
		 setWarehouse_zoneNumber( valueHolder.getWarehouse_zoneNumber() );
		 setWarehouse_number( valueHolder.getWarehouse_number() );
		 setFamily_number( valueHolder.getFamily_number() );
		 setSubfamily_number( valueHolder.getSubfamily_number() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.math.BigDecimal get_UnitPrice() ;

   public abstract void set_UnitPrice( java.math.BigDecimal _UnitPrice ) ;

   public abstract java.lang.String get_Description() ;

   public abstract void set_Description( java.lang.String _Description ) ;

   public abstract long getNumber() ;

   public abstract void setNumber( long number ) ;

   public abstract int getWarehouse_zoneNumber() ;

   public abstract void setWarehouse_zoneNumber( int warehouse_zoneNumber ) ;

   public abstract java.lang.Integer getWarehouse_number() ;

   public abstract void setWarehouse_number( java.lang.Integer warehouse_number ) ;

   public abstract int getFamily_number() ;

   public abstract void setFamily_number( int family_number ) ;

   public abstract int getSubfamily_number() ;

   public abstract void setSubfamily_number( int subfamily_number ) ;

}
