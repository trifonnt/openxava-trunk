
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.model.meta.*;
import org.openxava.util.*;

/**
 * Program Generator created by TL2Java
 * @version Fri Jan 27 18:09:36 CET 2006
 */
public class EntityReferencePG {
    Properties properties = new Properties();


private MetaReference reference=null;
public void setReference(MetaReference ref) {
	this.reference = ref;
}

public static void generate(XPathContext context, ProgramWriter out, MetaReference ref) throws XavaException {
	EntityReferencePG pg = new EntityReferencePG();
	pg.setReference(ref);
	pg.generate(context, out);
}


    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    
    String refName = Strings.firstUpper(reference.getName());
    
    out.print(" \n\tprivate ");
    out.print(reference.getMetaModelReferenced().getInterfaceName());
    out.print(" ");
    out.print(reference.getName());
    out.print(";\n\tpublic ");
    out.print(reference.getMetaModelReferenced().getInterfaceName());
    out.print(" get");
    out.print(refName);
    out.print("() {\n\t\treturn ");
    out.print(reference.getName());
    out.print(";\n\t}\n\tpublic void set");
    out.print(refName);
    out.print("(");
    out.print(reference.getMetaModelReferenced().getInterfaceName());
    out.print(" new");
    out.print(reference.getReferencedModelName());
    out.print(") {\n\t\tthis.");
    out.print(reference.getName());
    out.print(" = new");
    out.print(reference.getReferencedModelName());
    out.print(";\n\t}");
    
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
            EntityReferencePG pg = new EntityReferencePG();
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
        { "Fri Jan 27 18:09:36 CET 2006", // date this file was generated
             "/home/javi/workspace2/OpenXava/generator/entityReference.xml", // input file
             "/home/javi/workspace2/OpenXava/generator/EntityReferencePG.java" }, // output file
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