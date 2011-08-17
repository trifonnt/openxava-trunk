
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.util.*;
import org.openxava.util.meta.MetaSet;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.*;
import org.openxava.calculators.*;
import org.openxava.generators.*;
import org.openxava.mapping.*;

/**
 * Program Generator created by TL2Java
 * @version Wed Aug 03 11:31:51 CEST 2011
 */
public class PojoPG {
    Properties properties = new Properties();

    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    
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
    
    
    
    out.print("\n// File generated by OpenXava: ");
    out.print(new Date());
    out.print("\n// Archivo generado por OpenXava: ");
    out.print(new Date());
    out.print("\n\n// WARNING: NO EDIT\n// OJO: NO EDITAR");
    if (aggregateName == null) { 
    out.print("\n// Component: ");
    out.print(componentName);
    out.print("\t\tEntity/Entidad");
    } else { 
    out.print("\n// Component: ");
    out.print(componentName);
    out.print("\t\tAggregate/Agregado: ");
    out.print(aggregateName);
    } 
    out.print("\n\npackage ");
    out.print(packageName);
    out.print(";\n\nimport java.util.*;\nimport java.math.*;\nimport java.rmi.RemoteException;\nimport org.openxava.component.MetaComponent;\nimport org.openxava.model.meta.MetaModel;\nimport org.openxava.util.*;\n\n/**\n * \n * @author MCarmen Gimeno\n */\npublic class ");
    out.print(name);
    out.print(" implements java.io.Serializable, ");
    out.print(metaModel.getInterfaceName());
    out.print(" {\t\n\n\t// Constructor\n\tpublic ");
    out.print(name);
    out.print("() {\n\t\tinitMembers();\n\t}");
    InitMembersPG.generate(context, out, metaModel, false); 
    out.print(" \n\t\n\t// Properties/Propiedades");
    
    Iterator itProperties = metaModel.getMetaProperties().iterator();	
    while (itProperties.hasNext()) {	
    	MetaProperty property = (MetaProperty) itProperties.next();
    	PropertyPG.generate(context, out, property); 
    }
    
    out.print(" \n\n\t// References/Referencias");
    
    Iterator itReferences = metaModel.getMetaReferences().iterator();	
    while (itReferences.hasNext()) {	
    	MetaReference ref = (MetaReference) itReferences.next();
    	if (ref.getMetaModelReferenced() instanceof MetaAggregateForReference) {
    		AggregateReferencePG.generate(context, out, ref); 
    	}
    	else {
    		EntityReferencePG.generate(context, out, ref); 
    	}
    }
    
    out.print(" \n\n\t// Colecciones/Collections");
    
    Iterator itCollections = metaModel.getMetaCollections().iterator();	
    while (itCollections.hasNext()) {	
    	MetaCollection col = (MetaCollection) itCollections.next();
    	String colName = Strings.firstUpper(col.getName());
    	MetaReference reference = col.getMetaReference();
    	String colType = reference.getMetaModelReferenced().getInterfaceName();
    	String roleName = Strings.firstUpper(reference.getRole());
    	if (!col.hasCondition() && !col.hasCalculator()) {
    
    out.print(" \n\tprivate java.util.Collection ");
    out.print(col.getName());
    out.print(";\n\tpublic java.util.Collection get");
    out.print(colName);
    out.print("() {\n\t\treturn ");
    out.print(col.getName());
    out.print(";\n\t}\n\tpublic void set");
    out.print(colName);
    out.print("(java.util.Collection ");
    out.print(col.getName());
    out.print(") {\n\t\tthis.");
    out.print(col.getName());
    out.print(" = ");
    out.print(col.getName());
    out.print(";\n\t}");
    
    	}
    	if (col.hasCondition()) {
    
    out.print(" \n\tpublic java.util.Collection get");
    out.print(colName);
    out.print("() throws RemoteException {\n\t\tif (XavaPreferences.getInstance().isJPAPersistence()) return get");
    out.print(colName);
    out.print("_jpa();\n\t\telse return get");
    out.print(colName);
    out.print("_hibernate();\n\t}\n\t\n\tprivate java.util.Collection get");
    out.print(colName);
    out.print("_hibernate() throws RemoteException {\n\t\torg.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery(\"");
    out.print(col.getHQLCondition());
    out.print("\");");
    
    		int i=0;
    		for (Iterator it = col.getMetaPropertiesFinderArguments(true).iterator(); it.hasNext(); i++) {
    			MetaProperty parameter = (MetaProperty) it.next();
    			String argument = Generators.convertPropertyNameInPropertyCall(parameter.getName());
    			if (parameter.getType().isPrimitive()) {
    				argument = Generators.generatePrimitiveWrapper(parameter.getTypeName(), argument);
    			}
    
    out.print("\n\t\tquery.setParameter(");
    out.print(i);
    out.print(", ");
    out.print(argument);
    out.print(");");
    		
    		}
    
    out.print(" \t \n\t\treturn query.list();\n\t}\t\n\n\tprivate java.util.Collection get");
    out.print(colName);
    out.print("_jpa() throws RemoteException {");
    if (!XavaPreferences.getInstance().isJPACodeInPOJOs()) { 
    out.print(" \n\t\tthrow new RuntimeException(XavaResources.getString(\"jpa_code_not_generated\"));\n\t\t/*\n\t\t// The next code is commented in order to compile this code in Java 1.4\n\t\t// If you want to use JPA put in xava.properties:\n\t\t// jpaCodeInPOJOs=true\n\t\t// and regenerate code");
    } 
    out.print("\n\t\tjavax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery(\"");
    out.print(col.getJPACondition());
    out.print("\");");
    
    		i=0;
    		for (Iterator it = col.getMetaPropertiesFinderArguments(true).iterator(); it.hasNext(); i++) {
    			MetaProperty parameter = (MetaProperty) it.next();
    			String argument = Generators.convertPropertyNameInPropertyCall(parameter.getName());
    			if (parameter.getType().isPrimitive()) {
    				argument = Generators.generatePrimitiveWrapper(parameter.getTypeName(), argument);
    			}
    
    out.print("\n\t\tquery.setParameter(");
    out.print(i);
    out.print(", ");
    out.print(argument);
    out.print(");");
    		
    		}
    
    out.print(" \n\t\treturn query.getResultList();");
    if (!XavaPreferences.getInstance().isJPACodeInPOJOs()) { 
    out.print(" \n\t\t*/");
    } 
    out.print(" \n\t}");
    
    	}
    	else if (col.hasCalculator()) {
    		CalculatedCollectionPG.generate(context, out, col);	
    	}
    	if (!reference.isAggregate() && 
    		!col.hasCondition() && 
    		!col.hasCalculator() && 
    		!reference.getMetaModelReferenced().getMetaReference(reference.getRole()).isKey()) { 
    
    out.print(" \n\t\n\tpublic void addTo");
    out.print(colName);
    out.print("(");
    out.print(colType);
    out.print(" newElement) throws RemoteException {\n\t\tthis.get");
    out.print(colName);
    out.print("().add(newElement);\n\t\tnewElement.set");
    out.print(roleName);
    out.print("(this);\n\t}\n\tpublic void removeFrom");
    out.print(colName);
    out.print("(");
    out.print(colType);
    out.print(" toRemove) throws RemoteException {\n\t\tthis.get");
    out.print(colName);
    out.print("().remove(toRemove);\n\t\ttoRemove.set");
    out.print(roleName);
    out.print("(null);\n\t}");
    
    	}
    
    
    }
    
    	
    	MethodsPG.generate(context, out, metaModel); 
    
    out.print(" \t\n\n\t// User defined finders/Buscadores definidos por el usuario");
    
    
     Iterator itFinders = metaModel.getMetaFinders().iterator();
     while (itFinders.hasNext()) {
     	MetaFinder finder = (MetaFinder) itFinders.next();
     	String finderName = Strings.firstUpper(finder.getName());
     	String arguments = finder.getArguments();
     	String condition = finder.getEJBQLCondition(); 	
     	String type = finder.isCollection()?"Collection":name;
     	String exception = finder.isCollection()?"":"throws javax.ejb.ObjectNotFoundException";
    
    out.print(" \t\n \tpublic static ");
    out.print(type);
    out.print(" find");
    out.print(finderName);
    out.print("(");
    out.print(arguments);
    out.print(") ");
    out.print(exception);
    out.print(" {\n \t\tif (XavaPreferences.getInstance().isJPAPersistence()) {");
    if (!XavaPreferences.getInstance().isJPACodeInPOJOs()) { 
    out.print(" \n\t\t\tthrow new RuntimeException(XavaResources.getString(\"jpa_code_not_generated\"));\n\t\t\t/*\n\t\t\t// The next code is commented in order to compile this code in Java 1.4\n\t\t\t// If you want to use JPA put in xava.properties:\n\t\t\t// jpaCodeInPOJOs=true\n\t\t\t// and regenerate code");
    } 
    out.print(" \t\t\t\n \t\t\tjavax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery(\"");
    out.print(finder.getHQLCondition());
    out.print("\");");
    
    		int i=0;
    		for (Iterator it = finder.getMetaPropertiesArguments().iterator(); it.hasNext(); i++) {
    			MetaProperty parameter = (MetaProperty) it.next();
    			String argument = parameter.getName();
    			if (parameter.getType().isPrimitive()) {
    				argument = Generators.generatePrimitiveWrapper(parameter.getTypeName(), argument);
    			}
    
    out.print(" \n\t\t\tquery.setParameter(\"arg");
    out.print(i);
    out.print("\", ");
    out.print(argument);
    out.print(");");
    
    		}
    
    if (finder.isCollection()) { 
    out.print(" \n \t\t\treturn query.getResultList();");
    } else { 
    out.print(" \n \t\t\ttry {\n\t\t\t\treturn (");
    out.print(name);
    out.print(") query.getSingleResult();\n\t\t\t}\n\t\t\tcatch (Exception ex) {\n\t\t\t\t// In this way in order to work with Java pre 5 \n\t\t\t\tif (ex.getClass().getName().equals(\"javax.persistence.NoResultException\")) {\n\t\t\t\t\tthrow new javax.ejb.ObjectNotFoundException(XavaResources.getString(\"object_not_found\", \"");
    out.print(name);
    out.print("\"));\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tex.printStackTrace();\n\t\t\t\t\tthrow new RuntimeException(ex.getMessage());\n\t\t\t\t}\n\t\t\t}");
    } 
    if (!XavaPreferences.getInstance().isJPACodeInPOJOs()) { 
    out.print(" \n\t\t\t*/");
    } 
    out.print("  \t\t\n \t\t}\n \t\telse {\n \t\t\torg.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery(\"");
    out.print(finder.getHQLCondition());
    out.print("\");");
    if (finder.isCollection()) { 
    out.print(" \n \t\t\torg.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery(\"");
    out.print(finder.getHQLCountSentence());
    out.print("\");");
    } 
    
    		i=0;
    		for (Iterator it = finder.getMetaPropertiesArguments().iterator(); it.hasNext(); i++) {
    			MetaProperty parameter = (MetaProperty) it.next();
    			String argument = parameter.getName();
    			if (parameter.getType().isPrimitive()) {
    				argument = Generators.generatePrimitiveWrapper(parameter.getTypeName(), argument);
    			}
    
    out.print(" \n\t\t\tquery.setParameter(\"arg");
    out.print(i);
    out.print("\", ");
    out.print(argument);
    out.print(");");
    if (finder.isCollection()) { 
    out.print(" \n\t\t\tsizeQuery.setParameter(\"arg");
    out.print(i);
    out.print("\", ");
    out.print(argument);
    out.print(");");
    } 
    
    		}
    
    if (finder.isCollection()) { 
    out.print(" \n \t\t\treturn new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery);");
    } else { 
    out.print(" \n\t\t\t");
    out.print(name);
    out.print(" r = (");
    out.print(name);
    out.print(") query.uniqueResult();\n\t\t\tif (r == null) {\n\t\t\t\tthrow new javax.ejb.ObjectNotFoundException(XavaResources.getString(\"object_not_found\", \"");
    out.print(name);
    out.print("\"));\n\t\t\t}\n\t\t\treturn r;");
    } 
    out.print(" \n \t\t}\n \t}");
    
     }
    
    out.print(" \n\n\n\tprivate static MetaModel metaModel;\n\tpublic MetaModel getMetaModel() throws XavaException {\n\t\tif (metaModel == null) {");
    if (aggregateName == null) { 
    out.print("\n\t\t\tmetaModel = MetaComponent.get(\"");
    out.print(componentName);
    out.print("\").getMetaEntity();");
    } else { 
    out.print(" \n\t\t\tmetaModel = MetaComponent.get(\"");
    out.print(componentName);
    out.print("\").getMetaAggregate(\"");
    out.print(aggregateName);
    out.print("\");");
    } 
    out.print(" \t\n\t\t}\n\t\treturn metaModel;\n\t}\n\t\n\tpublic String toString() {\t\t\n\t\ttry {\n\t\t\treturn getMetaModel().toString(this);\n\t\t}\n\t\tcatch (XavaException ex) {\n\t\t\tSystem.err.println(XavaResources.getString(\"toString_warning\", \"");
    out.print(name);
    out.print("\"));\n\t\t\treturn super.toString();\n\t\t}\t\t\n\t}\n\n\tpublic boolean equals(Object other) {\t\t\n\t\tif (other == null) return false;\n\t\treturn toString().equals(other.toString());\n\t}\n\t\n\tpublic int hashCode() {\t\t\n\t\treturn toString().hashCode();\n\t}\n\t\n}");
    
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
            PojoPG pg = new PojoPG();
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
        { "Wed Aug 03 11:31:52 CEST 2011", // date this file was generated
             "../OpenXava/generator/pojo.xml", // input file
             "../OpenXava/generator/PojoPG.java" }, // output file
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