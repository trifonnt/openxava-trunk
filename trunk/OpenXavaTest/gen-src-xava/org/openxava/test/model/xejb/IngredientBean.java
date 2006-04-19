
// File generated by OpenXava: Wed Apr 19 12:36:32 CEST 2006
// Archivo generado por OpenXava: Wed Apr 19 12:36:32 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Ingredient		Entity/Entidad

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
 * @ejb:bean name="Ingredient" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Ingredient" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IIngredient"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Ingredient" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByPartOf(java.lang.String oid)" query="SELECT OBJECT(o) FROM Ingredient o WHERE o._PartOf_oid = ?1 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByPartOf(java.lang.String oid)" query="SELECT OBJECT(o) FROM Ingredient o WHERE o._PartOf_oid = ?1 " 	
 * @ejb:finder signature="Ingredient findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Ingredient o WHERE o.oid = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Ingredient findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Ingredient o WHERE o.oid = ?1" 
 * 
 * @jboss:table-name "XAVATEST_INGREDIENT"
 *
 * @author Javier Paniza
 */
abstract public class IngredientBean extends EJBReplicableBase 
			implements org.openxava.test.model.IIngredient, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.IngredientKey ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
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
	public org.openxava.test.model.IngredientKey ejbCreate(org.openxava.test.model.IngredientData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setOid(data.getOid()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.IngredientData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.IngredientKey ejbCreate(org.openxava.test.model.IngredientValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setIngredientValue(value); 
		setOid(value.getOid()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.IngredientValue value) 
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
	public abstract String getOid();
	/**
	  * 
	  */
	public abstract void setOid(String newOid); 
	private static org.openxava.converters.IConverter nameConverter;
	private org.openxava.converters.IConverter getNameConverter() {
		if (nameConverter == null) {
			try {
				nameConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("name");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "name"));
			}
			
		}	
		return nameConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "NAME"
	 */
	public abstract java.lang.String get_Name();
	public abstract void set_Name(java.lang.String newName); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getName() {
		try {
			return (String) getNameConverter().toJava(get_Name());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Ingredient", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setName(String newName) {
		try { 
			this.modified = true; 
			set_Name((java.lang.String) getNameConverter().toDB(newName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Ingredient", "String"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// PartOf : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IIngredient getPartOf() {
		try {		
			return getPartOfHome().findByPrimaryKey(getPartOfKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "PartOf", "Ingredient"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IngredientRemote getPartOfRemote() {
		return (org.openxava.test.model.IngredientRemote) getPartOf();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setPartOf(org.openxava.test.model.IIngredient newPartOf) { 
		this.modified = true; 
		try {	
			if (newPartOf == null) setPartOfKey(null);
			else {
				if (newPartOf instanceof org.openxava.test.model.Ingredient) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.IngredientRemote remote = (org.openxava.test.model.IngredientRemote) newPartOf;
				setPartOfKey((org.openxava.test.model.IngredientKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "PartOf", "Ingredient"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IngredientKey getPartOfKey() {				
		org.openxava.test.model.IngredientKey key = new org.openxava.test.model.IngredientKey(); 
		key.oid = getPartOf_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setPartOfKey(org.openxava.test.model.IngredientKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.IngredientKey(); 
			setPartOf_oid(key.oid);					
		}
		else { 
			setPartOf_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "PARTOF"
	 */
	public abstract String get_PartOf_oid();
	public abstract void set_PartOf_oid(String newPartOf_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getPartOf_oid() { 
		return get_PartOf_oid(); 
	}
	public void setPartOf_oid(String newPartOf_oid) { 
		set_PartOf_oid(newPartOf_oid); 	
	} 

	private org.openxava.test.model.IngredientHome partOfHome;	
	private org.openxava.test.model.IngredientHome getPartOfHome() throws Exception{
		if (partOfHome == null) {
			partOfHome = (org.openxava.test.model.IngredientHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Ingredient"),
			 		org.openxava.test.model.IngredientHome.class);			 		
		}
		return partOfHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Ingredient").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.IngredientData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.IngredientData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.IngredientValue getIngredientValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setIngredientValue(org.openxava.test.model.IngredientValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setOid(null); 
		setName(null); 
		setPartOfKey(null); 	
	} 		
}