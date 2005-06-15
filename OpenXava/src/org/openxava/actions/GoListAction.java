package org.openxava.actions;

import java.util.*;

import org.openxava.tab.*;
import org.openxava.view.*;


/**
 * @author Javier Paniza
 */

public class GoListAction extends BaseAction implements IChangeModeAction, INavigationAction {
		
	private View view;
	private Tab tab;
	private Tab mainTab;
	private Stack previousViews;
		
	public String getNextMode() {		
		return IChangeModeAction.LIST;
	}

	public void execute() throws Exception {
		restoreMainView();
		if (getView() != null) getView().clear();
		if (getMainTab() != null && getTab() != null) {
			getMainTab().setRequest(getTab().getRequest());
		}
		setTab(getMainTab());
		if (getTab() != null) getTab().deselectAll();
	}
	
	
	private void restoreMainView() {
		View mainView = null;
		while (previousViews != null && !previousViews.isEmpty()) {
			mainView = (View) previousViews.pop();
		}
		if (mainView != null) setView(mainView);
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {		
		this.view = view;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}

	public String[] getNextControllers() {		
		return DEFAULT_CONTROLLERS;
	}

	public String getCustomView() {		
		return DEFAULT_VIEW;
	}

	public Tab getMainTab() {
		return mainTab;
	}
	public void setMainTab(Tab maintTab) {
		this.mainTab = maintTab;
	}
	public Stack getPreviousViews() {
		return previousViews;
	}
	public void setPreviousViews(Stack previousViews) {
		this.previousViews = previousViews;
	}
}
