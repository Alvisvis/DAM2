/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2DAM
 */
public class ParcelaCamping {
    private int id;
    private String nombre;
    private int capacidad;
    private boolean tieneElectricidad;
    private double precioPorNoche;
    private String descripcion;
    private boolean disponible;
    
    public ParcelaCamping(String nombre, int capacidad, boolean tieneElectricidad, double precioPorNoche, String descripcion, boolean disponible) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tieneElectricidad = tieneElectricidad;
        this.precioPorNoche = precioPorNoche;
        this.descripcion = descripcion;
        this.disponible = disponible;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isTieneElectricidad() {
        return tieneElectricidad;
    }

    public void setTieneElectricidad(boolean tieneElectricidad) {
        this.tieneElectricidad = tieneElectricidad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    

    // CREATE
    public void create(GestorConexion gestor) {
        String sql = "INSERT INTO parcela_camping (nombre, capacidad, tieneElectricidad, precioPorNoche, descripcion, disponible) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement sentencia = gestor.conn1.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setInt(2, capacidad);
            sentencia.setBoolean(3, tieneElectricidad);
            sentencia.setDouble(4, precioPorNoche);
            sentencia.setString(5, descripcion);
            sentencia.setBoolean(6, disponible);
            sentencia.executeUpdate();
            System.out.println("Parcela " + nombre + " creada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //READ
    public void read(GestorConexion gestor) {
        String sql = "SELECT * FROM parcela_camping WHERE nombre = ?";
        try {
            PreparedStatement sentencia = gestor.conn1.prepareStatement(sql);
            sentencia.setString(1, nombre);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {    
            System.out.println("Nombre: " + rs.getString("nombre") + "\nCapacidad: " 
                    + rs.getInt("capacidad") + "\nElectricidad: " + rs.getBoolean("tieneElectricidad") 
                    + "\nPrecio: " + rs.getDouble("precioPorNoche") + "€/noche\nDescripción: " 
                    + rs.getString("descripcion") + "\nDisponible: " + rs.getBoolean("disponible"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //UPDATE
    public void update(GestorConexion gestor) {
        String sql = "UPDATE parcela_camping SET nombre=?, capacidad=?, tieneElectricidad=?, precioPorNoche=?, descripcion=?, disponible=? WHERE nombre=?";
        try {
            PreparedStatement sentencia = gestor.conn1.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setInt(2, capacidad);
            sentencia.setBoolean(3, tieneElectricidad);
            sentencia.setDouble(4, precioPorNoche);
            sentencia.setString(5, descripcion);
            sentencia.setBoolean(6, disponible);
            sentencia.setString(7, nombre);
            sentencia.executeUpdate();
            System.out.println("Parcela " + nombre + " actualizada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //DELETE
    public void delete(GestorConexion gestor) {
        String sql = "DELETE FROM parcela_camping WHERE nombre = ?";
        try {
            PreparedStatement sentencia = gestor.conn1.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.executeUpdate();
            System.out.println("Parcela " + nombre + " eliminada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    
    
    
}
