<%-- 
    Document   : success
    Created on : 21 oct 2022, 21:34:14
    Author     : MI PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Result of user's Registration</h1>
        <h3><%=request.getAttribute("message")%> </h3>
    </body>
</html>
