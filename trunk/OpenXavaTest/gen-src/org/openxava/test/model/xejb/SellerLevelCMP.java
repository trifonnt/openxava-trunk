/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for SellerLevel.
 */
public abstract class SellerLevelCMP
   extends org.openxava.test.model.xejb.SellerLevelBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.SellerLevelData getData()
   {
      org.openxava.test.model.SellerLevelData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.SellerLevelData();

         dataHolder.setId( getId() );
         dataHolder.set_Description( get_Description() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.SellerLevelData dataHolder )
   {
      try
      {
         set_Description( dataHolder.get_Description() );

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

      SellerLevelValue = null;
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

   private org.openxava.test.model.SellerLevelValue SellerLevelValue = null;

   public org.openxava.test.model.SellerLevelValue getSellerLevelValue()
   {
      SellerLevelValue = new org.openxava.test.model.SellerLevelValue();
      try
         {
            SellerLevelValue.setId( getId() );
            SellerLevelValue.setDescription( getDescription() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return SellerLevelValue;
   }

   public void setSellerLevelValue( org.openxava.test.model.SellerLevelValue valueHolder )
   {

	  try
	  {
		 setDescription( valueHolder.getDescription() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.String getId() ;

   public abstract void setId( java.lang.String id ) ;

   public abstract java.lang.String get_Description() ;

   public abstract void set_Description( java.lang.String _Description ) ;

}
