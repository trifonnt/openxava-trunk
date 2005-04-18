
// File generated by OpenXava: Mon Apr 18 09:24:45 CEST 2005
// Archivo generado por OpenXava: Mon Apr 18 09:24:45 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Product3		Entity/Entidad

package org.openxava.test.ejb.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.openxava.ejbx.*;
import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.validators.ValidationException;

import org.openxava.test.ejb.*;


/**
 * @ejb:bean name="Product3" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/Product3" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.IProduct3"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Product3" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByFamily(java.lang.String oid)" query="SELECT OBJECT(o) FROM Product3 o WHERE o.family_oid = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByFamily(java.lang.String oid)" query="SELECT OBJECT(o) FROM Product3 o WHERE o.family_oid = ?1 " 
 * 
 * @jboss:table-name "XAVATEST_PRODUCT3"
 *
 * @author Javier Paniza
 */
abstract public class Product3Bean extends EJBReplicableBase 
			implements org.openxava.test.ejb.IProduct3, EntityBean {	
			
	private boolean creating = false;		

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.Product3Key ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		executeSets(values); 
			
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
	public org.openxava.test.ejb.Product3Key ejbCreate(org.openxava.test.ejb.Product3Data data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setData(data); 
		setNumber(data.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Product3Data data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.Product3Key ejbCreate(org.openxava.test.ejb.Product3Value value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setProduct3Value(value); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Product3Value value) 
		throws
			CreateException,
			ValidationException {			
	}
	
	public void ejbLoad() {
		creating = false;
	}
	
	public void ejbStore() {
		if (creating) {
			creating = false;
			return;
		}			
	} 	
	
	// Properties/Propiedades 
	private org.openxava.converters.TrimStringConverter commentsConverter;
	private org.openxava.converters.TrimStringConverter getCommentsConverter() {
		if (commentsConverter == null) {
			try {
				commentsConverter = (org.openxava.converters.TrimStringConverter) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Comments", "Product3", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setComments(java.lang.String newComments) {
		try {
			set_Comments((java.lang.String) getCommentsConverter().toDB(newComments));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Comments", "Product3", "java.lang.String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter descriptionConverter;
	private org.openxava.converters.TrimStringConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("description");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "description"));
			}
			
		}	
		return descriptionConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DESCRIPTION"
	 */
	public abstract java.lang.String get_Description();
	public abstract void set_Description(java.lang.String newDescription); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getDescription() {
		try {
			return (String) getDescriptionConverter().toJava(get_Description());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Product3", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDescription(String newDescription) {
		try {
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Product3", "String"));
		}		
	} 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "NUMBER"
	 */
	public abstract long getNumber();
	/**
	  * 
	  */
	public abstract void setNumber(long newNumber); 

	// Colecciones/Collections		

	// References/Referencias 

	// Family : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Family getFamily() {
		try {		
			return getFamilyHome().findByPrimaryKey(getFamilyKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Family", "Product3"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setFamily(org.openxava.test.ejb.Family newFamily) {
		try {	
			if (newFamily == null) setFamilyKey(null);
			else setFamilyKey((org.openxava.test.ejb.FamilyKey) newFamily.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Family", "Product3"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.FamilyKey getFamilyKey() {				
			org.openxava.test.ejb.FamilyKey key = new org.openxava.test.ejb.FamilyKey(); 
			key.oid = getFamily_oid();		
			return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setFamilyKey(org.openxava.test.ejb.FamilyKey key) {
		if (key == null) {
			key = new org.openxava.test.ejb.FamilyKey();
		} 
		setFamily_oid(key.oid);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "FAMILY"
	 */
	public abstract String getFamily_oid();
	public abstract void setFamily_oid(String newFamily_oid); 

	private org.openxava.test.ejb.FamilyHome familyHome;	
	private org.openxava.test.ejb.FamilyHome getFamilyHome() throws Exception{
		if (familyHome == null) {
			familyHome = (org.openxava.test.ejb.FamilyHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/openxava.test/Family"),
			 		org.openxava.test.ejb.FamilyHome.class);			 		
		}
		return familyHome;
	} 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Product3").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.Product3Data getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.Product3Data data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.Product3Value getProduct3Value();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setProduct3Value(org.openxava.test.ejb.Product3Value value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setNumber(0); 
		setDescription(null); 
		setComments(null); 
	}
		
}