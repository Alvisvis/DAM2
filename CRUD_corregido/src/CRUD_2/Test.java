/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD_2;

/**
 *
 * @author 2DAM
 */
import crud_corregido.*;
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
            
            ParcelaCamping_DAO dao = new ParcelaCamping_DAO();
            
            ParcelaCamping_DTO pc1  = new ParcelaCamping_DTO("Parcela Buitre", 4, true, 32.0, "Tiene sombra", true);
            
            //crear
            dao.create(conn, pc1);
            System.out.println("Parcela creada " + pc1);
             
            //leer
            ParcelaCamping_DTO pcLeida = dao.read(conn,1);
            System.out.println(pcLeida);
            
            //eliminar
             int eliminadas = dao.delete(conn, 3);
             System.out.println("Filas eliminadas: " + eliminadas);
            
           
            //ACTUALIZAR
            ParcelaCamping_DTO actualizada = dao.update(conn, 4, "Parcela Aguila", 14, false, 32, "Tiene sombra", true);
            //ParcelaCamping actualizada = pc1.update(conn, 4, "Parcela Aguila", 21, false, 32, "Tiene sombra", true); //no deberia dejar
            System.out.println(actualizada);
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
} 


