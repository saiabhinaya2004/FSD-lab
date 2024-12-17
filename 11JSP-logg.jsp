<%-- 
    Document   : logg.jsp
    Created on : 5 Dec 2024, 8:15:24 pm
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String k1=request.getParameter("username");
            String k2=request.getParameter("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Saiabhinaya@2004");
            Statement st=con.createStatement();
            String q="select * from users";
            ResultSet rs= st.executeQuery(q);
            int f=0;
            while(rs.next())
            {
                String s1 = rs.getString("username");
                String s2 = rs.getString("password");
                if(k1.equals(s1) && k2.equals(s2)){
                    out.println("Login Successful,  Welcome "+k1+"! and your password is:"+k2);
                   
                    f=1;
                    return;
                }
            }
            if(f==0){
            out.println("Login Unsuccesful, Please enter valid credentials");
            }
            //step5: close connection
            con.close();
        %>
    </body>
</html>
          
