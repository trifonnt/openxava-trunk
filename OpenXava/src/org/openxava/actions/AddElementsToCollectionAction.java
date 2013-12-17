package org.openxava.actions;

import java.util.*;

import javax.ejb.*;
import javax.inject.*;

import org.apache.commons.logging.*;
import org.hibernate.validator.*;
import org.openxava.model.meta.*;
import org.openxava.tab.*;
import org.openxava.util.*;
import org.openxava.validators.*;

/**
 * This is for the case of collections of entities without @AsEmbedded (or without as-aggregate="true"). <p>
 * 
 * The remaining cases are treated by {@link SaveElementInCollectionAction}.<br> 
 * This case add a group of entities from a list.<br>
 *  
 * @author Javier Paniza
 * @author Jeromy Altuna
 */

public class AddElementsToCollectionAction extends SaveElementInCollectionAction implements INavigationAction {
	
	private static Log log = LogFactory.getLog(AddElementsToCollectionAction.class);
	 		
	@Inject 
	private Tab tab;
	private int added;
	private int failed;
	private int row = -1;
	@Inject
	private String currentCollectionLabel;
	
	public void execute() throws Exception {
		saveIfNotExists(getCollectionElementView().getParent());		
		if (row >= 0) {
			validateMaximum(1); 
			associateEntityInRow(row);
		}
		else {
			Map [] selectedOnes = getTab().getSelectedKeys();
			validateMaximum(selectedOnes.length); 
			if (selectedOnes != null && selectedOnes.length > 0) {						
				for (int i = 0; i < selectedOnes.length; i++) {
					associateKey(selectedOnes[i]);
				}
			}		
			else {
				addError("choose_element_before_add");
				return;
			}
		}
		addMessage("elements_added_to_collection", new Integer(added), currentCollectionLabel);		
		if (failed > 0) addError("elements_not_added_to_collection", new Integer(failed), currentCollectionLabel);
		getView().setKeyEditable(false); // To mark as saved
		getTab().deselectAll();
		resetDescriptionsCache(); 		
		closeDialog(); 
	}

	private void associateEntityInRow(int row) throws FinderException, Exception {
		Map key = (Map) getTab().getTableModel().getObjectAt(row);
		associateKey(key);
	}
	
	private void associateKey(Map key){
		try {									
			associateEntity(key); 					
			added++;
		}
		catch (Exception ex) {
			addValidationMessage(ex); 
			failed++;
			log.error(
				XavaResources.getString("add_collection_element_error", 
						getCollectionElementView().getModelName(), 
						getCollectionElementView().getParent().getModelName()), 
					ex);			
		}
	}
	
	private void addValidationMessage(Exception ex) { 
		if (ex instanceof ValidationException) {		
			addErrors(((ValidationException)ex).getErrors());
		}
		else if (ex instanceof InvalidStateException) {
			InvalidValue [] invalidValues = ((InvalidStateException) ex).getInvalidValues();
			for (int i=0; i<invalidValues.length; i++) {
				addError("invalid_state", 
						invalidValues[i].getPropertyName(), 
						invalidValues[i].getBeanClass().getSimpleName(), 
						invalidValues[i].getMessage(), 
						invalidValues[i].getValue());			
			}
		}
		else if(ex instanceof javax.validation.ConstraintViolationException){
			Set<javax.validation.ConstraintViolation<?>> violations = 
					((javax.validation.ConstraintViolationException) ex).getConstraintViolations();
			for(javax.validation.ConstraintViolation<?> violation : violations){
				String message = violation.getMessage();
				if (message.startsWith("{") && message.endsWith("}")) {			
					message = message.substring(1, message.length() - 1); 							
				}				
				javax.validation.metadata.ConstraintDescriptor<?> descriptor = violation.getConstraintDescriptor(); 
				java.lang.annotation.Annotation annotation = descriptor.getAnnotation();
				if(annotation instanceof javax.validation.constraints.AssertTrue){							
					Object bean = violation.getRootBean();				
					addError(message, bean);					
				}
			}					
		}
	}
	
	private void validateMaximum(int elementsToAdd) throws ValidationException, XavaException{
		MetaCollection metaCollection = getMetaCollection();
		int maximum = metaCollection.getMaximum();
		if(maximum > 0 && (getCollectionElementView().getCollectionSize() + elementsToAdd) > maximum){
			Messages errors = new Messages();
			errors.add("maximum_elements", new Integer(maximum), metaCollection.getName(), metaCollection.getMetaModel().getName());
			throw new ValidationException(errors);
		}
	}
	
	public String getNextAction() throws Exception { 
		// In order to annul the chaining of the action
		return null;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab web) {
		tab = web;
	}


	public String[] getNextControllers() {		
		return added > 0?PREVIOUS_CONTROLLERS:SAME_CONTROLLERS;
	}

	public String getCustomView() {		
		return added > 0?PREVIOUS_VIEW:SAME_VIEW; 
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	// This action is executed from an dialog so it has not viewObject,
	// but it could be injected from a old (not updated) action definition 
	// in controllers.xml using use-object. This method is to avoid that 
	// viewObject has value in that case
	public void setViewObject(String viewObject) { 
	}

}
