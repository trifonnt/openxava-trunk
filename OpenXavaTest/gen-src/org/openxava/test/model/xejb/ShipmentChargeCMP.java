/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for ShipmentCharge.
 */
public abstract class ShipmentChargeCMP
   extends org.openxava.test.model.xejb.ShipmentChargeBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.ShipmentChargeData getData()
   {
      org.openxava.test.model.ShipmentChargeData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.ShipmentChargeData();

         dataHolder.set_Amount( get_Amount() );
         dataHolder.setOid( getOid() );
         dataHolder.set_Mode( get_Mode() );
         dataHolder.set_Shipment_type( get_Shipment_type() );
         dataHolder.set_Shipment_number( get_Shipment_number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.ShipmentChargeData dataHolder )
   {
      try
      {
         set_Amount( dataHolder.get_Amount() );
         set_Mode( dataHolder.get_Mode() );
         set_Shipment_type( dataHolder.get_Shipment_type() );
         set_Shipment_number( dataHolder.get_Shipment_number() );

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

      ShipmentChargeValue = null;
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

   private org.openxava.test.model.ShipmentChargeValue ShipmentChargeValue = null;

   public org.openxava.test.model.ShipmentChargeValue getShipmentChargeValue()
   {
      ShipmentChargeValue = new org.openxava.test.model.ShipmentChargeValue();
      try
         {
            ShipmentChargeValue.setAmount( getAmount() );
            ShipmentChargeValue.setOid( getOid() );
            ShipmentChargeValue.setMode( getMode() );
            ShipmentChargeValue.setShipment_type( getShipment_type() );
            ShipmentChargeValue.setShipment_mode( getShipment_mode() );
            ShipmentChargeValue.setShipment_number( getShipment_number() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return ShipmentChargeValue;
   }

   public void setShipmentChargeValue( org.openxava.test.model.ShipmentChargeValue valueHolder )
   {

	  try
	  {
		 setAmount( valueHolder.getAmount() );
		 setMode( valueHolder.getMode() );
		 setShipment_type( valueHolder.getShipment_type() );
		 setShipment_mode( valueHolder.getShipment_mode() );
		 setShipment_number( valueHolder.getShipment_number() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.math.BigDecimal get_Amount() ;

   public abstract void set_Amount( java.math.BigDecimal _Amount ) ;

   public abstract java.lang.String getOid() ;

   public abstract void setOid( java.lang.String oid ) ;

   public abstract java.lang.Integer get_Mode() ;

   public abstract void set_Mode( java.lang.Integer _Mode ) ;

   public abstract java.lang.String get_Shipment_type() ;

   public abstract void set_Shipment_type( java.lang.String _Shipment_type ) ;

   public abstract int get_Shipment_number() ;

   public abstract void set_Shipment_number( int _Shipment_number ) ;

}
