/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for Issue.
 */
public class IssueData
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.lang.String _Description;
   private java.lang.String id;
   private java.lang.Integer _Worker_id;

   public IssueData()
   {
   }

   public IssueData( IssueData otherData )
   {
      set_Description(otherData.get_Description());
      setId(otherData.getId());
      set_Worker_id(otherData.get_Worker_id());

   }

   public org.openxava.test.model.IssueKey getPrimaryKey() {
     org.openxava.test.model.IssueKey pk = new org.openxava.test.model.IssueKey(this.getId());
     return pk;
   }

   public java.lang.String get_Description()
   {
      return this._Description;
   }
   public void set_Description( java.lang.String _Description )
   {
      this._Description = _Description;
   }

   public java.lang.String getId()
   {
      return this.id;
   }
   public void setId( java.lang.String id )
   {
      this.id = id;
   }

   public java.lang.Integer get_Worker_id()
   {
      return this._Worker_id;
   }
   public void set_Worker_id( java.lang.Integer _Worker_id )
   {
      this._Worker_id = _Worker_id;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("_Description=" + get_Description() + " " + "id=" + getId() + " " + "_Worker_id=" + get_Worker_id());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof IssueData )
      {
         IssueData lTest = (IssueData) pOther;
         boolean lEquals = true;

         if( this._Description == null )
         {
            lEquals = lEquals && ( lTest._Description == null );
         }
         else
         {
            lEquals = lEquals && this._Description.equals( lTest._Description );
         }
         if( this.id == null )
         {
            lEquals = lEquals && ( lTest.id == null );
         }
         else
         {
            lEquals = lEquals && this.id.equals( lTest.id );
         }
         if( this._Worker_id == null )
         {
            lEquals = lEquals && ( lTest._Worker_id == null );
         }
         else
         {
            lEquals = lEquals && this._Worker_id.equals( lTest._Worker_id );
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

      result = 37*result + ((this._Description != null) ? this._Description.hashCode() : 0);

      result = 37*result + ((this.id != null) ? this.id.hashCode() : 0);

      result = 37*result + ((this._Worker_id != null) ? this._Worker_id.hashCode() : 0);

      return result;
   }

}
