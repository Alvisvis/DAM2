/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alumnosprueba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author 2DAM
 */
public class GestorConexion {
    Connection conn1 = null;
    
    public GestorConexion(){
        try{
            String url = "jdbc:mysql://localhost:3306/alumnosprueba";
            String user = "root";
            String pass = "";
            conn1 = DriverManager.getConnection(url,user,pass);
            if(conn1 != null){
                System.out.println("Conectado a Alumnos Prueba  ");
            }
        }catch(SQLException ex){
            System.out.println("Error en la conexión"); 
             ex.printStackTrace();
        }
    }
    
       public void cerrarConexion(){
        try{
            conn1.close();
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexion");
        }
    }
       
    public ResultSet datosAlumnos(){
        String sql = "SELECT * FROM alumnos";
        try{
            Statement sentencia = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = sentencia.executeQuery(sql);
            return rs;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet alumnosAprobados(double notaCorte, String curso){
        String sql = "SELECT * FROM alumnos WHERE nota >= ? AND curso LIKE ?";
         try{
            PreparedStatement sentencia = conn1.prepareStatement(sql);
            sentencia.setDouble(1,notaCorte);
            sentencia.setString(2,curso);
            ResultSet rs = sentencia.executeQuery();
            return rs;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    
       
    
}
