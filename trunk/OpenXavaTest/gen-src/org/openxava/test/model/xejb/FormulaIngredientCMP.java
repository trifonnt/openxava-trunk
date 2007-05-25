/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model.xejb;

/**
 * CMP layer for FormulaIngredient.
 */
public abstract class FormulaIngredientCMP
   extends org.openxava.test.model.xejb.FormulaIngredientBean
   implements javax.ejb.EntityBean
{

   public org.openxava.test.model.FormulaIngredientData getData()
   {
      org.openxava.test.model.FormulaIngredientData dataHolder = null;
      try
      {
         dataHolder = new org.openxava.test.model.FormulaIngredientData();

         dataHolder.setOid( getOid() );
         dataHolder.set_Accentuate_oid( get_Accentuate_oid() );
         dataHolder.set_Ingredient_oid( get_Ingredient_oid() );
         dataHolder.set_Formula_oid( get_Formula_oid() );
         dataHolder.set_AnotherFormula_oid( get_AnotherFormula_oid() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( org.openxava.test.model.FormulaIngredientData dataHolder )
   {
      try
      {
         set_Accentuate_oid( dataHolder.get_Accentuate_oid() );
         set_Ingredient_oid( dataHolder.get_Ingredient_oid() );
         set_Formula_oid( dataHolder.get_Formula_oid() );
         set_AnotherFormula_oid( dataHolder.get_AnotherFormula_oid() );

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

      FormulaIngredientValue = null;
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

   private org.openxava.test.model.FormulaIngredientValue FormulaIngredientValue = null;

   public org.openxava.test.model.FormulaIngredientValue getFormulaIngredientValue()
   {
      FormulaIngredientValue = new org.openxava.test.model.FormulaIngredientValue();
      try
         {
            FormulaIngredientValue.setOid( getOid() );
            FormulaIngredientValue.setAccentuate_oid( getAccentuate_oid() );
            FormulaIngredientValue.setIngredient_oid( getIngredient_oid() );
            FormulaIngredientValue.setFormula_oid( getFormula_oid() );
            FormulaIngredientValue.setAnotherFormula_oid( getAnotherFormula_oid() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return FormulaIngredientValue;
   }

   public void setFormulaIngredientValue( org.openxava.test.model.FormulaIngredientValue valueHolder )
   {

	  try
	  {
		 setAccentuate_oid( valueHolder.getAccentuate_oid() );
		 setIngredient_oid( valueHolder.getIngredient_oid() );
		 setFormula_oid( valueHolder.getFormula_oid() );
		 setAnotherFormula_oid( valueHolder.getAnotherFormula_oid() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.String getOid() ;

   public abstract void setOid( java.lang.String oid ) ;

   public abstract java.lang.String get_Accentuate_oid() ;

   public abstract void set_Accentuate_oid( java.lang.String _Accentuate_oid ) ;

   public abstract java.lang.String get_Ingredient_oid() ;

   public abstract void set_Ingredient_oid( java.lang.String _Ingredient_oid ) ;

   public abstract java.lang.String get_Formula_oid() ;

   public abstract void set_Formula_oid( java.lang.String _Formula_oid ) ;

   public abstract java.lang.String get_AnotherFormula_oid() ;

   public abstract void set_AnotherFormula_oid( java.lang.String _AnotherFormula_oid ) ;

}
