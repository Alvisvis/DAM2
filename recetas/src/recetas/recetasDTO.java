/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recetas;

/**
 *
 * @author 2DAM
 */
public class recetasDTO {
    private int id;
    private String titulo;
    private String instrucciones;
    private ingredientesDTO ingredientes; //PhpMyAdmin?? no esta creada la fk que sería de la id PK de ingredientes, a ingredientes de recetas; e igual con el creador.

    public recetasDTO(int id, String titulo, String instrucciones, ingredientesDTO ingredientes) {
        this.id = id;
        this.titulo = titulo;
        this.instrucciones = instrucciones;
        this.ingredientes = ingredientes;
    }

    public recetasDTO(String titulo, String instrucciones, ingredientesDTO ingredientes) {
        this.titulo = titulo;
        this.instrucciones = instrucciones;
        this.ingredientes = ingredientes;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public ingredientesDTO getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ingredientesDTO ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "recetasDTO{" + "id=" + id + ", titulo=" + titulo + ", instrucciones=" + instrucciones + ", ingredientes=" + ingredientes + '}';
    }
    
    
    
    
}
