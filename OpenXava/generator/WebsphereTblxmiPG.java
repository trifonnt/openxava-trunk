
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;

/**
 * Program Generator created by TL2Java
 * @version Thu Mar 03 12:10:56 CET 2005
 */
public class WebsphereTblxmiPG {
    Properties properties = new Properties();

    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n<!-- Generated by OpenXava: ");
    out.print(new Date());
    out.print(" -->\n\n<RDBSchema:RDBTable xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:RDBSchema=\"RDBSchema.xmi\" xmi:id=\"PERSONA\" name=\"PERSONA\" primaryKey=\"C4404645\">\n  <database href=\"META-INF/backends/DB2UDBAS400_V5_1/EUROPA.dbxmi#EUROPA\"/>\n  <schema href=\"META-INF/backends/DB2UDBAS400_V5_1/EUROPA_JAVI.schxmi#JAVI\"/>\n  <columns xmi:type=\"RDBSchema:RDBColumn\" xmi:id=\"DNI\" name=\"DNI\">\n    <type xmi:type=\"RDBSchema:DB2AS400CharacterStringType\" xmi:id=\"DB2AS400CharacterStringType_1107953075972\" characterSet=\"800\" length=\"10\">\n      <originatingType xmi:type=\"RDBSchema:DB2AS400CharacterStringType\" href=\"DB2UDBAS400_V5_Primitives.xmi#DB2AS400CharacterStringType_3\"/>\n    </type>\n  </columns>\n  <columns xmi:type=\"RDBSchema:RDBColumn\" xmi:id=\"NOMBRE\" name=\"NOMBRE\" allowNull=\"true\">\n    <type xmi:type=\"RDBSchema:DB2AS400CharacterStringType\" xmi:id=\"DB2AS400CharacterStringType_1107953075973\" characterSet=\"800\" length=\"20\">\n      <originatingType xmi:type=\"RDBSchema:DB2AS400CharacterStringType\" href=\"DB2UDBAS400_V5_Primitives.xmi#DB2AS400CharacterStringType_3\"/>\n    </type>\n  </columns>\n  <columns xmi:type=\"RDBSchema:RDBColumn\" xmi:id=\"APELLIDOS\" name=\"APELLIDOS\" allowNull=\"true\">\n    <type xmi:type=\"RDBSchema:DB2AS400CharacterStringType\" xmi:id=\"DB2AS400CharacterStringType_1107953075974\" characterSet=\"800\" length=\"50\">\n      <originatingType xmi:type=\"RDBSchema:DB2AS400CharacterStringType\" href=\"DB2UDBAS400_V5_Primitives.xmi#DB2AS400CharacterStringType_3\"/>\n    </type>\n  </columns>\n  <namedGroup xmi:type=\"RDBSchema:SQLReference\" xmi:id=\"C4404645\" name=\"C4404645\" members=\"DNI\" constraint=\"SQLConstraint_1107953075972\"/>\n  <constraints xmi:id=\"SQLConstraint_1107953075972\" name=\"C4404645\" type=\"PRIMARYKEY\" primaryKey=\"C4404645\"/>\n</RDBSchema:RDBTable>");
    
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
            WebsphereTblxmiPG pg = new WebsphereTblxmiPG();
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
        { "Thu Mar 03 12:10:57 CET 2005", // date this file was generated
             "/home/javi/workspace/OpenXava/generator/websphereTblxmi.xml", // input file
             "/home/javi/workspace/OpenXava/generator/WebsphereTblxmiPG.java" }, // output file
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