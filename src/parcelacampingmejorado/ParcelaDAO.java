/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcelacampingmejorado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2DAM
 */
public class ParcelaDAO {

    private static Connection conn1;
    private static String url_ = "jdbc:mysql://localhost:3306/";
    private static String urlBD_ = "jdbc:mysql://localhost:3306/parcelaCamping";
    private static String usuario_ = "root";
    private static String pass_ = "";

    public static void CreateBDyTabla(ParcelaCampingMejorado pcM) {

        try (Connection conn = DriverManager.getConnection(url_, usuario_, pass_); Statement st = conn.createStatement()) {

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS parcelaCamping");
            System.out.println("Base de datos parcelaCamping creada.");

        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());

        }

        //Esto es para conectarnos a la BD, ya creada
        try (Connection conn = DriverManager.getConnection(urlBD_, usuario_, pass_); Statement st = conn.createStatement()) {

            String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS parcela_camping ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL,"
                    + "capacidad INT NOT NULL,"
                    + "tieneEletricidad BOOLEAN NOT NULL,"
                    + "precioNoche DOUBLE NOT NULL,"
                    + "descrip VARCHAR(255) NOT NULL,"
                    + "disponible BOOLEAN NOT NULL"
                    + ");";
            st.executeUpdate(sqlCrearTabla);
            System.out.println("Tabla parcela_camping creada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void create(Parcela parcela, Connection conn) {
        String sql = "INSERT INTO parcela_camping "
                + "(nombre, "
                + "capacidad, "
                + "tieneEletricidad, "
                + "precioNoche, "
                + "descrip, "
                + "disponible)"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, parcela.getNombre());
            ps.setInt(2, parcela.getCapacidad());
            ps.setBoolean(3, parcela.isTieneEletricidad());
            ps.setDouble(4, parcela.getPrecioNoche());
            ps.setString(5, parcela.getDescrip());
            ps.setBoolean(6, parcela.isDisponible());

            ps.executeUpdate();
            System.out.println("Parcela insertada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Parcela read(Connection conn, int idBuscado) {
        Parcela parcela = null;

        String sql = "SELECT * FROM parcela_camping WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareCall(sql);

            ps.setInt(1, idBuscado);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                parcela = new Parcela(rs.getString("nombre"),
                        rs.getInt("capacidad"),
                        rs.getBoolean("tieneEletricidad"),
                        rs.getDouble("precioNoche"),
                        rs.getString("descrip"),
                        rs.getBoolean("disponible"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return parcela;
    }

    public static void delete(Connection conn, int idBuscado) {

        String sql = "DELETE FROM parcela_camping WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idBuscado);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Parcela update(Connection conn,
            int idBuscado,
            String nombre,
            int capacidad,
            boolean tieneEletricidad,
            String descrip,
            double PrecioNoche,
            boolean disponible) {

        Parcela pcActualizada = new Parcela(nombre, capacidad, tieneEletricidad, PrecioNoche, descrip, disponible);
        String sql = "UPDATE parcela_camping "
                + "SET nombre = ?, "
                + "capacidad = ?, "
                + "tieneEletricidad = ?, "
                + "precioNoche = ?, "
                + "descrip = ?, "
                + "disponible = ? "
                + "WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pcActualizada.getNombre());
            ps.setInt(2, pcActualizada.getCapacidad());
            ps.setBoolean(3, pcActualizada.isTieneEletricidad());
            ps.setDouble(4, pcActualizada.getPrecioNoche());
            ps.setString(5, pcActualizada.getDescrip());
            ps.setBoolean(6, pcActualizada.isDisponible());
            ps.setInt(7, pcActualizada.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pcActualizada;
    }
}
