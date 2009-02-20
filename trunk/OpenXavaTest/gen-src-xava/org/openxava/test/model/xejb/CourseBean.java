
// File generated by OpenXava: Fri Feb 20 17:12:32 CET 2009
// Archivo generado por OpenXava: Fri Feb 20 17:12:32 CET 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Course		Entity/Entidad

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
 * @ejb:bean name="Course" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Course" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ICourse"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Course" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Course findByYearNumber(int year,int number)" query="SELECT OBJECT(o) FROM Course o WHERE o.year = ?1 and o.number = ?2" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Course findByYearNumber(int year,int number)" query="SELECT OBJECT(o) FROM Course o WHERE o.year = ?1 and o.number = ?2" 
 * 
 * @jboss:table-name "XAVATEST.COURSE"
 *
 * @author Javier Paniza
 */
abstract public class CourseBean extends EJBReplicableBase 
			implements org.openxava.test.model.ICourse, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CourseKey ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		try { 	
			org.openxava.test.calculators.CourseNumberCalculator numberCalculator = (org.openxava.test.calculators.CourseNumberCalculator)
				getMetaModel().getMetaProperty("number").getMetaCalculatorDefaultValue().createCalculator(); 
			setNumber(((Integer) numberCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Course", ex.getLocalizedMessage()));
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
	public org.openxava.test.model.CourseKey ejbCreate(org.openxava.test.model.CourseData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setYear(data.getYear()); 
		setNumber(data.getNumber()); 
		try { 	
			org.openxava.test.calculators.CourseNumberCalculator numberCalculator= (org.openxava.test.calculators.CourseNumberCalculator)
				getMetaModel().getMetaProperty("number").getMetaCalculatorDefaultValue().createCalculator(); 
			setNumber(((Integer) numberCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Course", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.CourseData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CourseKey ejbCreate(org.openxava.test.model.CourseValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setCourseValue(value); 
		setYear(value.getYear()); 
		setNumber(value.getNumber()); 
		try { 	
			org.openxava.test.calculators.CourseNumberCalculator numberCalculator = (org.openxava.test.calculators.CourseNumberCalculator)
				getMetaModel().getMetaProperty("number").getMetaCalculatorDefaultValue().createCalculator(); 
			setNumber(((Integer) numberCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Course", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.CourseValue value) 
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
	 * @jboss:column-name "YEAR"
	 */
	public abstract int getYear();
	/**
	  * 
	  */
	public abstract void setYear(int newYear); 
	private static org.openxava.converters.IConverter descriptionConverter;
	private org.openxava.converters.IConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.IConverter) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Course", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDescription(String newDescription) {
		try { 
			this.modified = true; 
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Course", "String"));
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
	public abstract int getNumber();
	/**
	  * 
	  */
	public abstract void setNumber(int newNumber); 

	// Colecciones/Collections		

	// References/Referencias 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Course").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CourseData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.CourseData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CourseValue getCourseValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setCourseValue(org.openxava.test.model.CourseValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setYear(0); 
		setNumber(0); 
		setDescription(null); 	
	} 		
}