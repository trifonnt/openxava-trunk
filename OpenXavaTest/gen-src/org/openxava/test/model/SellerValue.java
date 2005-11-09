/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Value object for Seller.
 *
 */
public class SellerValue
   extends java.lang.Object
   implements java.io.Serializable 
{

   private static final long serialVersionUID = 1L;

   private java.lang.String name;
   private boolean nameHasBeenSet = false;
   private java.lang.String[] regions;
   private boolean regionsHasBeenSet = false;
   private int number;
   private boolean numberHasBeenSet = false;
   private java.lang.String level_id;
   private boolean level_idHasBeenSet = false;
   private int boss_number;
   private boolean boss_numberHasBeenSet = false;

   public SellerValue()
   {
   }

   //TODO Cloneable is better than this !
   public SellerValue( SellerValue otherValue )
   {
	  this.name = otherValue.name;
	  nameHasBeenSet = true;
	  this.regions = otherValue.regions;
	  regionsHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;
	  this.level_id = otherValue.level_id;
	  level_idHasBeenSet = true;
	  this.boss_number = otherValue.boss_number;
	  boss_numberHasBeenSet = true;
   }

   public java.lang.String getName()
   {
	  return this.name;
   }

   public void setName( java.lang.String name )
   {
	  this.name = name;
	  nameHasBeenSet = true;
   }

   public boolean nameHasBeenSet(){
	  return nameHasBeenSet;
   }
   public java.lang.String[] getRegions()
   {
	  return this.regions;
   }

   public void setRegions( java.lang.String[] regions )
   {
	  this.regions = regions;
	  regionsHasBeenSet = true;
   }

   public boolean regionsHasBeenSet(){
	  return regionsHasBeenSet;
   }
   public int getNumber()
   {
	  return this.number;
   }

   public void setNumber( int number )
   {
	  this.number = number;
	  numberHasBeenSet = true;
   }

   public boolean numberHasBeenSet(){
	  return numberHasBeenSet;
   }
   public java.lang.String getLevel_id()
   {
	  return this.level_id;
   }

   public void setLevel_id( java.lang.String level_id )
   {
	  this.level_id = level_id;
	  level_idHasBeenSet = true;
   }

   public boolean level_idHasBeenSet(){
	  return level_idHasBeenSet;
   }
   public int getBoss_number()
   {
	  return this.boss_number;
   }

   public void setBoss_number( int boss_number )
   {
	  this.boss_number = boss_number;
	  boss_numberHasBeenSet = true;
   }

   public boolean boss_numberHasBeenSet(){
	  return boss_numberHasBeenSet;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("name=" + getName() + " " + "regions=" + getRegions() + " " + "number=" + getNumber() + " " + "level_id=" + getLevel_id() + " " + "boss_number=" + getBoss_number());
	  str.append('}');

	  return(str.toString());
   }

   /**
    * A Value Object has an identity if the attributes making its Primary Key have all been set. An object without identity is never equal to any other object.
    *
    * @return true if this instance has an identity.
    */
   protected boolean hasIdentity()
   {
	  boolean ret = true;
	  ret = ret && numberHasBeenSet;
	  return ret;
   }

   public boolean equals(Object other)
   {
      if (this == other)
         return true;
	  if ( ! hasIdentity() ) return false;
	  if (other instanceof SellerValue)
	  {
		 SellerValue that = (SellerValue) other;
		 if ( ! that.hasIdentity() ) return false;
		 boolean lEquals = true;
		 lEquals = lEquals && this.number == that.number;

		 lEquals = lEquals && isIdentical(that);

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public boolean isIdentical(Object other)
   {
	  if (other instanceof SellerValue)
	  {
		 SellerValue that = (SellerValue) other;
		 boolean lEquals = true;
		 if( this.name == null )
		 {
			lEquals = lEquals && ( that.name == null );
		 }
		 else
		 {
			lEquals = lEquals && this.name.equals( that.name );
		 }
		 if( this.regions == null )
		 {
			lEquals = lEquals && ( that.regions == null );
		 }
		 else
		 {
			lEquals = lEquals && this.regions.equals( that.regions );
		 }
		 if( this.level_id == null )
		 {
			lEquals = lEquals && ( that.level_id == null );
		 }
		 else
		 {
			lEquals = lEquals && this.level_id.equals( that.level_id );
		 }
		 lEquals = lEquals && this.boss_number == that.boss_number;

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);

      result = 37*result + ((this.regions != null) ? this.regions.hashCode() : 0);

      result = 37*result + (int) number;

      result = 37*result + ((this.level_id != null) ? this.level_id.hashCode() : 0);

      result = 37*result + (int) boss_number;

	  return result;
   }

}
