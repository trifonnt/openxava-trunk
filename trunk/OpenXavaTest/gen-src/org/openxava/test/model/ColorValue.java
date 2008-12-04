/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Value object for Color.
 *
 */
public class ColorValue
   extends java.lang.Object
   implements java.io.Serializable 
{

   private static final long serialVersionUID = 1L;

   private java.lang.String sample;
   private boolean sampleHasBeenSet = false;
   private java.lang.String name;
   private boolean nameHasBeenSet = false;
   private int version;
   private boolean versionHasBeenSet = false;
   private java.lang.Integer number;
   private boolean numberHasBeenSet = false;

   public ColorValue()
   {
   }

   //TODO Cloneable is better than this !
   public ColorValue( ColorValue otherValue )
   {
	  this.sample = otherValue.sample;
	  sampleHasBeenSet = true;
	  this.name = otherValue.name;
	  nameHasBeenSet = true;
	  this.version = otherValue.version;
	  versionHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;
   }

   public java.lang.String getSample()
   {
	  return this.sample;
   }

   public void setSample( java.lang.String sample )
   {
	  this.sample = sample;
	  sampleHasBeenSet = true;
   }

   public boolean sampleHasBeenSet(){
	  return sampleHasBeenSet;
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
   public int getVersion()
   {
	  return this.version;
   }

   public void setVersion( int version )
   {
	  this.version = version;
	  versionHasBeenSet = true;
   }

   public boolean versionHasBeenSet(){
	  return versionHasBeenSet;
   }
   public java.lang.Integer getNumber()
   {
	  return this.number;
   }

   public void setNumber( java.lang.Integer number )
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

	  str.append("sample=" + getSample() + " " + "name=" + getName() + " " + "version=" + getVersion() + " " + "number=" + getNumber());
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
	  if (other instanceof ColorValue)
	  {
		 ColorValue that = (ColorValue) other;
		 if ( ! that.hasIdentity() ) return false;
		 boolean lEquals = true;
		 if( this.number == null )
		 {
			lEquals = lEquals && ( that.number == null );
		 }
		 else
		 {
			lEquals = lEquals && this.number.equals( that.number );
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
	  if (other instanceof ColorValue)
	  {
		 ColorValue that = (ColorValue) other;
		 boolean lEquals = true;
		 if( this.sample == null )
		 {
			lEquals = lEquals && ( that.sample == null );
		 }
		 else
		 {
			lEquals = lEquals && this.sample.equals( that.sample );
		 }
		 if( this.name == null )
		 {
			lEquals = lEquals && ( that.name == null );
		 }
		 else
		 {
			lEquals = lEquals && this.name.equals( that.name );
		 }
		 lEquals = lEquals && this.version == that.version;

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + ((this.sample != null) ? this.sample.hashCode() : 0);

      result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);

      result = 37*result + (int) version;

      result = 37*result + ((this.number != null) ? this.number.hashCode() : 0);

	  return result;
   }

}
