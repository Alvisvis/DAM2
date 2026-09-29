/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class ConexionSQL {

    Connection conn1 = null;

    /**
     * Metodo para conectar con la base de datos Con este metodo se conecta con
     * la base de datos que queremos usar, hay que estar pendiente de revisar
     * siempre el puerto, nombre de la BBDD y contraseña o usuario si estan
     * cambiado
     */
    public ConexionSQL() {
        try {
            String url_ = "jdbc:mysql://localhost:3306/tiendamusical";
            String usuario_ = "root";
            String pass_ = "";

            conn1 = DriverManager.getConnection(url_, usuario_, pass_);

            if (conn1 != null) {
                System.out.println("Conectado a tu tienda musical");
            }

        } catch (SQLException e) {
            System.out.println("Error: La direccion, usuario o contraseña no son validas.");
        }
    }

    public void cerrarConexion() {
        try {
            conn1.close();
            System.out.println("Esta cerrad la base de datos");
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexion");
        }
    }

    public ResultSet nombresEmpresas() {

        String sql = "SELECT nombreCli FROM cliente";
        try {

            Statement sentencia = conn1.createStatement();

            ResultSet rs = sentencia.executeQuery(sql);
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet pedirDatos(String tipo, String tabla) {

        String sql = "SELECT " + tipo + " FROM " + tabla;

        try {
            Statement sentencia = conn1.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
