/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for Vehicle.
 */
public class VehicleData
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.lang.String _Model;
   private java.lang.String oid;
   private java.lang.String _Code;
   private java.lang.String _Make;

   public VehicleData()
   {
   }

   public VehicleData( VehicleData otherData )
   {
      set_Model(otherData.get_Model());
      setOid(otherData.getOid());
      set_Code(otherData.get_Code());
      set_Make(otherData.get_Make());

   }

   public org.openxava.test.model.VehicleKey getPrimaryKey() {
     org.openxava.test.model.VehicleKey pk = new org.openxava.test.model.VehicleKey(this.getOid());
     return pk;
   }

   public java.lang.String get_Model()
   {
      return this._Model;
   }
   public void set_Model( java.lang.String _Model )
   {
      this._Model = _Model;
   }

   public java.lang.String getOid()
   {
      return this.oid;
   }
   public void setOid( java.lang.String oid )
   {
      this.oid = oid;
   }

   public java.lang.String get_Code()
   {
      return this._Code;
   }
   public void set_Code( java.lang.String _Code )
   {
      this._Code = _Code;
   }

   public java.lang.String get_Make()
   {
      return this._Make;
   }
   public void set_Make( java.lang.String _Make )
   {
      this._Make = _Make;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Model=" + get_Model() + " " + "oid=" + getOid() + " " + "_Code=" + get_Code() + " " + "_Make=" + get_Make());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof VehicleData )
      {
         VehicleData lTest = (VehicleData) pOther;
         boolean lEquals = true;

         if( this._Model == null )
         {
            lEquals = lEquals && ( lTest._Model == null );
         }
         else
         {
            lEquals = lEquals && this._Model.equals( lTest._Model );
         }
         if( this.oid == null )
         {
            lEquals = lEquals && ( lTest.oid == null );
         }
         else
         {
            lEquals = lEquals && this.oid.equals( lTest.oid );
         }
         if( this._Code == null )
         {
            lEquals = lEquals && ( lTest._Code == null );
         }
         else
         {
            lEquals = lEquals && this._Code.equals( lTest._Code );
         }
         if( this._Make == null )
         {
            lEquals = lEquals && ( lTest._Make == null );
         }
         else
         {
            lEquals = lEquals && this._Make.equals( lTest._Make );
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

      result = 37*result + ((this._Model != null) ? this._Model.hashCode() : 0);

      result = 37*result + ((this.oid != null) ? this.oid.hashCode() : 0);

      result = 37*result + ((this._Code != null) ? this._Code.hashCode() : 0);

      result = 37*result + ((this._Make != null) ? this._Make.hashCode() : 0);

      return result;
   }

}
