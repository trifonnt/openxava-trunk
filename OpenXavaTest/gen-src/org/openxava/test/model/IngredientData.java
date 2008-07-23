/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for Ingredient.
 */
public class IngredientData
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.lang.String oid;
   private java.lang.String _Name;
   private java.lang.String _FavouriteFormula_oid;
   private java.lang.String _PartOf_oid;

   public IngredientData()
   {
   }

   public IngredientData( IngredientData otherData )
   {
      setOid(otherData.getOid());
      set_Name(otherData.get_Name());
      set_FavouriteFormula_oid(otherData.get_FavouriteFormula_oid());
      set_PartOf_oid(otherData.get_PartOf_oid());

   }

   public org.openxava.test.model.IngredientKey getPrimaryKey() {
     org.openxava.test.model.IngredientKey pk = new org.openxava.test.model.IngredientKey(this.getOid());
     return pk;
   }

   public java.lang.String getOid()
   {
      return this.oid;
   }
   public void setOid( java.lang.String oid )
   {
      this.oid = oid;
   }

   public java.lang.String get_Name()
   {
      return this._Name;
   }
   public void set_Name( java.lang.String _Name )
   {
      this._Name = _Name;
   }

   public java.lang.String get_FavouriteFormula_oid()
   {
      return this._FavouriteFormula_oid;
   }
   public void set_FavouriteFormula_oid( java.lang.String _FavouriteFormula_oid )
   {
      this._FavouriteFormula_oid = _FavouriteFormula_oid;
   }

   public java.lang.String get_PartOf_oid()
   {
      return this._PartOf_oid;
   }
   public void set_PartOf_oid( java.lang.String _PartOf_oid )
   {
      this._PartOf_oid = _PartOf_oid;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("oid=" + getOid() + " " + "_Name=" + get_Name() + " " + "_FavouriteFormula_oid=" + get_FavouriteFormula_oid() + " " + "_PartOf_oid=" + get_PartOf_oid());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof IngredientData )
      {
         IngredientData lTest = (IngredientData) pOther;
         boolean lEquals = true;

         if( this.oid == null )
         {
            lEquals = lEquals && ( lTest.oid == null );
         }
         else
         {
            lEquals = lEquals && this.oid.equals( lTest.oid );
         }
         if( this._Name == null )
         {
            lEquals = lEquals && ( lTest._Name == null );
         }
         else
         {
            lEquals = lEquals && this._Name.equals( lTest._Name );
         }
         if( this._FavouriteFormula_oid == null )
         {
            lEquals = lEquals && ( lTest._FavouriteFormula_oid == null );
         }
         else
         {
            lEquals = lEquals && this._FavouriteFormula_oid.equals( lTest._FavouriteFormula_oid );
         }
         if( this._PartOf_oid == null )
         {
            lEquals = lEquals && ( lTest._PartOf_oid == null );
         }
         else
         {
            lEquals = lEquals && this._PartOf_oid.equals( lTest._PartOf_oid );
         }

         return lEquals;
      }
      else
      {
         return false;
      }
   }

   public int hashCode()
   {
      int result = 17;

      result = 37*result + ((this.oid != null) ? this.oid.hashCode() : 0);

      result = 37*result + ((this._Name != null) ? this._Name.hashCode() : 0);

      result = 37*result + ((this._FavouriteFormula_oid != null) ? this._FavouriteFormula_oid.hashCode() : 0);

      result = 37*result + ((this._PartOf_oid != null) ? this._PartOf_oid.hashCode() : 0);

      return result;
   }

}
