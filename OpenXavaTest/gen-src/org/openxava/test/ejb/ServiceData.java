/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.ejb;

/**
 * Data object for Service.
 */
public class ServiceData
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.lang.Integer _Family;
   private java.lang.String _Description;
   private int number;
   private int detail_type;
   private int detail_subfamily;

  /*
  // begin value object
   private org.openxava.test.ejb.ServiceValue ServiceValue = null;

   public org.openxava.test.ejb.ServiceValue getServiceValue()
   {
	  if( ServiceValue == null )
	  {
          ServiceValue = new org.openxava.test.ejb.ServiceValue();
	  }
      try
         {
            ServiceValue.setFamily( getFamily() );
            ServiceValue.setDescription( getDescription() );
            ServiceValue.setNumber( getNumber() );
            ServiceValue.setDetail( getDetail() );
                   }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return ServiceValue;
   }

   public void setServiceValue( org.openxava.test.ejb.ServiceValue valueHolder )
   {

	  try
	  {
		 setFamily( valueHolder.getFamily() );
		 setDescription( valueHolder.getDescription() );
		 setDetail( valueHolder.getDetail() );
	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

  // end value object

 */

   public ServiceData()
   {
   }

  /*
   public ServiceData( java.lang.Integer _Family,java.lang.String _Description,int number,int detail_type,int detail_subfamily )
   {
      set_Family(_Family);
      set_Description(_Description);
      setNumber(number);
      setDetail_type(detail_type);
      setDetail_subfamily(detail_subfamily);
   }
   */

   public ServiceData( ServiceData otherData )
   {
      set_Family(otherData.get_Family());
      set_Description(otherData.get_Description());
      setNumber(otherData.getNumber());
      setDetail_type(otherData.getDetail_type());
      setDetail_subfamily(otherData.getDetail_subfamily());

   }

   public org.openxava.test.ejb.ServiceKey getPrimaryKey() {
     org.openxava.test.ejb.ServiceKey pk = new org.openxava.test.ejb.ServiceKey(this.getNumber());
     return pk;
   }

   public java.lang.Integer get_Family()
   {
      return this._Family;
   }
   public void set_Family( java.lang.Integer _Family )
   {
      this._Family = _Family;
   }

   public java.lang.String get_Description()
   {
      return this._Description;
   }
   public void set_Description( java.lang.String _Description )
   {
      this._Description = _Description;
   }

   public int getNumber()
   {
      return this.number;
   }
   public void setNumber( int number )
   {
      this.number = number;
   }

   public int getDetail_type()
   {
      return this.detail_type;
   }
   public void setDetail_type( int detail_type )
   {
      this.detail_type = detail_type;
   }

   public int getDetail_subfamily()
   {
      return this.detail_subfamily;
   }
   public void setDetail_subfamily( int detail_subfamily )
   {
      this.detail_subfamily = detail_subfamily;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Family=" + get_Family() + " " + "_Description=" + get_Description() + " " + "number=" + getNumber() + " " + "detail_type=" + getDetail_type() + " " + "detail_subfamily=" + getDetail_subfamily());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof ServiceData )
      {
         ServiceData lTest = (ServiceData) pOther;
         boolean lEquals = true;

         if( this._Family == null )
         {
            lEquals = lEquals && ( lTest._Family == null );
         }
         else
         {
            lEquals = lEquals && this._Family.equals( lTest._Family );
         }
         if( this._Description == null )
         {
            lEquals = lEquals && ( lTest._Description == null );
         }
         else
         {
            lEquals = lEquals && this._Description.equals( lTest._Description );
         }
         lEquals = lEquals && this.number == lTest.number;
         lEquals = lEquals && this.detail_type == lTest.detail_type;
         lEquals = lEquals && this.detail_subfamily == lTest.detail_subfamily;

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

      result = 37*result + ((this._Family != null) ? this._Family.hashCode() : 0);

      result = 37*result + ((this._Description != null) ? this._Description.hashCode() : 0);

      result = 37*result + (int) number;

      result = 37*result + (int) detail_type;

      result = 37*result + (int) detail_subfamily;

      return result;
   }

}
