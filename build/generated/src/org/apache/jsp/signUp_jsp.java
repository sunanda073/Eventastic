package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 String fnm = request.getParameter("fname");
        String lnm = request.getParameter("lname");
        String em = request.getParameter("email");
        String p = request.getParameter("password");
        String cno = request.getParameter("cno");
        String bt = request.getParameter("birthdate");
        String gndr = request.getParameter("gender");
        String ad = request.getParameter("address1") + " " + request.getParameter("address2");
        String cntry = request.getParameter("country");
        String cty = request.getParameter("city");
        String st = request.getParameter("state");
        String pin = request.getParameter("pin");
           //session.setAttribute("name", nm);
           try 
           {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");

                Statement stmt = con.createStatement();

                String str1 = "INSERT INTO UserRegistration " +
                          "VALUES ('" + fnm + "','" + lnm + "','" + em + "','" + p + "','" + cno + "'," +
                          "TO_DATE('" + bt + "','YYYY-MM-DD'),'" + gndr + "','" + ad + "','" + cntry + "','" + cty + "','" + st + "','" + pin + "')";

                int x = stmt.executeUpdate(str1);
            
                if(x>0)
                {
                 
      out.write("\n");
      out.write("                 ");
      if (true) {
        _jspx_page_context.forward("reg_success.jsp");
        return;
      }
      out.write("\n");
      out.write("                 ");
}
                else
                {
                 
      out.write("\n");
      out.write("                 ");
      if (true) {
        _jspx_page_context.forward("reg_failure.jsp");
        return;
      }
      out.write("\n");
      out.write("                 ");
 
                     
                 con.close();
                }
            }
            catch(Exception e)
            {
                out.println(e);
            }
    
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
