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
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;


public class ParcelaCamping {
 //ATRIBUTOS
    private int id;
    private String nombre;
    private int capacidad;
    private boolean tieneEletricidad;
    private double precioNoche;
    private String descrip;
    private boolean disponible;

    //CONSTRUCTORES
    public ParcelaCamping() {
    }

    public ParcelaCamping(String nombre, int capacidad, double precioNoche, String descrip) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        } else {
            this.nombre = nombre;
        }
        if (capacidad < 0 || capacidad > 20) {
            throw new IllegalArgumentException("La capacidad debe estar entre 1 y 20");
        } else {
            this.capacidad = capacidad;
        }
        if (precioNoche < 0.0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        } else {
            this.precioNoche = precioNoche;
        }

        this.id = 0;
        this.tieneEletricidad = true;
        this.descrip = descrip;
        this.disponible = true;
    }

    public ParcelaCamping(int id, String nombre, int capacidad, boolean tieneEletricidad, double precioNoche, String descrip, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tieneEletricidad = tieneEletricidad;
        this.precioNoche = precioNoche;
        this.descrip = descrip;
        this.disponible = disponible;
    }

    public ParcelaCamping(String nombre, int capacidad, boolean tieneEletricidad, double precioNoche, String descrip, boolean disponible) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tieneEletricidad = tieneEletricidad;
        this.precioNoche = precioNoche;
        this.descrip = descrip;
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
        if(capacidad <= 0 || capacidad >20){
            throw new IllegalArgumentException("La capacidad debe entrar entre 0 y 20");
        }else{
            this.capacidad = capacidad;
        }
       
    }

    public boolean isTieneEletricidad() {
        return tieneEletricidad;
    }

    public void setTieneEletricidad(boolean tieneEletricidad) {
        this.tieneEletricidad = tieneEletricidad;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void create(Connection conn1, ParcelaCamping parcela) {
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

    public ParcelaCamping read(Connection conn1, int idBuscado) {
        ParcelaCamping parcela = null;

        String sql = "SELECT * FROM parcela_camping WHERE id = ?";

        try {
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, idBuscado);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Si encuentra alguna parcela
                parcela = new ParcelaCamping(rs.getString("nombre"), rs.getInt("capacidad"), rs.getBoolean("tieneElectricidad"), rs.getDouble("precioNoche"), rs.getString("descrip"), rs.getBoolean("disponible"));
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
    
    public ParcelaCamping update(Connection conn, int id, String nombre, int capacidad, boolean tieneEletricidad, double precioNoche, String descrip, boolean disponible ){
        ParcelaCamping parcelaActualizada = new ParcelaCamping(nombre, capacidad, tieneEletricidad, precioNoche,descrip, disponible);
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

    @Override
    public String toString() {
        return "ParcelaCamping{" + "id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", tieneEletricidad=" + tieneEletricidad + ", precioNoche=" + precioNoche + ", descrip=" + descrip + ", disponible=" + disponible + '}';
    }

}

