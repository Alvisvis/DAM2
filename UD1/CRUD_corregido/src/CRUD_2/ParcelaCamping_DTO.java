/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD_2;

/**
 *
 * @author 2DAM
 */
public class ParcelaCamping_DTO {
    //ATRIBUTOS
    private int id;
    private String nombre;
    private int capacidad;
    private boolean tieneEletricidad;
    private double precioNoche;
    private String descrip;
    private boolean disponible;

    //CONSTRUCTORES
    public ParcelaCamping_DTO() {
    }

    public ParcelaCamping_DTO(String nombre, int capacidad, double precioNoche, String descrip) {

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

    public ParcelaCamping_DTO(int id, String nombre, int capacidad, boolean tieneEletricidad, double precioNoche, String descrip, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tieneEletricidad = tieneEletricidad;
        this.precioNoche = precioNoche;
        this.descrip = descrip;
        this.disponible = disponible;
    }

    public ParcelaCamping_DTO(String nombre, int capacidad, boolean tieneEletricidad, double precioNoche, String descrip, boolean disponible) {
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
    
    @Override
    public String toString(){
        return "ParcelaCamping{" + "id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", tieneEletricidad=" + tieneEletricidad + ", precioNoche=" + precioNoche + ", descrip=" + descrip + ", disponible=" + disponible + '}';
    }
}
