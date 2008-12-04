/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for Subfamily.
 */
public abstract class SubfamilyCMP
   extends org.openxava.test.model.xejb.SubfamilyBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.SubfamilyData getData()
   {
      org.openxava.test.model.SubfamilyData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.SubfamilyData();

         dataHolder.set_FamilyNumber( get_FamilyNumber() );
         dataHolder.setOid( getOid() );
         dataHolder.set_Remarks( get_Remarks() );
         dataHolder.set_Description( get_Description() );
         dataHolder.set_Number( get_Number() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.SubfamilyData dataHolder )
   {
      try
      {
         set_FamilyNumber( dataHolder.get_FamilyNumber() );
         set_Remarks( dataHolder.get_Remarks() );
         set_Description( dataHolder.get_Description() );
         set_Number( dataHolder.get_Number() );

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

      SubfamilyValue = null;
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

   private org.openxava.test.model.SubfamilyValue SubfamilyValue = null;

   public org.openxava.test.model.SubfamilyValue getSubfamilyValue()
   {
      SubfamilyValue = new org.openxava.test.model.SubfamilyValue();
      try
         {
            SubfamilyValue.setFamily( getFamily() );
            SubfamilyValue.setFamilyNumber( getFamilyNumber() );
            SubfamilyValue.setOid( getOid() );
            SubfamilyValue.setRemarks( getRemarks() );
            SubfamilyValue.setDescription( getDescription() );
            SubfamilyValue.setRemarksDB( getRemarksDB() );
            SubfamilyValue.setNumber( getNumber() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return SubfamilyValue;
   }

   public void setSubfamilyValue( org.openxava.test.model.SubfamilyValue valueHolder )
   {

	  try
	  {
		 setFamily( valueHolder.getFamily() );
		 setFamilyNumber( valueHolder.getFamilyNumber() );
		 setRemarks( valueHolder.getRemarks() );
		 setDescription( valueHolder.getDescription() );
		 setRemarksDB( valueHolder.getRemarksDB() );
		 setNumber( valueHolder.getNumber() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.Integer get_FamilyNumber() ;

   public abstract void set_FamilyNumber( java.lang.Integer _FamilyNumber ) ;

   public abstract java.lang.String getOid() ;

   public abstract void setOid( java.lang.String oid ) ;

   public abstract java.lang.String get_Remarks() ;

   public abstract void set_Remarks( java.lang.String _Remarks ) ;

   public abstract java.lang.String get_Description() ;

   public abstract void set_Description( java.lang.String _Description ) ;

   public abstract java.lang.Integer get_Number() ;

   public abstract void set_Number( java.lang.Integer _Number ) ;

}
