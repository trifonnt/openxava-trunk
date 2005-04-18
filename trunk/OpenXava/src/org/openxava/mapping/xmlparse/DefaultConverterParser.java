package org.openxava.mapping.xmlparse;

import org.openxava.mapping.*;
import org.openxava.util.*;
import org.openxava.util.xmlparse.*;
import org.w3c.dom.*;

/**
 * @author: Javier Paniza
 */
public class DefaultConverterParser extends ParserBase {

	public DefaultConverterParser(String urlArchivoXml, int language) {
		super(urlArchivoXml, language);
	}
	
	public static void configureDefaultConverter() throws XavaException {
		DefaultConverterParser enParser = new DefaultConverterParser("default-converter.xml", ENGLISH);
		enParser.parse();		
		DefaultConverterParser esParser = new DefaultConverterParser("conversor-defecto.xml", ESPA�OL);
		esParser.parse();
	}
	
	private void createForStereotype(Node n) throws XavaException {
		Element el = (Element) n;
		String stereotype = el.getAttribute(xstereotype[lang]);		
		String converterClass = el.getAttribute(xconverter_class[lang]);
		String cmpType = el.getAttribute(xcmp_type[lang]);
		DefaultConverter._addForStereotype(stereotype, converterClass, cmpType);
	}
	
	private void createForType(Node n) throws XavaException {
		Element el = (Element) n;
		String type = el.getAttribute(xtype[lang]);
		String converterClass = el.getAttribute(xconverter_class[lang]);
		String cmpType = el.getAttribute(xcmp_type[lang]);
		DefaultConverter._addForType(type, converterClass, cmpType);
	}
		
	private void createForStereotypes() throws XavaException {
		NodeList l = getRoot().getElementsByTagName(xfor_stereotype[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			createForStereotype(l.item(i));
		}
	}
	
	private void createForTypes() throws XavaException {
		NodeList l = getRoot().getElementsByTagName(xfor_type[lang]);
		int c = l.getLength();
		for (int i = 0; i < c; i++) {
			createForType(l.item(i));
		}
	}	
	
	protected void createObjects() throws XavaException {
		createForStereotypes();
		createForTypes();
	}
			
}