package org.openxava.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openxava.tab.*;

/**
 * @author Javier Paniza
 */

public class RemoveColumnAction extends BaseAction {
	
	private Tab tab;
	private int columnIndex;
	private Log log = LogFactory.getLog(RemoveColumnAction.class);

	public void execute() throws Exception {
		getTab().removeProperty(columnIndex);
	}

	public Tab getTab() {
		return tab;
	}
	public void setTab(Tab tab) {
		this.tab = tab;
	}
	public int getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
}
