
// File generated by OpenXava: Tue Oct 25 11:52:11 CEST 2016
// Archivo generado por OpenXava: Tue Oct 25 11:52:11 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Issue		Aggregate/Agregado: Comment

package org.openxava.test.model;

import java.util.*;
import java.math.*;
import java.rmi.RemoteException;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.*;

/**
 * 
 * @author MCarmen Gimeno
 */
public class Comment implements java.io.Serializable, org.openxava.test.model.IComment {	

	// Constructor
	public Comment() {
		initMembers();
	} 

	private void initMembers() { 
		setId(null); 
		setDate(null); 
		setComment(null); 	
	} 
	
	// Properties/Propiedades 
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer newId) {
		this.id = newId;
	} 
	private static org.openxava.converters.IConverter commentConverter;
	private org.openxava.converters.IConverter getCommentConverter() {
		if (commentConverter == null) {
			try {
				commentConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("comment");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "comment"));
			}
			
		}	
		return commentConverter;
	} 
	private java.lang.String comment;
	private java.lang.String get_Comment() {
		return comment;
	}
	private void set_Comment(java.lang.String newComment) {
		this.comment = newComment;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.lang.String getComment() {
		try {
			return (java.lang.String) getCommentConverter().toJava(get_Comment());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Comment", "Comment", "java.lang.String"));
		}
	}
	
	/**
	 * 
	 */
	public void setComment(java.lang.String newComment) {
		try { 
			set_Comment((java.lang.String) getCommentConverter().toDB(newComment));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Comment", "Comment", "java.lang.String"));
		}		
	} 
	private static org.openxava.converters.IConverter dateConverter;
	private org.openxava.converters.IConverter getDateConverter() {
		if (dateConverter == null) {
			try {
				dateConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("date");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	private java.sql.Date date;
	private java.sql.Date get_Date() {
		return date;
	}
	private void set_Date(java.sql.Date newDate) {
		this.date = newDate;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.util.Date getDate() {
		try {
			return (java.util.Date) getDateConverter().toJava(get_Date());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Comment", "java.util.Date"));
		}
	}
	
	/**
	 * 
	 */
	public void setDate(java.util.Date newDate) {
		try { 
			set_Date((java.sql.Date) getDateConverter().toDB(newDate));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Comment", "java.util.Date"));
		}		
	} 

	// References/Referencias 

	private org.openxava.test.model.IIssue issue; 	
	public org.openxava.test.model.IIssue getIssue() {
		if (issue != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				issue.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return issue;
	}
	public void setIssue(org.openxava.test.model.IIssue newIssue) {
		if (newIssue != null && !(newIssue instanceof org.openxava.test.model.Issue)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.issue = newIssue; 
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Issue").getMetaAggregate("Comment"); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "Comment"));
			return super.toString();
		}		
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}