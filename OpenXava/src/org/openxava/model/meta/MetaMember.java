package org.openxava.model.meta;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openxava.util.*;
import org.openxava.util.meta.*;

/**
 * @author Javier Paniza
 */
abstract public class MetaMember extends MetaElement {

	private MetaModel metaModel;
	private String labelId;
	private String qualifiedName;
	
	private Log log = LogFactory.getLog(MetaMember.class);

	public MetaModel getMetaModel() {		
		return metaModel;
	}

	public void setMetaModel(MetaModel newContainer) {
		metaModel = newContainer;		
	}
	
	public String getQualifiedName() {
		if (qualifiedName == null) {
			if (getMetaModel() == null) qualifiedName = getName();
			else qualifiedName = getMetaModel().getName() + "." + getName();
		}
		return qualifiedName;
	}
	
	/**
	 * For can set a qualified name manually.
	 */
	public void setQualifiedName(String newQualifiedName) {
		qualifiedName = newQualifiedName;
	}
		
	public boolean isHidden() {
		return false;
	}
	
	public String getId() {
		if (!Is.emptyString(labelId)) {
			return labelId;		
		}
		MetaModel m = getMetaModel(); 
		return m==null?getName():m.getId() + "." + getName();
	}
	
	/**
	 * Id used to look up label in resource files. <p>
	 */ 	
	public String getLabelId() {
		return labelId;
	}
	public void setLabelId(String id) {
		this.labelId = id;		
	}
	
}