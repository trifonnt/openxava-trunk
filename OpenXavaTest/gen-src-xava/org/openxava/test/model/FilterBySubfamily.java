
// File generated by OpenXava: Fri Feb 10 11:13:30 CET 2006
// Archivo generado por OpenXava: Fri Feb 10 11:13:30 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: FilterBySubfamily		Entity/Entidad

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
public class FilterBySubfamily implements java.io.Serializable, org.openxava.test.model.IFilterBySubfamily {	
	
	// Properties/Propiedades 
	private String oid;
	public String getOid() {
		return oid;
	}
	public void setOid(String newOid) {
		this.oid = newOid;
	} 

	// References/Referencias 
	private org.openxava.test.model.ISubfamily2 subfamilyTo;
	public org.openxava.test.model.ISubfamily2 getSubfamilyTo() {
		return subfamilyTo;
	}
	public void setSubfamilyTo(org.openxava.test.model.ISubfamily2 newSubfamily2) {
		this.subfamilyTo = newSubfamily2;
	} 
	private org.openxava.test.model.ISubfamily2 subfamily;
	public org.openxava.test.model.ISubfamily2 getSubfamily() {
		return subfamily;
	}
	public void setSubfamily(org.openxava.test.model.ISubfamily2 newSubfamily2) {
		this.subfamily = newSubfamily2;
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 


	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("FilterBySubfamily").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		StringBuffer toStringValue = new StringBuffer("[.");
		java.lang.reflect.Field [] fields = getClass().getDeclaredFields();
		Arrays.sort(fields, FieldComparator.getInstance());
		for (int i=0; i < fields.length; i++) {
			try {
				if (getMetaModel().isKey(fields[i].getName())) {
					toStringValue.append(fields[i].get(this)).append('.');
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
				toStringValue.append(" ").append('.');
			}
		}
		toStringValue.append(']');
		return toStringValue.toString();
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}