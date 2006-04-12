package org.openxava.model.impl;

import java.lang.reflect.*;
import java.rmi.*;
import java.util.*;

import javax.ejb.*;

import org.openxava.calculators.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.util.*;
import org.openxava.util.meta.*;
import org.openxava.validators.*;
import org.openxava.validators.meta.*;


/**
 * Implement the logic of MapFacade. <p>
 * 
 * @author Javier Paniza
 */

// tmp: Quitar IMetaEjb (si hay)
// tmp: Quitar EJBException

public class MapFacadeBean implements IMapFacadeImpl, SessionBean {
	
	
	private javax.ejb.SessionContext sessionContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	
	public Object create(String user, String modelName, Map values)
		throws CreateException, XavaException, ValidationException, RemoteException {		
		Users.setCurrent(user);
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {
			MetaModel metaModel = getMetaModel(modelName);					
			Object result = create(persistenceProvider, metaModel, values, null, null, 0);
			persistenceProvider.commit();
			return result;
		} 
		catch (CreateException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public Map getValues(
			String user, 
			String modelName,
			Map keyValues,
			Map membersNames)
			throws FinderException, XavaException, RemoteException {		
		Users.setCurrent(user);
		keyValues = Maps.recursiveClone(keyValues); 
		membersNames = Maps.recursiveClone(membersNames); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {			
			Map result = getValuesImpl(persistenceProvider, modelName, keyValues, membersNames);
			persistenceProvider.commit();
			return result;
		} 
		catch (FinderException ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public void delete(String user, String modelName, Map keyValues)
		throws RemoveException, ValidationException, XavaException, RemoteException 
	{		
		Users.setCurrent(user);
		keyValues = Maps.recursiveClone(keyValues); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {
			MetaModel metaModel = getMetaModel(modelName);					
			remove(persistenceProvider, metaModel, keyValues);
			persistenceProvider.commit();
		}
		catch (RemoveException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public void setValues(String user, String modelName, Map keyValues, Map values)
		throws FinderException, ValidationException, XavaException, RemoteException 
	{						
		Users.setCurrent(user);
		keyValues = Maps.recursiveClone(keyValues); 
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {
			MetaModel metaModel = getMetaModel(modelName);					
			setValues(persistenceProvider, metaModel, keyValues, values);			
			persistenceProvider.commit();
		}
		catch (FinderException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}

	public Object findEntity(String user, String modelName, Map keyValues)
		throws FinderException, RemoteException {
		Users.setCurrent(user);
		keyValues = Maps.recursiveClone(keyValues); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();		
		return findEntity(persistenceProvider, modelName, keyValues);
	}
	
	public Map createReturningValues(String user, String modelName, Map values) 
		throws CreateException, XavaException, ValidationException, RemoteException {
		Users.setCurrent(user);
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {
			Map result = createReturningValues(persistenceProvider, modelName, values);
			persistenceProvider.commit();
			return result;
		}	
		catch (CreateException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}		
	}
	
	public Map createReturningKey(String user, String modelName, Map values) 
		throws CreateException, XavaException, ValidationException, RemoteException {
		Users.setCurrent(user);
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();		
		try {							
			Map result = createReturningKey(persistenceProvider, modelName, values);
			persistenceProvider.commit();
			return result;
		}	
		catch (CreateException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public Object createAggregate(String user, String modelName, Map containerKeyValues, int counter, Map values)  
		throws CreateException,ValidationException, XavaException, RemoteException 
	{		
		Users.setCurrent(user);
		containerKeyValues = Maps.recursiveClone(containerKeyValues); 
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {								
			Object result = createAggregate(persistenceProvider, modelName, containerKeyValues, counter, values);
			persistenceProvider.commit();
			return result;
		}	
		catch (CreateException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public Object createAggregate(String user, String modelName, Object container, int counter, Map values)  
		throws CreateException,ValidationException, XavaException, RemoteException
	{		
		Users.setCurrent(user);
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();		
		try {								
			Object result = createAggregate(persistenceProvider, modelName, container, counter, values);
			persistenceProvider.commit();
			return result;
		}	
		catch (CreateException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public Map createAggregateReturningKey(String user, String modelName, Map containerKeyValues, int counter, Map values)  
		throws CreateException,ValidationException, XavaException, RemoteException 
	{		
		Users.setCurrent(user);
		containerKeyValues = Maps.recursiveClone(containerKeyValues); 
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {					
			Map result = createAggregateReturningKey(persistenceProvider, modelName, containerKeyValues, counter, values);
			persistenceProvider.commit();
			return result;
		}	
		catch (CreateException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}

	public Map getValues( 
		String user, 
		String modelName,
		Object modelObject,
		Map memberNames) throws XavaException, RemoteException  
		 {				
		Users.setCurrent(user);
		memberNames = Maps.recursiveClone(memberNames); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {								
			Map result = getValues(persistenceProvider, modelName, modelObject, memberNames);
			persistenceProvider.commit();
			return result;
		}	
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	

	public Messages validate(String user, String modelName, Map values) throws XavaException, RemoteException {
		Users.setCurrent(user);
		values = Maps.recursiveClone(values); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();		
		try {					
			Messages result = validate(persistenceProvider, modelName, values, false);
			persistenceProvider.commit();
			return result;
		}	
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}
	}
	
	public void removeCollectionElement(String user, String modelName, Map keyValues, String collectionName, Map collectionElementKeyValues)   
		throws FinderException,	ValidationException, XavaException, RemoveException, RemoteException 
	{
		Users.setCurrent(user);
		keyValues = Maps.recursiveClone(keyValues); 
		collectionElementKeyValues = Maps.recursiveClone(collectionElementKeyValues); 
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		try {					
			removeCollectionElement(persistenceProvider, modelName, keyValues, collectionName, collectionElementKeyValues);
			persistenceProvider.commit();
		} 
		catch (FinderException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (ValidationException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (RemoveException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (XavaException ex) {
			rollback(persistenceProvider);
			throw ex;
		}
		catch (Exception ex) {
			rollback(persistenceProvider);
			throw new RemoteException(ex.getMessage());
		}						
	}
		
	private void removeCollectionElement(IPersistenceProvider persistenceProvider, String modelName, Map keyValues, String collectionName, Map collectionElementKeyValues) 
		throws FinderException,	ValidationException, XavaException, RemoveException, RemoteException 
	{
		MetaModel metaModel = getMetaModel(modelName);
		MetaCollection metaCollection = metaModel.getMetaCollection(collectionName);
		MetaModel metaModelReferenced = metaCollection.getMetaReference().getMetaModelReferenced();
		if (metaCollection.isAggregate()) {						
			remove(persistenceProvider, metaModelReferenced, collectionElementKeyValues);
		}
		else {
			Map nullParentKey = new HashMap();
			nullParentKey.put(Strings.firstLower(modelName), null);						
			setValues(persistenceProvider, metaModelReferenced, collectionElementKeyValues, nullParentKey);					
		}												
		if (metaCollection.hasPostRemoveCalculators()) {
			executePostremoveCollectionElement(persistenceProvider, metaModel, keyValues, metaCollection);			
		}						
	}
	
	private Messages validate(IPersistenceProvider persistenceProvider, String modelName, Map values, boolean creating) throws XavaException { 			
		MetaEntityEjb metaEntity = (MetaEntityEjb) MetaComponent.get(modelName).getMetaEntity();		
		Messages validationErrors = new Messages(); 				
		validate(persistenceProvider, validationErrors, metaEntity, values, null, null, creating);
		return validationErrors;
	}
	
	private Map getValues(
		IPersistenceProvider persistenceProvider, 	
		String modelName,
		Object modelObject,
		Map memberNames) throws XavaException
		 {		
		try {			
			MetaModel metaModel = getMetaModel(modelName);
			Map result = getValues(persistenceProvider, metaModel, modelObject, memberNames);						
			return result;
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("get_values_error", modelName);
		}
	}
	
	private Map createAggregateReturningKey(IPersistenceProvider persistenceProvider, String modelName, Map containerKeyValues, int counter, Map values) 
		throws CreateException,ValidationException, XavaException 
	{		
		MetaModel metaModel = getMetaModel(modelName);
		MetaModel metaModelContainer = metaModel.getMetaModelContainer();
		try {								
			Object containerKey = persistenceProvider.getKey((IMetaEjb) metaModelContainer, containerKeyValues);
			Object aggregate = createAggregate(persistenceProvider, metaModel, containerKey, counter, values);						
			return getValues(persistenceProvider, metaModel, aggregate, getKeyNames(metaModel));			
		}
		catch (ClassCastException ex) {
			throw new XavaException("aggregate_must_be_persistent_for_create", metaModelContainer.getName());					
		}
	}
	
	private Object createAggregate(IPersistenceProvider persistenceProvider, String modelName, Object container, int counter, Map values) 
		throws CreateException,ValidationException, XavaException
	{		
		MetaModel metaModel = getMetaModel(modelName);		
		return createAggregate(persistenceProvider, metaModel, container, counter, values);
	}
	
	private Object createAggregate(IPersistenceProvider persistenceProvider, String modelName, Map containerKeyValues, int counter, Map values) 
		throws CreateException,ValidationException, XavaException 
	{		
		MetaModel metaModel = getMetaModel(modelName);
		MetaModel metaModelContainer = metaModel.getMetaModelContainer();
		try {					
			Object containerKey = persistenceProvider.getKey((IMetaEjb) metaModelContainer, containerKeyValues);
			return createAggregate(persistenceProvider, metaModel, containerKey, counter, values);
		}
		catch (ClassCastException ex) {
			throw new XavaException("aggregate_must_be_persistent_for_create", metaModelContainer.getName());					
		}
	}
	
	private Map createReturningKey(IPersistenceProvider persistenceProvider, String modelName, Map values)
		throws CreateException, XavaException, ValidationException {
		MetaEntityEjb metaEntity = (MetaEntityEjb) MetaComponent.get(modelName).getMetaEntity();
		Object entity = create(persistenceProvider, metaEntity, values, null, null, 0);
		return getValues(persistenceProvider, metaEntity, entity, getKeyNames(metaEntity));
	}
	
	private Map createReturningValues(IPersistenceProvider persistenceProvider, String modelName, Map values)
		throws CreateException, XavaException, ValidationException {
		MetaEntityEjb metaEntity = (MetaEntityEjb) MetaComponent.get(modelName).getMetaEntity();
		Object entity = create(persistenceProvider, metaEntity, values, null, null, 0);
		persistenceProvider.flush(); // to execute calculators
		return getValues(persistenceProvider, metaEntity, entity, values);
	}
		
	private Map getValuesImpl(
		IPersistenceProvider	persistenceProvider,	
		String modelName,
		Map keyValues,
		Map membersNames)
		throws FinderException, XavaException {		
		try {			
			MetaModel metaModel = getMetaModel(modelName);						 
			Map result =
				getValues(
					persistenceProvider, 
					metaModel,
					findEntity(persistenceProvider, modelName, keyValues),
					membersNames); 						
			return result;
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("get_values_error", modelName);
		}
	}
		
	private Map getKeyNames(MetaModel metaModel) throws XavaException {
		Iterator itProperties = metaModel.getKeyPropertiesNames().iterator();
		Map names = new HashMap();
		while (itProperties.hasNext()) {
			names.put(itProperties.next(), null);
		}
		Iterator itReferences = metaModel.getMetaReferencesKey().iterator();
		while (itReferences.hasNext()) {
			MetaReference ref = (MetaReference) itReferences.next();
			names.put(ref.getName(), getKeyNames(ref.getMetaModelReferenced()));
		}		
		return names;
	}
	
	private Object createAggregate(IPersistenceProvider persistenceProvider, MetaModel metaModel, Object container, int counter, Map values) 
		throws CreateException,ValidationException, XavaException 
	{				
		MetaModel metaModelContainer = metaModel.getMetaModelContainer();								
		int attempts = 0;
		// Loop with 10 attempts, because the counter can be repeated because deleted objects
		do {				 
			try {
				return create(persistenceProvider, metaModel, values, metaModelContainer, container, counter);
			}
			catch (DuplicateKeyException ex) {
				if (attempts > 10) throw ex;
				counter++;
				attempts++;
			}				
		}
		while (true);			
	}
	
	

	/**
	 * Allows create independent entities or aggregates to another entities. <p>
	 *
	 * If the argument <tt>metaModelContainer</tt> is null it assume
	 * a independent entity else a aggregate.<p>
	 * 
	 * @param metaModel  of entity or aggregate to create. It must to implement IMetaEjb
	 * @param values  to assign to entity to create.
	 * @param metaModelContainer  Only if the object is a aggregate. It's the MetaModel of container model.
	 * @param containerModel Only if object to create is a aggregate.
	 * @param number  Only if object to create is a aggregate. It's a secuential number.
	 * @return The created entity.
	 */
	private Object create(
		IPersistenceProvider persistenceProvider,	
		MetaModel metaModel,
		Map values,
		MetaModel metaModelContainer,
		Object containerKey,
		int number)
		throws CreateException, ValidationException, XavaException {						
		try {			
			if (!(metaModel instanceof IMetaEjb)) {
				throw new IllegalArgumentException(XavaResources.getString("argument_type_error", "metaEjb", "MapFacadeBean.createEjb", "IMetaEjb"));
			}			 
			//removeReadOnlyFields(metaEjb, values); // not remove the read only fields because it maybe needed initialized on create
			removeCalculatedFields(metaModel, values); 			
			Messages validationErrors = new Messages(); 
			validateExistRequired(validationErrors, metaModel, values);						
			validate(persistenceProvider, validationErrors, metaModel, values, null, containerKey, true);
			removeViewProperties(metaModel, values); 
			if (validationErrors.contains()) {
				throw new ValidationException(validationErrors);			
			}
			Map convertedValues = convertSubmapsInObject(persistenceProvider, metaModel, values, XavaPreferences.getInstance().isEJB2Persistence());
			Object newObject = null;
			if (metaModelContainer == null) {
				newObject = persistenceProvider.create((IMetaEjb)metaModel, convertedValues);
			} else {				
				newObject = persistenceProvider.createAggregate(					
						(IMetaEjb) metaModel,
						convertedValues,
						metaModelContainer,
						containerKey,
						number);
			}			
			// Collections are not managed
			return newObject;
		} catch (ValidationException ex) {
			throw ex;
		} catch (DuplicateKeyException ex) {
			ex.printStackTrace();
			throw new DuplicateKeyException(
				XavaResources.getString("no_create_exists", metaModel.getName()));	
		} catch (CreateException ex) {
			ex.printStackTrace();
			throw new CreateException(XavaResources.getString("create_error", metaModel.getName()));		} catch (RemoteException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("create_error", metaModel.getName()));
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("create_error", metaModel.getName());
		}
	}

	public void ejbActivate() throws java.rmi.RemoteException {
	}
	public void ejbCreate()
		throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
	public void ejbPassivate() throws java.rmi.RemoteException {
	}
	public void ejbRemove() throws java.rmi.RemoteException {
	}

	private Object getReferencedObject(Object container, String memberName) {
		try {
			PropertiesManager man =
				new PropertiesManager(container);
			Object result = man.executeGet(memberName);
			return result;
		} catch (PropertiesManagerException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_property_error", memberName));
		} catch (InvocationTargetException ex) {
			Throwable th = ex.getTargetException();
			th.printStackTrace();
			throw new EJBException(XavaResources.getString("get_property_error", memberName));
		}
	}

	public javax.ejb.SessionContext getSessionContext() {
		return sessionContext;
	}

	
	private Map getValues( 
		IPersistenceProvider persistenceProvider,	
		MetaModel metaModel,
		Map keyValues,
		Map memberNames)
		throws FinderException, XavaException { 
		try {									 
			Map result =
				getValues(
					persistenceProvider,	
					metaModel,
					findEntity(persistenceProvider, (IMetaEjb)metaModel, keyValues),
					memberNames);			
			return result;
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("get_values_error", metaModel.getName());
		}
	}
	
	private MetaModel getMetaModel(String modelName) throws XavaException { 
		int idx = modelName.indexOf('.');			
		if (idx < 0) {
			return MetaComponent.get(modelName).getMetaEntity();
		}
		else {
			String component = modelName.substring(0, idx);
			idx = modelName.lastIndexOf('.'); // just in case we have: MyEntity.MyAggregate.MyAnotherAggregate --> It get MyAnotherAggregate within MyEntity Component
			String aggregate = modelName.substring(idx + 1);
			return MetaComponent.get(component).getMetaAggregate(aggregate);
		}
	}

	private Map getValues(
		IPersistenceProvider persistenceProvider,		
		MetaModel metaModel, 
		Object modelObject,
		Map membersNames) throws XavaException {
		try {
			if (modelObject == null)
				return null;						
			if (membersNames == null) return Collections.EMPTY_MAP;			 
			IPropertiesContainer r = persistenceProvider.toPropertiesContainer(metaModel, modelObject);			
			StringBuffer names = new StringBuffer();
			addKey(metaModel, membersNames); // always return the key althought it don't is aunque no se solicit
			removeViewProperties(metaModel, membersNames);			
			Iterator it = membersNames.keySet().iterator();			
			Map result = new HashMap();			
			while (it.hasNext()) {
				String memberName = (String) it.next();
				if (metaModel.containsMetaProperty(memberName) ||
					(metaModel.isKey(memberName) && !metaModel.containsMetaReference(memberName))) {
					names.append(memberName);
					names.append(":");
				} 
				else {
					Map submemberNames = (Map) membersNames.get(memberName);
					if (metaModel.containsMetaReference(memberName)) {						
						result.put(
							memberName,
							getReferenceValues(persistenceProvider, metaModel, modelObject, memberName, submemberNames));
					}
					else if (metaModel.containsMetaCollection(memberName)) {						
						result.put(
							memberName,
							getCollectionValues(persistenceProvider, metaModel, modelObject, memberName, submemberNames));
					} 
					else {
						throw new XavaException("member_not_found", memberName, metaModel.getName());
					}
				}
			}			
			result.putAll(r.executeGets(names.toString()));			
			return result;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_values_error", metaModel.getName()));
		}
	}
	
	public Map getKeyValues(String user, String modelName, Object entity) throws RemoteException, XavaException {
		Users.setCurrent(user);
		IPersistenceProvider persistenceProvider = createPersistenceProvider();
		MetaModel metaModel = getMetaModel(modelName);
		return getValues(persistenceProvider, metaModel, entity, getKeyNames(metaModel));
	}
		
	private void addKey(MetaModel metaModel, Map memberNames) throws XavaException {
		Iterator it = metaModel.getKeyPropertiesNames().iterator();		
		while (it.hasNext()) {
			String name = (String) it.next();
			memberNames.put(name, null);
		}		
		Iterator itRef = metaModel.getMetaReferencesKey().iterator();
		while (itRef.hasNext()) {
			MetaReference ref = (MetaReference) itRef.next();
			Map referenceKeyNames = null;
			referenceKeyNames = (Map) memberNames.get(ref.getName());
			if (referenceKeyNames == null) {
				referenceKeyNames = new HashMap();
			}
			addKey(ref.getMetaModelReferenced(), referenceKeyNames);
			memberNames.put(ref.getName(), referenceKeyNames);
		}				
	}
	
	/**
	 * If we send null as <tt>nombresPropiedades</tt> it return a empty Map. <p>
	 */
	private Map getAggregateValues(IPersistenceProvider persistenceProvider, MetaAggregate metaAggregate, Object aggregate, Map memberNames) throws XavaException {
		if (memberNames == null) return Collections.EMPTY_MAP;
		PropertiesManager man = new PropertiesManager(aggregate);
		StringBuffer names = new StringBuffer();
				
		Map result = new HashMap();
		
		Iterator itKeys = metaAggregate.getKeyPropertiesNames().iterator();
		while (itKeys.hasNext()) {
			names.append(itKeys.next());
			names.append(":");			
		}
		
		removeViewProperties(metaAggregate, memberNames); 
		 
		Iterator it = memberNames.keySet().iterator();		
		while (it.hasNext()) {
			String memberName = (String) it.next();
			if (metaAggregate.containsMetaProperty(memberName)) {
				names.append(memberName);
				names.append(":");
			} else
				if (metaAggregate.containsMetaReference(memberName)) {
					Map submemberNames = (Map) memberNames.get(memberName);
					result.put(
						memberName,
						getReferenceValues(persistenceProvider, metaAggregate, aggregate, memberName, submemberNames));
				} else {
					throw new XavaException("member_not_found", memberName, metaAggregate.getName());
				}
		}
		try {
			result.putAll(man.executeGets(names.toString()));
		} catch (PropertiesManagerException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_values_error", metaAggregate.getName()));
		} catch (InvocationTargetException ex) {
			Throwable th = ex.getTargetException();
			th.printStackTrace();
			throw new EJBException(XavaResources.getString("get_values_error", metaAggregate.getName()));
		}
		return result;
	}


	/**
	 * If <tt>memberNames</tt> is null then return a empty map.
	 */
	private Map getAssociatedEntityValues(IPersistenceProvider persistenceProvider, MetaEntity metaEntity, Object modelObject, Map memberNames) throws XavaException {
		if (memberNames == null) return Collections.EMPTY_MAP;
		Map result = getValues(persistenceProvider, metaEntity, modelObject, memberNames);
		return result;
	}

	private Map getReferenceValues(
		IPersistenceProvider persistenceProvider,	
		MetaModel metaModel,
		Object model,
		String memberName,
		Map submembersNames) throws XavaException {
		try {			
			MetaReference r = metaModel.getMetaReference(memberName);
			Object object = getReferencedObject(model, memberName);
			if (r.isAggregate()) {
				return getAggregateValues(persistenceProvider, (MetaAggregate) r.getMetaModelReferenced(), object, submembersNames);
			} 
			else {				
				return getAssociatedEntityValues(persistenceProvider, (MetaEntity) r.getMetaModelReferenced(), object, submembersNames);
			}
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("get_reference_error", memberName, metaModel.getName());
		}
	}
	
	private Collection getCollectionValues(
		IPersistenceProvider persistenceProvider,	
		MetaModel metaModel,
		Object modelObject,
		String memberName,
		Map memberNames) throws XavaException {
		try {
			MetaCollection c = metaModel.getMetaCollection(memberName);
			Object object = getReferencedObject(modelObject, memberName);
			return getCollectionValues( persistenceProvider,
					c.getMetaReference().getMetaModelReferenced(),
					c.isAggregate(),	object, memberNames);
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("get_collection_elements_error", memberName, metaModel.getName());
		}
	}
	
	private Collection getCollectionValues(
		IPersistenceProvider persistenceProvider,	
		MetaModel metaModel,
		boolean aggregate,
		Object elements, Map memberNames) throws XavaException {
		Collection result = new ArrayList();
		Enumeration enumeration = null;
		if (elements instanceof Enumeration) {
			enumeration = (Enumeration) elements;
		}
		else if (elements instanceof Collection) {
			enumeration = Collections.enumeration((Collection) elements);
		}
		else {
			String collectionType = elements == null?"null":elements.getClass().getName();
			throw new XavaException("collection_type_not_supported", collectionType);
		}		
		while (enumeration.hasMoreElements()) {
			Object object = enumeration.nextElement();			
			result.add(getValues(persistenceProvider, metaModel, object, memberNames));
		}
		return result;
	}


	private Object instanceAggregate(IPersistenceProvider persistenceProvider, MetaAggregateBean metaAggregate, Map values)
		throws ValidationException, XavaException {
		try {
			Object object = Class.forName(metaAggregate.getBeanClass()).newInstance();
			PropertiesManager man = new PropertiesManager(object);			
			removeViewProperties(metaAggregate, values);
			values = convertSubmapsInObject(persistenceProvider, metaAggregate, values, false);
			man.executeSets(values);
			return object;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("instantiate_error", metaAggregate.getBeanClass()));
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("instantiate_error", metaAggregate.getBeanClass()));
		} catch (InstantiationException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("instantiate_error", metaAggregate.getBeanClass()));
		} catch (InvocationTargetException ex) {
			throwsValicationException(
				ex, XavaResources.getString("assign_values_error", metaAggregate.getBeanClass(), ex.getLocalizedMessage())); 				
			throw new EJBException(); // Never
		} catch (PropertiesManagerException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("assign_values_error", metaAggregate.getBeanClass(), ex.getLocalizedMessage()));
		}
	}

	private void throwsValicationException(
		InvocationTargetException ex,
		String ejbmessage)
		throws ValidationException {
		Throwable th = ex.getTargetException();
		if (th instanceof ValidationException) {
			throw (ValidationException) th;
		}
		th.printStackTrace();
		throw new EJBException(ejbmessage);
	}

	private Object mapToReferencedObject(
		IPersistenceProvider persistenceProvider,	
		MetaModel metaModel,
		String memberName,
		Map values)
		throws ValidationException, XavaException {		
		MetaReference r = null;
		try {
			if (Maps.isEmpty(values)) return null;			
			r = metaModel.getMetaReference(memberName);
			if (r.isAggregate()) {
				return instanceAggregate(persistenceProvider, (MetaAggregateBean) r.getMetaModelReferenced(), values);
			} else {
				return findAssociatedEntity(persistenceProvider, (MetaEntity) r.getMetaModelReferenced(), values);
			}
		}
		catch (ObjectNotFoundException ex) {
			return null; 
		} 
		catch (FinderException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("map_to_reference_error",
					r.getName(),					
					metaModel.getName(),					
					memberName));
		} catch (XavaException ex) {
			throw ex;
		}
	}

	private Object findAssociatedEntity(IPersistenceProvider persistenceProvider, MetaEntity metaEntity, Map values)
		throws FinderException, XavaException {
		Map keyValues = extractKeyValues(metaEntity, values);		
		return findEntity(persistenceProvider, metaEntity.getName(), keyValues);
	}

	private Map extractKeyValues(MetaEntity metaEntity, Map values)
		throws XavaException {
		return metaEntity.extractKeyValues(values);
	}

	private void removeKeyFields(MetaModel metaModel, Map values)
		throws XavaException {
		Iterator keys = metaModel.getKeyPropertiesNames().iterator();
		while (keys.hasNext()) {
			values.remove(keys.next());
		}
		Iterator itRef = metaModel.getMetaReferencesKey().iterator();
		while (itRef.hasNext()) {
			MetaReference ref = (MetaReference) itRef.next();
			values.remove(ref.getName());
		}		
	}

	private void removeReadOnlyFields(MetaModel metaModel, Map values)
		throws XavaException {
		Iterator toRemove = metaModel.getOnlyReadPropertiesNames().iterator();
		while (toRemove.hasNext()) {
			values.remove(toRemove.next());
		}
	}
		
	private void removeCalculatedFields(MetaModel metaModel, Map values)
		throws XavaException {
		Iterator toRemove = metaModel.getCalculatedPropertiesNames().iterator();
		while (toRemove.hasNext()) {
			values.remove(toRemove.next());
		}
	}
	
	private void removeViewProperties(MetaModel metaModel, Map values)
		throws XavaException {		
		Iterator toRemove = metaModel.getViewPropertiesNames().iterator();
		while (toRemove.hasNext()) {
			values.remove(toRemove.next());
		}
	}	
		
	private void remove(IPersistenceProvider persistenceProvider, MetaModel metaModel, Map keyValues)
		throws RemoveException, ValidationException, XavaException {
		try {			
			Object object = findEntity(persistenceProvider, (IMetaEjb)metaModel, keyValues);
			remove(persistenceProvider, metaModel, object);
		} catch (FinderException ex) {
			ex.printStackTrace();
			throw new RemoveException(XavaResources.getString("remove_error",
				metaModel.getName(), ex.getLocalizedMessage()));
		}		
	}
		
	private void remove(IPersistenceProvider persistenceProvider, MetaModel metaModel, Object modelObject)
		throws RemoveException, ValidationException, XavaException {
		try {
			Messages errors = validateOnRemove(metaModel, modelObject);
			if (!errors.isEmpty()) {
				throw new ValidationException(errors);
			}			
			// removing collections are resposibility of persistence provider
			persistenceProvider.remove(metaModel, modelObject);			
		} catch (ValidationException ex) {
			throw ex;					
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("remove_error", metaModel.getName(), ex.getLocalizedMessage());				
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("remove_error",
				metaModel.getName(), ex.getLocalizedMessage()));
		}
	}
	
	private Messages validateOnRemove(MetaModel metaModel, Object modelObject) throws Exception {		
		Messages errors = new Messages();
		Iterator it = metaModel.getMetaValidatorsRemove().iterator();
		while (it.hasNext()) {
			MetaValidator metaValidator = (MetaValidator) it.next(); 
			IRemoveValidator validator = metaValidator.getRemoveValidator();
			validator.setEntity(modelObject);
			validator.validate(errors);			
		}				 		
		return errors;		
	}
		
	public void setSessionContext(javax.ejb.SessionContext ctx)
		throws java.rmi.RemoteException {
		sessionContext = ctx;
	}
		
	private void setValues(IPersistenceProvider persistenceProvider, MetaModel metaModel, Map keyValues, Map values)
		throws FinderException, ValidationException, XavaException {		
		try {						 
			removeKeyFields(metaModel, values);			
			removeReadOnlyFields(metaModel, values);
			removeViewProperties(metaModel, values);			
			validate(persistenceProvider, metaModel, values, keyValues, null, false);			
			Object entity = findEntity(persistenceProvider, (IMetaEjb) metaModel, keyValues);			
			IPropertiesContainer r = persistenceProvider.toPropertiesContainer(metaModel, entity);			
			r.executeSets(convertSubmapsInObject(persistenceProvider, metaModel, values, XavaPreferences.getInstance().isEJB2Persistence()));			
			// Collections are not managed			
		} 
		catch (FinderException ex) { 
			throw ex;
		}		
		catch (ValidationException ex) {
			throw ex;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			throw new XavaException("assign_values_error", metaModel.getName(), ex.getLocalizedMessage()); 
		}
	}
	
	private void validate(
		IPersistenceProvider persistenceProvider,	
		Messages errors,
		MetaModel metaModel,
		String memberName,
		Object values,
		boolean creating) throws XavaException {			
		try {			
			if (metaModel.containsMetaProperty(memberName)) {
				metaModel.getMetaProperty(memberName).validate(errors, values, creating); 
			} else
				if (metaModel.containsMetaReference(memberName)) {
					MetaReference ref = metaModel.getMetaReference(memberName); 
					MetaModel referencedModel = ref.getMetaModelReferenced();
					Map mapValues = (Map) values;					
					if (hasValue(mapValues)) {
						if (ref.isAggregate()) validate(persistenceProvider, errors, referencedModel, mapValues, mapValues, null, creating);
					} else
						if (metaModel
							.getMetaReference(memberName)
							.isRequired()) {
							errors.add("required", memberName, metaModel.getName());
						}
						
				} else if (metaModel.containsMetaCollection(memberName)) {
					// It never happens this way 
					metaModel.getMetaCollection(memberName).validate(errors, values, null, null);
				} else if (metaModel.containsMetaPropertyView(memberName)) { 										
					metaModel.getMetaPropertyView(memberName).validate(errors, values, creating);									
				} else {					
					System.err.println(XavaResources.getString("not_validate_member_warning", memberName, metaModel.getName()));
				}
		} catch (XavaException ex) {
			ex.printStackTrace();
			throw new XavaException("validate_error", memberName, metaModel.getName());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("validate_error", memberName, metaModel.getName()));				
		}
	}
	
	private boolean hasValue(Map values) {
		if (values == null) return false;
		Iterator it = values.values().iterator();
		while (it.hasNext()) {
			Object v = it.next();
			if (v == null) continue;
			if (v instanceof String && ((String) v).trim().equals("")) continue;
			if (v instanceof Number && ((Number)  v).intValue()==0) continue;
			return true;
		}		
		return false;
	}
	
	private void validate(IPersistenceProvider persistenceProvider, Messages errors, MetaModel metaModel, Map values, Map keyValues, Object containerKey, boolean creating)	  
		throws XavaException {		
		Iterator it = values.entrySet().iterator();		
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			String name = (String) en.getKey();
			Object value = en.getValue();
			validate(persistenceProvider, errors, metaModel, name, value, creating);
		}
		if (metaModel.containsValidadors()) {
			validateWithModelValidator(persistenceProvider, errors, metaModel, values, keyValues, containerKey, creating);			
		}
	}
	
	private void validateWithModelValidator(IPersistenceProvider persistenceProvider, Messages errors, MetaModel metaModel, Map values, Map keyValues, Object containerKey, boolean creating) throws XavaException {				
		try {
			String containerReferenceName = Strings.firstLower(metaModel.getMetaModelContainer().getName());
			Iterator itValidators = metaModel.getMetaValidators().iterator();
			while (itValidators.hasNext()) {
				MetaValidator metaValidator = (MetaValidator) itValidators.next();
				Iterator itSets =  metaValidator.getMetaSetsWithoutValue().iterator();
				if (!creating && metaValidator.isOnlyOnCreate()) continue; 
				IValidator v = metaValidator.createValidator();
				PropertiesManager mp = new PropertiesManager(v);		
				while (itSets.hasNext()) {
					MetaSet set = (MetaSet) itSets.next();					
					Object value = values.get(set.getPropertyNameFrom());
					if (value == null && !values.containsKey(set.getPropertyNameFrom())) {						
						if (keyValues != null) {							
							Map memberName = new HashMap();
							memberName.put(set.getPropertyNameFrom(), null);
							Map memberValue = getValues(persistenceProvider, metaModel, keyValues, memberName);
							value = memberValue.get(set.getPropertyNameFrom());
						}											
					}					
					if (set.getPropertyNameFrom().equals(containerReferenceName)) {					
						if (containerKey == null) {							
							Object object = findEntity(persistenceProvider, ((IMetaEjb)metaModel), keyValues);
							value = Objects.execute(object, "get" + metaModel.getMetaModelContainer().getName());
						}
						else {							
							IMetaEjb containerReference = (IMetaEjb) metaModel.getMetaModelContainer();
							try {							
								value = persistenceProvider.find(containerReference, containerKey);								
							}
							catch (ObjectNotFoundException ex) {								
								value = null;
							}			
						}
					}
					else if (metaModel.containsMetaReference(set.getPropertyNameFrom())) {						
						MetaReference ref = metaModel.getMetaReference(set.getPropertyNameFrom());
						if (ref.isAggregate()) {							
							value = mapToReferencedObject(persistenceProvider, metaModel, set.getPropertyNameFrom(), (Map) value);
						}
						else {							
							IMetaEjb referencedEntity = (IMetaEjb) ref.getMetaModelReferenced();
							try {
								value = findEntity(persistenceProvider, referencedEntity, (Map) value);								
							}
							catch (ObjectNotFoundException ex) {								
								value = null;
							}																															
						}						
					}								
					mp.executeSet(set.getPropertyName(), value);									
				}							
				v.validate(errors);
			}		
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new XavaException("validate_model_error", metaModel.getName());
		}
	}
	
	private void validate(IPersistenceProvider persistenceProvider, MetaModel metaModel, Map values, Map keyValues, Object containerKey, boolean creating)
		throws ValidationException, XavaException, RemoteException {
		Messages errors = new Messages();		
		validate(persistenceProvider, errors, metaModel, values, keyValues, containerKey, creating);		
		if (errors.contains()) {
			throw new ValidationException(errors);
		}
	}

	private void validateExistRequired(Messages errors, MetaModel metaModel, Map values)
		throws XavaException {		
		Iterator it = metaModel.getRequiredMemberNames().iterator();		
		while (it.hasNext()) {
			String name = (String) it.next();			
			if (!values.containsKey(name)) {				
				errors.add("required", name, metaModel.getName());
			}
		}
	}
				
	private Object findEntity(IPersistenceProvider persistenceProvider, IMetaEjb metaEntity, Map keyValues)	throws FinderException, XavaException {
		return persistenceProvider.find(metaEntity, keyValues);
	}
	
	private void rollback (IPersistenceProvider pp) {
		if (getSessionContext() != null) getSessionContext().setRollbackOnly();
		pp.rollback();
	}
		
	private void executePostremoveCollectionElement(IPersistenceProvider persistenceProvider, MetaModel metaModel, Map keyValues, MetaCollection metaCollection) throws FinderException, ValidationException, XavaException {
		Iterator itCalculators = metaCollection.getMetaCalculatorsPostRemove().iterator();
		while (itCalculators.hasNext()) {
			MetaCalculator metaCalculator = (MetaCalculator) itCalculators.next();			
			ICalculator calculator = metaCalculator.createCalculator();
			PropertiesManager mp = new PropertiesManager(calculator);
			Collection sets =  metaCalculator.getMetaSetsWithoutValue();
			if (metaCalculator.containsMetaSetsWithoutValue()) {
				Map neededPropertyNames = new HashMap();
				Iterator itSets = sets.iterator();
				while (itSets.hasNext()) {
					MetaSet set = (MetaSet) itSets.next();
					neededPropertyNames.put(set.getPropertyNameFrom(), null);
				}												
				Map values = getValues(persistenceProvider, metaModel, keyValues, neededPropertyNames);
				
				itSets = sets.iterator();											
				while (itSets.hasNext()) {
					MetaSet set = (MetaSet) itSets.next();
					Object value = values.get(set.getPropertyNameFrom());
					if (value == null && !values.containsKey(set.getPropertyNameFrom())) {
						if (keyValues != null) { 
							Map memberName = new HashMap();
							memberName.put(set.getPropertyNameFrom(), null);
							Map memberValue = getValues(persistenceProvider, metaModel, keyValues, memberName);
							value = memberValue.get(set.getPropertyNameFrom());
						}											
					}
						
					if (metaModel.containsMetaReference(set.getPropertyNameFrom())) {
						MetaReference ref = metaModel.getMetaReference(set.getPropertyNameFrom());
						if (ref.isAggregate()) {
							value = mapToReferencedObject(persistenceProvider, metaModel, set.getPropertyNameFrom(), (Map) value);
						}
						else {
							IMetaEjb referencedEntity = (IMetaEjb) ref.getMetaModelReferenced();
							try {
								value = findEntity(persistenceProvider, referencedEntity, (Map) value);
							}
							catch (ObjectNotFoundException ex) {
								value = null;
							}
																																
						}						
					}
					try {			
						mp.executeSet(set.getPropertyName(), value);
					}
					catch (Exception ex) {
						ex.printStackTrace();
						throw new XavaException("calculator_property_error", value, set.getPropertyName());
					}									
				}
			}			
			
			if (calculator instanceof IModelCalculator) {
				Object entity = findEntity(persistenceProvider, (IMetaEjb) metaModel, keyValues);
				try {
					((IModelCalculator) calculator).setModel(entity);
				}
				catch (Exception ex) {
					ex.printStackTrace();
					throw new XavaException("assign_entity_to_calculator_error", metaModel.getName(), keyValues);
				}									
				
			}
			if (calculator instanceof IEntityCalculator) {
				Object entity = findEntity(persistenceProvider, (IMetaEjb) metaModel, keyValues);
				try {
					((IEntityCalculator) calculator).setEntity(entity);
				}
				catch (Exception ex) {
					ex.printStackTrace();
					throw new XavaException("assign_entity_to_calculator_error", metaModel.getName(), keyValues);
				}									
				
			}
			
			try {
				calculator.calculate();
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("postremove_error", metaModel.getName(), keyValues));
			}
		}				
	}
	
	private Map convertSubmapsInObject(IPersistenceProvider persistenceProvider, MetaModel metaModel, Map values,
			boolean referencesAsKey) throws ValidationException, XavaException {		
		Map result = new HashMap();
		Iterator it = values.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			String memberName = (String) en.getKey();
			Object value = null;
			if (metaModel.containsMetaProperty(memberName)) {
				value = en.getValue();
			}
			else if (metaModel.containsMetaReference(memberName)) {
				MetaReference ref = metaModel.getMetaReference(memberName);
				if (!referencesAsKey || ref.isAggregate()) { 
					value = mapToReferencedObject(persistenceProvider, metaModel, memberName, (Map) en
							.getValue());
				}
				else {
					MetaEntityEjb referencedEntity = (MetaEntityEjb) ref
							.getMetaModelReferenced();
					memberName = memberName + "Key";
					value = referencedEntity.obtainPrimaryKeyFromKey((Map) en.getValue());
				}
			}
			else if (metaModel.getMapping().hasPropertyMapping(memberName)) {
				value = en.getValue();
			}
			else {
				throw new XavaException("member_not_found", memberName, metaModel
						.getName());
			}
			result.put(memberName, value);
		}
		return result;
	}
	
	private Object findEntity(IPersistenceProvider persistenceProvider,	String modelName, Map keyValues)
		throws FinderException {
		try {
			return findEntity(persistenceProvider, (IMetaEjb) getMetaModel(modelName), keyValues);			
		} catch (FinderException ex) {
			throw ex;
		} catch (ElementNotFoundException ex) {
			throw new EJBException(XavaResources.getString("model_not_found", modelName));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("find_error", modelName));
		}
	}

	private IPersistenceProvider createPersistenceProvider() throws RemoteException {
		try {
			return (IPersistenceProvider) Class.forName(XavaPreferences.getInstance().getPersistenceProviderClass()).newInstance();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RemoteException(XavaResources.getString("persistence_provider_creation_error"));
		}
	}

}


