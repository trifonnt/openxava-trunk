/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Value object for Clerk.
 *
 */
public class ClerkValue
   extends java.lang.Object
   implements java.io.Serializable 
{

   private static final long serialVersionUID = 1L;

   private java.sql.Time arrivalTime;
   private boolean arrivalTimeHasBeenSet = false;
   private java.lang.String endingTime;
   private boolean endingTimeHasBeenSet = false;
   private java.lang.String name;
   private boolean nameHasBeenSet = false;
   private int officeNumber;
   private boolean officeNumberHasBeenSet = false;
   private int number;
   private boolean numberHasBeenSet = false;
   private int zoneNumber;
   private boolean zoneNumberHasBeenSet = false;
   private java.lang.String comments;
   private boolean commentsHasBeenSet = false;

   public ClerkValue()
   {
   }

   //TODO Cloneable is better than this !
   public ClerkValue( ClerkValue otherValue )
   {
	  this.arrivalTime = otherValue.arrivalTime;
	  arrivalTimeHasBeenSet = true;
	  this.endingTime = otherValue.endingTime;
	  endingTimeHasBeenSet = true;
	  this.name = otherValue.name;
	  nameHasBeenSet = true;
	  this.officeNumber = otherValue.officeNumber;
	  officeNumberHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;
	  this.zoneNumber = otherValue.zoneNumber;
	  zoneNumberHasBeenSet = true;
	  this.comments = otherValue.comments;
	  commentsHasBeenSet = true;
   }

   public java.sql.Time getArrivalTime()
   {
	  return this.arrivalTime;
   }

   public void setArrivalTime( java.sql.Time arrivalTime )
   {
	  this.arrivalTime = arrivalTime;
	  arrivalTimeHasBeenSet = true;
   }

   public boolean arrivalTimeHasBeenSet(){
	  return arrivalTimeHasBeenSet;
   }
   public java.lang.String getEndingTime()
   {
	  return this.endingTime;
   }

   public void setEndingTime( java.lang.String endingTime )
   {
	  this.endingTime = endingTime;
	  endingTimeHasBeenSet = true;
   }

   public boolean endingTimeHasBeenSet(){
	  return endingTimeHasBeenSet;
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
   public int getOfficeNumber()
   {
	  return this.officeNumber;
   }

   public void setOfficeNumber( int officeNumber )
   {
	  this.officeNumber = officeNumber;
	  officeNumberHasBeenSet = true;
   }

   public boolean officeNumberHasBeenSet(){
	  return officeNumberHasBeenSet;
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
   public int getZoneNumber()
   {
	  return this.zoneNumber;
   }

   public void setZoneNumber( int zoneNumber )
   {
	  this.zoneNumber = zoneNumber;
	  zoneNumberHasBeenSet = true;
   }

   public boolean zoneNumberHasBeenSet(){
	  return zoneNumberHasBeenSet;
   }
   public java.lang.String getComments()
   {
	  return this.comments;
   }

   public void setComments( java.lang.String comments )
   {
	  this.comments = comments;
	  commentsHasBeenSet = true;
   }

   public boolean commentsHasBeenSet(){
	  return commentsHasBeenSet;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("arrivalTime=" + getArrivalTime() + " " + "endingTime=" + getEndingTime() + " " + "name=" + getName() + " " + "officeNumber=" + getOfficeNumber() + " " + "number=" + getNumber() + " " + "zoneNumber=" + getZoneNumber() + " " + "comments=" + getComments());
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
	  ret = ret && officeNumberHasBeenSet;
	  ret = ret && numberHasBeenSet;
	  ret = ret && zoneNumberHasBeenSet;
	  return ret;
   }

   public boolean equals(Object other)
   {
      if (this == other)
         return true;
	  if ( ! hasIdentity() ) return false;
	  if (other instanceof ClerkValue)
	  {
		 ClerkValue that = (ClerkValue) other;
		 if ( ! that.hasIdentity() ) return false;
		 boolean lEquals = true;
		 lEquals = lEquals && this.officeNumber == that.officeNumber;
		 lEquals = lEquals && this.number == that.number;
		 lEquals = lEquals && this.zoneNumber == that.zoneNumber;

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
	  if (other instanceof ClerkValue)
	  {
		 ClerkValue that = (ClerkValue) other;
		 boolean lEquals = true;
		 if( this.arrivalTime == null )
		 {
			lEquals = lEquals && ( that.arrivalTime == null );
		 }
		 else
		 {
			lEquals = lEquals && this.arrivalTime.equals( that.arrivalTime );
		 }
		 if( this.endingTime == null )
		 {
			lEquals = lEquals && ( that.endingTime == null );
		 }
		 else
		 {
			lEquals = lEquals && this.endingTime.equals( that.endingTime );
		 }
		 if( this.name == null )
		 {
			lEquals = lEquals && ( that.name == null );
		 }
		 else
		 {
			lEquals = lEquals && this.name.equals( that.name );
		 }
		 if( this.comments == null )
		 {
			lEquals = lEquals && ( that.comments == null );
		 }
		 else
		 {
			lEquals = lEquals && this.comments.equals( that.comments );
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
      result = 37*result + ((this.arrivalTime != null) ? this.arrivalTime.hashCode() : 0);

      result = 37*result + ((this.endingTime != null) ? this.endingTime.hashCode() : 0);

      result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);

      result = 37*result + (int) officeNumber;

      result = 37*result + (int) number;

      result = 37*result + (int) zoneNumber;

      result = 37*result + ((this.comments != null) ? this.comments.hashCode() : 0);

	  return result;
   }

}
