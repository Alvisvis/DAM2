/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_corregido;

/**
 *
 * @author 2DAM
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2DAM
 */
public class Test {

    public static void main(String[] args) {
        String url_ = "jdbc:mysql://localhost:3306/";
        String nombreBD_ = "camping";
        String usuario_ = "root";
        String pass_ = "";

        //Este try es para crear la base de datos SI NO EXISTE
        try (Connection conn = DriverManager.getConnection(url_, usuario_, pass_); Statement st = conn.createStatement()) {

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + nombreBD_);
            System.out.println("Base de datos " + nombreBD_ + " creada.");

        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());

        }

        //Esto es para conectarnos a la BD, ya creada
        String urlDB = url_ + nombreBD_;
        try (Connection conn = DriverManager.getConnection(urlDB, usuario_, pass_); Statement st = conn.createStatement()) {

            String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS parcela_camping ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "nombre VARCHAR(255) NOT NULL, "
            + "capacidad INT NOT NULL, "
            + "tieneElectricidad BOOLEAN NOT NULL, "
            + "precioNoche DOUBLE NOT NULL, "
            + "descrip VARCHAR(255) NOT NULL, "
            + "disponible BOOLEAN NOT NULL"
            + ")";
            st.executeUpdate(sqlCrearTabla);
            System.out.println("Tabla parcela_cammping creada");
            
            //CREAR TABLA
            ParcelaCamping pc1 = new ParcelaCamping("Parcela Buitre", 4, true, 32.0, "Tiene sombra", true);
            pc1.create(conn, pc1);
            System.out.println("Parcela creada " + pc1);
           
            //LEER
            ParcelaCamping parcelaLeida = pc1.read(conn, 1); // Seleccionando el ID 1
            System.out.println(parcelaLeida);
            
            //ELIMINAR
            int eliminadas = pc1.delete(conn, 3);
            System.out.println("Filas eliminadas: " + eliminadas);
            
            //ACTUALIZAR
            ParcelaCamping actualizada = pc1.update(conn, 4, "Parcela Aguila", 14, false, 32, "Tiene sombra", true);
            //ParcelaCamping actualizada = pc1.update(conn, 4, "Parcela Aguila", 21, false, 32, "Tiene sombra", true); //no deberia dejar
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
} 


