/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD_2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 2DAM
 */
public class ParcelaCamping_DAO {
    
    public void create(Connection conn1, ParcelaCamping_DTO parcela) {
        String sql = "INSERT INTO parcela_camping (nombre, capacidad, tieneElectricidad, precioNoche, descrip, disponible) "
        + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn1.prepareStatement(sql)) {
            ps.setString(1, parcela.getNombre());
            ps.setInt(2, parcela.getCapacidad());
            ps.setBoolean(3, parcela.isTieneEletricidad());
            ps.setDouble(4, parcela.getPrecioNoche());
            ps.setString(5, parcela.getDescrip());
            ps.setBoolean(6, parcela.isDisponible());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ParcelaCamping_DTO read(Connection conn1, int idBuscado) {
        ParcelaCamping_DTO parcela = null;

        String sql = "SELECT * FROM parcela_camping WHERE id = ?";

        try {
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, idBuscado);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Si encuentra alguna parcela
                parcela = new ParcelaCamping_DTO(rs.getString("nombre"), rs.getInt("capacidad"), rs.getBoolean("tieneElectricidad"), rs.getDouble("precioNoche"), rs.getString("descrip"), rs.getBoolean("disponible"));
                parcela.setId(rs.getInt("id")); // Para ponerle su ID real desde la BD
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return parcela;
    }

    public int delete(Connection conn1, int idAEliminar) {
        int filasEliminadas = 0;
        String sql = "DELETE FROM parcela_camping WHERE id = ?";
        try {
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, idAEliminar);
            filasEliminadas = ps.executeUpdate(); // ExecuteUpdate devuelve el numero de filas eliminadas, en INTEGER            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return filasEliminadas;
    }
    
    public ParcelaCamping_DTO update(Connection conn, int id, String nombre, int capacidad, boolean tieneEletricidad, double precioNoche, String descrip, boolean disponible ){
        ParcelaCamping_DTO parcelaActualizada = new ParcelaCamping_DTO(nombre, capacidad, tieneEletricidad, precioNoche,descrip, disponible);
        parcelaActualizada.setId(id);
        
String SQL = "UPDATE parcela_camping SET nombre=?, capacidad=?, tieneElectricidad=?, precioNoche=?, descrip=?, disponible=? WHERE id=?";        try{
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1,parcelaActualizada.getNombre());
            ps.setInt(2, parcelaActualizada.getCapacidad());
            ps.setBoolean(3, parcelaActualizada.isTieneEletricidad());
            ps.setDouble(4, parcelaActualizada.getPrecioNoche());
            ps.setString(5, parcelaActualizada.getDescrip());
            ps.setBoolean(6, parcelaActualizada.isDisponible());
            ps.setInt(7, parcelaActualizada.getId());
            
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al actualizar" + ex.getMessage());
        }
        return parcelaActualizada;
    }   

    
    
}
