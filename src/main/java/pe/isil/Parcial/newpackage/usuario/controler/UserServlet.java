/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.Parcial.newpackage.usuario.controler;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.Parcial.newpackage.usuario.dao1.usuarioDao;
import pe.isil.Parcial.newpackage.usuario.model.Usuario;
/**
 *
 * @author MI PC
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
        
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuarioDao userdao = new usuarioDao();
        int rowsAffected=0;
        String mensaje = "";
        
        String correo = request.getParameter("correo");
        String nombre = request.getParameter("nombre");
        String apePaterno = request.getParameter("apePaterno");
        String apeMaterno = request.getParameter("apeMaterno");
        String direccion = request.getParameter("direccion");
        String password = request.getParameter("password");

        
        Usuario user = new Usuario();
        
        user.setCorreo(correo);
        user.setNombre(nombre);
        user.setApePaterno(apePaterno);
        user.setApeMaterno(apeMaterno);
        user.setDireccion(direccion);
        user.setPassword(password);

        
        try{
            rowsAffected = userdao.registerUser(user);
            mensaje = "Usuario registrado satisfactoriamente";
        }catch(Exception e){
            mensaje=e.toString(); 
            e.printStackTrace();

        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        if(rowsAffected > 0){
            request.setAttribute("message", "Usuario registrado satisfactoriamente");
        }
        dispatcher.forward(request, response);
        
        processRequest(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
