
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.*;
import org.openxava.mapping.*;
import org.openxava.util.*;

/**
 * Program Generator created by TL2Java
 * @version Wed Mar 18 12:26:36 CET 2015
 */
public class HibernatePG {
    Properties properties = new Properties();
 

private String getSizeAttributes(MetaProperty property) throws XavaException {
	if (property.isNumber() && !property.isKey()) {
		int scale = property.getScale();
		return "precision='" + property.getSize() + "' scale='" + scale + "'";
	}
	else {
		return "length='" + property.getSize() + "'";
	}
}

/**
 * This method adds database check constraint to column which given valid values.
 * @author Radoslaw Ostrzycki, Newitech Sp. z o.o.
 * @param property the property
 */
private String getCheck(MetaProperty property) throws XavaException {
	if (property.isNumber() && !property.isKey() && property.hasValidValues()) {
		int startsWith = (property.isRequired()) ? 1 : 0;
		int endsWith = 0;
		for(Iterator i=property.validValues(); i.hasNext(); i.next()) {
			endsWith++;
		}
			
		return " check='" + property.getMapping().getColumn() + " between " + startsWith + " and " + endsWith + "'";
	}
	else {
		return "";
	}
}



    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print("<?xml version=\"1.0\" encoding=\"");
    out.print(org.openxava.util.XSystem.getEncoding());
    out.print("\"?>");
    out.print(" \n\n<!-- Generated by OpenXava: ");
    out.print(new Date());
    out.print(" -->");
    
    String packageName = properties.getProperty("arg3");
    String componentName = properties.getProperty("arg4");
    String aggregateName = properties.getProperty("arg5");
    MetaComponent component = MetaComponent.get(componentName);
    
    String name=null;
    MetaModel metaModel=null;
    if (aggregateName == null) {
    	name=componentName;	
    	metaModel = component.getMetaEntity();
    }
    else {
    	name=aggregateName;	
    	metaModel = component.getMetaAggregate(aggregateName);
    }
    ModelMapping mapping = metaModel.getMapping();
    
    out.print("\n\n<!DOCTYPE hibernate-mapping SYSTEM \"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">\n\n<hibernate-mapping package=\"");
    out.print(packageName);
    out.print("\">\n\n  <class \n  \tname=\"");
    out.print(name);
    out.print("\"");
    if (mapping.getSchema() != null) {  
    out.print(" schema=\"");
    out.print(mapping.getSchema());
    out.print("\"");
    } 
    out.print(" \n  \ttable=\"");
    out.print(mapping.getUnqualifiedTable());
    out.print("\">");
    
    Collection keyMembers = metaModel.getMetaMembersKey();
    Collection keyProperties = metaModel.getMetaPropertiesKey(); 
    if (keyMembers.size() == 0) {
    	throw new XavaException("model_without_key_error", name);
    }
    else if (keyProperties.size() == 1 &&  keyMembers.size() == 1) {
    		MetaProperty key = (MetaProperty) keyProperties.iterator().next();
    		PropertyMapping pMapping = key.getMapping();
    		String propertyName = key.getName();	
    		String generator = key.isHidden() && !key.hasCalculatorDefaultValueOnCreate()?"native":"assigned";
    		String type = "type='" + pMapping.getCmpTypeName() + "'";
    
    out.print(" \t\n\t\t<id name=\"");
    out.print(propertyName);
    out.print("\" column=\"");
    out.print(pMapping.getColumn());
    out.print("\" access=\"field\" ");
    out.print(type);
    out.print(" ");
    out.print(getSizeAttributes(key));
    out.print(">");
    if (key.hasCalculatorDefaultValueOnCreate()) { 
    if (key.isDefaultCalculatorHibernateIdGenerator()) { 
    out.print(" \n\t\t\t");
    out.print(key.getHbmGeneratorCode());
    } else { 
    out.print(" \n\t\t\t<generator class=\"org.openxava.hibernate.impl.DefaultValueIdentifierGenerator\">\n\t\t\t\t<param name=\"property\">");
    out.print(propertyName);
    out.print("</param>\n\t\t\t</generator>");
    } 
    } else { 
    out.print(" \n\t\t\t<generator class=\"");
    out.print(generator);
    out.print("\"/>");
    } 
    out.print(" \n\t\t</id>");
    
    }
    else {
    
    out.print(" \n\t\t<composite-id>");
    
    	for (Iterator it = keyMembers.iterator(); it.hasNext();) {
        	MetaMember key = (MetaMember) it.next();
        	if (key instanceof MetaProperty) {
    			PropertyMapping pMapping = ((MetaProperty) key).getMapping();
    			String propertyName = key.getName();			
    			String type = "type='" + pMapping.getCmpTypeName() + "'";			
    
    out.print(" \t\n\t\t\t<key-property name=\"");
    out.print(propertyName);
    out.print("\" column=\"");
    out.print(pMapping.getColumn());
    out.print("\" access=\"field\" ");
    out.print(type);
    out.print(" ");
    out.print(getSizeAttributes((MetaProperty)key));
    out.print("/>");
    
    		}
    		if (key instanceof MetaReference) {
    			if (mapping.isReferenceOverlappingWithSomeProperty(key.getName())) {
    				for (Iterator itDetails = mapping.getReferenceMapping(key.getName()).getDetails().iterator(); itDetails.hasNext(); ) {
    					ReferenceMappingDetail detail = (ReferenceMappingDetail) itDetails.next();
    					if (!mapping.isReferenceOverlappingWithSomeProperty(key.getName(), detail.getReferencedModelProperty())) {
    					MetaProperty metaPropertyInReferencedModel = (MetaProperty) ((MetaReference) key).getMetaModelReferenced().getMetaProperty(detail.getReferencedModelProperty());
    
    out.print(" \n\t\t\t<key-property name=\"");
    out.print(key.getName());
    out.print("_");
    out.print(Strings.change(detail.getReferencedModelProperty(), ".", "_"));
    out.print("\" column=\"");
    out.print(detail.getColumn());
    out.print("\" access=\"field\" ");
    out.print(getSizeAttributes(metaPropertyInReferencedModel));
    out.print("/>");
    			
    					}
    				}		
    			}
    			else {
    				ReferenceMapping pMapping = mapping.getReferenceMapping(key.getName());
    				String referenceName = key.getName();	
    				String className = ((MetaReference) key).getMetaModelReferenced().getPOJOClassName();		
    
    out.print(" \t\n\t\t\t<key-many-to-one name=\"");
    out.print(referenceName);
    out.print("\" class=\"");
    out.print(className);
    out.print("\">");
    
    				for (Iterator itC = pMapping.getColumns().iterator(); itC.hasNext();) {
    					String col = (String) itC.next();				
    
    out.print(" \t\t\t\n\t\t\t\t<column name=\"");
    out.print(col);
    out.print("\"/>");
    
    				}			
    
    out.print(" \t\t\t\t\t\t\n\t\t\t</key-many-to-one>");
    	
    			}
     		} 		
     	}	
    
    out.print("  \t\n\t\t</composite-id>");
    		
    }
    
    if (metaModel.hasVersionProperty()) { 	
    	MetaProperty versionProperty = metaModel.getMetaProperty(metaModel.getVersionPropertyName());
    
    out.print(" \n\t\t<version name=\"");
    out.print(versionProperty.getName());
    out.print("\" access=\"field\" type='");
    out.print(versionProperty.getTypeName());
    out.print("' column=\"");
    out.print(versionProperty.getMapping().getColumn());
    out.print("\"/>");
    
    }  	 
    
    
    	Collection properties = metaModel.getMetaPropertiesPersistents();
    	for (Iterator it = properties.iterator(); it.hasNext();) {
    		MetaProperty prop = (MetaProperty) it.next();
    		PropertyMapping pMapping = prop.getMapping();
    		String propertyName = prop.getName();			
    		if (!prop.isKey() && !prop.isVersion()) {
    			if (pMapping.hasMultipleConverter()) {
    				for (Iterator itCmpFields = pMapping.getCmpFields().iterator(); itCmpFields.hasNext();) {					
    					CmpField field = (CmpField) itCmpFields.next();
    
    out.print(" \n\t\t<property name=\"");
    out.print(propertyName);
    out.print("_");
    out.print(field.getConverterPropertyName());
    out.print("\" column=\"");
    out.print(field.getColumn());
    out.print("\" access=\"field\" type=\"");
    out.print(field.getCmpTypeName());
    out.print("\"/>");
    				
    				}
    			}
    			else {
    				String type = "type='" + pMapping.getCmpTypeName() + "'"; 
    
    out.print(" \n\t\t<property name=\"");
    out.print(propertyName);
    out.print("\" access=\"field\" ");
    out.print(type);
    out.print(" ");
    out.print(getSizeAttributes(prop));
    out.print(">");
    				if (pMapping.hasFormula()) { 
    out.print(" \n\t\t \t<formula>");
    out.print(pMapping.getFormula());
    out.print("</formula>");
    				} else { 
    out.print("  \n\t\t\t<column name=\"");
    out.print(pMapping.getColumn());
    out.print("\" ");
    out.print(getCheck(prop));
    out.print(" />");
    				} 
    out.print("\n\t\t</property>");
    
    			} 	
    		} 
    	}
     
    Iterator itReferences = metaModel.getMetaReferences().iterator();	
    while (itReferences.hasNext()) {	
    	MetaReference reference = (MetaReference) itReferences.next();
    	if (reference.isKey() && !mapping.isReferenceOverlappingWithSomeProperty(reference.getName())) continue;
    	if (reference.getMetaModelReferenced() instanceof MetaAggregateForReference) {	
    		for (Iterator itAggregateProperties = reference.getMetaModelReferenced().getMetaPropertiesPersistentsFromReference(reference.getName()).iterator(); itAggregateProperties.hasNext();) {	
    			MetaProperty property = (MetaProperty) itAggregateProperties.next();
    			String propertyName = reference.getName() + "_" + property.getName();
    			String column = mapping.getColumn(reference.getName() + "_" + property.getName()); 
    			String type = "type='" + property.getMapping().getCmpTypeName() + "'";			
    
    out.print(" \n\t\t<property name=\"");
    out.print(propertyName);
    out.print("\" access=\"field\" ");
    out.print(type);
    out.print(" ");
    out.print(getSizeAttributes(property));
    out.print(">\n\t\t \t<column name=\"");
    out.print(column);
    out.print("\" ");
    out.print(getCheck(property));
    out.print(" />\n\t\t</property>");
    
    		} 
    		for (Iterator itAggregateReferences = reference.getMetaModelReferenced().getMetaReferences().iterator(); itAggregateReferences.hasNext();) {	
    			MetaReference ref = (MetaReference) itAggregateReferences.next();
    			String refName = reference.getName() + "_" + ref.getName();
    			Collection columns = mapping.getReferenceMapping(reference.getName() + "_" + ref.getName()).getColumns();   
    			boolean overlapped = mapping.isReferenceOverlappingWithSomeProperty(reference.getName() + "_" + ref.getName());
    			String insertUpdate = overlapped?"insert='false' update='false'":"";
    			if (columns.size() == 1) {	
    				String column = (String) columns.iterator().next();
    
    out.print(" \n\t\t<many-to-one name=\"");
    out.print(refName);
    out.print("\" column=\"");
    out.print(column);
    out.print("\" class=\"");
    out.print(ref.getMetaModelReferenced().getPOJOClassName());
    out.print("\" ");
    out.print(insertUpdate);
    out.print(" access=\"field\" />");
    
    			}
    			else { 
    
    out.print(" \n\t\t<many-to-one name=\"");
    out.print(refName);
    out.print("\" class=\"");
    out.print(ref.getMetaModelReferenced().getPOJOClassName());
    out.print("\" ");
    out.print(insertUpdate);
    out.print(" access=\"field\">");
    
    			for (Iterator itC = columns.iterator(); itC.hasNext();) {
    				String col = (String) itC.next();
    
    out.print(" \n\t\t\t<column name=\"");
    out.print(col);
    out.print("\" />");
    
    			}
    
    out.print(" \n\t\t</many-to-one>");
    
    			}         
    			if (overlapped) {
    				for (Iterator itDetails = mapping.getReferenceMapping(reference.getName() + "_" + ref.getName()).getDetails().iterator(); itDetails.hasNext(); ) {
    					ReferenceMappingDetail detail = (ReferenceMappingDetail) itDetails.next();
    					if (!mapping.isReferenceOverlappingWithSomeProperty(reference.getName() + "_" + ref.getName(), detail.getReferencedModelProperty())) {
    					MetaProperty metaPropertyInReferencedModel = (MetaProperty) ref.getMetaModelReferenced().getMetaProperty(detail.getReferencedModelProperty());
    
    out.print(" \n\t\t<property name=\"");
    out.print(reference.getName());
    out.print("_");
    out.print(ref.getName());
    out.print("_");
    out.print(Strings.change(detail.getReferencedModelProperty(), ".", "_"));
    out.print("\" column=\"");
    out.print(detail.getColumn());
    out.print("\" access=\"field\" ");
    out.print(getSizeAttributes(metaPropertyInReferencedModel));
    out.print("/>");
    			
    					}
    				}		
    			}
    		}
    	} 
    	else { // reference to entity or persistent aggregate 
    		Collection columns = mapping.getReferenceMapping(reference.getName()).getColumns();   
    		boolean overlapped = mapping.isReferenceOverlappingWithSomeProperty(reference.getName());
    		String insertUpdate = overlapped || reference.isKey()?"insert='false' update='false'":"";
    		String lazy = overlapped && reference.isKey()?"lazy='false'":"";
    		if (columns.size() == 1) {	
    			String column = (String) columns.iterator().next();
    
    out.print(" \n\t\t<many-to-one name=\"");
    out.print(reference.getName());
    out.print("\" column=\"");
    out.print(column);
    out.print("\" class=\"");
    out.print(reference.getMetaModelReferenced().getPOJOClassName());
    out.print("\" ");
    out.print(insertUpdate);
    out.print(" ");
    out.print(lazy);
    out.print(" access=\"field\"/>");
    
    		}
    		else { 
    
    out.print(" \n\t\t<many-to-one name=\"");
    out.print(reference.getName());
    out.print("\" class=\"");
    out.print(reference.getMetaModelReferenced().getPOJOClassName());
    out.print("\" ");
    out.print(insertUpdate);
    out.print(" ");
    out.print(lazy);
    out.print(" access=\"field\">");
    
    			for (Iterator itC = columns.iterator(); itC.hasNext();) {
    				String col = (String) itC.next();
    
    out.print(" \n\t\t\t<column name=\"");
    out.print(col);
    out.print("\"/>");
    			
    			}
    
    out.print(" \n\t\t</many-to-one>");
    			
    		}
    		if (overlapped && !reference.isKey()) {
    			for (Iterator itDetails = mapping.getReferenceMapping(reference.getName()).getDetails().iterator(); itDetails.hasNext(); ) {
    				ReferenceMappingDetail detail = (ReferenceMappingDetail) itDetails.next();
    				if (!mapping.isReferenceOverlappingWithSomeProperty(reference.getName(), detail.getReferencedModelProperty())) {
    				MetaProperty metaPropertyInReferencedModel = (MetaProperty) reference.getMetaModelReferenced().getMetaProperty(detail.getReferencedModelProperty());
    
    out.print(" \n\t\t<property name=\"");
    out.print(reference.getName());
    out.print("_");
    out.print(Strings.change(detail.getReferencedModelProperty(), ".", "_"));
    out.print("\" column=\"");
    out.print(detail.getColumn());
    out.print("\" access=\"field\" ");
    out.print(getSizeAttributes(metaPropertyInReferencedModel));
    out.print("/>");
    			
    				}
    			}		
    		}
    	}
    } 
     
    Iterator itCollections = metaModel.getMetaCollections().iterator();	
    while (itCollections.hasNext()) {	
    	MetaCollection col = (MetaCollection) itCollections.next();
    	if (col.hasCalculator() || col.hasCondition()) {
    		continue;
    	}
    	boolean isAggregate = col.getMetaReference().getMetaModelReferenced() instanceof MetaAggregate;
    	String roleName = col.getMetaReference().getRole();	 
    	boolean inverseReferenceIsKey = col.getMetaReference().getMetaModelReferenced().getMetaReference(roleName).isKey();
    	String cascadeDelete = isAggregate?"cascade='delete'":"";
    	String inverse = isAggregate || inverseReferenceIsKey?"inverse='true'":"";	
    	ModelMapping referencedMapping = col.getMetaReference().getMetaModelReferenced().getMapping();
    	Collection columns = referencedMapping.getReferenceMapping(roleName).getColumns();
    	String order = col.orderHasQualifiedProperties()?null:col.getSQLOrder();
    	if (Is.emptyString(order)) {
    		Collection cKeys = col.getMetaReference().getMetaModelReferenced().getAllKeyPropertiesNames();
    		StringBuffer nKeys = new StringBuffer();
    		for (Iterator it = cKeys.iterator(); it.hasNext();) {
    			nKeys.append(referencedMapping.getColumn((String) it.next()));
    			if (it.hasNext()) nKeys.append(", ");
    		}
    		order = nKeys.toString();
    	}
    	if (columns.size() == 1) {	
    		String column = (String) columns.iterator().next();
    
    out.print("  \n\t\t<set name=\"");
    out.print(col.getName());
    out.print("\" order-by=\"");
    out.print(order);
    out.print("\" ");
    out.print(cascadeDelete);
    out.print(" ");
    out.print(inverse);
    out.print(">\n\t\t\t<key column=\"");
    out.print(column);
    out.print("\"/>\n\t\t\t<one-to-many class=\"");
    out.print(col.getMetaReference().getMetaModelReferenced().getName());
    out.print("\"/>\n\t\t</set>");
    
    	}	
    	else { 
    
    out.print(" \n\t\t<set name=\"");
    out.print(col.getName());
    out.print("\" order-by=\"");
    out.print(order);
    out.print("\" ");
    out.print(cascadeDelete);
    out.print(" ");
    out.print(inverse);
    out.print(">\n\t\t\t<key>");
    
    		Iterator itCol = columns.iterator();	
    		while (itCol.hasNext()) {	
    			String column = (String) itCol.next();
    
    out.print(" \t\t\t\n\t\t\t\t<column name=\"");
    out.print(column);
    out.print("\"/>");
    			
    		}	
    
    out.print(" \n\t\t\t</key>\t\n\t\t\t<one-to-many class=\"");
    out.print(col.getMetaReference().getMetaModelReferenced().getName());
    out.print("\"/>\n\t\t</set>");
    
    	}
    
    }
    
    
    
    for (Iterator it=mapping.getPropertyMappingsNotInModel().iterator(); it.hasNext(); ) {
    	PropertyMapping pm = (PropertyMapping) it.next();
    
    out.print(" \t\n\t\t<property name=\"");
    out.print(pm.getProperty());
    out.print("\" access=\"field\" column=\"");
    out.print(pm.getColumn());
    out.print("\"/>");
    
    }
    
    out.print(" \n  </class>\n\n</hibernate-mapping>");
    
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * A program generator is typically (but not always) invoked
     * with a command line with arguments for the XML input file
     * and output file.
     */    
    public static void main(String[] args) {
        try {
            ProgramWriter out = args.length>=2
                ?new ProgramWriter(new FileOutputStream(args[1]))
                :new ProgramWriter(System.out);
            HibernatePG pg = new HibernatePG();
            for (int j=1; j<=args.length; ++j) {
                pg.properties.put("arg"+j, args[j-1]);
            }
            pg.generate(new XPathContext(args[0]), out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This array provides program generator development history
     */
    public String[][] history = {
        { "Wed Mar 18 12:26:38 CET 2015", // date this file was generated
             "../OpenXava/generator/hibernate.xml", // input file
             "../OpenXava/generator/HibernatePG.java" }, // output file
        {"Mon Apr 09 16:45:30 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Mon Apr 09 16:39:37 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Mon Apr 09 16:37:21 EDT 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 14:49:11 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 14:30:24 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 11:13:01 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Fri Feb 09 10:57:04 EST 2001", "TL2Java.xml", "TL2Java.java", }, 
        {"Wed Apr 26 11:15:41 EDT 2000", "..\\input\\TL2Java.xml", "TL2Java1.java", }, 
        {"April 2000", "hand coded", "TL2Java1.java", }, 

    };
}