/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Data object for Customer.
 */
public class CustomerData
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.lang.Integer _Type;
   private java.lang.String _Remarks;
   private java.lang.String _RelationWithSeller;
   private byte[] photo;
   private java.lang.String _Name;
   private int number;
   private int seller_number;
   private int alternateSeller_number;
   private java.lang.String address_state_id;

   public CustomerData()
   {
   }

   public CustomerData( CustomerData otherData )
   {
      set_Type(otherData.get_Type());
      set_Remarks(otherData.get_Remarks());
      set_RelationWithSeller(otherData.get_RelationWithSeller());
      setPhoto(otherData.getPhoto());
      set_Name(otherData.get_Name());
      setNumber(otherData.getNumber());
      setSeller_number(otherData.getSeller_number());
      setAlternateSeller_number(otherData.getAlternateSeller_number());
      setAddress_state_id(otherData.getAddress_state_id());

   }

   public org.openxava.test.ejb.CustomerKey getPrimaryKey() {
     org.openxava.test.ejb.CustomerKey pk = new org.openxava.test.ejb.CustomerKey(this.getNumber());
     return pk;
   }

   public java.lang.Integer get_Type()
   {
      return this._Type;
   }
   public void set_Type( java.lang.Integer _Type )
   {
      this._Type = _Type;
   }

   public java.lang.String get_Remarks()
   {
      return this._Remarks;
   }
   public void set_Remarks( java.lang.String _Remarks )
   {
      this._Remarks = _Remarks;
   }

   public java.lang.String get_RelationWithSeller()
   {
      return this._RelationWithSeller;
   }
   public void set_RelationWithSeller( java.lang.String _RelationWithSeller )
   {
      this._RelationWithSeller = _RelationWithSeller;
   }

   public byte[] getPhoto()
   {
      return this.photo;
   }
   public void setPhoto( byte[] photo )
   {
      this.photo = photo;
   }

   public java.lang.String get_Name()
   {
      return this._Name;
   }
   public void set_Name( java.lang.String _Name )
   {
      this._Name = _Name;
   }

   public int getNumber()
   {
      return this.number;
   }
   public void setNumber( int number )
   {
      this.number = number;
   }

   public int getSeller_number()
   {
      return this.seller_number;
   }
   public void setSeller_number( int seller_number )
   {
      this.seller_number = seller_number;
   }

   public int getAlternateSeller_number()
   {
      return this.alternateSeller_number;
   }
   public void setAlternateSeller_number( int alternateSeller_number )
   {
      this.alternateSeller_number = alternateSeller_number;
   }

   public java.lang.String getAddress_state_id()
   {
      return this.address_state_id;
   }
   public void setAddress_state_id( java.lang.String address_state_id )
   {
      this.address_state_id = address_state_id;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Type=" + get_Type() + " " + "_Remarks=" + get_Remarks() + " " + "_RelationWithSeller=" + get_RelationWithSeller() + " " + "photo=" + getPhoto() + " " + "_Name=" + get_Name() + " " + "number=" + getNumber() + " " + "seller_number=" + getSeller_number() + " " + "alternateSeller_number=" + getAlternateSeller_number() + " " + "address_state_id=" + getAddress_state_id());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof CustomerData )
      {
         CustomerData lTest = (CustomerData) pOther;
         boolean lEquals = true;

         if( this._Type == null )
         {
            lEquals = lEquals && ( lTest._Type == null );
         }
         else
         {
            lEquals = lEquals && this._Type.equals( lTest._Type );
         }
         if( this._Remarks == null )
         {
            lEquals = lEquals && ( lTest._Remarks == null );
         }
         else
         {
            lEquals = lEquals && this._Remarks.equals( lTest._Remarks );
         }
         if( this._RelationWithSeller == null )
         {
            lEquals = lEquals && ( lTest._RelationWithSeller == null );
         }
         else
         {
            lEquals = lEquals && this._RelationWithSeller.equals( lTest._RelationWithSeller );
         }
         lEquals = lEquals && this.photo == lTest.photo;
         if( this._Name == null )
         {
            lEquals = lEquals && ( lTest._Name == null );
         }
         else
         {
            lEquals = lEquals && this._Name.equals( lTest._Name );
         }
         lEquals = lEquals && this.number == lTest.number;
         lEquals = lEquals && this.seller_number == lTest.seller_number;
         lEquals = lEquals && this.alternateSeller_number == lTest.alternateSeller_number;
         if( this.address_state_id == null )
         {
            lEquals = lEquals && ( lTest.address_state_id == null );
         }
         else
         {
            lEquals = lEquals && this.address_state_id.equals( lTest.address_state_id );
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

      result = 37*result + ((this._Type != null) ? this._Type.hashCode() : 0);

      result = 37*result + ((this._Remarks != null) ? this._Remarks.hashCode() : 0);

      result = 37*result + ((this._RelationWithSeller != null) ? this._RelationWithSeller.hashCode() : 0);

      if (photo != null) {
        for (int i=0; i<photo.length; i++)
        {
          long l = photo[i];
          result = 37*result + (int)(l^(l>>>32));
        }
      }

      result = 37*result + ((this._Name != null) ? this._Name.hashCode() : 0);

      result = 37*result + (int) number;

      result = 37*result + (int) seller_number;

      result = 37*result + (int) alternateSeller_number;

      result = 37*result + ((this.address_state_id != null) ? this.address_state_id.hashCode() : 0);

      return result;
   }

}
