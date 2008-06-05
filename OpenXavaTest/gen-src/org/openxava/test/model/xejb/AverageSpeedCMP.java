/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for AverageSpeed.
 */
public abstract class AverageSpeedCMP
   extends org.openxava.test.model.xejb.AverageSpeedBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.AverageSpeedData getData()
   {
      org.openxava.test.model.AverageSpeedData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.AverageSpeedData();

         dataHolder.set_Speed( get_Speed() );
         dataHolder.setOid( getOid() );
         dataHolder.set_Vehicle_oid( get_Vehicle_oid() );
         dataHolder.set_Driver_number( get_Driver_number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.AverageSpeedData dataHolder )
   {
      try
      {
         set_Speed( dataHolder.get_Speed() );
         set_Vehicle_oid( dataHolder.get_Vehicle_oid() );
         set_Driver_number( dataHolder.get_Driver_number() );

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

      AverageSpeedValue = null;
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

   private org.openxava.test.model.AverageSpeedValue AverageSpeedValue = null;

   public org.openxava.test.model.AverageSpeedValue getAverageSpeedValue()
   {
      AverageSpeedValue = new org.openxava.test.model.AverageSpeedValue();
      try
         {
            AverageSpeedValue.setSpeed( getSpeed() );
            AverageSpeedValue.setOid( getOid() );
            AverageSpeedValue.setVehicle_oid( getVehicle_oid() );
            AverageSpeedValue.setDriver_number( getDriver_number() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return AverageSpeedValue;
   }

   public void setAverageSpeedValue( org.openxava.test.model.AverageSpeedValue valueHolder )
   {

	  try
	  {
		 setSpeed( valueHolder.getSpeed() );
		 setVehicle_oid( valueHolder.getVehicle_oid() );
		 setDriver_number( valueHolder.getDriver_number() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.Integer get_Speed() ;

   public abstract void set_Speed( java.lang.Integer _Speed ) ;

   public abstract java.lang.String getOid() ;

   public abstract void setOid( java.lang.String oid ) ;

   public abstract java.lang.String get_Vehicle_oid() ;

   public abstract void set_Vehicle_oid( java.lang.String _Vehicle_oid ) ;

   public abstract java.lang.Integer get_Driver_number() ;

   public abstract void set_Driver_number( java.lang.Integer _Driver_number ) ;

}
