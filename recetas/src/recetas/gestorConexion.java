/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recetas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author 2DAM
 */
public class gestorConexion {
    Connection conn1 = null;
    public gestorConexion(){
        try{
            String url = "jdbc:mysql://localhost:3306/recetas";
            String usuario = "root";
            String pass ="";
            conn1 = DriverManager.getConnection(url, usuario, pass);
            if (conn1 != null){
                System.out.println("Conectado a recetas");
            }
        }catch(SQLException e){
            System.out.println("Error: direccion, usuario o clave no válida " + e);
        }
    }
    
    public void cerrarConexion(){
    try {

        conn1.close();

    } catch (SQLException ex) {
        System.out.println("ERROR: al cerrar la conexión");
    }
    }

    
    
}
