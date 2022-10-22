<%-- 
    Document   : edit
    Created on : 21 oct 2022, 21:35:41
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
        <h1>Recuperar Contraseña</h1>
        <form action="<%= request.getContextPath()%>/EditUserServlet" method="post">
            <table style="width:80%">
        <tr>
            <td>Buscar Usuario</td>
        </tr>
        <tr>
            <td>Correo</td>
            <td><input type="text" name="correo" /></td>
            <td><input type="submit" value="Recuperar" /></td>
        </tr>
        <tr>
            <td>Contraseña Recuperada</td>
        </tr>
        <tr>
            <td>Contraseña</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
           
            <a href="<%= request.getContextPath()%>" style="color: black; text-decoration: none; background-color: silver; border: black;">Volver al Login</a>
        
        </form>
    </body>
</html>
