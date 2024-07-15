import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String fnm = req.getParameter("fname");
        String lnm = req.getParameter("lname");
        String em = req.getParameter("email");
        String p = req.getParameter("password");
        String cno = req.getParameter("cno");
        String bt = req.getParameter("birthdate");
        String gndr = req.getParameter("gender");
        String ad = req.getParameter("address1") + " " + req.getParameter("address2");
        String cntry = req.getParameter("country");
        String cty = req.getParameter("city");
        String st = req.getParameter("state");
        String pin = req.getParameter("pin");

        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");

            Statement stmt = con.createStatement();

            String str1 = "INSERT INTO UserRegistration " +
                          "VALUES ('" + fnm + "','" + lnm + "','" + em + "','" + p + "','" + cno + "'," +
                          "TO_DATE('" + bt + "','YYYY-MM-DD'),'" + gndr + "','" + ad + "','" + cntry + "','" + cty + "','" + st + "','" + pin + "')";

            int x = stmt.executeUpdate(str1);

            if (x > 0)
                pw1.println("Insertion successful");
            else
                pw1.println("Insertion unsuccessful");

            con.close(); // closing the connection
        } 
        catch (Exception e) 
        {
            pw1.println(e);
        }
    }
}
