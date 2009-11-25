package org.openxava.controller;

import java.util.*;

import javax.persistence.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.logging.*;
import org.hibernate.validator.*;

import org.openxava.actions.*;
import org.openxava.application.meta.*;
import org.openxava.controller.meta.*;
import org.openxava.hibernate.*;
import org.openxava.jpa.*;
import org.openxava.util.*;
import org.openxava.validators.*;
import org.openxava.view.*;
import org.openxava.web.*;

/**
 * @author Javier Paniza
 */

public class ModuleManager {
	
	private static Log log = LogFactory.getLog(ModuleManager.class);
	
	static {		
		MetaControllers.setContext(MetaControllers.WEB);		
		XSystem._setLogLevelFromJavaLoggingLevelOfXavaPreferences();
		log.info("OpenXava 4m1 (2009-11-25)");		
	}
	
	private static String DEFAULT_MODE = IChangeModeAction.LIST;	
		
	private String user; 
	private Collection metaActionsOnInit;
	private Collection metaActionsOnEachRequest;
	private Collection metaActionsBeforeEachRequest; 
	private boolean moduleInitiated;	
	private String defaultActionQualifiedName;
	private MetaModule metaModule;
	private String[] controllersNames;
	private Collection metaActions;
	private String applicationName;
	private String moduleName;
	private Set hiddenActions;	
	private String modeControllerName = "Mode";
	private Collection metaControllers;
	private MetaController metaControllerMode;
	private HttpSession session;
	private String viewName = null;
	private String modeName;	
	private String nextModule;
	private Stack<String> previousModules;	
	private String defaultView = null;
	private boolean formUpload = false;
	private String previousMode;
	private boolean executingAction = false;
	private boolean reloadAllUINeeded;  
	private boolean reloadViewNeeded; 
	private boolean actionsChanged;
	private boolean showDialog; 
	private boolean hideDialog;  
	private MetaAction lastExecutedMetaAction;
	private int dialogLevel = 0;  

	
		
	/**
	 * HTML action bind to the current form.
	 * @return
	 */
	public String getFormAction(HttpServletRequest request) {		
		if (!isFormUpload()) return "";
		String module = !getPreviousModules().isEmpty() ? previousModules.elementAt(0) : getModuleName();
		Object portletActionURL = request.getSession().getAttribute(Ids.decorate(getApplicationName(), module, "xava.portlet.uploadActionURL"));
		if (portletActionURL == null) return "";
		return "action='" +  portletActionURL + "'";
	}

	public Collection getMetaActions() {
		if (metaActions == null) {
			try {			
				Iterator it = getMetaControllers().iterator();
				metaActions = new ArrayList();
				while (it.hasNext()) {
					MetaController contr = (MetaController) it.next();					
					metaActions.addAll(contr.getMetaActionsForMode(getModeName()));									
				} 										
				removeHiddenActions();
			}
			catch (Exception ex) {
				log.error(XavaResources.getString("controller_actions_error"),ex);
				return new ArrayList();
			}			
		}		
		return metaActions;		
	}
	
	public Collection getMetaActionsOnInit() {
		if (metaActionsOnInit == null) {
			try {			
				Iterator it = getMetaControllers().iterator();
				metaActionsOnInit = new ArrayList();
				while (it.hasNext()) {
					MetaController contr = (MetaController) it.next();
					metaActionsOnInit.addAll(contr.getMetaActionsOnInit());									
				} 										
			}
			catch (Exception ex) {
				log.error(XavaResources.getString("controller_init_action_error"),ex);
				return Collections.EMPTY_LIST;
			}	
		}
		return metaActionsOnInit;		
	}
	
	
	public Collection getMetaActionsMode() {
		try {			
			return getMetaControllerMode().getMetaActions();						
		}
		catch (Exception ex) {
			log.error(XavaResources.getString("controllers_actions_error", getModeControllerName()),ex);
			return new ArrayList();
		}			
	}
	
	/**
	 * An iterator over <code>getMetaActions()</code> and <code>getMetaActionsMode()</code>. <p>
	 */
	public Iterator getAllMetaActionsIterator() {
		return org.apache.commons.collections.IteratorUtils.chainedIterator(
				new Iterator[] {
					getMetaActions().iterator(), 
					getMetaActionsMode().iterator()
				}
		);				
	}
	
	private MetaController getMetaControllerMode() throws XavaException {
		if (metaControllerMode == null) {
			metaControllerMode = MetaControllers.getMetaController(getModeControllerName());
		}
		return metaControllerMode;
	}
	
	
	private Collection getMetaControllers() throws XavaException {
		if (metaControllers == null) {
			metaControllers = new ArrayList();
			String [] names = getControllersNames();		
			for (int i = 0; i < names.length; i++) {
				metaControllers.add(MetaControllers.getMetaController(names[i]));				
			}						
		}
		return metaControllers;
	}

	private void setupModuleControllers() throws XavaException {					
		Collection controllers = getMetaModule().getControllersNames();
		String [] names = new String[controllers.size()];
		controllers.toArray(names);		
		setControllersNames(names);			
	}
		
	private String getModeControllerName() {		
		return modeControllerName;
	}
	
	private void setModeControllerName(String controllerName) {
		metaControllerMode = null;
		this.modeControllerName = controllerName;
	}
	
	public boolean hasProcessRequest(HttpServletRequest request) {
		return isFormUpload() || // May be that in this way upload forms does not work well in multimodule 			 
			actionOfThisModule(request);				
	}

	private boolean actionOfThisModule(HttpServletRequest request) {
		return Is.equal(request.getParameter("xava_action_module"),getModuleName()) &&
			Is.equal(request.getParameter("xava_action_application"),getApplicationName());
	}
		
	public void execute(HttpServletRequest request, Messages errors, Messages messages) {
		try {						
			if (errors.isEmpty()) { // Only it's executed the action if there aren't errors
				if (isFormUpload()) {
					parseMultipartRequest(request);
				}				
				String xavaAction = getParameter(request, "xava_action");
				if (!Is.emptyString(xavaAction)) {
					String actionValue = request.getParameter("xava_action_argv");
					if ("undefined".equals(actionValue)) actionValue = null;
					String range = request.getParameter("xava_action_range");
					if ("undefined".equals(range)) range = null;
					String alreadyProcessed = request.getParameter("xava_action_already_processed");
					if ("undefined".equals(alreadyProcessed) || alreadyProcessed == null) alreadyProcessed = "";
					
					// range
					int first = Is.empty(range) ? 0 : Integer.parseInt(range.substring(0, range.indexOf("_")));
					int last = Is.empty(range) ? 0 : Integer.parseInt(range.substring(range.indexOf("_") + 1));
					//
					for (int i = first; i <= last; i++){
						if (!alreadyProcessed.contains("_" + i + "_")){
							String av = Is.empty(range) ? actionValue : actionValue + ",row=" + i;
							MetaAction a = MetaControllers.getMetaAction(xavaAction);
							long ini = System.currentTimeMillis();
							executeAction(a, errors, messages, av, request);
							long time = System.currentTimeMillis() - ini;
							log.debug("Execute " + xavaAction + "=" + time + " ms");	
						}
					}					
				}				
			}			
		}
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			errors.add("no_execute_action");
		}
	}
	
	private String getParameter(HttpServletRequest request, String parameter) throws FileUploadException {		
		if (isFormUpload()) {
			List items = (List) request.getAttribute("xava.upload.fileitems");
			for (Iterator it = items.iterator(); it.hasNext(); ) {
				FileItem item = (FileItem) it.next();								
				if (parameter.equals(Ids.undecorate(item.getFieldName()))) return item.getString();
			}	
			return null;    
		}
		else { 
			return request.getParameter(parameter);
		}
	}

	private void executeAction(MetaAction metaAction, Messages errors, Messages message, HttpServletRequest request) {
		executeAction(metaAction, errors, message, null, request);
	}
	
	private void executeAction(MetaAction metaAction, Messages errors, Messages message, String propertyValues, HttpServletRequest request) {
		executingAction = true; 
		try {
			IAction action = metaAction.createAction();
			executeAction(action, metaAction, errors, message, propertyValues, request);
		}
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			errors.add("no_execute_action", metaAction.getId());			
		}						
		finally {
			executingAction = false; 
		}
	}
	
	public void executeAction(IAction action, Messages errors, Messages messages, HttpServletRequest request) {
		executeAction(action, null, errors, messages, null, request);
	}

	private void executeAction(IAction action, MetaAction metaAction, Messages errors, Messages messages, String propertyValues, HttpServletRequest request) {
		int originalDialogLevel = dialogLevel;		
		try {			
			Object previousView = getContext().get(applicationName, moduleName, "xava_view");  
			action.setErrors(errors);
			action.setMessages(messages);
			action.setEnvironment(getEnvironment());
			String previousDefaultActionQualifiedName = getDefaultActionQualifiedName();  
			if (metaAction != null) {
				setObjectsInAction(action, metaAction);
			}
			Map xavaValues = setPropertyValues(action, propertyValues);
			if (action instanceof IModuleContextAction) {
				((IModuleContextAction) action).setContext(getContext());
			}						
			if (action instanceof IModelAction) {
				((IModelAction) action).setModel(getModelName());
			}
			if (action instanceof IRequestAction) {
				((IRequestAction) action).setRequest(request);
			}
			
			if (action instanceof IJDBCAction) {
				((IJDBCAction) action).setConnectionProvider(DataSourceConnectionProvider.getByComponent(getModelName()));
			}		
			
			if (action instanceof IPropertyAction) {
				String keyProperty = Ids.undecorate((String) xavaValues.get("xava.keyProperty")); 
				if (Is.emptyString(keyProperty)) {
					throw new XavaException("property_action_error", action.getClass()); 
				}								
				int idx = keyProperty.lastIndexOf('.');
				View view = (View) getContext().get(request, "xava_view");
				if (idx < 0) { 
					((IPropertyAction) action).setProperty(keyProperty);
					((IPropertyAction) action).setView(view);
				}
				else {
					String subviewName =  keyProperty.substring(0, idx);
					String propertyName = keyProperty.substring(idx + 1);
					((IPropertyAction) action).setProperty(propertyName); 					
					((IPropertyAction) action).setView(getSubview(view, subviewName));
				}
			}			
			
			if (action instanceof IProcessLoadedFileAction) {
				List fileItems = (List) request.getAttribute("xava.upload.fileitems");
				String error = (String) request.getAttribute("xava.upload.error");
				if (!Is.emptyString(error))	errors.add(error);
				((IProcessLoadedFileAction) action).setFileItems(fileItems==null?Collections.EMPTY_LIST:fileItems);
			}
						
			if (action instanceof IRemoteAction) {
				IRemoteAction remote = (IRemoteAction) action;
				remote.executeBefore();					
				if (remote.isExecuteOnServer()) {
					remote = Server.execute(remote, remote.getPackageName());
					errors.removeAll();
					messages.removeAll();
					errors.add(remote.getErrors());
					messages.add(remote.getMessages());
					remote.setErrors(errors);
					remote.setMessages(messages);	
				}								
				remote.executeAfter();
				action = remote;
			}
			else {
				action.execute();				
			}
			if (action instanceof IChangeModeAction) {
				IChangeModeAction modeChange = (IChangeModeAction) action;
				String nextMode = modeChange.getNextMode();
				if (IChangeModeAction.PREVIOUS_MODE.equals(nextMode)) { 
					restorePreviousMode();															
				}													
				else if (!Is.emptyString(nextMode)) {
					memorizePreviousMode(); 
					setModeName(nextMode);					
				}								
			}
			setFormUpload(false);						
			if (action instanceof ICustomViewAction) {
				ICustomViewAction customViewAction = (ICustomViewAction) action;
				String newView = customViewAction.getCustomView();
				if (ICustomViewAction.PREVIOUS_VIEW.equals(newView)) {
					restorePreviousCustomView();
					reloadViewNeeded = true; 
				}													
				else if (!Is.emptyString(newView)) {
					memorizeCustomView(); 
					setViewName(newView);		
					reloadViewNeeded = true; 
				} 
			}
			if (action instanceof IChangeControllersAction) {
				IChangeControllersAction changeControllersAction = (IChangeControllersAction) action;
				String [] nextControllers = changeControllersAction.getNextControllers();				
				if (nextControllers != IChangeControllersAction.SAME_CONTROLLERS) {
					if (nextControllers == IChangeControllersAction.DEFAULT_CONTROLLERS) {
						setupModuleControllers();															
					}
					else if (nextControllers == IChangeControllersAction.PREVIOUS_CONTROLLERS) {
						restorePreviousControllers();															
					}													
					else {
						memorizeControllers();										
						setControllersNames(nextControllers);
						executeInitAction(request, errors, messages);
					}
					actionsChanged = true; 
				}
			}			
			if (action instanceof IHideActionAction) {
				String actionToHide = ((IHideActionAction) action).getActionToHide();
				if (actionToHide != null) {
					addToHiddenActions(actionToHide);
				}
				actionsChanged = true;
			}
			if (action instanceof IHideActionsAction) {
				String [] actionsToHide = ((IHideActionsAction) action).getActionsToHide();
				if (actionsToHide != null) {
					for (int i = 0; i < actionsToHide.length; i++) {
						if (actionsToHide[i] != null) {
							addToHiddenActions(actionsToHide[i]);
						}
					}					
				}
				actionsChanged = true;
			}
			if (action instanceof IShowActionAction) {
				String actionToShow = ((IShowActionAction) action).getActionToShow();
				if (actionToShow != null) {
					removeFromHiddenActions(actionToShow);
				}
				actionsChanged = true;
			}
			if (action instanceof IShowActionsAction) {
				String [] actionsToShow = ((IShowActionsAction) action).getActionsToShow();
				if (actionsToShow != null) {
					for (int i = 0; i < actionsToShow.length; i++) {
						if (actionsToShow[i] != null) {
							removeFromHiddenActions(actionsToShow[i]);
						}
					}					
				}
				actionsChanged = true;
			}						
			if (action instanceof ILoadFileAction) {					
				setFormUpload(((ILoadFileAction) action).isLoadFile());
			}			
			if (metaAction != null) {
				getObjectFromAction(action, metaAction);
			}
			if (action instanceof IForwardAction) {				
				IForwardAction forward = (IForwardAction) action;
				String uri = forward.getForwardURI();
				if (!Is.emptyString(uri)) {
					request.getSession().setAttribute("xava_forward", uri);
					request.getSession().setAttribute("xava_forward_inNewWindow", String.valueOf(forward.inNewWindow()));					
				}				
			}
			nextModule = null;			
			if (action instanceof IChangeModuleAction) {				
				IChangeModuleAction moduleChange = (IChangeModuleAction) action;
				nextModule = moduleChange.getNextModule();				
				if (!Is.emptyString(nextModule)) {					
					if (moduleChange.hasReinitNextModule()) {						
						getContext().put(getApplicationName(), nextModule, "manager", null);
					}
					request.setAttribute("xava.sendParametersToTab", "false");
				}
			}		
			if (action instanceof IChainAction) {
				IChainAction chainable = (IChainAction) action;				
				String nextAction = chainable.getNextAction();				
				if (!Is.emptyString(nextAction)) {
					MetaAction nextMetaAction = null;
					if (nextAction.indexOf('.') < 0 && metaAction != null) {
						nextMetaAction = metaAction.getMetaController().getMetaAction(nextAction);
					}
					else {
						nextMetaAction = MetaControllers.getMetaAction(nextAction);
					}
					String argv = null;
					if (chainable instanceof IChainActionWithArgv) {
						argv = ((IChainActionWithArgv) chainable).getNextActionArgv();
					}					
					executeAction(nextMetaAction, action.getErrors(), action.getMessages(), argv, request); 
				}
			}
			if (metaAction != null && errors.isEmpty()) {
				setShowDialog(metaAction.isShowDialog());
				if (metaAction.isShowDialog()) {					
					dialogLevel++;  
				}
				if (metaAction.isHideDialog() != null) {
					setHideDialog(metaAction.isHideDialog());
					if (metaAction.isHideDialog()) {						
						dialogLevel--;
					}
				}
				else {
					if (metaAction.getQualifiedName().equals(previousDefaultActionQualifiedName) ||
						"cancel".equals(metaAction.getName()) || "cancelar".equals(metaAction.getName())) 
					{
						setHideDialog(true);						
						dialogLevel--; 
					}
				}
				if (dialogLevel < 0) dialogLevel = 0; 
			}
			if (!reloadViewNeeded) {
				Object currentView = getContext().get(applicationName, moduleName, "xava_view"); 
				reloadViewNeeded = currentView != previousView;
			}
			lastExecutedMetaAction = metaAction;
			if (!(metaAction == null && executingAction)) { // For avoiding commit on OnChange actions triggered from a regular action execution
				doCommit(); // after executing action
			}			
		}
		catch (Exception ex) {
			setHideDialog(false);
			dialogLevel = originalDialogLevel; 
			manageException(metaAction, errors, messages, ex);
		}				
	}
	
	private void manageException(MetaAction metaAction, Messages errors, Messages messages, Exception ex) {
		if (ex instanceof ValidationException) {		
			errors.add(((ValidationException)ex).getErrors());
			messages.removeAll();
			doRollback();			
		}
		else if (ex instanceof RollbackException) {
			if (ex.getCause() instanceof InvalidStateException) {
				manageInvalidStateException(metaAction, errors, messages, (InvalidStateException) ex.getCause());				
			}
			else {
				manageRegularException(metaAction, errors, messages, ex);
			}
			doRollback();
		}
		else if (ex instanceof InvalidStateException) {			
			manageInvalidStateException(metaAction, errors, messages, (InvalidStateException) ex);				
			doRollback();
		}				
		else {			
			manageRegularException(metaAction, errors, messages, ex);
			doRollback();			
		}						
	}
	
	private void manageInvalidStateException(MetaAction metaAction, Messages errors, Messages messages, InvalidStateException ex) {
		InvalidValue [] invalidValues = ex.getInvalidValues();
		for (int i=0; i<invalidValues.length; i++) {
			errors.add("invalid_state", 
					invalidValues[i].getPropertyName(), 
					Classes.getSimpleName(invalidValues[i].getBeanClass()), 
					invalidValues[i].getMessage(), 
					invalidValues[i].getValue());			
		}
		messages.removeAll();		
	}
	

	private void manageRegularException(MetaAction metaAction, Messages errors, Messages messages, Exception ex) {
		log.error(ex.getMessage(), ex);
		if (metaAction != null) {
			errors.add("no_execute_action", metaAction.getId(), "'" + ex.getLocalizedMessage() + "'"); 
		}
		else {
			errors.add("no_execute_action", "", "'" + ex.getLocalizedMessage() + "'"); 
		}
		messages.removeAll();
	}
	
	private void memorizePreviousMode() {
		// At the moment we only memorize the last one 
		previousMode = modeName==null?DEFAULT_MODE:modeName; 		
	}

	private void restorePreviousMode() {
		// At the moment we only have memorized the last one
		if (previousMode != null) setModeName(previousMode);				
	}

	private View getSubview(View view, String memberName) throws XavaException {
		memberName = Ids.undecorate(memberName); 
		if (memberName.indexOf('.') < 0) {
			return view.getSubview(memberName); 
		}
		StringTokenizer st = new StringTokenizer(memberName, ".");
		String subviewName = st.nextToken();
		String nextMember = st.nextToken(); 
		return getSubview(view.getSubview(subviewName), nextMember);
	}
	
	/**
	 * Init JPA and Hibernate in order to process the current request.
	 */
	public void resetPersistence() {
		org.openxava.hibernate.XHibernate.setCmt(false); 
		org.openxava.jpa.XPersistence.reset();
		org.openxava.hibernate.XHibernate.reset(); 
	}
	
	/**
	 * Commit the current JPA manager and Hibernate session, if they exist. <p>
	 * 
	 * @return <code>true</code> if commit is successful
	 */
	public void commit() { // Usually after render page
		try {			
			doCommit();			
		}
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			doRollback();
		}
	}
	
	private void doCommit() {
		XPersistence.commit();
		XHibernate.commit();		
	}
	
	void doRollback() {
		XPersistence.rollback(); 
		XHibernate.rollback();		
	}		

	public void parseMultipartRequest(HttpServletRequest request) throws FileUploadException { 
		List fileItems = (List) request.getAttribute("xava.upload.fileitems");		
		if (fileItems != null) return;		
		DiskFileItemFactory factory = new DiskFileItemFactory();		
		factory.setSizeThreshold(1000000);				
		ServletFileUpload upload = new ServletFileUpload(factory);		
		request.setAttribute("xava.upload.fileitems", upload.parseRequest(request));		
	}

	public Environment getEnvironment() throws XavaException {		
		return getMetaModule().getEnvironment();
	}

	private void setControllersNames(String [] names) {		
		metaControllers = null;
		metaActions = null;
		metaActionsOnInit = null;
		defaultActionQualifiedName = null;
		this.controllersNames = names;
	}
	
	private void restorePreviousControllers() throws XavaException {
		Stack previousControllers = (Stack) getObjectFromContext("xava_previousControllers");
		if (previousControllers.isEmpty()) {
			setupModuleControllers();
			return;						
		}
		
		String [] controllers = (String []) previousControllers.pop();
		setControllersNames(controllers);		
	}
	
	private void restorePreviousCustomView() throws XavaException { 
		Stack previousCustomViews = (Stack) getObjectFromContext("xava_previousCustomViews");	
		if (previousCustomViews.isEmpty()) {			
			setViewName(ICustomViewAction.DEFAULT_VIEW);
			return;						
		}		
		String view = (String) previousCustomViews.pop();		
		setViewName(view);		
	}
		
	private void memorizeControllers() throws XavaException {
		Stack previousControllers = (Stack) getObjectFromContext("xava_previousControllers");		
		previousControllers.push(this.controllersNames);
	}
	
	private void memorizeCustomView() throws XavaException { 
		Stack previousCustomViews = (Stack) getObjectFromContext("xava_previousCustomViews");	
		previousCustomViews.push(this.viewName);		
	}	

	/**
	 * Returs all propeties with the 'xava.' prefix, these properties are not assigned
	 * to the action and they will be used internally ModuleManager.
	 */
	private Map setPropertyValues(IAction action, String propertyValues) throws Exception { 
		if (Is.emptyString(propertyValues)) return Collections.EMPTY_MAP;
		StringTokenizer st = new StringTokenizer(propertyValues, ",");
		Map values = new HashMap();
		Map xavaValues = null;
		while (st.hasMoreTokens()) {
			String propertyValue = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(propertyValue, "()=");
			if (!st2.hasMoreTokens()) {
				log.warn(XavaResources.getString("action_property_warning"));
				break;
			}
			String name = st2.nextToken().trim();
			if (!st2.hasMoreTokens()) {
				log.warn(XavaResources.getString("action_property_warning"));
				break;
			}
			String value = st2.nextToken().trim();
			if (!name.startsWith("xava.")) { 
				values.put(name, value);		
			}
			else { 
				if (xavaValues == null) xavaValues = new HashMap();
				xavaValues.put(name, value);
			}
		}		
		PropertiesManager mp = new PropertiesManager(action);
		mp.executeSetsFromStrings(values);
		return xavaValues == null?Collections.EMPTY_MAP:xavaValues; 
	}

	private void getObjectFromAction(IAction action, MetaAction metaAction) throws XavaException {
		if (!metaAction.usesObjects()) return;
		PropertiesManager mp = new PropertiesManager(action);
		Iterator it = metaAction.getMetaUseObjects().iterator();
		while (it.hasNext()) {
			MetaUseObject metaUseObject = (MetaUseObject) it.next();
			String property = metaUseObject.getActionProperty();
			Object value = null;
			try {
				value = mp.executeGet(property);
			}
			catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new XavaException("get_property_action_value_error", property, metaAction.getName());
			}
			if (value != null) {
				// The nulls are not assigned 
				// los nulos no los asignamos and thus we allow to have trasient attributes
				// that it can lost on go and return from server without danger of alter
				// the session value 				
				setObjectInContext(metaUseObject.getName(), value);
			}
		}
	}

	private void setObjectsInAction(IAction action, MetaAction metaAction) throws XavaException {
		if (!metaAction.usesObjects()) return;
		PropertiesManager mp = new PropertiesManager(action);
		Iterator it = metaAction.getMetaUseObjects().iterator();
		while (it.hasNext()) {
			MetaUseObject metaUseObject = (MetaUseObject) it.next();
			String objectName = metaUseObject.getName();			 
			String property = metaUseObject.getActionProperty();			
			Object value = getObjectFromContext(objectName);			
			if (value == null) {				
				value = createObject(objectName);
				setObjectInContext(objectName, value);
			}
			
			try {
				mp.executeSet(property, value);
			}
			catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new XavaException("set_property_action_value_error", property, metaAction.getName());
			}
			getSession().setAttribute(objectName, value);
		}		
	}
		
	private Object getObjectFromContext(String objectName) throws XavaException {
		return getContext().get(getApplicationName(), getModuleName(), objectName);				
	}
	
	private void setObjectInContext(String objectName, Object value) throws XavaException {
		getContext().put(getApplicationName(), getModuleName(), objectName, value);				
	}
	
	private ModuleContext getContext() {
		return (ModuleContext) getSession().getAttribute("context");		
	}

	private Object createObject(String objectName) throws XavaException {		
		MetaObject metaObject =	MetaControllers.getMetaObject(objectName);
		return metaObject.createObject();		
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getViewURL() {
		String viewName = getViewName();
		String r = null;
		if (viewName.startsWith("xava/")) r = viewName.substring(5);
		else r = "../" + viewName;
		if (r.toLowerCase().indexOf(".jsp") < 0) r = r + ".jsp";				
		return r;	
	}

	private String getViewName() {
		if (IChangeModeAction.LIST.equals(getModeName())) {
			return "xava/list";
		}		
		if (viewName == null) {			
			viewName = "xava/detail"; 
		}		
		return viewName;		
	}

	private void setViewName(String newView) throws XavaException {
		if (ICustomViewAction.DEFAULT_VIEW.equals(newView)) {					
			viewName = defaultView;
		}
		else {		
			viewName = newView;
		}						
	}
	
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String newName) throws XavaException {
		if (Is.equal(applicationName, newName)) return;
		applicationName = newName;
		moduleName = null;
		controllersNames = null;
		reset();
	}

	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @return <tt>true</tt> if is new. 
	 */
	public void setModuleName(String newModule) throws XavaException {		
		if (Is.equal(moduleName, newModule)) return; 
		moduleName = newModule;
		metaControllerMode = null;
		reset();
		setupModuleControllers();
		if (!Is.emptyString(getMetaModule().getModeControllerName())) {
			setModeControllerName(getMetaModule().getModeControllerName());
			modeName = null;						
		}
		if (!Is.emptyString(getMetaModule().getWebViewURL())) {
			defaultView = getMetaModule().getWebViewURL();
			setViewName(defaultView);			
		}		
		View view = (View) getContext().get(applicationName, moduleName, "xava_view");
		view.setModelName(getModelName());	
		view.setViewName(getXavaViewName());
	}
	
	private String [] getControllersNames() {		
		return controllersNames==null?new String[0]:controllersNames;
	}
	
	private MetaModule getMetaModule() throws ElementNotFoundException, XavaException {
		if (metaModule == null) {
			if (Is.emptyString(applicationName, moduleName)) {
				throw new XavaException("application_and_module_required");
			}
			metaModule = MetaApplications.getMetaApplication(applicationName).getMetaModule(moduleName);
			
		}
		return metaModule;
	}
	
	public String getModuleDescription() {
		try {
			return getMetaModule().getMetaApplication().getLabel() + " - " +  
				getMetaModule().getDescription();
		}
		catch (Exception ex) {
			return XavaResources.getString("unknow_module");
		}
	}
	
	public String getModelName() throws XavaException {
		return getMetaModule().getModelName();
	}
	
	public String getTabName() throws XavaException {
		return getMetaModule().getTabName();
	} 

	public boolean isListMode() {
		return IChangeModeAction.LIST.equals(getModeName());
	}
	
	public String getModeName() {
		return modeName==null?DEFAULT_MODE:modeName;
	}

	private void setModeName(String newModelName) {		
		if (Is.equal(modeName, newModelName)) return;
		reloadAllUINeeded = true;
		modeName = newModelName;		
		metaActions = null;
		defaultActionQualifiedName = null;
	}

	public String getDefaultActionQualifiedName() {
		if (defaultActionQualifiedName == null) {
			Iterator it = getMetaActions().iterator();
			int max = -1;
			while (it.hasNext()) {
				MetaAction a = (MetaAction) it.next();
				if (a.getByDefault() > max) {
					max = a.getByDefault();					
					defaultActionQualifiedName = a.getQualifiedName();					
				}
			}			
		}		
		return defaultActionQualifiedName;
	}
	
	public boolean isXavaView() throws XavaException{
		// For that a upload form does not delete the view data.
		// It's a ad hoc solution. It can be improved 
		if (isFormUpload()) return false; 							
		return "xava/detail".equals(getViewName()) ||
				(getViewName().equals(defaultView)); // Because a custom JSP page can use xava_view too
	}

	public String getXavaViewName() throws XavaException {
		return getMetaModule().getViewName();		
	}
	
	/*
	 * to execute.jsp, init 'actionsChanged' after execute 'assignValuesToWebView' and 'initModule'
	 */
	public void preInitModule() {
		actionsChanged = false;
	}
	
	public void initModule(HttpServletRequest request, Messages errors, Messages messages) {		
		if (!Is.equal(Users.getCurrent(), user)) {
			user = Users.getCurrent();
			moduleInitiated = false;			
		}
		if (!moduleInitiated) {
			modeName = getMetaActionsMode().isEmpty()?IChangeModeAction.DETAIL:null;
			moduleInitiated = true;
			executeInitAction(request, errors, messages);
			reloadAllUINeeded = true;
		}	
		else {
			reloadAllUINeeded = false;
		}
		showDialog = dialogLevel > 0 && !hasProcessRequest(request)?true:false; // When a dialog is shown and the user click in refresh in browser we'll re-open the dialog
		hideDialog = false;
		reloadViewNeeded = false;		
	}
	
	public void executeBeforeEachRequestActions(HttpServletRequest request, Messages errors, Messages messages) {
		if (!Is.emptyString(getNextModule())) return; // Another module is executing now
		boolean formUpload = isFormUpload(); 
		Iterator it = getMetaActionsBeforeEachRequest().iterator();
		while (it.hasNext()) {
			MetaAction a = (MetaAction) it.next();
			if (Is.emptyString(a.getMode()) || a.getMode().equals(getModeName())) { 
				executeAction(a, errors, messages, request); 
			}
		}
		setFormUpload(formUpload); 
	}
	
	private void executeInitAction(HttpServletRequest request, Messages errors, Messages messages) {
		if (!Is.emptyString(getNextModule())) return; // Another module is executing now
		Iterator it = getMetaActionsOnInit().iterator();
		while (it.hasNext()) {
			MetaAction a = (MetaAction) it.next();			
			executeAction(a, errors, messages, request); 
		}		
	}
	
	public void executeOnEachRequestActions(HttpServletRequest request, Messages errors, Messages messages) {
		if (!Is.emptyString(getNextModule())) return; // Another module is executing now
		boolean formUpload = isFormUpload(); 
		Iterator it = getMetaActionsOnEachRequest().iterator();
		while (it.hasNext()) {
			MetaAction a = (MetaAction) it.next();			
			if (Is.emptyString(a.getMode()) || a.getMode().equals(getModeName())) { 
				executeAction(a, errors, messages, request);
			}
		}	
		setFormUpload(formUpload); 
	}
	
	private Collection getMetaActionsOnEachRequest() {		
		if (metaActionsOnEachRequest == null) {
			try {			
				Iterator it = getMetaControllers().iterator();
				metaActionsOnEachRequest = new ArrayList();
				while (it.hasNext()) {
					MetaController contr = (MetaController) it.next();		
					metaActionsOnEachRequest.addAll(contr.getMetaActionsOnEachRequest());
				} 										
			}
			catch (Exception ex) {
				log.error(XavaResources.getString("controller_on_each_request_action_error"), ex);
				return Collections.EMPTY_LIST; 
			}	
		}
		return metaActionsOnEachRequest;		
	}
	
	private Collection getMetaActionsBeforeEachRequest() {
		if (metaActionsBeforeEachRequest == null) {
			try {			
				Iterator it = getMetaControllers().iterator();
				metaActionsBeforeEachRequest = new ArrayList();
				while (it.hasNext()) {
					MetaController contr = (MetaController) it.next();						
					metaActionsBeforeEachRequest.addAll(contr.getMetaActionsBeforeEachRequest());
				} 										
			}
			catch (Exception ex) {
				log.error(XavaResources.getString("controller_before_each_request_action_error"), ex); 
				return Collections.EMPTY_LIST; 
			}	
		}
		return metaActionsBeforeEachRequest;		
	}	
	
	public String getEnctype() { 		
		return isFormUpload()?"ENCTYPE='multipart/form-data'":"";		
	}
	
	public boolean isButtonBarVisible() {
		if (!getMetaActionsMode().isEmpty()) return true;	
		Iterator it = getMetaActions().iterator();
		while (it.hasNext()) {
			MetaAction action = (MetaAction) it.next();
			if (!action.isHidden() && action.hasImage()) return true;
		}
		return false;
	}
	
	public boolean isFormUpload() {  
		return formUpload;
	}	

	private void setFormUpload(boolean b) { 		
		formUpload = b;
	}

	public String getNextModule() {		
		return nextModule;
	}
	public void setNextModule(String nextModule) {
		this.nextModule = nextModule;
	}
	
	private void addToHiddenActions(String action) {
		if (hiddenActions == null) hiddenActions = new HashSet();
		hiddenActions.add(action);		
		metaActions = null;
	}
	
	private void removeFromHiddenActions(String action) {
		if (hiddenActions == null) return;
		hiddenActions.remove(action);	
		metaActions = null;		
	}
	
	private void removeHiddenActions() {
		if (hiddenActions == null) return;		
		for (Iterator it = metaActions.iterator(); it.hasNext(); ) {
			MetaAction action = (MetaAction) it.next();
			if (hiddenActions.contains(action.getQualifiedName())) {
				it.remove();
			}
		}
	}

	public boolean isReloadAllUINeeded() {
		return reloadAllUINeeded;
	}
		
	/**
	 * Is actions list change since the last action execution ?. <p>
	 */
	public boolean isActionsChanged() {
		return actionsChanged;
	}

	public boolean isReloadViewNeeded() {
		return reloadViewNeeded || isListMode() || !"xava/detail".equals(getViewName());
	}
	
	public Stack<String> getPreviousModules() { 
		if (previousModules == null) previousModules = new Stack<String>();
		return previousModules;
	}

	public void setPreviousModules(Stack<String> previousModules) {
		this.previousModules = previousModules;
	}
	
	public void reset() {
		moduleInitiated = false;
		metaControllers = null;
		metaActions = null;
		defaultActionQualifiedName = null;
		metaModule = null;
		DescriptionsLists.resetDescriptionsCache(getSession());
	}
	
	public boolean isShowDialog() {
		return showDialog;
	}

	private void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public boolean isHideDialog() {
		return hideDialog;
	}

	private void setHideDialog(boolean hideDialog) { 
		if (dialogLevel > 0 && hideDialog) reloadAllUINeeded = true; 
		this.hideDialog = dialogLevel > 0 && hideDialog;
	}
	
	public MetaAction getLastExecutedMetaAction() {
		return lastExecutedMetaAction;
	}

	public int getDialogLevel() { 
		return dialogLevel;
	}
			
}
