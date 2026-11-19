/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 2DAM
 */
public class GestorConexion {
    Connection conn1 = null;
    
    public GestorConexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/camping";
            String user = "root";
            String pass = "";
            conn1 = DriverManager.getConnection(url, user, pass);
            if (conn1 != null) {
                System.out.println("Conectado a Camping");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
        }
    }
 
    public void cerrarConexion() {
        try {
            conn1.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion");
        }
    }
}
 