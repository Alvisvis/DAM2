/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 2DAM
 */
public class conexion {
    private static String url_ = "jdbc:mysql://localhost:3306/camping";
    private static String usuario_ = "root";
    private static String pass_ = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url_, usuario_, pass_);
    }
    
    
    
}
