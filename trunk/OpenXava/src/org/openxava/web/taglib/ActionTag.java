package org.openxava.web.taglib;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import org.openxava.controller.meta.*;
import org.openxava.util.*;


/**
 * @author Javier Paniza
 */

public class ActionTag extends TagSupport {
	
	private IActionTag actionTag;
	private String action;
	private String argv;
	

	public int doStartTag() throws JspException {
		try {
			MetaAction metaAccion = MetaControllers.getMetaAction(getAction());
			actionTag = metaAccion.hasImage()?(IActionTag)new ImageTag():(IActionTag)new LinkTag();
			actionTag.setPageContext(pageContext);
			actionTag.setAction(action);
			actionTag.setArgv(argv);
			return actionTag.doStartTag();			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new JspException(XavaResources.getString("action_tag_error", getAction()));
		}		
	}

	public int doAfterBody() throws JspException {
		return actionTag.doAfterBody();					
	}

	public int doEndTag() throws JspException {
		return actionTag.doEndTag();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String string) {
		action = string;
	}

	public String getArgv() {
		return argv;
	}

	public void setArgv(String string) {
		argv = string;
	}

}