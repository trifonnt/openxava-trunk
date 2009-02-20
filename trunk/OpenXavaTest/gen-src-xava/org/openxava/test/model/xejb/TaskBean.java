
// File generated by OpenXava: Fri Feb 20 17:12:32 CET 2009
// Archivo generado por OpenXava: Fri Feb 20 17:12:32 CET 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Task		Entity/Entidad

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
 * @ejb:bean name="Task" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Task" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ITask"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Task" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Task findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Task o WHERE o.oid = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Task findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Task o WHERE o.oid = ?1" 
 * 
 * @jboss:table-name "XAVATEST.TASK"
 *
 * @author Javier Paniza
 */
abstract public class TaskBean extends EJBReplicableBase 
			implements org.openxava.test.model.ITask, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.TaskKey ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator = (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setModel(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Task", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.TaskKey ejbCreate(org.openxava.test.model.TaskData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setOid(data.getOid()); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator= (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setModel(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Task", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.TaskData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.TaskKey ejbCreate(org.openxava.test.model.TaskValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setTaskValue(value); 
		setOid(value.getOid()); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator = (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setModel(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Task", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.TaskValue value) 
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
	private static org.openxava.converters.IConverter commentsConverter;
	private org.openxava.converters.IConverter getCommentsConverter() {
		if (commentsConverter == null) {
			try {
				commentsConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("comments");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "comments"));
			}
			
		}	
		return commentsConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "COMMENTS"
	 */
	public abstract java.lang.String get_Comments();
	public abstract void set_Comments(java.lang.String newComments); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.lang.String getComments() {
		try {
			return (java.lang.String) getCommentsConverter().toJava(get_Comments());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Comments", "Task", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setComments(java.lang.String newComments) {
		try { 
			this.modified = true; 
			set_Comments((java.lang.String) getCommentsConverter().toDB(newComments));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Comments", "Task", "java.lang.String"));
		}		
	} 
	private static org.openxava.converters.IConverter summaryConverter;
	private org.openxava.converters.IConverter getSummaryConverter() {
		if (summaryConverter == null) {
			try {
				summaryConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("summary");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "summary"));
			}
			
		}	
		return summaryConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "SUMMARY"
	 */
	public abstract java.lang.String get_Summary();
	public abstract void set_Summary(java.lang.String newSummary); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.lang.String getSummary() {
		try {
			return (java.lang.String) getSummaryConverter().toJava(get_Summary());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Summary", "Task", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setSummary(java.lang.String newSummary) {
		try { 
			this.modified = true; 
			set_Summary((java.lang.String) getSummaryConverter().toDB(newSummary));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Summary", "Task", "java.lang.String"));
		}		
	} 
	private static org.openxava.converters.IConverter userConverter;
	private org.openxava.converters.IConverter getUserConverter() {
		if (userConverter == null) {
			try {
				userConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("user");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "user"));
			}
			
		}	
		return userConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "USERNAME"
	 */
	public abstract java.lang.String get_User();
	public abstract void set_User(java.lang.String newUser); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getUser() {
		try {
			return (String) getUserConverter().toJava(get_User());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "User", "Task", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setUser(String newUser) {
		try { 
			this.modified = true; 
			set_User((java.lang.String) getUserConverter().toDB(newUser));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "User", "Task", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter userFamilyNameConverter;
	private org.openxava.converters.IConverter getUserFamilyNameConverter() {
		if (userFamilyNameConverter == null) {
			try {
				userFamilyNameConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("userFamilyName");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "userFamilyName"));
			}
			
		}	
		return userFamilyNameConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "USERFAMILYNAME"
	 */
	public abstract java.lang.String get_UserFamilyName();
	public abstract void set_UserFamilyName(java.lang.String newUserFamilyName); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getUserFamilyName() {
		try {
			return (String) getUserFamilyNameConverter().toJava(get_UserFamilyName());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UserFamilyName", "Task", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setUserFamilyName(String newUserFamilyName) {
		try { 
			this.modified = true; 
			set_UserFamilyName((java.lang.String) getUserFamilyNameConverter().toDB(newUserFamilyName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UserFamilyName", "Task", "String"));
		}		
	} 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "ID"
	 */
	public abstract String getOid();
	/**
	  * 
	  */
	public abstract void setOid(String newOid); 
	private static org.openxava.converters.IConverter userGivenNameConverter;
	private org.openxava.converters.IConverter getUserGivenNameConverter() {
		if (userGivenNameConverter == null) {
			try {
				userGivenNameConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("userGivenName");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "userGivenName"));
			}
			
		}	
		return userGivenNameConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "USERGIVENNAME"
	 */
	public abstract java.lang.String get_UserGivenName();
	public abstract void set_UserGivenName(java.lang.String newUserGivenName); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getUserGivenName() {
		try {
			return (String) getUserGivenNameConverter().toJava(get_UserGivenName());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UserGivenName", "Task", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setUserGivenName(String newUserGivenName) {
		try { 
			this.modified = true; 
			set_UserGivenName((java.lang.String) getUserGivenNameConverter().toDB(newUserGivenName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UserGivenName", "Task", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Task", "java.util.Date"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Task", "java.util.Date"));
		}		
	} 
	private static org.openxava.converters.IConverter userEMailConverter;
	private org.openxava.converters.IConverter getUserEMailConverter() {
		if (userEMailConverter == null) {
			try {
				userEMailConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("userEMail");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "userEMail"));
			}
			
		}	
		return userEMailConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "USEREMAIL"
	 */
	public abstract java.lang.String get_UserEMail();
	public abstract void set_UserEMail(java.lang.String newUserEMail); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getUserEMail() {
		try {
			return (String) getUserEMailConverter().toJava(get_UserEMail());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UserEMail", "Task", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setUserEMail(String newUserEMail) {
		try { 
			this.modified = true; 
			set_UserEMail((java.lang.String) getUserEMailConverter().toDB(newUserEMail));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UserEMail", "Task", "String"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Task").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.TaskData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.TaskData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.TaskValue getTaskValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setTaskValue(org.openxava.test.model.TaskValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setOid(null); 
		setUser(null); 
		setUserGivenName(null); 
		setUserFamilyName(null); 
		setUserEMail(null); 
		setDate(null); 
		setSummary(null); 
		setComments(null); 	
	} 		
}