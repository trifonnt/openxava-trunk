
// File generated by OpenXava: Thu Nov 09 12:22:50 CET 2006
// Archivo generado por OpenXava: Thu Nov 09 12:22:50 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Formula		Aggregate/Agregado: FormulaIngredient

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
 * @ejb:bean name="FormulaIngredient" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/FormulaIngredient" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IFormulaIngredient"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="FormulaIngredient" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByIngredient(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._Ingredient_oid = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByIngredient(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._Ingredient_oid = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Collection findByAccentuate(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._Accentuate_oid = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByAccentuate(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._Accentuate_oid = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Collection findByAnotherFormula(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._AnotherFormula_oid = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByAnotherFormula(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._AnotherFormula_oid = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Collection findByFormula(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._Formula_oid = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByFormula(java.lang.String oid)" query="SELECT OBJECT(o) FROM FormulaIngredient o WHERE o._Formula_oid = ?1 ORDER BY o.oid" 
 * 
 * @jboss:table-name "XAVATEST_FORMULAINGREDIENT"
 *
 * @author Javier Paniza
 */
abstract public class FormulaIngredientBean extends EJBReplicableBase 
			implements org.openxava.test.model.IFormulaIngredient, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.FormulaIngredientKey ejbCreate(org.openxava.test.model.FormulaRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		org.openxava.test.model.FormulaKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.FormulaKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Formula", "FormulaIngredient"));
		} 
		setFormula_oid(containerKey.oid); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.FormulaRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.FormulaIngredientKey ejbCreate(org.openxava.test.model.FormulaKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		executeSets(values); 
		setFormula_oid(containerKey.oid); 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.model.FormulaKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.FormulaIngredientKey ejbCreate(org.openxava.test.model.FormulaRemote container, int counter, org.openxava.test.model.FormulaIngredientData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		org.openxava.test.model.FormulaKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.FormulaKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Formula", "FormulaIngredient"));
		} 
		setFormula_oid(containerKey.oid); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.FormulaRemote container, int counter, org.openxava.test.model.FormulaIngredientData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.FormulaIngredientKey ejbCreate(org.openxava.test.model.FormulaRemote container, int counter, org.openxava.test.model.FormulaIngredientValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setFormulaIngredientValue(value); 
		setOid(value.getOid()); 
		org.openxava.test.model.FormulaKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.FormulaKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Formula", "FormulaIngredient"));
		} 
		setFormula_oid(containerKey.oid); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.FormulaRemote container, int counter, org.openxava.test.model.FormulaIngredientValue value) 
		throws
			CreateException,
			ValidationException { 			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.FormulaIngredientKey ejbCreate(org.openxava.test.model.FormulaKey containerKey, int counter, org.openxava.test.model.FormulaIngredientValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		setFormulaIngredientValue(value); 
		setOid(value.getOid());
		setFormula_oid(containerKey.oid); 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.model.FormulaKey containerKey, int counter, org.openxava.test.model.FormulaIngredientValue value)	
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

	// Colecciones/Collections		

	// References/Referencias 

	// Ingredient : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IIngredient getIngredient() {
		try {		
			return getIngredientHome().findByPrimaryKey(getIngredientKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Ingredient", "FormulaIngredient"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IngredientRemote getIngredientRemote() {
		return (org.openxava.test.model.IngredientRemote) getIngredient();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setIngredient(org.openxava.test.model.IIngredient newIngredient) { 
		this.modified = true; 
		try {	
			if (newIngredient == null) setIngredientKey(null);
			else {
				if (newIngredient instanceof org.openxava.test.model.Ingredient) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.IngredientRemote remote = (org.openxava.test.model.IngredientRemote) newIngredient;
				setIngredientKey((org.openxava.test.model.IngredientKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Ingredient", "FormulaIngredient"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IngredientKey getIngredientKey() {				
		org.openxava.test.model.IngredientKey key = new org.openxava.test.model.IngredientKey(); 
		key.oid = getIngredient_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setIngredientKey(org.openxava.test.model.IngredientKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.IngredientKey(); 
			setIngredient_oid(key.oid);					
		}
		else { 
			setIngredient_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "INGREDIENT"
	 */
	public abstract String get_Ingredient_oid();
	public abstract void set_Ingredient_oid(String newIngredient_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getIngredient_oid() { 
		return get_Ingredient_oid(); 
	}
	public void setIngredient_oid(String newIngredient_oid) { 
		set_Ingredient_oid(newIngredient_oid); 	
	} 

	private org.openxava.test.model.IngredientHome ingredientHome;	
	private org.openxava.test.model.IngredientHome getIngredientHome() throws Exception{
		if (ingredientHome == null) {
			ingredientHome = (org.openxava.test.model.IngredientHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Ingredient"),
			 		org.openxava.test.model.IngredientHome.class);			 		
		}
		return ingredientHome;
	} 

	// Accentuate : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IIngredient getAccentuate() {
		try {		
			return getAccentuateHome().findByPrimaryKey(getAccentuateKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Accentuate", "FormulaIngredient"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IngredientRemote getAccentuateRemote() {
		return (org.openxava.test.model.IngredientRemote) getAccentuate();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAccentuate(org.openxava.test.model.IIngredient newAccentuate) { 
		this.modified = true; 
		try {	
			if (newAccentuate == null) setAccentuateKey(null);
			else {
				if (newAccentuate instanceof org.openxava.test.model.Ingredient) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.IngredientRemote remote = (org.openxava.test.model.IngredientRemote) newAccentuate;
				setAccentuateKey((org.openxava.test.model.IngredientKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Accentuate", "FormulaIngredient"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IngredientKey getAccentuateKey() {				
		org.openxava.test.model.IngredientKey key = new org.openxava.test.model.IngredientKey(); 
		key.oid = getAccentuate_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setAccentuateKey(org.openxava.test.model.IngredientKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.IngredientKey(); 
			setAccentuate_oid(key.oid);					
		}
		else { 
			setAccentuate_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "ACCENTUATE"
	 */
	public abstract String get_Accentuate_oid();
	public abstract void set_Accentuate_oid(String newAccentuate_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getAccentuate_oid() { 
		return get_Accentuate_oid(); 
	}
	public void setAccentuate_oid(String newAccentuate_oid) { 
		set_Accentuate_oid(newAccentuate_oid); 	
	} 

	private org.openxava.test.model.IngredientHome accentuateHome;	
	private org.openxava.test.model.IngredientHome getAccentuateHome() throws Exception{
		if (accentuateHome == null) {
			accentuateHome = (org.openxava.test.model.IngredientHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Ingredient"),
			 		org.openxava.test.model.IngredientHome.class);			 		
		}
		return accentuateHome;
	} 

	// AnotherFormula : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IFormula getAnotherFormula() {
		try {		
			return getAnotherFormulaHome().findByPrimaryKey(getAnotherFormulaKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "AnotherFormula", "FormulaIngredient"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.FormulaRemote getAnotherFormulaRemote() {
		return (org.openxava.test.model.FormulaRemote) getAnotherFormula();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAnotherFormula(org.openxava.test.model.IFormula newAnotherFormula) { 
		this.modified = true; 
		try {	
			if (newAnotherFormula == null) setAnotherFormulaKey(null);
			else {
				if (newAnotherFormula instanceof org.openxava.test.model.Formula) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.FormulaRemote remote = (org.openxava.test.model.FormulaRemote) newAnotherFormula;
				setAnotherFormulaKey((org.openxava.test.model.FormulaKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "AnotherFormula", "FormulaIngredient"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.FormulaKey getAnotherFormulaKey() {				
		org.openxava.test.model.FormulaKey key = new org.openxava.test.model.FormulaKey(); 
		key.oid = getAnotherFormula_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setAnotherFormulaKey(org.openxava.test.model.FormulaKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.FormulaKey(); 
			setAnotherFormula_oid(key.oid);					
		}
		else { 
			setAnotherFormula_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "ANOTHERFORMULA"
	 */
	public abstract String get_AnotherFormula_oid();
	public abstract void set_AnotherFormula_oid(String newAnotherFormula_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getAnotherFormula_oid() { 
		return get_AnotherFormula_oid(); 
	}
	public void setAnotherFormula_oid(String newAnotherFormula_oid) { 
		set_AnotherFormula_oid(newAnotherFormula_oid); 	
	} 

	private org.openxava.test.model.FormulaHome anotherFormulaHome;	
	private org.openxava.test.model.FormulaHome getAnotherFormulaHome() throws Exception{
		if (anotherFormulaHome == null) {
			anotherFormulaHome = (org.openxava.test.model.FormulaHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Formula"),
			 		org.openxava.test.model.FormulaHome.class);			 		
		}
		return anotherFormulaHome;
	} 

	// Formula : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IFormula getFormula() {
		try {		
			return getFormulaHome().findByPrimaryKey(getFormulaKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Formula", "FormulaIngredient"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.FormulaRemote getFormulaRemote() {
		return (org.openxava.test.model.FormulaRemote) getFormula();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setFormula(org.openxava.test.model.IFormula newFormula) { 
		this.modified = true; 
		try {	
			if (newFormula == null) setFormulaKey(null);
			else {
				if (newFormula instanceof org.openxava.test.model.Formula) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.FormulaRemote remote = (org.openxava.test.model.FormulaRemote) newFormula;
				setFormulaKey((org.openxava.test.model.FormulaKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Formula", "FormulaIngredient"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.FormulaKey getFormulaKey() {				
		org.openxava.test.model.FormulaKey key = new org.openxava.test.model.FormulaKey(); 
		key.oid = getFormula_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setFormulaKey(org.openxava.test.model.FormulaKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.FormulaKey(); 
			setFormula_oid(key.oid);					
		}
		else { 
			setFormula_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "FORMULA"
	 */
	public abstract String get_Formula_oid();
	public abstract void set_Formula_oid(String newFormula_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getFormula_oid() { 
		return get_Formula_oid(); 
	}
	public void setFormula_oid(String newFormula_oid) { 
		set_Formula_oid(newFormula_oid); 	
	} 

	private org.openxava.test.model.FormulaHome formulaHome;	
	private org.openxava.test.model.FormulaHome getFormulaHome() throws Exception{
		if (formulaHome == null) {
			formulaHome = (org.openxava.test.model.FormulaHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Formula"),
			 		org.openxava.test.model.FormulaHome.class);			 		
		}
		return formulaHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Formula").getMetaAggregate("FormulaIngredient"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.FormulaIngredientData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.FormulaIngredientData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.FormulaIngredientValue getFormulaIngredientValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setFormulaIngredientValue(org.openxava.test.model.FormulaIngredientValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setOid(null); 
		setIngredientKey(null); 
		setAccentuateKey(null); 
		setAnotherFormulaKey(null); 
		setFormulaKey(null); 	
	} 		
}