/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Value object for ServiceType.
 *
 */
public class ServiceTypeValue
   extends java.lang.Object
   implements java.io.Serializable 
{
   private int family;
   private boolean familyHasBeenSet = false;
   private java.lang.String description;
   private boolean descriptionHasBeenSet = false;
   private int subfamily;
   private boolean subfamilyHasBeenSet = false;
   private int number;
   private boolean numberHasBeenSet = false;

   // private org.openxava.test.ejb.ServiceTypeKey pk;

   public ServiceTypeValue()
   {
	 // pk = new org.openxava.test.ejb.ServiceTypeKey();
   }

   /*
   public ServiceTypeValue(org.openxava.test.ejb.ServiceTypeKey pk)
   {
	  this.pk = pk;
   }
   */

   /*
   public ServiceTypeValue( int family,java.lang.String description,int subfamily,int number )
   {
	  this.family = family;
	  familyHasBeenSet = true;
	  this.description = description;
	  descriptionHasBeenSet = true;
	  this.subfamily = subfamily;
	  subfamilyHasBeenSet = true;
	  this.number = number;
	  numberHasBeenSet = true;
	  //pk = new org.openxava.test.ejb.ServiceTypeKey(this.getNumber());
   }
   */

   //TODO Cloneable is better than this !
   public ServiceTypeValue( ServiceTypeValue otherValue )
   {
	  this.family = otherValue.family;
	  familyHasBeenSet = true;
	  this.description = otherValue.description;
	  descriptionHasBeenSet = true;
	  this.subfamily = otherValue.subfamily;
	  subfamilyHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;

	  // pk = new org.openxava.test.ejb.ServiceTypeKey(this.getNumber());
   }

   /*
   public org.openxava.test.ejb.ServiceTypeKey getPrimaryKey()
   {
	  return pk;
   }

   public void setPrimaryKey( org.openxava.test.ejb.ServiceTypeKey pk )
   {
      // it's also nice to update PK object - just in case
      // somebody would ask for it later...
      this.pk = pk;
	  setNumber( pk.number );
   }
   */

   public int getFamily()
   {
	  return this.family;
   }

   public void setFamily( int family )
   {
	  this.family = family;
	  familyHasBeenSet = true;

   }

   public boolean familyHasBeenSet(){
	  return familyHasBeenSet;
   }
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
   public int getSubfamily()
   {
	  return this.subfamily;
   }

   public void setSubfamily( int subfamily )
   {
	  this.subfamily = subfamily;
	  subfamilyHasBeenSet = true;

   }

   public boolean subfamilyHasBeenSet(){
	  return subfamilyHasBeenSet;
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

	  str.append("family=" + getFamily() + " " + "description=" + getDescription() + " " + "subfamily=" + getSubfamily() + " " + "number=" + getNumber());
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
	  if (other instanceof ServiceTypeValue)
	  {
		 ServiceTypeValue that = (ServiceTypeValue) other;
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
	  if (other instanceof ServiceTypeValue)
	  {
		 ServiceTypeValue that = (ServiceTypeValue) other;
		 boolean lEquals = true;
		 lEquals = lEquals && this.family == that.family;
		 if( this.description == null )
		 {
			lEquals = lEquals && ( that.description == null );
		 }
		 else
		 {
			lEquals = lEquals && this.description.equals( that.description );
		 }
		 lEquals = lEquals && this.subfamily == that.subfamily;

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + (int) family;

      result = 37*result + ((this.description != null) ? this.description.hashCode() : 0);

      result = 37*result + (int) subfamily;

      result = 37*result + (int) number;

	  return result;
   }

}
