package org.openxava.view.meta.xmlparse;

import org.openxava.model.meta.xmlparse.*;
import org.openxava.util.*;
import org.openxava.util.xmlparse.*;
import org.openxava.view.meta.*;
import org.w3c.dom.*;


/**
 * @author: Javier Paniza
 */
public class ViewParser extends XmlElementsNames {
	
	public static MetaView parseView(Node n, int lang) throws XavaException {
		Element el = (Element) n;
		MetaView v = new MetaView();
		v.setName(el.getAttribute(xname[lang]));
		v.setLabel(el.getAttribute(xlabel[lang]));
		v.setModelName(el.getAttribute(xmodel[lang]));
		String attributeMembers = el.getAttribute(xmembers[lang]);
		String elementMembers = getMemberElementMembers(el, lang);						
		if (!attributeMembers.equals("*") && !Is.emptyString(elementMembers)) {
			throw new XavaException("incompatible_attribute_element_members");
		} 		
		if (!Is.emptyString(elementMembers)){
			v.setMembersNames(elementMembers);
		}
		else  {
			v.setMembersNames(attributeMembers);
		}
		fillMediator(el, v, lang);
		fillProperties(el, v, lang);
		fillReferenceViews(el, v, lang);
		fillCollectionViews(el, v, lang);
		fillPropertyViews(el, v, lang);
		fillGroups(el, v, lang);
		fillSections(el, v, lang); 
		return v;
	}
	
	private static String getMemberElementMembers(Element el, int lang) {
		NodeList l = el.getElementsByTagName(xmembers[lang]);
		if (l.getLength() < 1)
			return null;
		return getMembers(l.item(0), lang);
	}
	
	private static String getMembers(Node n, int lang) {		
		NodeList list = n.getChildNodes();
		StringBuffer r = new StringBuffer();
		for (int i = 0; i < list.getLength(); i++) {
			Node node = (Node) list.item(i);
			if (xgroup[lang].equals(node.getNodeName())) {
				String groupName = ((Element) node).getAttribute(xname[lang]);
				r.append("__GROUP__");
				r.append(groupName);
				r.append(',');
			}
			else {
				String nodeValue = node.getNodeValue();
				if (nodeValue != null) r.append(nodeValue);
			}
		}
		String s = r.toString();		
		return Is.emptyString(s)?null:s;
	}
	
	private static void fillSections(Element el, MetaView v, int lang) throws XavaException {
		NodeList nodesMembers = el.getElementsByTagName(xmembers[lang]);
		if (nodesMembers.getLength() == 0) return;
		fillSectionsImpl((Element) nodesMembers.item(0), v, lang);		
	}
	
	private static void fillSectionsImpl(Element el, MetaView v, int lang) throws XavaException {
		NodeList l = el.getChildNodes();
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			if (!(l.item(i) instanceof Element)) continue;
			Element s = (Element) l.item(i);
			String type = s.getTagName();
			if (!type.equals(xsection[lang])) continue;
			String name = s.getAttribute(xname[lang]);
			String label = s.getAttribute(xlabel[lang]);
			if (Is.emptyStringAll(name, label)) {
				throw new XavaException("section_name_or_label_required");			
			}			
			String members = getMembers(s, lang);
			MetaView newSection = v.addSection(name, label, members);
			fillSectionsImpl(s, newSection, lang);
		}
	}
	
	private static void fillGroups(Element el, MetaView v, int lang) throws XavaException {
		NodeList l = el.getElementsByTagName(xgroup[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			Element n = (Element) l.item(i);
			String name = n.getAttribute(xname[lang]);
			String label = n.getAttribute(xlabel[lang]);
			String members = getMembers(n, lang); 
			v.addMetaGroup(name, label, members);
		}
	}
	
	private static void fillMediator(Element el, MetaView container, int lang) // only use in spanish/swing version
		throws XavaException {
		NodeList l = el.getChildNodes();
		int c = l.getLength();
		if (c == 0) return;
		Node found = null;
		for (int i = 0; i < l.getLength(); i++) {
			Node n = l.item(i);
			if (n.getNodeName().equals(xmediator[lang])) {
				found = n;
				break;
			}
		}
		if (found == null) {
			return;
		}		
		container.setMediatorClassName(getMediatorClass(found, lang));		
	}
	
	private static void fillMediator(Element el, MetaCollectionView container, int lang)
		throws XavaException {			
		NodeList l = el.getElementsByTagName(xmediator[lang]);
		int c = l.getLength();
		if (c == 0) return;
		if (c > 1) {
			throw new XavaException("only_1_mediator");
		}
		container.setMediatorClassName(getMediatorClass(l.item(0), lang));
	}	
		
	private static void fillReferenceViews(Element el, MetaView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xreference_view[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			container.addMetaViewReference(createMetaReferenceView(l.item(i), lang));
		}
	}
	
	private static void fillCollectionViews(Element el, MetaView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xcollection_view[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			container.addMetaViewCollection(createMetaCollectionView(l.item(i), lang));
		}
	}	
	
	private static void fillPropertyViews(Element el, MetaView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xproperty_view[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			container.addMetaViewProperty(createMetaPropertyView(l.item(i), lang));
		}
	}	
	
	private static MetaReferenceView createMetaReferenceView(Node n, int lang) throws XavaException {
		Element el = (Element) n;
		MetaReferenceView a = new MetaReferenceView();		
		a.setReferenceName(el.getAttribute(xreference[lang]));
		a.setViewName(el.getAttribute(xview[lang]));
		a.setReadOnly(ParserUtil.getAttributeBoolean(el, xread_only[lang]));
		if (!Is.emptyString(el.getAttribute(xframe[lang]))) {
			a.setFrame(ParserUtil.getAttributeBoolean(el, xframe[lang]));
		}
		if (!Is.emptyString(el.getAttribute(xcreate[lang]))) {
			a.setCreate(ParserUtil.getAttributeBoolean(el, xcreate[lang]) );
		}
		if (!Is.emptyString(el.getAttribute(xsearch[lang]))) {
			a.setSearch(ParserUtil.getAttributeBoolean(el, xsearch[lang]) );
		}		
		fillMetaSearchAction(el, a, lang);
		fillMetaDescriptionsList(el, a, lang);
		fillActions(el, a, lang);
		return a;
	}
	
	private static MetaCollectionView createMetaCollectionView(Node n, int lang) throws XavaException {
		Element el = (Element) n;
		MetaCollectionView a = new MetaCollectionView();
		a.setCollectionName(el.getAttribute(xcollection[lang]));		
		a.setViewName(el.getAttribute(xview[lang]));
		a.setReadOnly(ParserUtil.getAttributeBoolean(el, xread_only[lang]));		
		a.setEditOnly(ParserUtil.getAttributeBoolean(el, xedit_only[lang]));
		if (a.isEditOnly() && a.isReadOnly()) {
			throw new XavaException("collection_onlyread_onlyedit_incompatible");
		}
		a.setCreateReference(ParserUtil.getAttributeBoolean(el, xcreate_reference[lang]));
		fillMediator(el, a, lang);
		a.setPropertiesList(ParserUtil.getString(el, xlist_properties[lang]));
		fillEditAction(el, a, lang);
		fillViewAction(el, a, lang);
		fillDetailActions(el, a, lang); 		
		fillListActions(el, a, lang);
		return a;
	}	
	
	private static MetaPropertyView createMetaPropertyView(Node n, int lang) throws XavaException {
		Element el = (Element) n;
		MetaPropertyView a = new MetaPropertyView();		
		a.setPropertyName(el.getAttribute(xproperty[lang]));
		a.setLabel(el.getAttribute(xlabel[lang]));	
		a.setReadOnly(ParserUtil.getAttributeBoolean(el, xread_only[lang]));
		String labelFormat = el.getAttribute(xlabel_format[lang]);
		if (XNORMAL[lang].equals(labelFormat)) a.setLabelFormat(MetaPropertyView.NORMAL_LABEL);
		else if (XSMALL[lang].equals(labelFormat)) a.setLabelFormat(MetaPropertyView.SMALL_LABEL);
		else if (XNO_LABEL[lang].equals(labelFormat)) a.setLabelFormat(MetaPropertyView.NO_LABEL);
		else throw new XavaException("invalid_label_format", labelFormat);
		fillOnChangeAction(el, a, lang);	
		fillActions(el, a, lang);
		return a;
	}
	
	private static void fillOnChangeAction(Element el, MetaPropertyView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xon_change[lang]);
		int c = l.getLength();
		if (c==0) return;
		if (c>1) {			
			throw new XavaException("no_more_1_on_change_in_property_view");
		}
		Element elAction = (Element) l.item(0);
		container.setOnChangeActionClassName(elAction.getAttribute(xclass[lang]));
	}
			
	private static void fillMetaSearchAction(Element el, MetaReferenceView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xsearch_action[lang]);
		int c = l.getLength();
		if (c==0) return;
		if (c>1) {			
			throw new XavaException("no_more_1_search_action_in_reference_view");
		}
		container.setMetaSearchAction(createMetaSearchAction(l.item(0), lang));
	}

	private static void fillEditAction(Element el, MetaCollectionView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xedit_action[lang]);
		int c = l.getLength();
		if (c==0) return;
		if (c>1) throw new XavaException("no_more_1_edit_action_in_collection_view");
		String action = ((Element) l.item(0)).getAttribute(xaction[lang]);		
		container.setEditActionName(action);		
	}
	
	private static void fillViewAction(Element el, MetaCollectionView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xview_action[lang]);
		int c = l.getLength();
		if (c==0) return;
		if (c>1) throw new XavaException("no_more_1_view_action_in_collection_view");
		String action = ((Element) l.item(0)).getAttribute(xaction[lang]);		
		container.setViewActionName(action);		
	}	
	
	private static void fillDetailActions(Element el, MetaCollectionView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xdetail_action[lang]);
		int c = l.getLength();
		for (int i=0; i<c; i++) {
			String accion = ((Element) l.item(i)).getAttribute(xaction[lang]);		
			container.addActionDetailName(accion);
		}
	}
	
	private static void fillListActions(Element el, MetaCollectionView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xlist_action[lang]);
		int c = l.getLength();
		for (int i=0; i<c; i++) {
			String action = ((Element) l.item(i)).getAttribute(xaction[lang]);		
			container.addActionListName(action);
		}
	}
		
	private static void fillActions(Element el, MetaMemberView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xaction[lang]);
		int c = l.getLength();
		for (int i=0; i<c; i++) {
			String action = ((Element) l.item(i)).getAttribute(xaction[lang]);		
			container.addActionName(action);
		}
	}
	
	private static void fillMetaDescriptionsList(Element el, MetaReferenceView container, int lang)
		throws XavaException {
		NodeList l = el.getElementsByTagName(xdescriptions_list[lang]);
		int c = l.getLength();
		if (c==0) return;
		if (c>1) {			
			throw new XavaException("no_more_1_descriptions_list_in_reference_view");
		}
		container.setMetaDescriptionsList(createMetaDescriptionsList(l.item(0), lang));
	}
	
	
	private static MetaSearchAction createMetaSearchAction(Node n, int lang) throws XavaException {
		Element el = (Element) n;
		MetaSearchAction m = new MetaSearchAction();
		String className = el.getAttribute(xclass[lang]);
		if (!Is.emptyString(className)) {
			m.setClassName(className);
		}
		String action = el.getAttribute(xaction[lang]);
		if (!Is.emptyString(action)) {
			m.setActionName(action);
		}		
		fillMetaSetsOfSearchAction(el, m, lang);	
		return m;
	}
	
	private static MetaDescriptionsList createMetaDescriptionsList(Node n, int lang) throws XavaException {
		Element el = (Element) n;		
		MetaDescriptionsList m = new MetaDescriptionsList();
		String descriptionProperty = el.getAttribute(xdescription_property[lang]);
		if (!Is.emptyString(descriptionProperty)) {
			m.setDescriptionPropertyName(descriptionProperty);
		}
		String descriptionProperties = el.getAttribute(xdescription_properties[lang]);
		if (!Is.emptyString(descriptionProperties)) {
			m.setDescriptionPropertiesNames(descriptionProperties);
		}				
		m.setDepends(el.getAttribute(xdepends[lang]));
		m.setCondition(el.getAttribute(xcondition[lang]));
		m.setOrderByKey(ParserUtil.getAttributeBoolean(el, xorder_by_key[lang]));
		m.setOrder(el.getAttribute(xorder[lang]));
		String labelFormat = el.getAttribute(xlabel_format[lang]);
		if (XNORMAL[lang].equals(labelFormat)) m.setLabelFormat(MetaPropertyView.NORMAL_LABEL);
		else if (XSMALL[lang].equals(labelFormat)) m.setLabelFormat(MetaPropertyView.SMALL_LABEL);
		else if (XNO_LABEL[lang].equals(labelFormat)) m.setLabelFormat(MetaPropertyView.NO_LABEL);
		else throw new XavaException("invalid_label_format", labelFormat);
		return m;
	}
	
	
	private static String getMediatorClass(Node n, int lang) throws XavaException {
		Element el = (Element) n;		 
		return el.getAttribute(xclass[lang]);		
	}	
	
	private static void fillMetaSetsOfSearchAction(Element el, MetaSearchAction container, int lang) throws XavaException {
		NodeList l = el.getElementsByTagName(xset[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			Element elPoner = (Element) l.item(i);		
			container.addPropertyValue(
				elPoner.getAttribute(xproperty[lang]),
				elPoner.getAttribute(xvalue[lang]));
		}
	}
	
	private static void fillProperties(Element el, MetaView container, int lang)
		throws XavaException {
		NodeList l = el.getChildNodes();
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			if (!(l.item(i) instanceof Element)) continue;
			Element d = (Element) l.item(i);
			String tipo = d.getTagName();
			if (tipo.equals(xproperty[lang])) {
				container.addMetaViewProperty(ModelParser.createProperty(d, lang));
			}
		}
	}
	
	
				
}