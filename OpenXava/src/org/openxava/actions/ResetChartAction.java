/**
 * 
 */
package org.openxava.actions;


/**
 * @author Federico Alcantara
 *
 */
public class ResetChartAction extends ChartsAction {
	/**
	 * @see org.openxava.actions.IAction#execute()
	 */
	@Override
	public void execute() throws Exception {
		loadLastNode();
		addMessage("my_chart_reset");
	}

}