package org.openxava.test.actions;

import org.openxava.actions.*;

/**
 * 
 * @author Javier Paniza
 */

public class NewDeliveryDetailAction extends CreateNewElementInCollectionAction {

	public void execute() throws Exception {
		super.execute();
		addMessage("delivery_detail_action_executed", "new");
	}

}
