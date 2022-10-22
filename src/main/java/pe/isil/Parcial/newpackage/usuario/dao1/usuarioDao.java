/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.Parcial.newpackage.usuario.dao1;

import pe.isil.Parcial.newpackage.usuario.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.isil.Parcial.newpackage.usuario.dao.mysql.mysqlConnection;

public class usuarioDao {
    
     public int registerUser(Usuario user) throws Exception{

            mysqlConnection mysqlConn = new mysqlConnection();
            Connection conn = mysqlConn.getConnection();
            int rowsAffected=0;
            
            String queryInsert = "Insert Into Users(correo,nombre,apePaterno,apeMaterno,direccion,password)"+
                    "Values(?,?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, user.getCorreo());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getApePaterno());
            ps.setString(4, user.getApeMaterno());
            ps.setString(5, user.getDireccion());
            ps.setString(6, user.getPassword());
            
            rowsAffected = ps.executeUpdate();
            return rowsAffected;
 
    }
    
    public String updateUser(Usuario user) throws Exception{
        String message= "";
        mysqlConnection mysqlConn = new mysqlConnection();
        Connection conn = mysqlConn.getConnection();
        int rowsAffected=0;
        int count=0;
        
        PreparedStatement ps = conn.prepareStatement("Select * from Users where correo=?");
        ps.setString(1, user.getCorreo());
        ResultSet rs = ps.executeQuery();
        Statement st;
        
        while(rs.next()){
            count++;
        }
        
        if(count > 0){
            String queryString = "select password from users where correo=?";
            st = conn.createStatement();
            ResultSet us = st.executeQuery(queryString);
            ps.setString(1, user.getPassword());
            rowsAffected= 1;
            
            if(rowsAffected>0)
            {
                message="Contraseña recuperada";
            }else{
                message="Ocurrio un error";
            }
           
        }else{
            message="User no existe";
        }
        
        return message;
        
    }
    
}
