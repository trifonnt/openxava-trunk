/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Value object for Customer.
 *
 */
public class CustomerValue
   extends java.lang.Object
   implements java.io.Serializable 
{
   private int type;
   private boolean typeHasBeenSet = false;
   private java.lang.String remarks;
   private boolean remarksHasBeenSet = false;
   private java.lang.String relationWithSeller;
   private boolean relationWithSellerHasBeenSet = false;
   private byte[] photo;
   private boolean photoHasBeenSet = false;
   private java.lang.String name;
   private boolean nameHasBeenSet = false;
   private int number;
   private boolean numberHasBeenSet = false;
   private int seller_number;
   private boolean seller_numberHasBeenSet = false;
   private int alternateSeller_number;
   private boolean alternateSeller_numberHasBeenSet = false;
   private org.openxava.test.ejb.Address address;
   private boolean addressHasBeenSet = false;
   private java.lang.String address_state_id;
   private boolean address_state_idHasBeenSet = false;

   public CustomerValue()
   {
   }

   //TODO Cloneable is better than this !
   public CustomerValue( CustomerValue otherValue )
   {
	  this.type = otherValue.type;
	  typeHasBeenSet = true;
	  this.remarks = otherValue.remarks;
	  remarksHasBeenSet = true;
	  this.relationWithSeller = otherValue.relationWithSeller;
	  relationWithSellerHasBeenSet = true;
	  this.photo = otherValue.photo;
	  photoHasBeenSet = true;
	  this.name = otherValue.name;
	  nameHasBeenSet = true;
	  this.number = otherValue.number;
	  numberHasBeenSet = true;
	  this.seller_number = otherValue.seller_number;
	  seller_numberHasBeenSet = true;
	  this.alternateSeller_number = otherValue.alternateSeller_number;
	  alternateSeller_numberHasBeenSet = true;
	  this.address = otherValue.address;
	  addressHasBeenSet = true;
	  this.address_state_id = otherValue.address_state_id;
	  address_state_idHasBeenSet = true;
   }

   public int getType()
   {
	  return this.type;
   }

   public void setType( int type )
   {
	  this.type = type;
	  typeHasBeenSet = true;
   }

   public boolean typeHasBeenSet(){
	  return typeHasBeenSet;
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
   public java.lang.String getRelationWithSeller()
   {
	  return this.relationWithSeller;
   }

   public void setRelationWithSeller( java.lang.String relationWithSeller )
   {
	  this.relationWithSeller = relationWithSeller;
	  relationWithSellerHasBeenSet = true;
   }

   public boolean relationWithSellerHasBeenSet(){
	  return relationWithSellerHasBeenSet;
   }
   public byte[] getPhoto()
   {
	  return this.photo;
   }

   public void setPhoto( byte[] photo )
   {
	  this.photo = photo;
	  photoHasBeenSet = true;
   }

   public boolean photoHasBeenSet(){
	  return photoHasBeenSet;
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
   public int getSeller_number()
   {
	  return this.seller_number;
   }

   public void setSeller_number( int seller_number )
   {
	  this.seller_number = seller_number;
	  seller_numberHasBeenSet = true;
   }

   public boolean seller_numberHasBeenSet(){
	  return seller_numberHasBeenSet;
   }
   public int getAlternateSeller_number()
   {
	  return this.alternateSeller_number;
   }

   public void setAlternateSeller_number( int alternateSeller_number )
   {
	  this.alternateSeller_number = alternateSeller_number;
	  alternateSeller_numberHasBeenSet = true;
   }

   public boolean alternateSeller_numberHasBeenSet(){
	  return alternateSeller_numberHasBeenSet;
   }
   public org.openxava.test.ejb.Address getAddress()
   {
	  return this.address;
   }

   public void setAddress( org.openxava.test.ejb.Address address )
   {
	  this.address = address;
	  addressHasBeenSet = true;
   }

   public boolean addressHasBeenSet(){
	  return addressHasBeenSet;
   }
   public java.lang.String getAddress_state_id()
   {
	  return this.address_state_id;
   }

   public void setAddress_state_id( java.lang.String address_state_id )
   {
	  this.address_state_id = address_state_id;
	  address_state_idHasBeenSet = true;
   }

   public boolean address_state_idHasBeenSet(){
	  return address_state_idHasBeenSet;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("type=" + getType() + " " + "remarks=" + getRemarks() + " " + "relationWithSeller=" + getRelationWithSeller() + " " + "photo=" + getPhoto() + " " + "name=" + getName() + " " + "number=" + getNumber() + " " + "seller_number=" + getSeller_number() + " " + "alternateSeller_number=" + getAlternateSeller_number() + " " + "address=" + getAddress() + " " + "address_state_id=" + getAddress_state_id());
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
	  if (other instanceof CustomerValue)
	  {
		 CustomerValue that = (CustomerValue) other;
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
	  if (other instanceof CustomerValue)
	  {
		 CustomerValue that = (CustomerValue) other;
		 boolean lEquals = true;
		 lEquals = lEquals && this.type == that.type;
		 if( this.remarks == null )
		 {
			lEquals = lEquals && ( that.remarks == null );
		 }
		 else
		 {
			lEquals = lEquals && this.remarks.equals( that.remarks );
		 }
		 if( this.relationWithSeller == null )
		 {
			lEquals = lEquals && ( that.relationWithSeller == null );
		 }
		 else
		 {
			lEquals = lEquals && this.relationWithSeller.equals( that.relationWithSeller );
		 }
		 lEquals = lEquals && this.photo == that.photo;
		 if( this.name == null )
		 {
			lEquals = lEquals && ( that.name == null );
		 }
		 else
		 {
			lEquals = lEquals && this.name.equals( that.name );
		 }
		 lEquals = lEquals && this.seller_number == that.seller_number;
		 lEquals = lEquals && this.alternateSeller_number == that.alternateSeller_number;
		 if( this.address == null )
		 {
			lEquals = lEquals && ( that.address == null );
		 }
		 else
		 {
			lEquals = lEquals && this.address.equals( that.address );
		 }
		 if( this.address_state_id == null )
		 {
			lEquals = lEquals && ( that.address_state_id == null );
		 }
		 else
		 {
			lEquals = lEquals && this.address_state_id.equals( that.address_state_id );
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
      result = 37*result + (int) type;

      result = 37*result + ((this.remarks != null) ? this.remarks.hashCode() : 0);

      result = 37*result + ((this.relationWithSeller != null) ? this.relationWithSeller.hashCode() : 0);

      if (photo != null) {
        for (int i=0; i<photo.length; i++)
        {
          long l = photo[i];
          result = 37*result + (int)(l^(l>>>32));
        }
      }

      result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);

      result = 37*result + (int) number;

      result = 37*result + (int) seller_number;

      result = 37*result + (int) alternateSeller_number;

      result = 37*result + ((this.address != null) ? this.address.hashCode() : 0);

      result = 37*result + ((this.address_state_id != null) ? this.address_state_id.hashCode() : 0);

	  return result;
   }

}
