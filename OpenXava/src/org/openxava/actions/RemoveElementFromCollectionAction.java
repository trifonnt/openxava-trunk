package org.openxava.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openxava.model.*;
import org.openxava.validators.*;

/**
 * @author Javier Paniza
 */

public class RemoveElementFromCollectionAction extends CollectionElementViewBaseAction {
	
	private Log log = LogFactory.getLog(RemoveElementFromCollectionAction.class);
	
	public void execute() throws Exception {
		try {											
			if (!getCollectionElementView().getKeyValuesWithValue().isEmpty()) {				
				MapFacade.removeCollectionElement(getCollectionElementView().getParent().getModelName(), getCollectionElementView().getParent().getKeyValues(), getCollectionElementView().getMemberName(), getCollectionElementView().getKeyValues());
				if (isEntityReferencesCollection()) {
					addMessage("association_removed", getCollectionElementView().getModelName(), getCollectionElementView().getParent().getModelName());
				}
				else {
					addMessage("aggregate_removed", getCollectionElementView().getModelName());
				}
			}			
			getCollectionElementView().setCollectionEditingRow(-1);
			getCollectionElementView().clear();
			getView().recalculateProperties();
		}
		catch (ValidationException ex) {			
			addErrors(ex.getErrors());
		}				
	}
		
}
