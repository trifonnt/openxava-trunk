
// File generated by xavax: Tue Jan 04 19:56:46 CET 2005
// Archivo generado por xavax: Tue Jan 04 19:56:46 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// XavaxComponent: Profesor		Entity/Entidad

package org.xavax.escuela.model.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.xavax.ejbx.*;
import org.xavax.util.*;
import org.xavax.component.*;
import org.xavax.model.meta.*;
import org.xavax.validators.ValidationException;

import org.xavax.escuela.model.*;


/**
 * @ejb:bean name="Profesor" type="CMP" jndi-name="@subcontext@/ejb/org.xavax.escuela.model/Profesor" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.xavax.ejbx.EJBReplicable, org.xavax.escuela.model.IProfesor"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Profesor" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 
 * 
 * @jboss:table-name "MYSCHOOL@separator@TEACHER"
 *
 * @author Javier Paniza
 */
abstract public class ProfesorBean extends EJBReplicableBase 
			implements org.xavax.escuela.model.IProfesor, EntityBean {	
			
	private boolean creating = false;		

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.xavax.escuela.model.ProfesorKey ejbCreate(Map values) 
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
	public org.xavax.escuela.model.ProfesorKey ejbCreate(org.xavax.escuela.model.ProfesorData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setData(data); 
		setCodigo(data.getCodigo()); 
			
		return null;
	} 
	public void ejbPostCreate(org.xavax.escuela.model.ProfesorData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.xavax.escuela.model.ProfesorKey ejbCreate(org.xavax.escuela.model.ProfesorValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setProfesorValue(value); 
		setCodigo(value.getCodigo()); 
			
		return null;
	} 
	public void ejbPostCreate(org.xavax.escuela.model.ProfesorValue value) 
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
	private org.xavax.converters.TrimStringConverter nombreConverter;
	private org.xavax.converters.TrimStringConverter getNombreConverter() {
		if (nombreConverter == null) {
			try {
				nombreConverter = (org.xavax.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("nombre");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaxResources.getString("generator.create_converter_error", "nombre"));
			}
			
		}	
		return nombreConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "NAME"
	 */
	public abstract java.lang.String get_Nombre();
	public abstract void set_Nombre(java.lang.String newNombre); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getNombre() {
		try {
			return (String) getNombreConverter().toJava(get_Nombre());
		}
		catch (org.xavax.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaxResources.getString("generator.conversion_error", "Nombre", "Profesor", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setNombre(String newNombre) {
		try {
			set_Nombre((java.lang.String) getNombreConverter().toDB(newNombre));
		}
		catch (org.xavax.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaxResources.getString("generator.conversion_error", "Nombre", "Profesor", "String"));
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
	public abstract String getCodigo();
	/**
	  * 
	  */
	public abstract void setCodigo(String newCodigo); 

	// Colecciones/Collections		

	// References/Referencias 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaxException {
		if (metaModel == null) {
			metaModel = XavaxComponent.get("Profesor").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.xavax.escuela.model.ProfesorData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.xavax.escuela.model.ProfesorData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.xavax.escuela.model.ProfesorValue getProfesorValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setProfesorValue(org.xavax.escuela.model.ProfesorValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setCodigo(null); 
		setNombre(null); 
	}
		
}