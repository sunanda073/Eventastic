<%@page import="java.sql.* "%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <% String fnm = request.getParameter("fname");
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
                 %>
                 <jsp:forward page="reg_success.jsp"/>
                 <%}
                else
                {
                 %>
                 <jsp:forward page="reg_failure.jsp"/>
                 <% 
                     
                 con.close();
                }
            }
            catch(Exception e)
            {
                out.println(e);
            }
    %>
    </body>
</html>
