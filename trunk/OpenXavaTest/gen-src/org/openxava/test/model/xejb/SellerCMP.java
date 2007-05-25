/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for Seller.
 */
public abstract class SellerCMP
   extends org.openxava.test.model.xejb.SellerBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.SellerData getData()
   {
      org.openxava.test.model.SellerData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.SellerData();

         dataHolder.set_Name( get_Name() );
         dataHolder.setNumber( getNumber() );
         dataHolder.set_Regions( get_Regions() );
         dataHolder.set_Level_id( get_Level_id() );
         dataHolder.set_Boss_number( get_Boss_number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.SellerData dataHolder )
   {
      try
      {
         set_Name( dataHolder.get_Name() );
         set_Regions( dataHolder.get_Regions() );
         set_Level_id( dataHolder.get_Level_id() );
         set_Boss_number( dataHolder.get_Boss_number() );

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

      SellerValue = null;
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

   private org.openxava.test.model.SellerValue SellerValue = null;

   public org.openxava.test.model.SellerValue getSellerValue()
   {
      SellerValue = new org.openxava.test.model.SellerValue();
      try
         {
            SellerValue.setName( getName() );
            SellerValue.setNumber( getNumber() );
            SellerValue.setRegions( getRegions() );
            SellerValue.setLevel_id( getLevel_id() );
            SellerValue.setBoss_number( getBoss_number() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return SellerValue;
   }

   public void setSellerValue( org.openxava.test.model.SellerValue valueHolder )
   {

	  try
	  {
		 setName( valueHolder.getName() );
		 setRegions( valueHolder.getRegions() );
		 setLevel_id( valueHolder.getLevel_id() );
		 setBoss_number( valueHolder.getBoss_number() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.String get_Name() ;

   public abstract void set_Name( java.lang.String _Name ) ;

   public abstract int getNumber() ;

   public abstract void setNumber( int number ) ;

   public abstract java.lang.String get_Regions() ;

   public abstract void set_Regions( java.lang.String _Regions ) ;

   public abstract java.lang.String get_Level_id() ;

   public abstract void set_Level_id( java.lang.String _Level_id ) ;

   public abstract int get_Boss_number() ;

   public abstract void set_Boss_number( int _Boss_number ) ;

}
