package org.openxava.test.actions;

import org.openxava.actions.*;

/**
 * @author Javier Paniza
 */
public class OnChangePreferredWarehouseAction extends OnChangePropertyBaseAction {

	public void execute() throws Exception {	
		if (getNewValue() == null) getView().setValue("remarks", "");
		else getView().setValue("remarks", "PREFERRED WAREHOUSE IS " + getNewValue());		
	}

}
