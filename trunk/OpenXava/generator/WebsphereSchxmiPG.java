
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import java.util.*;
import org.openxava.util.Strings;
import org.openxava.mapping.Mapping;

/**
 * Program Generator created by TL2Java
 * @version Fri Apr 15 19:26:53 CEST 2005
 */
public class WebsphereSchxmiPG {
    Properties properties = new Properties();

    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.print("\n\n<!-- Generated by OpenXava: ");
    out.print(new Date());
    out.print(" -->");
    
    String schema = properties.getProperty("arg3");
    
    out.print(" \n\n<RDBSchema:RDBSchema xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:RDBSchema=\"RDBSchema.xmi\" xmi:id=\"");
    out.print(schema);
    out.print("\" name=\"");
    out.print(schema);
    out.print("\">\n  <database href=\"META-INF/backends/OPENXAVA/DB.dbxmi#DB\"/>");
    
    for (Iterator it=Mapping.getTablesBySchema(schema).iterator(); it.hasNext();) {
    	String tableId = Strings.change((String) it.next(), ".", "_");
    
    out.print(" \n  <tables xmi:type=\"RDBSchema:RDBTable\" href=\"META-INF/backends/OPENXAVA/");
    out.print(tableId);
    out.print(".tblxmi#");
    out.print(tableId);
    out.print("\"/>");
    
    }
    
    out.print(" \n</RDBSchema:RDBSchema>");
    
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
            WebsphereSchxmiPG pg = new WebsphereSchxmiPG();
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
        { "Fri Apr 15 19:26:53 CEST 2005", // date this file was generated
             "/home/javi/workspace/OpenXava/generator/websphereSchxmi.xml", // input file
             "/home/javi/workspace/OpenXava/generator/WebsphereSchxmiPG.java" }, // output file
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