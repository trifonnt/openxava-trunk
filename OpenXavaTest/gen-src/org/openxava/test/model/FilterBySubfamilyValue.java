/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Value object for FilterBySubfamily.
 *
 */
public class FilterBySubfamilyValue
   extends java.lang.Object
   implements java.io.Serializable 
{

   private static final long serialVersionUID = 1L;

   private java.lang.String rangeDescription;
   private boolean rangeDescriptionHasBeenSet = false;
   private int subfamilyTo_number;
   private boolean subfamilyTo_numberHasBeenSet = false;
   private int subfamily_number;
   private boolean subfamily_numberHasBeenSet = false;

   public FilterBySubfamilyValue()
   {
   }

   //TODO Cloneable is better than this !
   public FilterBySubfamilyValue( FilterBySubfamilyValue otherValue )
   {
	  this.rangeDescription = otherValue.rangeDescription;
	  rangeDescriptionHasBeenSet = true;
	  this.subfamilyTo_number = otherValue.subfamilyTo_number;
	  subfamilyTo_numberHasBeenSet = true;
	  this.subfamily_number = otherValue.subfamily_number;
	  subfamily_numberHasBeenSet = true;
   }

   public java.lang.String getRangeDescription()
   {
	  return this.rangeDescription;
   }

   public void setRangeDescription( java.lang.String rangeDescription )
   {
	  this.rangeDescription = rangeDescription;
	  rangeDescriptionHasBeenSet = true;
   }

   public boolean rangeDescriptionHasBeenSet(){
	  return rangeDescriptionHasBeenSet;
   }
   public int getSubfamilyTo_number()
   {
	  return this.subfamilyTo_number;
   }

   public void setSubfamilyTo_number( int subfamilyTo_number )
   {
	  this.subfamilyTo_number = subfamilyTo_number;
	  subfamilyTo_numberHasBeenSet = true;
   }

   public boolean subfamilyTo_numberHasBeenSet(){
	  return subfamilyTo_numberHasBeenSet;
   }
   public int getSubfamily_number()
   {
	  return this.subfamily_number;
   }

   public void setSubfamily_number( int subfamily_number )
   {
	  this.subfamily_number = subfamily_number;
	  subfamily_numberHasBeenSet = true;
   }

   public boolean subfamily_numberHasBeenSet(){
	  return subfamily_numberHasBeenSet;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("rangeDescription=" + getRangeDescription() + " " + "subfamilyTo_number=" + getSubfamilyTo_number() + " " + "subfamily_number=" + getSubfamily_number());
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
	  return ret;
   }

   public boolean equals(Object other)
   {
      if (this == other)
         return true;
	  if ( ! hasIdentity() ) return false;
	  if (other instanceof FilterBySubfamilyValue)
	  {
		 FilterBySubfamilyValue that = (FilterBySubfamilyValue) other;
		 if ( ! that.hasIdentity() ) return false;
		 boolean lEquals = true;

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
	  if (other instanceof FilterBySubfamilyValue)
	  {
		 FilterBySubfamilyValue that = (FilterBySubfamilyValue) other;
		 boolean lEquals = true;
		 if( this.rangeDescription == null )
		 {
			lEquals = lEquals && ( that.rangeDescription == null );
		 }
		 else
		 {
			lEquals = lEquals && this.rangeDescription.equals( that.rangeDescription );
		 }
		 lEquals = lEquals && this.subfamilyTo_number == that.subfamilyTo_number;
		 lEquals = lEquals && this.subfamily_number == that.subfamily_number;

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + ((this.rangeDescription != null) ? this.rangeDescription.hashCode() : 0);

      result = 37*result + (int) subfamilyTo_number;

      result = 37*result + (int) subfamily_number;

	  return result;
   }

}
