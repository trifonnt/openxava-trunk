/*
 * Generated by XDoclet - Do not edit!
 */
package org.openxava.test.model;

/**
 * Data object for Comment.
 */
public class CommentData
   extends java.lang.Object
   implements java.io.Serializable
{

   private static final long serialVersionUID = 1L;
   private java.lang.Integer id;
   private java.lang.String _Comment;
   private java.sql.Date _Date;
   private java.lang.String _Issue_id;

   public CommentData()
   {
   }

   public CommentData( CommentData otherData )
   {
      setId(otherData.getId());
      set_Comment(otherData.get_Comment());
      set_Date(otherData.get_Date());
      set_Issue_id(otherData.get_Issue_id());

   }

   public org.openxava.test.model.CommentKey getPrimaryKey() {
     org.openxava.test.model.CommentKey pk = new org.openxava.test.model.CommentKey(this.getId());
     return pk;
   }

   public java.lang.Integer getId()
   {
      return this.id;
   }
   public void setId( java.lang.Integer id )
   {
      this.id = id;
   }

   public java.lang.String get_Comment()
   {
      return this._Comment;
   }
   public void set_Comment( java.lang.String _Comment )
   {
      this._Comment = _Comment;
   }

   public java.sql.Date get_Date()
   {
      return this._Date;
   }
   public void set_Date( java.sql.Date _Date )
   {
      this._Date = _Date;
   }

   public java.lang.String get_Issue_id()
   {
      return this._Issue_id;
   }
   public void set_Issue_id( java.lang.String _Issue_id )
   {
      this._Issue_id = _Issue_id;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("id=" + getId() + " " + "_Comment=" + get_Comment() + " " + "_Date=" + get_Date() + " " + "_Issue_id=" + get_Issue_id());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof CommentData )
      {
         CommentData lTest = (CommentData) pOther;
         boolean lEquals = true;

         if( this.id == null )
         {
            lEquals = lEquals && ( lTest.id == null );
         }
         else
         {
            lEquals = lEquals && this.id.equals( lTest.id );
         }
         if( this._Comment == null )
         {
            lEquals = lEquals && ( lTest._Comment == null );
         }
         else
         {
            lEquals = lEquals && this._Comment.equals( lTest._Comment );
         }
         if( this._Date == null )
         {
            lEquals = lEquals && ( lTest._Date == null );
         }
         else
         {
            lEquals = lEquals && this._Date.equals( lTest._Date );
         }
         if( this._Issue_id == null )
         {
            lEquals = lEquals && ( lTest._Issue_id == null );
         }
         else
         {
            lEquals = lEquals && this._Issue_id.equals( lTest._Issue_id );
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

      result = 37*result + ((this.id != null) ? this.id.hashCode() : 0);

      result = 37*result + ((this._Comment != null) ? this._Comment.hashCode() : 0);

      result = 37*result + ((this._Date != null) ? this._Date.hashCode() : 0);

      result = 37*result + ((this._Issue_id != null) ? this._Issue_id.hashCode() : 0);

      return result;
   }

}
