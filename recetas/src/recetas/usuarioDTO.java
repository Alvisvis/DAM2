/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recetas;

/**
 *
 * @author 2DAM
 */
public class usuarioDTO {
    private int id;
    String nombre;
    String correo;
    String contasenya;

    public usuarioDTO(int id, String nombre, String correo, String contasenya) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contasenya = contasenya;
    }

    public usuarioDTO(String nombre, String correo, String contasenya) {
        this.nombre = nombre;
        this.correo = correo;
        this.contasenya = contasenya;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContasenya() {
        return contasenya;
    }

    public void setContasenya(String contasenya) {
        this.contasenya = contasenya;
    }

    @Override
    public String toString() {
        return "usuarioDTO{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contasenya=" + contasenya + '}';
    }
    
    
    
    
}
