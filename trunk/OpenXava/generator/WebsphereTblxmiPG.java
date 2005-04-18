
/* Generated by TL2Java Version 1.2, April 9, 2001 */
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import org.openxava.component.MetaComponent;
import org.openxava.generators.Generators;
import org.openxava.util.*;
import org.openxava.model.meta.*;
import org.openxava.mapping.*;

/**
 * Program Generator created by TL2Java
 * @version Mon Apr 18 18:12:02 CEST 2005
 */
public class WebsphereTblxmiPG {
    Properties properties = new Properties();

    /**
     * This method generates the output given a context and output stream
     */
    public boolean generate(XPathContext context, ProgramWriter out) {
        try {    out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.print("\n\n<!-- Generated by OpenXava: ");
    out.print(new Date());
    out.print(" -->");
    
    String componentName = properties.getProperty("arg3");
    String aggregateName = properties.getProperty("arg4");
    MetaComponent component = MetaComponent.get(componentName);
    ModelMapping mapping = null;
    if (aggregateName == null) {
    	mapping = component.getEntityMapping();	
    }
    else {
    	mapping = component.getAggregateMapping(aggregateName);	
    }
    String tableId = Strings.change(mapping.getTable(), ".", "_");
    String table = mapping.getUnqualifiedTable();
    String schema = mapping.getSchema();
    String pk = table + "PK";
    String pkMembers = mapping.getKeyColumnsAsString();
    if (schema == null) {
    	throw new XavaException("websphere_schema_required", componentName);
    }
    
    out.print(" \n\n<RDBSchema:RDBTable xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:RDBSchema=\"RDBSchema.xmi\" xmi:id=\"");
    out.print(tableId);
    out.print("\" name=\"");
    out.print(table);
    out.print("\" primaryKey=\"");
    out.print(pk);
    out.print("\">\n  <database href=\"META-INF/backends/OPENXAVA/DB.dbxmi#DB\"/>\n  <schema href=\"META-INF/backends/OPENXAVA/");
    out.print(schema);
    out.print(".schxmi#");
    out.print(schema);
    out.print("\"/>");
    
    for (Iterator it=mapping.getCmpFields().iterator(); it.hasNext();) {
    	CmpField field = (CmpField) it.next();
    	String cmpTypeName = field.getCmpTypeName();
    	if (Is.emptyString(cmpTypeName)) {
    		throw new XavaException("unknow_type", field.getCmpPropertyName(), mapping.getModelName());
    	}
    	String type = Generators.getWebsphereSQLType(cmpTypeName, false);
    	String href = Generators.getWebsphereSQLType(cmpTypeName, true);
    
    out.print(" \n  <columns xmi:type=\"RDBSchema:RDBColumn\" xmi:id=\"");
    out.print(field.getColumn());
    out.print("\" name=\"");
    out.print(field.getColumn());
    out.print("\">\n    <type xmi:type=\"");
    out.print(type);
    out.print("\" xmi:id=\"");
    out.print(type);
    out.print("_");
    out.print(field);
    out.print("\">\n      <originatingType xmi:type=\"");
    out.print(type);
    out.print("\" href=\"");
    out.print(href);
    out.print("\"/>\n    </type>\n  </columns>");
    
    }
    
    out.print(" \n  <namedGroup xmi:type=\"RDBSchema:SQLReference\" xmi:id=\"");
    out.print(pk);
    out.print("\" name=\"");
    out.print(pk);
    out.print("\" members=\"");
    out.print(pkMembers);
    out.print("\" constraint=\"SQLConstraint_");
    out.print(pk);
    out.print("\"/>\n  <constraints xmi:id=\"SQLConstraint_");
    out.print(pk);
    out.print("\" name=\"");
    out.print(pk);
    out.print("\" type=\"PRIMARYKEY\" primaryKey=\"");
    out.print(pk);
    out.print("\"/>\n</RDBSchema:RDBTable>");
    
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
        { "Mon Apr 18 18:12:03 CEST 2005", // date this file was generated
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