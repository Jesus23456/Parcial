<%-- 
    Document   : index.jsp
    Created on : 21 oct 2022, 21:03:45
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
        <form action="<%= request.getContextPath()%>/UserServlet" method="post">
            <table style="width:80%">
        <tr>
            <td>Correo</td>
            <td><input type="text" name="correo" /></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Ingresar" /></td>
        </tr>
        </table>
            <ul>
            <li><a href="<%= request.getContextPath()%>/UserServlet" style="color: black;">Crear Usuario</a></li>
            <li><a href="<%= request.getContextPath()%>/EditUserServlet" style="color: black;">Recuperar Contraseña</a></li>
        </ul>
        </form>
    </body>
</html>
