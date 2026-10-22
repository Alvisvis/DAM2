/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recetas;

/**
 *
 * @author 2DAM
 */
class ingredientesDTO {
    private int id;
    private String nombre;
    private String uMedida;

    public ingredientesDTO(int id, String nombre, String uMedida) {
        this.id = id;
        this.nombre = nombre;
        this.uMedida = uMedida;
    }

    public ingredientesDTO(String nombre, String uMedida) {
        this.nombre = nombre;
        this.uMedida = uMedida;
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

    public String getuMedida() {
        return uMedida;
    }

    public void setuMedida(String uMedida) {
        this.uMedida = uMedida;
    }

    @Override
    public String toString() {
        return "ingredientesDTO{" + "id=" + id + ", nombre=" + nombre + ", uMedida=" + uMedida + '}';
    }
    
    
    
    
}
