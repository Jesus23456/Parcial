/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.Parcial.newpackage.usuario.controler;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.Parcial.newpackage.usuario.dao1.usuarioDao;
import pe.isil.Parcial.newpackage.usuario.model.Usuario;
/**
 *
 * @author MI PC
 */
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        usuarioDao userdao = new usuarioDao();
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
            mensaje = userdao.updateUser(user);
  
        }catch(Exception e){
            mensaje=e.toString(); 
            e.printStackTrace();

        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        request.setAttribute("message", mensaje);
        dispatcher.forward(request, response);
    }

    
}
