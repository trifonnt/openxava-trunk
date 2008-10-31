package org.openxava.web.servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.directwebremoting.util.*;
import org.openxava.util.*;




/**
 * Utilities to work with servlets. <p>
 * 
 * @author Javier Paniza
 */

public class Servlets {
	
	
	
	/**
	 * From a uri return the resource (dynamic or static) in InputStream format. <p>
	 * 
	 * Suitable for binary streams. <br>
	 * 
	 * @param request  request of the current servlet
	 * @param response response of the current servlet. This method does not write to it  
	 * @param uri And uri, for example /mypage.jsp
	 * @return The stream with the content of the resource in uri.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static InputStream getURIAsStream(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException { 
		// We don't use (HttpServletRequest request, HttpServletResponse response, String uri, String encoding) throws ServletException, IOException
		// as implementation, because it corrupts binary data trying to do charset conversions.
		RequestDispatcher dispatcher = request.getSession().getServletContext().getRequestDispatcher(uri);
		ServletResponse res = new ServletResponse(response);
		dispatcher.include(request, res);
		return res.getInputStream();
	}
	
	/**
	 * From a uri return the resource (dynamic or static) in InputStream format. <p>
	 * 
	 * Suitable for characters streams. <br>
	 * 
	 * @param request  request of the current servlet
	 * @param response response of the current servlet. This method does not write to it  
	 * @param uri And uri, for example /mypage.jsp
	 * @param encoding  Character encoding for the response
	 * @return The stream with the content of the resource in uri
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static InputStream getURIAsStream(HttpServletRequest request, HttpServletResponse response, String uri, String encoding) throws ServletException, IOException { 		
		// Copied with some slight modifications from WebContext.forwardToString of DWR
        StringWriter sout = new StringWriter();
        StringBuffer buffer = sout.getBuffer();
 
        HttpServletResponse fakeResponse = new SwallowingHttpServletResponse(response, sout, encoding);         
        request.getSession().getServletContext().getRequestDispatcher(uri).forward(request, fakeResponse);
        
        return new ByteArrayInputStream(buffer.toString().getBytes(encoding));                
	}
	
	
	static private class ServletResponse extends HttpServletResponseWrapper {
		
		private OutputStream out = new OutputStream();		
		private PrintWriter writer = new PrintWriter(out);

		public ServletResponse(HttpServletResponse response) {
			super(response);		
		}
		
		public ServletOutputStream getOutputStream() throws IOException {
			return out;
		}
		
		public InputStream getInputStream() {		
			writer.flush();
			return out.getInputStream();
		}
		
		public PrintWriter getWriter() throws IOException {		
			return writer;
		}
		
	}
	
	static private class OutputStream extends ServletOutputStream {
		
		public List bytes = new ArrayList();

		public void write(int b) throws IOException {
			bytes.add(new Integer(b));		
		}
			
		public InputStream getInputStream() {
			byte [] result = new byte[bytes.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = ((Integer) bytes.get(i)).byteValue(); 
			}		
			return new ByteArrayInputStream(result);
		}

	}
	
	
}
