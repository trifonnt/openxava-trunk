/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Value object for DeliveryType.
 *
 */
public class DeliveryTypeValue
   extends java.lang.Object
   implements java.io.Serializable 
{
   private java.lang.String description;
   private boolean descriptionHasBeenSet = false;
   private int number;
   private boolean numberHasBeenSet = false;

   // private org.openxava.test.ejb.DeliveryTypeKey pk;

   public DeliveryTypeValue()
   {
	 // pk = new org.openxava.test.ejb.DeliveryTypeKey();
   }

   /*
   public DeliveryTypeValue(org.openxava.test.ejb.DeliveryTypeKey pk)
   {
	  this.pk = pk;
   }
   */

   /*
   public DeliveryTypeValue( java.lang.String description,int number )
   {
	  this.description = description;
	  descriptionHasBeenSet = true;
	  this.number = number;
	  numberHasBeenSet = true;
	  //pk = new org.openxava.test.ejb.DeliveryTypeKey(this.getNumber());
   }
   */

   //TODO Cloneable is better than this !
   public DeliveryTypeValue( DeliveryTypeValue otherValue )
   {
	  this.description = otherValue.description;
	  descriptionHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;

	  // pk = new org.openxava.test.ejb.DeliveryTypeKey(this.getNumber());
   }

   /*
   public org.openxava.test.ejb.DeliveryTypeKey getPrimaryKey()
   {
	  return pk;
   }

   public void setPrimaryKey( org.openxava.test.ejb.DeliveryTypeKey pk )
   {
      // it's also nice to update PK object - just in case
      // somebody would ask for it later...
      this.pk = pk;
	  setNumber( pk.number );
   }
   */

   public java.lang.String getDescription()
   {
	  return this.description;
   }

   public void setDescription( java.lang.String description )
   {
	  this.description = description;
	  descriptionHasBeenSet = true;

   }

   public boolean descriptionHasBeenSet(){
	  return descriptionHasBeenSet;
   }
   public int getNumber()
   {
	  return this.number;
   }

   public void setNumber( int number )
   {
	  this.number = number;
	  numberHasBeenSet = true;

		 //pk.setNumber(number);
   }

   public boolean numberHasBeenSet(){
	  return numberHasBeenSet;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("description=" + getDescription() + " " + "number=" + getNumber());
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
	  if (other instanceof DeliveryTypeValue)
	  {
		 DeliveryTypeValue that = (DeliveryTypeValue) other;
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
	  if (other instanceof DeliveryTypeValue)
	  {
		 DeliveryTypeValue that = (DeliveryTypeValue) other;
		 boolean lEquals = true;
		 if( this.description == null )
		 {
			lEquals = lEquals && ( that.description == null );
		 }
		 else
		 {
			lEquals = lEquals && this.description.equals( that.description );
		 }

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + ((this.description != null) ? this.description.hashCode() : 0);

      result = 37*result + (int) number;

	  return result;
   }

}
