
// File generated by OpenXava: Mon Jun 20 11:03:30 CEST 2016
// Archivo generado por OpenXava: Mon Jun 20 11:03:30 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: IssueList		Entity/Entidad

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
public class IssueList implements java.io.Serializable, org.openxava.test.model.IIssueList {	

	// Constructor
	public IssueList() {
		initMembers();
	} 

	private void initMembers() { 	
	} 
	
	// Properties/Propiedades 

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
 	public static IssueList findBy() throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from IssueList as o"); 
 			try {
				return (IssueList) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "IssueList"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			}  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from IssueList as o"); 
			IssueList r = (IssueList) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "IssueList"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("IssueList").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "IssueList"));
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