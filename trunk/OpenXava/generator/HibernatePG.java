
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.*;
import org.openxava.mapping.*;
import org.openxava.util.Strings;
import org.openxava.util.XavaException;

/**
 * Program Generator created by TL2Java
 * @version Mon Oct 24 11:48:00 CEST 2005
 */
public class HibernatePG {
    Properties properties = new Properties();

    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
    out.print("\n\n<!-- Generated by OpenXava: ");
    out.print(new Date());
    out.print(" -->");
    
    String packageName = properties.getProperty("arg3");
    String componentName = properties.getProperty("arg4");
    String aggregateName = properties.getProperty("arg5");
    MetaComponent component = MetaComponent.get(componentName);
    
    String name=null;
    IMetaModel metaModel=null;
    if (aggregateName == null) {
    	name=componentName;	
    	metaModel = (IMetaModel) component.getMetaEntity();
    }
    else {
    	name=aggregateName;	
    	metaModel =  (IMetaEjb)component.getMetaAggregate(aggregateName);
    }
    ModelMapping mapping = metaModel.getMapping();
    
    out.print("\n\n<!DOCTYPE hibernate-mapping SYSTEM \"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">\n\n<hibernate-mapping package=\"");
    out.print(packageName);
    out.print("\">\n\n  <class \n  \tname=\"");
    out.print(name);
    out.print("\"\n  \ttable=\"");
    out.print(mapping.getTable());
    out.print("\">");
    
    Collection keyProperties = metaModel.getMetaPropertiesKey(); 
    Collection keyReferences = metaModel.getMetaReferencesKey();
    if (keyProperties.size() + keyReferences.size() == 0) {
    	throw new XavaException("model_without_key_error", name);
    }
    else if (keyProperties.size() == 1 &&  keyReferences.size() == 0) {
    		MetaProperty key = (MetaProperty) keyProperties.iterator().next();
    		PropertyMapping pMapping = key.getMapping();
    		String propertyName = pMapping.hasConverter()?"_"+Strings.firstUpper(key.getName()):key.getName();	
    
    out.print(" \t\n\t\t<id name=\"");
    out.print(propertyName);
    out.print("\" column=\"");
    out.print(pMapping.getColumn());
    out.print("\">\n\t\t\t<generator class=\"assigned\"/>\n\t\t</id>");
    
    }
    else {
    
    out.print(" \n\t\t<composite-id>");
    
    	for (Iterator it = keyProperties.iterator(); it.hasNext();) {
    		MetaProperty key = (MetaProperty) it.next();
    		PropertyMapping pMapping = key.getMapping();
    		String propertyName = pMapping.hasConverter()?"_"+Strings.firstUpper(key.getName()):key.getName();			
    
    out.print(" \t\n\t\t\t<key-property name=\"");
    out.print(propertyName);
    out.print("\" column=\"");
    out.print(pMapping.getColumn());
    out.print("\"/>");
    	
    	}
    
    	for (Iterator it = keyReferences.iterator(); it.hasNext();) {
    		MetaReference key = (MetaReference) it.next();
    		ReferenceMapping pMapping = mapping.getReferenceMapping(key.getName());
    		String referenceName = key.getName();	
    		String className = key.getMetaModelReferenced().getPOJOClassName();		
    		if (mapping.isReferenceOverlappingWithSomeProperty(referenceName)) {
    
    out.print(" \t\t\n\t\t\t<!-- Maping of \"");
    out.print(referenceName);
    out.print("\" : Overlapping references still not supported -->");
    		
    		}
    		else {
    
    out.print(" \t\n\t\t\t<key-many-to-one name=\"");
    out.print(referenceName);
    out.print("\" class=\"");
    out.print(className);
    out.print("\">");
    
    			for (Iterator itC = pMapping.getColumns().iterator(); itC.hasNext();) {
    				String col = (String) itC.next();
    
    out.print(" \t\t\t\n\t\t\t\t<column name=\"");
    out.print(col);
    out.print("\" />");
    
    			}
    
    out.print(" \t\t\t\t\t\t\n\t\t\t</key-many-to-one>");
    	
     		}
     	}
    
    out.print("  \t\n\t\t</composite-id>");
    		
    }
    
    	Collection properties = metaModel.getMetaPropertiesPersistents();
    	for (Iterator it = properties.iterator(); it.hasNext();) {
    		MetaProperty prop = (MetaProperty) it.next();
    		PropertyMapping pMapping = prop.getMapping();
    		String propertyName = pMapping.hasConverter()?"_"+Strings.firstUpper(prop.getName()):prop.getName();			
    		if (!prop.isKey()) {
    			if (pMapping.hasMultipleConverter()) {
    
    out.print(" \n\t\t<!--  Mapping of \"");
    out.print(propertyName);
    out.print("\" : multiple columns mapping still not supported -->");
    			
    			}
    			else {
    
    out.print(" \t\n\t\t<property name=\"");
    out.print(propertyName);
    out.print("\" column=\"");
    out.print(pMapping.getColumn());
    out.print("\"/>");
    
    			} 	
    		} 
    	}
     
    Iterator itReferences = metaModel.getMetaReferences().iterator();	
    while (itReferences.hasNext()) {	
    	MetaReference reference = (MetaReference) itReferences.next();
    	if (reference.isKey()) continue;
    	String referenceName = Strings.firstUpper(reference.getName());	
    	if (reference.getMetaModelReferenced() instanceof MetaAggregateBean) {	
    		for (Iterator itAggregateProperties = reference.getMetaModelReferenced().getMetaPropertiesPersistents().iterator(); itAggregateProperties.hasNext();) {	
    			MetaProperty property = (MetaProperty) itAggregateProperties.next();
    			String propertyName = "_" + referenceName + "_" + property.getName();
    			String column = mapping.getColumn(reference.getName() + "_" + property.getName()); 
    
    out.print(" \n\t\t<property name=\"");
    out.print(propertyName);
    out.print("\" column=\"");
    out.print(column);
    out.print("\"/>");
               
    		} 
    		for (Iterator itAggregateReferences = reference.getMetaModelReferenced().getMetaReferences().iterator(); itAggregateReferences.hasNext();) {	
    			MetaReference ref = (MetaReference) itAggregateReferences.next();
    			String refName = reference.getName() + "_" + ref.getName();
    			Collection columns = mapping.getReferenceMapping(reference.getName() + "_" + ref.getName()).getColumns();   
      			if (columns.size() == 1) {	
    				String column = (String) columns.iterator().next();
    
    out.print(" \n\t\t<many-to-one name=\"");
    out.print(refName);
    out.print("\" column=\"");
    out.print(column);
    out.print("\" class=\"");
    out.print(ref.getMetaModelReferenced().getPOJOClassName());
    out.print("\"/>");
    
    			}
    			else { 
    
    out.print(" \n\t\t<!--  Mapping of \"");
    out.print(reference.getName() + "_" + ref.getName());
    out.print("\": multiple key still not supported -->");
    
    			}         
    		}
    	} 
    	else { // reference to entity or persistent aggregate 
    		Collection columns = mapping.getReferenceMapping(reference.getName()).getColumns();   
      		if (columns.size() == 1) {	
    			String column = (String) columns.iterator().next();
    
    out.print(" \n\t\t<many-to-one name=\"");
    out.print(reference.getName());
    out.print("\" column=\"");
    out.print(column);
    out.print("\" class=\"");
    out.print(reference.getMetaModelReferenced().getPOJOClassName());
    out.print("\"/>");
    
    		}
    		else { 
    
    out.print(" \n\t\t<!--  Mapping of \"");
    out.print(reference.getName());
    out.print("\": multiple key still not supported -->");
    
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
    	String cascadeDelete = isAggregate?"cascade='delete'":"";
    	String roleName = col.getMetaReference().getRole();	 
    	Collection columns = col.getMetaReference().getMetaModelReferenced().getMapping().getReferenceMapping(roleName).getColumns();
    	Collection cKeys = col.getMetaReference().getMetaModelReferenced().getAllKeyPropertiesNames();
    	String nKeys = Strings.toString(cKeys);          		
    	if (columns.size() == 1) {	
    		String column = (String) columns.iterator().next();
    
    out.print("  \n\t\t<set name=\"");
    out.print(col.getName());
    out.print("\" order-by=\"");
    out.print(nKeys);
    out.print("\" ");
    out.print(cascadeDelete);
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
    out.print(nKeys);
    out.print("\" ");
    out.print(cascadeDelete);
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
    
    
    out.print(" \t\n  </class>\n\n</hibernate-mapping>");
    
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
        { "Mon Oct 24 11:48:00 CEST 2005", // date this file was generated
             "/home/javi/workspace/OpenXava/generator/hibernate.xml", // input file
             "/home/javi/workspace/OpenXava/generator/HibernatePG.java" }, // output file
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