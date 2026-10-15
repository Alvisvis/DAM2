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

/**
 *
 * @author 2DAM
 */
public class ParcelaDAO {

    Connection conn1 = null;

    public void ConexionSQL() {
        try {
            String url_ = "jdbc:mysql://localhost:3306/";
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
    
    public void create(Parcela parcela, Connection conn) {
        String sql = "INSERT INTO parcela_camping "
                + "(nombre, capacidad, tieneEletricidad, precioNoche, descrip, disponible)"
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

    public Parcela read(Connection conn, int idBuscado) {
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

    public void delete(Connection conn, int idBuscado) {

        String sql = "DELETE FROM parcela_camping WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idBuscado);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Parcela update(Connection conn,
            int idBuscado, String nombre, int capacidad,
            boolean tieneEletricidad,
            String descrip, double PrecioNoche, boolean disponible) {

        Parcela pcActualizada = new Parcela(nombre, capacidad, tieneEletricidad, PrecioNoche, descrip, disponible);
        String sql = "UPDATE parcela_camping SET nombre = ?, capacidad = ?, tieneEletricidad = ?, precioNoche = ?, descrip = ?, disponible = ? WHERE id = ?";

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
