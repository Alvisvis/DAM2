/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recetas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author 2DAM
 */
public class usuarioDAO {
    
    public void create(Connection conn1, usuarioDTO u ){
        String SQL = "INSERT INTO usuarios (nombre, correo, contrasenya)" + "VALUES (?,?,?)";
        //PreparedStatement ps = conn1.preparedStatement(SQL);
        try{
            PreparedStatement ps = conn1.prepareStatement(SQL);
            ps.setString(1, u.nombre);
            ps.setString(2, u.correo);
            ps.setString(3, u.contasenya);
            ps.executeQuery();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    
    }
//    public void create(gestorConexion conn1, usuarioDTO u ){
//        String SQL = "INSERT INTO usuarios (nombre, correo, contrasenya)" + "VALUES (?,?,?)";
//        //PreparedStatement ps = conn1.preparedStatement(SQL);
//        try{
//            PreparedStatement ps = conn1.preparedStatement(SQL);
//            ps.setString(1, u.nombre);
//            ps.setString(2, u.correo);
//            ps.setString(3, u.contasenya);
//            ps.executeQuery();
//            
//        }catch(SQLException ex){
//            System.out.println(ex);
//        }
//    
//    }
    
    public void listar(Connection conn){
        String sql = "SELECT * FROM usuario";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                
//            }
                                
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
 
    
    
    
    
}
