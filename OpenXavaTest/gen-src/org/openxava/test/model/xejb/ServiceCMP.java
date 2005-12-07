/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for Service.
 */
public abstract class ServiceCMP
   extends org.openxava.test.model.xejb.ServiceBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.ServiceData getData()
   {
      org.openxava.test.model.ServiceData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.ServiceData();

         dataHolder.set_Family( get_Family() );
         dataHolder.set_Description( get_Description() );
         dataHolder.setNumber( getNumber() );
         dataHolder.set_Detail_free( get_Detail_free() );
         dataHolder.set_Detail_type( get_Detail_type() );
         dataHolder.set_Detail_subfamily( get_Detail_subfamily() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.ServiceData dataHolder )
   {
      try
      {
         set_Family( dataHolder.get_Family() );
         set_Description( dataHolder.get_Description() );
         set_Detail_free( dataHolder.get_Detail_free() );
         set_Detail_type( dataHolder.get_Detail_type() );
         set_Detail_subfamily( dataHolder.get_Detail_subfamily() );

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

      ServiceValue = null;
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

   private org.openxava.test.model.ServiceValue ServiceValue = null;

   public org.openxava.test.model.ServiceValue getServiceValue()
   {
      ServiceValue = new org.openxava.test.model.ServiceValue();
      try
         {
            ServiceValue.setFamily( getFamily() );
            ServiceValue.setDescription( getDescription() );
            ServiceValue.setNumber( getNumber() );
            ServiceValue.setDetail( getDetail() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return ServiceValue;
   }

   public void setServiceValue( org.openxava.test.model.ServiceValue valueHolder )
   {

	  try
	  {
		 setFamily( valueHolder.getFamily() );
		 setDescription( valueHolder.getDescription() );
		 setDetail( valueHolder.getDetail() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.Integer get_Family() ;

   public abstract void set_Family( java.lang.Integer _Family ) ;

   public abstract java.lang.String get_Description() ;

   public abstract void set_Description( java.lang.String _Description ) ;

   public abstract int getNumber() ;

   public abstract void setNumber( int number ) ;

   public abstract java.lang.Integer get_Detail_free() ;

   public abstract void set_Detail_free( java.lang.Integer _Detail_free ) ;

   public abstract java.lang.Integer get_Detail_type() ;

   public abstract void set_Detail_type( java.lang.Integer _Detail_type ) ;

   public abstract java.lang.Integer get_Detail_subfamily() ;

   public abstract void set_Detail_subfamily( java.lang.Integer _Detail_subfamily ) ;

}
