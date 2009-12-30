package org.openxava.test.actions;

import org.openxava.actions.*;

public class GoAddFullAddressAction 
	extends ViewBaseAction 
	implements IChangeControllersAction {

	public void execute() throws Exception {
		showDialog(); // tmp En migration y gu�a de referencia
		getView().setTitleId("entry_full_address");
		// getView().setTitle("Entry the full address");
		getView().setModelName("OneLineAddress");		
	}

	public String[] getNextControllers() throws Exception {		
		return new String [] { "AddFullAddress" };
	}

}
