
// File generated by OpenXava: Tue Jul 22 16:34:16 CEST 2008
// Archivo generado por OpenXava: Tue Jul 22 16:34:16 CEST 2008

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Issue		Aggregate/Agregado: Comment

package org.openxava.test.model.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.openxava.ejbx.*;
import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.validators.ValidationException;

import org.openxava.test.model.*;


/**
 * @ejb:bean name="Comment" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Comment" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IComment"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Comment" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByIssue(java.lang.String id)" query="SELECT OBJECT(o) FROM Comment o WHERE o._Issue_id = ?1 ORDER BY o.id" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByIssue(java.lang.String id)" query="SELECT OBJECT(o) FROM Comment o WHERE o._Issue_id = ?1 ORDER BY o.id" 
 * 
 * @jboss:table-name "COMMENT"
 *
 * @author Javier Paniza
 */
abstract public class CommentBean extends EJBReplicableBase 
			implements org.openxava.test.model.IComment, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.CommentKey ejbCreate(org.openxava.test.model.IssueRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		org.openxava.test.model.IssueKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.IssueKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Issue", "Comment"));
		} 
		setIssue_id(containerKey.id); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.IssueRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.CommentKey ejbCreate(org.openxava.test.model.IssueKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		executeSets(values); 
		setIssue_id(containerKey.id); 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.model.IssueKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.CommentKey ejbCreate(org.openxava.test.model.IssueRemote container, int counter, org.openxava.test.model.CommentData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		org.openxava.test.model.IssueKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.IssueKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Issue", "Comment"));
		} 
		setIssue_id(containerKey.id); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.IssueRemote container, int counter, org.openxava.test.model.CommentData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.CommentKey ejbCreate(org.openxava.test.model.IssueRemote container, int counter, org.openxava.test.model.CommentValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setCommentValue(value); 
		setId(value.getId()); 
		org.openxava.test.model.IssueKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.IssueKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Issue", "Comment"));
		} 
		setIssue_id(containerKey.id); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.IssueRemote container, int counter, org.openxava.test.model.CommentValue value) 
		throws
			CreateException,
			ValidationException { 			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.CommentKey ejbCreate(org.openxava.test.model.IssueKey containerKey, int counter, org.openxava.test.model.CommentValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		setCommentValue(value); 
		setId(value.getId());
		setIssue_id(containerKey.id); 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.model.IssueKey containerKey, int counter, org.openxava.test.model.CommentValue value)	
		throws
			CreateException,
			ValidationException { 			
	}
	
	public void ejbLoad() {
		creating = false;
		modified = false; 
	}
	
	public void ejbStore() {
		if (creating) {
			creating = false;
			return;
		}
		if (!modified) return; 
		
		modified = false;
	} 	
	

	public void ejbRemove() throws RemoveException { 						
	} 	
	
	// Properties/Propiedades 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "ID"
	 */
	public abstract Integer getId();
	/**
	  * 
	  */
	public abstract void setId(Integer newId); 
	private static org.openxava.converters.IConverter commentConverter;
	private org.openxava.converters.IConverter getCommentConverter() {
		if (commentConverter == null) {
			try {
				commentConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("comment");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "comment"));
			}
			
		}	
		return commentConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "COMMENT"
	 */
	public abstract java.lang.String get_Comment();
	public abstract void set_Comment(java.lang.String newComment); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.lang.String getComment() {
		try {
			return (java.lang.String) getCommentConverter().toJava(get_Comment());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Comment", "Comment", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setComment(java.lang.String newComment) {
		try { 
			this.modified = true; 
			set_Comment((java.lang.String) getCommentConverter().toDB(newComment));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Comment", "Comment", "java.lang.String"));
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
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DATE"
	 */
	public abstract java.sql.Date get_Date();
	public abstract void set_Date(java.sql.Date newDate); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.util.Date getDate() {
		try {
			return (java.util.Date) getDateConverter().toJava(get_Date());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Comment", "java.util.Date"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDate(java.util.Date newDate) {
		try { 
			this.modified = true; 
			set_Date((java.sql.Date) getDateConverter().toDB(newDate));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Comment", "java.util.Date"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// Issue : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IIssue getIssue() {
		try {		
			return getIssueHome().findByPrimaryKey(getIssueKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Issue", "Comment"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IssueRemote getIssueRemote() {
		return (org.openxava.test.model.IssueRemote) getIssue();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setIssue(org.openxava.test.model.IIssue newIssue) { 
		this.modified = true; 
		try {	
			if (newIssue == null) setIssueKey(null);
			else {
				if (newIssue instanceof org.openxava.test.model.Issue) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.IssueRemote remote = (org.openxava.test.model.IssueRemote) newIssue;
				setIssueKey((org.openxava.test.model.IssueKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Issue", "Comment"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IssueKey getIssueKey() {				
		org.openxava.test.model.IssueKey key = new org.openxava.test.model.IssueKey(); 
		key.id = getIssue_id();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setIssueKey(org.openxava.test.model.IssueKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.IssueKey(); 
			setIssue_id(key.id);					
		}
		else { 
			setIssue_id(key.id);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "ISSUE_ID"
	 */
	public abstract String get_Issue_id();
	public abstract void set_Issue_id(String newIssue_id);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getIssue_id() { 
		return get_Issue_id(); 
	}
	public void setIssue_id(String newIssue_id) { 
		set_Issue_id(newIssue_id); 	
	} 

	private org.openxava.test.model.IssueHome issueHome;	
	private org.openxava.test.model.IssueHome getIssueHome() throws Exception{
		if (issueHome == null) {
			issueHome = (org.openxava.test.model.IssueHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Issue"),
			 		org.openxava.test.model.IssueHome.class);			 		
		}
		return issueHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Issue").getMetaAggregate("Comment"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CommentData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.CommentData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CommentValue getCommentValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setCommentValue(org.openxava.test.model.CommentValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setId(null); 
		setDate(null); 
		setComment(null); 
		setIssueKey(null); 	
	} 		
}