
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.util.Strings;
import org.openxava.util.XavaException;
import org.openxava.util.meta.*;
import org.openxava.model.meta.*;
import org.openxava.component.MetaComponent;
import org.openxava.calculators.*;
import org.openxava.generators.*;
import org.openxava.mapping.*;

/**
 * Program Generator created by TL2Java
 * @version Fri Feb 10 11:13:02 CET 2006
 */
public class InterfacePG {
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
    IMetaEjb metaModel=null;
    ModelMapping modelMapping=null;
    
    if (aggregateName == null) {
    	name=componentName;	
    	metaModel = (IMetaEjb) component.getMetaEntity();
    	modelMapping = component.getEntityMapping();
    }
    else {
    	name=aggregateName;	
    	metaModel =  (IMetaEjb)component.getMetaAggregate(aggregateName);
    	modelMapping = component.getAggregateMapping(aggregateName);	
    }
    String interfaces = metaModel.getInterfacesNames().isEmpty()?"":" extends " + metaModel.getImplements();
    
    out.print("\n\n// File generated by OpenXava: ");
    out.print(new Date());
    out.print("\n// Archivo generado por OpenXava: ");
    out.print(new Date());
    out.print("\n\n// WARNING: NO EDIT\n// OJO: NO EDITAR");
    if (aggregateName == null) { 
    out.print("\n// Component: ");
    out.print(componentName);
    out.print("\t\tJava interface for entity/Interfaz java para Entidad");
    } else { 
    out.print("\n// Component: ");
    out.print(componentName);
    out.print("\t\tJava interface for aggregate/Interfaz java para Agregado: ");
    out.print(aggregateName);
    } 
    out.print("\n\npackage ");
    out.print(packageName);
    out.print(";\n\nimport java.math.*;\nimport java.rmi.RemoteException;\n\n\npublic interface I");
    out.print(name);
    out.print(" ");
    out.print(interfaces);
    out.print(" {\t\n\n\t// Properties/Propiedades");
    
    Iterator itProperties = metaModel.getMetaProperties().iterator();	
    while (itProperties.hasNext()) {	
    	MetaProperty property = (MetaProperty) itProperties.next();
    	String propertyName = Strings.firstUpper(property.getName());
    	String type = property.getTypeName();	
    	String get = type.equals("boolean")?"is":"get";	
    	if (property.isCalculated() || property.isKey()) {
    		// Read only
    	
    out.print(" \t\n\t");
    out.print(type);
    out.print(" ");
    out.print(get);
    out.print(propertyName);
    out.print("() throws RemoteException;");
    
    	}
    	else {
    	
    out.print(" \n\t");
    out.print(type);
    out.print(" ");
    out.print(get);
    out.print(propertyName);
    out.print("() throws RemoteException;\n\tvoid set");
    out.print(propertyName);
    out.print("(");
    out.print(type);
    out.print(" ");
    out.print(property.getName());
    out.print(") throws RemoteException;");
     		
    	} // else
    } //while 
    
    	// Collections/Colecciones
    	
    
    Iterator itCollections = metaModel.getMetaCollections().iterator();	
    while (itCollections.hasNext()) {	
    	MetaCollection collection = (MetaCollection) itCollections.next();
    	String collectionName = Strings.firstUpper(collection.getName());
    	MetaReference reference = collection.getMetaReference();	
    	IMetaEjb referencedModel = (IMetaEjb) reference.getMetaModelReferenced();
    	String referencedModelName = reference.getReferencedModelName();
    	String referencedModelClass = referencedModel.getInterfaceName();	
    	
     	if (!reference.isAggregate() && 
    		!collection.hasCondition() && 
    		!collection.hasCalculator() && 
    		!reference.getMetaModelReferenced().getMetaReference(reference.getRole()).isKey()) {	
    
    out.print(" \n\tvoid addTo");
    out.print(collectionName);
    out.print("(");
    out.print(referencedModelClass);
    out.print(" newElement) throws RemoteException;\n\tvoid removeFrom");
    out.print(collectionName);
    out.print("(");
    out.print(referencedModelClass);
    out.print(" toRemove) throws RemoteException;");
    } // if aggregate 
    out.print("\t\n\n\tjava.util.Collection get");
    out.print(collectionName);
    out.print("() throws RemoteException;");
    } // while collections 
    out.print("\t\t\n\n\t// References/Referencias");
    
    Iterator itReferences = metaModel.getMetaReferences().iterator();	
    while (itReferences.hasNext()) {	
    	MetaReference reference = (MetaReference) itReferences.next();
    	String referenceName = Strings.firstUpper(reference.getName());	
    	if (reference.getMetaModelReferenced() instanceof MetaAggregateBean) {	
    		MetaAggregateBean referencedModel = (MetaAggregateBean) reference.getMetaModelReferenced();
    		String referencedModelClass = referencedModel.getBeanClass();					
    
    out.print("  \t\n\t// ");
    out.print(referenceName);
    out.print(" : Aggregate \n\t\n\t");
    out.print(referencedModelClass);
    out.print(" get");
    out.print(referenceName);
    out.print("() throws RemoteException;\n\tvoid set");
    out.print(referenceName);
    out.print("(");
    out.print(referencedModelClass);
    out.print(" new");
    out.print(referenceName);
    out.print(") throws RemoteException;");
    } else { // reference to entity or EJB aggregate
    		IMetaEjb referencedModel = (IMetaEjb) reference.getMetaModelReferenced();
    		String referencedModelClass = referencedModel.getInterfaceName();
    		
    
    out.print(" \n\n\t// ");
    out.print(referenceName);
    out.print(" : Reference/Referencia\n\t\n\t");
    out.print(referencedModelClass);
    out.print(" get");
    out.print(referenceName);
    out.print("() throws RemoteException;\n\tvoid set");
    out.print(referenceName);
    out.print("(");
    out.print(referencedModelClass);
    out.print(" new");
    out.print(referenceName);
    out.print(") throws RemoteException;");
    } // if/else aggregate/reference 
    } // References 
    out.print("\n\n\t// Methods");
    
    Iterator itMethods = metaModel.getMetaMethods().iterator();	
    while (itMethods.hasNext()) {	
    	MetaMethod method = (MetaMethod) itMethods.next();
    	String throwSentence = "throws " + (method.hasExceptions()?method.getExceptions() + ", RemoteException":"RemoteException");
    
    out.print(" \n\t");
    out.print(method.getTypeName());
    out.print(" ");
    out.print(method.getName());
    out.print("(");
    out.print(method.getArguments());
    out.print(") ");
    out.print(throwSentence);
    out.print(";");
    		
    } // Methods
    
    out.print(" \n\n\n}");
    
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
            InterfacePG pg = new InterfacePG();
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
        { "Fri Feb 10 11:13:02 CET 2006", // date this file was generated
             "/home/javi/workspace/OpenXava/generator/interface.xml", // input file
             "/home/javi/workspace/OpenXava/generator/InterfacePG.java" }, // output file
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