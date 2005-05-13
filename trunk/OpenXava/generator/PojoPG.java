
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.util.Strings;
import org.openxava.util.XavaException;
import org.openxava.util.meta.MetaSet;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.*;
import org.openxava.calculators.*;
import org.openxava.generators.*;

/**
 * Program Generator created by TL2Java
 * @version Fri May 13 17:17:55 CEST 2005
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
    IMetaModel metaModel=null;
    if (aggregateName == null) {
    	name=componentName;	
    	metaModel = (IMetaModel) component.getMetaEntity();
    }
    else {
    	name=aggregateName;	
    	metaModel =  (IMetaEjb)component.getMetaAggregate(aggregateName);
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
    out.print(";\n\nimport java.util.*;\nimport org.openxava.component.MetaComponent;\nimport org.openxava.model.meta.MetaModel;\nimport org.openxava.util.*;\n\n/**\n * \n * @author MCarmen Gimeno\n */\npublic class ");
    out.print(name);
    out.print(" implements java.io.Serializable {\t\n\t\n\t// Properties/Propiedades");
    
    Iterator itProperties = metaModel.getMetaProperties().iterator();	
    while (itProperties.hasNext()) {	
    	MetaProperty property = (MetaProperty) itProperties.next();
    	PropertyPG.generate(context, out, property); 
    }
    
    out.print(" \n\n\t// References/Referencias");
    
    Iterator itReferences = metaModel.getMetaReferences().iterator();	
    while (itReferences.hasNext()) {	
    	MetaReference ref = (MetaReference) itReferences.next();
    	if (ref.getMetaModelReferenced() instanceof MetaAggregateBean) {
    //		AggregateReferencePG.generate(context, out, ref); by now
    	}
    	else {
    		String refName = Strings.firstUpper(ref.getName());
    	
    out.print(" \n\tprivate ");
    out.print(ref.getReferencedModelName());
    out.print(" ");
    out.print(ref.getName());
    out.print(";\n\tpublic ");
    out.print(ref.getReferencedModelName());
    out.print(" get");
    out.print(refName);
    out.print("() {\n\t\treturn ");
    out.print(ref.getName());
    out.print(";\n\t}\n\tpublic void set");
    out.print(refName);
    out.print("(");
    out.print(ref.getReferencedModelName());
    out.print(" new");
    out.print(ref.getReferencedModelName());
    out.print(") {\n\t\tthis.");
    out.print(ref.getName());
    out.print(" = new");
    out.print(ref.getReferencedModelName());
    out.print(";\n\t}");
    
    	}
    }
    
    out.print(" \n\n\t// Colecciones/Collections");
    
    Iterator itCollections = metaModel.getMetaCollections().iterator();	
    while (itCollections.hasNext()) {	
    	MetaCollection col = (MetaCollection) itCollections.next();
    	String colName = Strings.firstUpper(col.getName());
    	
    out.print(" \n\tprivate java.util.Collection ");
    out.print(col.getName());
    out.print(";\n\tpublic java.util.Collection get");
    out.print(colName);
    out.print("() {\n\t\treturn ");
    out.print(col.getName());
    out.print(";\n\t}");
    
    }
    
    out.print(" \n\t\n\tprivate MetaModel metaModel;\n\tprivate MetaModel getMetaModel() throws XavaException {\n\t\tif (metaModel == null) {");
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
    out.print(" \t\n\t\t}\n\t\treturn metaModel;\n\t}\n}");
    
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
        { "Fri May 13 17:17:55 CEST 2005", // date this file was generated
             "/home/javi/workspace/OpenXava/generator/pojo.xml", // input file
             "/home/javi/workspace/OpenXava/generator/PojoPG.java" }, // output file
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