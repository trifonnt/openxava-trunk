/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Value object for Subfamily.
 *
 */
public class SubfamilyValue
   extends java.lang.Object
   implements java.io.Serializable 
{
   private java.lang.String family;
   private boolean familyHasBeenSet = false;
   private int familyNumber;
   private boolean familyNumberHasBeenSet = false;
   private java.lang.String oid;
   private boolean oidHasBeenSet = false;
   private java.lang.String remarks;
   private boolean remarksHasBeenSet = false;
   private java.lang.String description;
   private boolean descriptionHasBeenSet = false;
   private java.lang.String remarksDB;
   private boolean remarksDBHasBeenSet = false;
   private int number;
   private boolean numberHasBeenSet = false;

   public SubfamilyValue()
   {
   }

   //TODO Cloneable is better than this !
   public SubfamilyValue( SubfamilyValue otherValue )
   {
	  this.family = otherValue.family;
	  familyHasBeenSet = true;
	  this.familyNumber = otherValue.familyNumber;
	  familyNumberHasBeenSet = true;
	  this.oid = otherValue.oid;
	  oidHasBeenSet = true;
	  this.remarks = otherValue.remarks;
	  remarksHasBeenSet = true;
	  this.description = otherValue.description;
	  descriptionHasBeenSet = true;
	  this.remarksDB = otherValue.remarksDB;
	  remarksDBHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;
   }

   public java.lang.String getFamily()
   {
	  return this.family;
   }

   public void setFamily( java.lang.String family )
   {
	  this.family = family;
	  familyHasBeenSet = true;
   }

   public boolean familyHasBeenSet(){
	  return familyHasBeenSet;
   }
   public int getFamilyNumber()
   {
	  return this.familyNumber;
   }

   public void setFamilyNumber( int familyNumber )
   {
	  this.familyNumber = familyNumber;
	  familyNumberHasBeenSet = true;
   }

   public boolean familyNumberHasBeenSet(){
	  return familyNumberHasBeenSet;
   }
   public java.lang.String getOid()
   {
	  return this.oid;
   }

   public void setOid( java.lang.String oid )
   {
	  this.oid = oid;
	  oidHasBeenSet = true;
   }

   public boolean oidHasBeenSet(){
	  return oidHasBeenSet;
   }
   public java.lang.String getRemarks()
   {
	  return this.remarks;
   }

   public void setRemarks( java.lang.String remarks )
   {
	  this.remarks = remarks;
	  remarksHasBeenSet = true;
   }

   public boolean remarksHasBeenSet(){
	  return remarksHasBeenSet;
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
   public java.lang.String getRemarksDB()
   {
	  return this.remarksDB;
   }

   public void setRemarksDB( java.lang.String remarksDB )
   {
	  this.remarksDB = remarksDB;
	  remarksDBHasBeenSet = true;
   }

   public boolean remarksDBHasBeenSet(){
	  return remarksDBHasBeenSet;
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

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("family=" + getFamily() + " " + "familyNumber=" + getFamilyNumber() + " " + "oid=" + getOid() + " " + "remarks=" + getRemarks() + " " + "description=" + getDescription() + " " + "remarksDB=" + getRemarksDB() + " " + "number=" + getNumber());
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
	  ret = ret && oidHasBeenSet;
	  return ret;
   }

   public boolean equals(Object other)
   {
      if (this == other)
         return true;
	  if ( ! hasIdentity() ) return false;
	  if (other instanceof SubfamilyValue)
	  {
		 SubfamilyValue that = (SubfamilyValue) other;
		 if ( ! that.hasIdentity() ) return false;
		 boolean lEquals = true;
		 if( this.oid == null )
		 {
			lEquals = lEquals && ( that.oid == null );
		 }
		 else
		 {
			lEquals = lEquals && this.oid.equals( that.oid );
		 }

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
	  if (other instanceof SubfamilyValue)
	  {
		 SubfamilyValue that = (SubfamilyValue) other;
		 boolean lEquals = true;
		 if( this.family == null )
		 {
			lEquals = lEquals && ( that.family == null );
		 }
		 else
		 {
			lEquals = lEquals && this.family.equals( that.family );
		 }
		 lEquals = lEquals && this.familyNumber == that.familyNumber;
		 if( this.remarks == null )
		 {
			lEquals = lEquals && ( that.remarks == null );
		 }
		 else
		 {
			lEquals = lEquals && this.remarks.equals( that.remarks );
		 }
		 if( this.description == null )
		 {
			lEquals = lEquals && ( that.description == null );
		 }
		 else
		 {
			lEquals = lEquals && this.description.equals( that.description );
		 }
		 if( this.remarksDB == null )
		 {
			lEquals = lEquals && ( that.remarksDB == null );
		 }
		 else
		 {
			lEquals = lEquals && this.remarksDB.equals( that.remarksDB );
		 }
		 lEquals = lEquals && this.number == that.number;

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + ((this.family != null) ? this.family.hashCode() : 0);

      result = 37*result + (int) familyNumber;

      result = 37*result + ((this.oid != null) ? this.oid.hashCode() : 0);

      result = 37*result + ((this.remarks != null) ? this.remarks.hashCode() : 0);

      result = 37*result + ((this.description != null) ? this.description.hashCode() : 0);

      result = 37*result + ((this.remarksDB != null) ? this.remarksDB.hashCode() : 0);

      result = 37*result + (int) number;

	  return result;
   }

}
