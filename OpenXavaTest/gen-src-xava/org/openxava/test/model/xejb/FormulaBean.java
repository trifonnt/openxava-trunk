
// File generated by OpenXava: Thu Jan 18 17:38:59 CET 2007
// Archivo generado por OpenXava: Thu Jan 18 17:38:59 CET 2007

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Formula		Entity/Entidad

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
 * @ejb:bean name="Formula" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Formula" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IFormula"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Formula" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Formula findByName(java.lang.String name)" query="SELECT OBJECT(o) FROM Formula o WHERE o._Name = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Formula findByName(java.lang.String name)" query="SELECT OBJECT(o) FROM Formula o WHERE o._Name = ?1" 	
 * @ejb:finder signature="Formula findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Formula o WHERE o.oid = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Formula findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Formula o WHERE o.oid = ?1" 
 * 
 * @jboss:table-name "XAVATEST_FORMULA"
 *
 * @author Javier Paniza
 */
abstract public class FormulaBean extends EJBReplicableBase 
			implements org.openxava.test.model.IFormula, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.FormulaKey ejbCreate(Map values) 
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
			throw new EJBException(XavaResources.getString("entity_create_error", "Formula", ex.getLocalizedMessage()));
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
	public org.openxava.test.model.FormulaKey ejbCreate(org.openxava.test.model.FormulaData data) 
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
			throw new EJBException(XavaResources.getString("entity_create_error", "Formula", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.FormulaData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.FormulaKey ejbCreate(org.openxava.test.model.FormulaValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setFormulaValue(value); 
		setOid(value.getOid()); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator = (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setModel(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Formula", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.FormulaValue value) 
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
	private static org.openxava.converters.IConverter recipeConverter;
	private org.openxava.converters.IConverter getRecipeConverter() {
		if (recipeConverter == null) {
			try {
				recipeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("recipe");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "recipe"));
			}
			
		}	
		return recipeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "RECIPE"
	 */
	public abstract java.lang.String get_Recipe();
	public abstract void set_Recipe(java.lang.String newRecipe); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.lang.String getRecipe() {
		try {
			return (java.lang.String) getRecipeConverter().toJava(get_Recipe());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Recipe", "Formula", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setRecipe(java.lang.String newRecipe) {
		try { 
			this.modified = true; 
			set_Recipe((java.lang.String) getRecipeConverter().toDB(newRecipe));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Recipe", "Formula", "java.lang.String"));
		}		
	} 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Formula", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Formula", "String"));
		}		
	} 

	// Colecciones/Collections	

	private org.openxava.test.model.FormulaIngredientHome ingredientsHome; 
	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getIngredients() {		
		try {
			return getIngredientsHome().findByFormula(getOid());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "Ingredients", "Formula"));
		}
	}
		
	private org.openxava.test.model.FormulaIngredientHome getIngredientsHome() throws Exception{
		if (ingredientsHome == null) {
			ingredientsHome = (org.openxava.test.model.FormulaIngredientHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/FormulaIngredient"),
			 		org.openxava.test.model.FormulaIngredientHome.class);			 		
		}
		return ingredientsHome;
	}		

	// References/Referencias 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Formula").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.FormulaData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.FormulaData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.FormulaValue getFormulaValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setFormulaValue(org.openxava.test.model.FormulaValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setOid(null); 
		setName(null); 
		setRecipe(null); 	
	} 		
}